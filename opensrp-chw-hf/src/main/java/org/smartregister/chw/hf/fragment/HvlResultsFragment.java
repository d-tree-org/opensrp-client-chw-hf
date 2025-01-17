package org.smartregister.chw.hf.fragment;

import static org.smartregister.util.JsonFormUtils.FIELDS;
import static org.smartregister.util.JsonFormUtils.STEP1;

import android.os.Bundle;

import com.vijay.jsonwizard.utils.FormUtils;

import org.json.JSONException;
import org.json.JSONObject;
import org.smartregister.chw.hf.activity.HvlResultsViewActivity;
import org.smartregister.chw.hf.dao.HfPmtctDao;
import org.smartregister.chw.hf.model.HvlResultsFragmentModel;
import org.smartregister.chw.hf.presenter.HvlResultsFragmentPresenter;
import org.smartregister.chw.pmtct.fragment.BaseHvlResultsFragment;
import org.smartregister.chw.pmtct.util.DBConstants;
import org.smartregister.commonregistry.CommonPersonObjectClient;
import org.smartregister.util.Utils;

public class HvlResultsFragment extends BaseHvlResultsFragment {

    public static final String BASE_ENTITY_ID = "BASE_ENTITY_ID";
    private String baseEntityId;

    public static HvlResultsFragment newInstance(String baseEntityId) {
        HvlResultsFragment hvlResultsFragment = new HvlResultsFragment();
        Bundle b = new Bundle();
        b.putString(BASE_ENTITY_ID, baseEntityId);
        hvlResultsFragment.setArguments(b);
        return hvlResultsFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        if (getArguments() != null) {
            this.baseEntityId = getArguments().getString(BASE_ENTITY_ID);
        }
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initializePresenter() {
        if (getActivity() == null) {
            return;
        }
        presenter = new HvlResultsFragmentPresenter(baseEntityId, this, new HvlResultsFragmentModel(), null);
    }

    @Override
    public void openResultsForm(CommonPersonObjectClient client) {
        String sampleId = Utils.getValue(client.getColumnmaps(), DBConstants.KEY.HVL_SAMPLE_ID, false);
        String baseEntityId = Utils.getValue(client.getColumnmaps(), DBConstants.KEY.BASE_ENTITY_ID, false);
        String formSubmissionId = Utils.getValue(client.getColumnmaps(), DBConstants.KEY.ENTITY_ID, false);
        try {
            JSONObject jsonObject = (new FormUtils()).getFormJsonFromRepositoryOrAssets(requireContext(), org.smartregister.chw.hf.utils.Constants.JsonForm.getHvlTestResultsForm());
            assert jsonObject != null;
            jsonObject.getJSONObject(STEP1).getJSONArray(FIELDS).getJSONObject(0).put("value", sampleId);
            JSONObject global = jsonObject.getJSONObject("global");
            global.put("is_after_eac", HfPmtctDao.isAfterEAC(baseEntityId));
            HvlResultsViewActivity.startResultsForm(getContext(), jsonObject.toString(), baseEntityId, formSubmissionId);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}
