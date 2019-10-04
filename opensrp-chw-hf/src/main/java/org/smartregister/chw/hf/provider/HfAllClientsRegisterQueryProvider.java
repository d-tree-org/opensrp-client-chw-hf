package org.smartregister.chw.hf.provider;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;

import org.smartregister.opd.configuration.OpdRegisterQueryProviderContract;

public class HfAllClientsRegisterQueryProvider extends OpdRegisterQueryProviderContract {

    @NonNull
    @Override
    public String getObjectIdsQuery(@Nullable String filters) {
        if (TextUtils.isEmpty(filters)) {
            return "SELECT object_id, last_interacted_with FROM (SELECT object_id, last_interacted_with FROM ec_family_member_search WHERE date_removed IS NULL) ORDER BY last_interacted_with DESC ";
        } else {
            return "SELECT object_id, last_interacted_with FROM (SELECT object_id, last_interacted_with FROM ec_family_member_search WHERE date_removed IS NULL) ORDER BY last_interacted_with DESC ";
        }
    }

    @NonNull
    @Override
    public String[] countExecuteQueries(@Nullable String filters) {
        return new String[]{
                "SELECT COUNT(*) AS c\n" +
                        "         FROM ec_child\n" +
                        "                  inner join ec_family_member on ec_family_member.base_entity_id = ec_child.base_entity_id\n" +
                        "                  inner join ec_family on ec_family.base_entity_id = ec_family_member.relational_id\n" +
                        "         WHERE ec_family_member.is_closed = '0'\n" +
                        "           AND ec_family_member.date_removed is null\n" +
                        "           AND cast(strftime('%Y-%m-%d %H:%M:%S', 'now') - strftime('%Y-%m-%d %H:%M:%S', ec_child.dob) as int) > 0",

                "SELECT COUNT(*)\n" +
                        "         FROM ec_anc_register\n" +
                        "                  inner join ec_family_member on ec_family_member.base_entity_id = ec_anc_register.base_entity_id\n" +
                        "                  inner join ec_family on ec_family.base_entity_id = ec_family_member.relational_id\n" +
                        "         where ec_family_member.date_removed is null\n" +
                        "           and ec_anc_register.is_closed is 0",

                "SELECT COUNT(*)\n" +
                        "         FROM ec_pregnancy_outcome\n" +
                        "                  inner join ec_family_member on ec_family_member.base_entity_id = ec_pregnancy_outcome.base_entity_id\n" +
                        "                  inner join ec_family on ec_family.base_entity_id = ec_family_member.relational_id\n" +
                        "         where ec_family_member.date_removed is null\n" +
                        "           and ec_pregnancy_outcome.is_closed is 0\n" +
                        "           AND ec_pregnancy_outcome.base_entity_id NOT IN\n" +
                        "               (SELECT base_entity_id FROM ec_anc_register WHERE ec_anc_register.is_closed IS 0)",

                "SELECT COUNT(*)\n" +
                        "FROM ec_family_member\n" +
                        "         inner join ec_family on ec_family.base_entity_id = ec_family_member.relational_id\n" +
                        "where ec_family_member.date_removed is null\n" +
                        "  AND ec_family_member.base_entity_id NOT IN (\n" +
                        "    SELECT ec_anc_register.base_entity_id AS base_entity_id\n" +
                        "    FROM ec_anc_register\n" +
                        "    UNION ALL\n" +
                        "    SELECT ec_pregnancy_outcome.base_entity_id AS base_entity_id\n" +
                        "    FROM ec_pregnancy_outcome\n" +
                        "    UNION ALL\n" +
                        "    SELECT ec_child.base_entity_id AS base_entity_id\n" +
                        "    FROM ec_child\n" +
                        ")\n"
        };
    }

    @NonNull
    @Override
    public String mainSelectWhereIDsIn() {
        return "/* ANC REGISTER */\n" +
                "SELECT ec_family_member.first_name          AS first_name,\n" +
                "       ec_family_member.middle_name         AS middle_name,\n" +
                "       ec_family_member.last_name           AS last_name,\n" +
                "       ec_family_member.gender              AS gender,\n" +
                "       ec_family_member.dob                 AS dob,\n" +
                "       ec_family_member.base_entity_id      AS base_entity_id,\n" +
                "       ec_family_member.id                  as _id,\n" +
                "       'ANC'                                AS register_type,\n" +
                "       ec_family_member.relational_id       as relationalid,\n" +
                "       ec_family.village_town               as home_address,\n" +
                "       ec_anc_register.last_interacted_with AS last_interacted_with,\n" +
                "       NULL                                 AS mother_first_name,\n" +
                "       NULL                                 AS mother_last_name,\n" +
                "       NULL                                 AS mother_middle_name\n" +
                "FROM ec_anc_register\n" +
                "         inner join ec_family_member on ec_family_member.base_entity_id = ec_anc_register.base_entity_id\n" +
                "         inner join ec_family on ec_family.base_entity_id = ec_family_member.relational_id\n" +
                "where ec_family_member.date_removed is null\n" +
                "  and ec_anc_register.is_closed is 0\n" +
                "  and ec_anc_register.base_entity_id IN (%s)\n" +
                "\n" +
                "UNION ALL\n" +
                "\n" +
                "/* PNC REGISTER */\n" +
                "\n" +
                "SELECT ec_family_member.first_name               AS first_name,\n" +
                "       ec_family_member.middle_name              AS middle_name,\n" +
                "       ec_family_member.last_name                AS last_name,\n" +
                "       ec_family_member.gender                   AS gender,\n" +
                "       ec_family_member.dob                      AS dob,\n" +
                "       ec_family_member.base_entity_id           AS base_entity_id,\n" +
                "       ec_family_member.id                       as _id,\n" +
                "       'PNC'                                     AS register_type,\n" +
                "       ec_family_member.relational_id            as relationalid,\n" +
                "       ec_family.village_town                    as home_address,\n" +
                "       ec_pregnancy_outcome.last_interacted_with AS last_interacted_with,\n" +
                "       NULL                                      AS mother_first_name,\n" +
                "       NULL                                      AS mother_last_name,\n" +
                "       NULL                                      AS mother_middle_name\n" +
                "FROM ec_pregnancy_outcome\n" +
                "         inner join ec_family_member on ec_family_member.base_entity_id = ec_pregnancy_outcome.base_entity_id\n" +
                "         inner join ec_family on ec_family.base_entity_id = ec_family_member.relational_id\n" +
                "where ec_family_member.date_removed is null\n" +
                "  and ec_pregnancy_outcome.is_closed is 0\n" +
                "  AND ec_pregnancy_outcome.base_entity_id NOT IN\n" +
                "      (SELECT base_entity_id FROM ec_anc_register WHERE ec_anc_register.is_closed IS 0)\n" +
                "  AND ec_pregnancy_outcome.base_entity_id IN (%s)\n" +
                "\n" +
                "UNION ALL\n" +
                "/* CHILD REGISTER */\n" +
                "\n" +
                "SELECT ec_family_member.first_name     AS first_name,\n" +
                "       ec_family_member.middle_name    AS middle_name,\n" +
                "       ec_family_member.last_name      AS last_name,\n" +
                "       ec_family_member.gender         AS gender,\n" +
                "       ec_family_member.dob            AS dob,\n" +
                "       ec_family_member.base_entity_id AS base_entity_id,\n" +
                "       ec_family_member.id             as _id,\n" +
                "       'Child'                         AS register_type,\n" +
                "       ec_family_member.relational_id  as relationalid,\n" +
                "       ec_family.village_town          as home_address,\n" +
                "       ec_child.last_interacted_with   AS last_interacted_with,\n" +
                "       ec_child.mother_first_name      AS mother_first_name,\n" +
                "       ec_child.mother_middle_name     AS mother_middle_name,\n" +
                "       ec_child.mother_last_name       AS mother_last_name\n" +
                "FROM (SELECT ec_child.*,\n" +
                "             mother.first_name  AS mother_first_name,\n" +
                "             mother.last_name   AS mother_last_name,\n" +
                "             mother.middle_name AS mother_middle_name\n" +
                "      FROM ec_child\n" +
                "               inner join ec_family on ec_family.base_entity_id = ec_child.relational_id\n" +
                "               INNER JOIN ec_family_member AS mother ON ec_family.primary_caregiver = mother.base_entity_id\n" +
                "     ) ec_child\n" +
                "         inner join ec_family_member on ec_family_member.base_entity_id = ec_child.base_entity_id\n" +
                "         inner join ec_family on ec_family.base_entity_id = ec_family_member.relational_id\n" +
                "WHERE ec_family_member.is_closed = '0'\n" +
                "  AND ec_family_member.date_removed is null\n" +
                "  AND cast(strftime('%Y-%m-%d %H:%M:%S', 'now') - strftime('%Y-%m-%d %H:%M:%S', ec_child.dob) as int) > 0\n" +
                "  AND ec_child.base_entity_id IN (%s)\n" +
                "\n" +
                "UNION ALL\n" +
                "/*OTHER FAMILY MEMBERS*/\n" +
                "SELECT ec_family_member.first_name,\n" +
                "       ec_family_member.middle_name,\n" +
                "       ec_family_member.last_name,\n" +
                "       ec_family_member.gender,\n" +
                "       ec_family_member.dob,\n" +
                "       ec_family_member.base_entity_id,\n" +
                "       ec_family_member.id                   as _id,\n" +
                "       NULL                                    AS register_type,\n" +
                "       ec_family_member.relational_id        as relationalid,\n" +
                "       ec_family.village_town                as home_address,\n" +
                "       NULL                                  AS mother_first_name,\n" +
                "       NULL                                  AS mother_last_name,\n" +
                "       NULL                                  AS mother_middle_name,\n" +
                "       ec_family_member.last_interacted_with AS last_interacted_with\n" +
                "FROM ec_family_member\n" +
                "         inner join ec_family on ec_family.base_entity_id = ec_family_member.relational_id\n" +
                "where ec_family_member.date_removed is null\n" +
                "  AND ec_family_member.base_entity_id IN (%s)\n" +
                "  AND ec_family_member.base_entity_id NOT IN (\n" +
                "    SELECT ec_anc_register.base_entity_id AS base_entity_id\n" +
                "    FROM ec_anc_register\n" +
                "    UNION ALL\n" +
                "    SELECT ec_pregnancy_outcome.base_entity_id AS base_entity_id\n" +
                "    FROM ec_pregnancy_outcome\n" +
                "    UNION ALL\n" +
                "    SELECT ec_child.base_entity_id AS base_entity_id\n" +
                "    FROM ec_child\n" +
                ")\n" +
                "ORDER BY last_interacted_with DESC";
    }
}
