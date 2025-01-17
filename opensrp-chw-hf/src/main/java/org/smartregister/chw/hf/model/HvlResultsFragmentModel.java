package org.smartregister.chw.hf.model;

import androidx.annotation.NonNull;

import org.smartregister.chw.core.utils.ChildDBConstants;
import org.smartregister.chw.hf.utils.Constants;
import org.smartregister.chw.pmtct.model.BaseHvlResultsFragmentModel;
import org.smartregister.cursoradapter.SmartRegisterQueryBuilder;
import org.smartregister.family.util.DBConstants;

import java.util.HashSet;
import java.util.Set;

public class HvlResultsFragmentModel extends BaseHvlResultsFragmentModel {

    @NonNull
    @Override
    public String mainSelect(@NonNull String tableName, @NonNull String mainCondition) {
        SmartRegisterQueryBuilder queryBuilder = new SmartRegisterQueryBuilder();
        queryBuilder.selectInitiateMainTable(tableName, mainColumns(tableName));
        queryBuilder.customJoin("INNER JOIN " + Constants.TABLE_NAME.FAMILY_MEMBER + " ON  " + tableName + "." + org.smartregister.chw.pmtct.util.DBConstants.KEY.ENTITY_ID + "= " + Constants.TABLE_NAME.FAMILY_MEMBER + "." + DBConstants.KEY.BASE_ENTITY_ID + " COLLATE NOCASE ");
        queryBuilder.customJoin("INNER JOIN " + Constants.TABLE_NAME.FAMILY + " ON  " + Constants.TABLE_NAME.FAMILY_MEMBER + "." + DBConstants.KEY.RELATIONAL_ID + " = " + Constants.TABLE_NAME.FAMILY + "." + DBConstants.KEY.BASE_ENTITY_ID);
        queryBuilder.customJoin("LEFT JOIN " + Constants.TABLE_NAME.FAMILY_MEMBER + " as T1 ON  " + Constants.TABLE_NAME.FAMILY + "." + DBConstants.KEY.PRIMARY_CAREGIVER + " = T1." + DBConstants.KEY.BASE_ENTITY_ID);
        queryBuilder.customJoin("LEFT JOIN " + Constants.TABLE_NAME.FAMILY_MEMBER + " as T2 ON  " + Constants.TABLE_NAME.FAMILY + "." + DBConstants.KEY.FAMILY_HEAD + " = T2." + DBConstants.KEY.BASE_ENTITY_ID);
        queryBuilder.customJoin("LEFT JOIN " + org.smartregister.chw.pmtct.util.Constants.TABLES.PMTCT_HVL_RESULTS + " ON " + org.smartregister.chw.pmtct.util.Constants.TABLES.PMTCT_HVL_RESULTS + "." + org.smartregister.chw.pmtct.util.DBConstants.KEY.HVL_FOLLOWUP_FORM_SUBMISSION_ID + " = "+ tableName + "." + DBConstants.KEY.BASE_ENTITY_ID);
        return queryBuilder.mainCondition(mainCondition);
    }
    @Override
    protected String[] mainColumns(String tableName) {
        Set<String> columnList = new HashSet<>();
        columnList.add(tableName + "." + org.smartregister.chw.pmtct.util.DBConstants.KEY.ENTITY_ID + " as " + DBConstants.KEY.BASE_ENTITY_ID);
        columnList.add(tableName + "." + DBConstants.KEY.BASE_ENTITY_ID + " as " + org.smartregister.chw.pmtct.util.DBConstants.KEY.ENTITY_ID);
        columnList.add(Constants.TABLE_NAME.FAMILY_MEMBER + "." + DBConstants.KEY.RELATIONAL_ID + " as " + ChildDBConstants.KEY.RELATIONAL_ID);
        columnList.add(Constants.TABLE_NAME.FAMILY_MEMBER + "." + DBConstants.KEY.FIRST_NAME);
        columnList.add(Constants.TABLE_NAME.FAMILY_MEMBER + "." + DBConstants.KEY.MIDDLE_NAME);
        columnList.add(Constants.TABLE_NAME.FAMILY_MEMBER + "." + DBConstants.KEY.LAST_NAME);
        columnList.add(Constants.TABLE_NAME.FAMILY_MEMBER + "." + DBConstants.KEY.DOB);
        columnList.add(Constants.TABLE_NAME.FAMILY_MEMBER + "." + DBConstants.KEY.GENDER);
        columnList.add(Constants.TABLE_NAME.FAMILY_MEMBER + "." + DBConstants.KEY.UNIQUE_ID);
        columnList.add(Constants.TABLE_NAME.FAMILY_MEMBER + "." + DBConstants.KEY.RELATIONAL_ID);
        columnList.add(Constants.TABLE_NAME.FAMILY_MEMBER + "." + DBConstants.KEY.PHONE_NUMBER);
        columnList.add(Constants.TABLE_NAME.FAMILY_MEMBER + "." + DBConstants.KEY.OTHER_PHONE_NUMBER);
        columnList.add("T2." + DBConstants.KEY.PHONE_NUMBER + " AS " + org.smartregister.chw.tb.util.DBConstants.Key.FAMILY_HEAD_PHONE_NUMBER);
        columnList.add(Constants.TABLE_NAME.FAMILY + "." + DBConstants.KEY.VILLAGE_TOWN);
        columnList.add("T1." + DBConstants.KEY.FIRST_NAME + " || " + "' '" + " || " + "T1." + DBConstants.KEY.MIDDLE_NAME + " || " + "' '" + " || " + "T1." + DBConstants.KEY.LAST_NAME + " AS " + DBConstants.KEY.PRIMARY_CAREGIVER);
        columnList.add("T2." + DBConstants.KEY.FIRST_NAME + " || " + "' '" + " || " + "T2." + DBConstants.KEY.MIDDLE_NAME + " || " + "' '" + " || " + "T2." + DBConstants.KEY.LAST_NAME + " AS " + DBConstants.KEY.FAMILY_HEAD);
        columnList.add(Constants.TABLE_NAME.FAMILY + "." + DBConstants.KEY.FIRST_NAME + " as " + org.smartregister.chw.anc.util.DBConstants.KEY.FAMILY_NAME);
        columnList.add(org.smartregister.chw.pmtct.util.Constants.TABLES.PMTCT_FOLLOW_UP + "." + org.smartregister.chw.pmtct.util.DBConstants.KEY.HVL_SAMPLE_ID);
        columnList.add(org.smartregister.chw.pmtct.util.Constants.TABLES.PMTCT_HVL_RESULTS + "." + org.smartregister.chw.pmtct.util.DBConstants.KEY.HVL_RESULT);
        columnList.add(org.smartregister.chw.pmtct.util.Constants.TABLES.PMTCT_FOLLOW_UP + "." + org.smartregister.chw.pmtct.util.DBConstants.KEY.HVL_SAMPLE_COLLECTION_DATE);
        columnList.add(org.smartregister.chw.pmtct.util.Constants.TABLES.PMTCT_HVL_RESULTS + "." + org.smartregister.chw.pmtct.util.DBConstants.KEY.HVL_RESULT_DATE);
        columnList.add(org.smartregister.chw.pmtct.util.Constants.TABLES.PMTCT_HVL_RESULTS + "." + org.smartregister.chw.pmtct.util.DBConstants.KEY.HVL_FOLLOWUP_FORM_SUBMISSION_ID);

        return columnList.toArray(new String[columnList.size()]);

    }
}
