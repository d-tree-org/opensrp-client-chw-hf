package org.smartregister.chw.hf.actionhelper;

import android.content.Context;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.smartregister.chw.core.utils.CoreJsonFormUtils;
import org.smartregister.chw.hf.R;
import org.smartregister.chw.pmtct.domain.MemberObject;
import org.smartregister.chw.pmtct.domain.VisitDetail;
import org.smartregister.chw.pmtct.model.BasePmtctHomeVisitAction;

import java.util.List;
import java.util.Map;

import timber.log.Timber;

public class HeiAntibodyTestAction implements BasePmtctHomeVisitAction.PmtctHomeVisitActionHelper {
    protected MemberObject memberObject;
    private String jsonPayload;
    private String test_result;
    private Context context;
    private String subTitle;
    private BasePmtctHomeVisitAction.ScheduleStatus scheduleStatus;

    public HeiAntibodyTestAction(MemberObject memberObject) {
        this.memberObject = memberObject;
    }

    @Override
    public void onJsonFormLoaded(String jsonPayload, Context context, Map<String, List<VisitDetail>> map) {
        this.jsonPayload = jsonPayload;
        this.context = context;
    }

    @Override
    public String getPreProcessed() {
        try {
            JSONObject jsonObject = new JSONObject(jsonPayload);
            return jsonObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void onPayloadReceived(String jsonPayload) {
        try {
            JSONObject jsonObject = new JSONObject(jsonPayload);
            test_result = CoreJsonFormUtils.getValue(jsonObject, "hiv_test_result");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public BasePmtctHomeVisitAction.ScheduleStatus getPreProcessedStatus() {
        return scheduleStatus;
    }

    @Override
    public String getPreProcessedSubTitle() {
        return subTitle;
    }

    @Override
    public String postProcess(String s) {
        return s;
    }

    @Override
    public String evaluateSubTitle() {
        if (StringUtils.isBlank(test_result))
            return null;

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(context.getString(R.string.antibody_test_results_filled));

        return stringBuilder.toString();
    }

    @Override
    public BasePmtctHomeVisitAction.Status evaluateStatusOnPayload() {
        if (StringUtils.isBlank(test_result))
            return BasePmtctHomeVisitAction.Status.PENDING;
        else {
            return BasePmtctHomeVisitAction.Status.COMPLETED;
        }
    }

    @Override
    public void onPayloadReceived(BasePmtctHomeVisitAction basePmtctHomeVisitAction) {
        Timber.d("onPayloadReceived");
    }
}
