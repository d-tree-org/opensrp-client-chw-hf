package org.smartregister.chw.hf.model;

import org.smartregister.chw.core.utils.ChildDBConstants;
import org.smartregister.chw.core.utils.ChwDBConstants;
import org.smartregister.chw.core.utils.CoreConstants;
import org.smartregister.chw.hf.utils.Constants;
import org.smartregister.cursoradapter.SmartRegisterQueryBuilder;
import org.smartregister.family.util.DBConstants;

import java.util.HashSet;
import java.util.Set;

public class PncNoMotherRegisterFragmentModel extends org.smartregister.chw.core.model.PncRegisterFragmentModel {
    @Override
    protected String[] mainColumns(String tableName) {
        Set<String> columnList = new HashSet<>();

        columnList.add(tableName + "." + ChwDBConstants.DELIVERY_DATE);
        columnList.add(tableName + "." + DBConstants.KEY.BASE_ENTITY_ID);
        columnList.add(tableName + "." + Constants.DBConstants.CAREGIVER_NAME);
        columnList.add(tableName + "." + Constants.DBConstants.CAREGIVER_PHONE_NUMBER);
        columnList.add(CoreConstants.TABLE_NAME.FAMILY_MEMBER + "." + DBConstants.KEY.RELATIONAL_ID + " as " + ChildDBConstants.KEY.RELATIONAL_ID);
        columnList.add(CoreConstants.TABLE_NAME.FAMILY_MEMBER + "." + DBConstants.KEY.FIRST_NAME);
        columnList.add(CoreConstants.TABLE_NAME.FAMILY_MEMBER + "." + DBConstants.KEY.MIDDLE_NAME);
        columnList.add(CoreConstants.TABLE_NAME.FAMILY_MEMBER + "." + DBConstants.KEY.LAST_NAME);
        columnList.add(CoreConstants.TABLE_NAME.FAMILY_MEMBER + "." + DBConstants.KEY.DOB);
        columnList.add(CoreConstants.TABLE_NAME.FAMILY_MEMBER + "." + DBConstants.KEY.PHONE_NUMBER);
        columnList.add(CoreConstants.TABLE_NAME.FAMILY_MEMBER + "." + DBConstants.KEY.RELATIONAL_ID);
        columnList.add(CoreConstants.TABLE_NAME.FAMILY_MEMBER + "." + DBConstants.KEY.UNIQUE_ID);
        columnList.add(CoreConstants.TABLE_NAME.FAMILY_MEMBER + "." + DBConstants.KEY.GENDER);
        columnList.add(CoreConstants.TABLE_NAME.FAMILY + "." + DBConstants.KEY.FAMILY_HEAD);
        columnList.add(CoreConstants.TABLE_NAME.FAMILY + "." + DBConstants.KEY.PRIMARY_CAREGIVER);
        columnList.add(CoreConstants.TABLE_NAME.FAMILY + "." + DBConstants.KEY.VILLAGE_TOWN);
        columnList.add(CoreConstants.TABLE_NAME.FAMILY + "." + DBConstants.KEY.FIRST_NAME + " as " + org.smartregister.chw.anc.util.DBConstants.KEY.FAMILY_NAME);

        return columnList.toArray(new String[columnList.size()]);
    }

    @Override
    public String mainSelect(String tableName, String mainCondition) {
        SmartRegisterQueryBuilder queryBuilder = new SmartRegisterQueryBuilder();
        queryBuilder.selectInitiateMainTable(tableName, mainColumns(tableName));
        queryBuilder.customJoin("INNER JOIN " + CoreConstants.TABLE_NAME.FAMILY_MEMBER + " ON  " + tableName + "." + DBConstants.KEY.BASE_ENTITY_ID + " = " + CoreConstants.TABLE_NAME.FAMILY_MEMBER + "." + DBConstants.KEY.BASE_ENTITY_ID + " AND " + tableName + "." + ChwDBConstants.IS_CLOSED + " IS " + 0  + " AND " + CoreConstants.TABLE_NAME.FAMILY_MEMBER + "." + ChwDBConstants.IS_CLOSED + " IS " + 0 + " AND " + tableName + "." + ChwDBConstants.DELIVERY_DATE + " IS NOT NULL COLLATE NOCASE ");
        queryBuilder.customJoin("INNER JOIN " + CoreConstants.TABLE_NAME.FAMILY + " ON  " + CoreConstants.TABLE_NAME.FAMILY_MEMBER + "." + DBConstants.KEY.RELATIONAL_ID + " = " + CoreConstants.TABLE_NAME.FAMILY + "." + DBConstants.KEY.BASE_ENTITY_ID + " COLLATE NOCASE ");
        queryBuilder.customJoin("LEFT JOIN (select base_entity_id , max(visit_date) visit_date from visits GROUP by base_entity_id) VISIT_SUMMARY ON VISIT_SUMMARY.base_entity_id = " + tableName + "." + DBConstants.KEY.BASE_ENTITY_ID);

        return queryBuilder.mainCondition(mainCondition);
    }
}
