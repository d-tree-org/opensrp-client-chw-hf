package org.smartregister.chw.hf.dao;

import org.smartregister.chw.core.dao.PNCDao;

import java.util.List;

public class HfPncDao extends PNCDao {
    public static boolean isChildEligibleForBcg(String baseEntityId) {
        String sql = "SELECT child_bcg_vaccination FROM ec_pregnancy_outcome WHERE child_bcg_vaccination = 'yes' AND base_entity_id = '" + baseEntityId + "'";

        DataMap<String> dataMap = cursor -> getCursorValue(cursor, "child_bcg_vaccination");
        List<String> res = readData(sql, dataMap);

        return res != null && res.size() > 0 && res.get(0) != null;
    }

    public static boolean isChildEligibleForOpv0(String baseEntityId) {
        String sql = "SELECT child_opv0_vaccination FROM ec_pregnancy_outcome WHERE child_opv0_vaccination = 'yes' AND base_entity_id = '" + baseEntityId + "'";

        DataMap<String> dataMap = cursor -> getCursorValue(cursor, "child_opv0_vaccination");
        List<String> res = readData(sql, dataMap);

        return res != null && res.size() > 0 && res.get(0) != null;
    }

    public static boolean isMotherEligibleForHepB(String baseEntityId) {
        String sql = "SELECT hepatitis_b_vaccination FROM ec_pregnancy_outcome WHERE hepatitis_b_vaccination = 'yes' AND base_entity_id = '" + baseEntityId + "'";

        DataMap<String> dataMap = cursor -> getCursorValue(cursor, "hepatitis_b_vaccination");
        List<String> res = readData(sql, dataMap);

        return res != null && res.size() > 0 && res.get(0) != null;
    }

    public static boolean isMotherEligibleForTetanus(String baseEntityId) {
        String sql = "SELECT tetanus_vaccination FROM ec_pregnancy_outcome WHERE tetanus_vaccination = 'yes' AND base_entity_id = '" + baseEntityId + "'";

        DataMap<String> dataMap = cursor -> getCursorValue(cursor, "tetanus_vaccination");
        List<String> res = readData(sql, dataMap);

        return res != null && res.size() > 0 && res.get(0) != null;
    }
}
