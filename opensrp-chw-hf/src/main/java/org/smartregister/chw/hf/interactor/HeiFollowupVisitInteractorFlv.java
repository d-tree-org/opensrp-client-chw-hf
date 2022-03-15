package org.smartregister.chw.hf.interactor;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.smartregister.chw.core.utils.FormUtils;
import org.smartregister.chw.hf.actionhelper.HeiAntibodyTestAction;
import org.smartregister.chw.hf.actionhelper.HeiArvPrescriptionHighOrLowRiskInfantAction;
import org.smartregister.chw.hf.actionhelper.HeiArvPrescrptionHighRiskInfantAction;
import org.smartregister.chw.hf.actionhelper.HeiCtxAction;
import org.smartregister.chw.hf.actionhelper.HeiDnaPcrTestAction;
import org.smartregister.chw.hf.dao.HeiDao;
import org.smartregister.chw.hf.utils.Constants;
import org.smartregister.chw.pmtct.PmtctLibrary;
import org.smartregister.chw.pmtct.contract.BasePmtctHomeVisitContract;
import org.smartregister.chw.pmtct.domain.MemberObject;
import org.smartregister.chw.pmtct.domain.Visit;
import org.smartregister.chw.pmtct.domain.VisitDetail;
import org.smartregister.chw.pmtct.model.BasePmtctHomeVisitAction;
import org.smartregister.chw.pmtct.util.JsonFormUtils;
import org.smartregister.chw.pmtct.util.VisitUtils;
import org.smartregister.chw.referral.util.JsonFormConstants;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import timber.log.Timber;

public class HeiFollowupVisitInteractorFlv implements PmtctFollowupVisitInteractor.Flavor {


    @Override
    public LinkedHashMap<String, BasePmtctHomeVisitAction> calculateActions(BasePmtctHomeVisitContract.View view, MemberObject memberObject, BasePmtctHomeVisitContract.InteractorCallBack interactorCallBack) throws BasePmtctHomeVisitAction.ValidationException {
        LinkedHashMap<String, BasePmtctHomeVisitAction> actionList = new LinkedHashMap<>();

        Context context = view.getContext();

        Map<String, List<VisitDetail>> details = null;
        // get the preloaded data
        if (view.getEditMode()) {
            Visit lastVisit = PmtctLibrary.getInstance().visitRepository().getLatestVisit(memberObject.getBaseEntityId(), Constants.Events.HEI_FOLLOWUP);
            if (lastVisit != null) {
                details = VisitUtils.getVisitGroups(PmtctLibrary.getInstance().visitDetailsRepository().getVisits(lastVisit.getVisitId()));
            }
        }

        evaluateHEIActions(actionList, details, memberObject, context);

        return actionList;
    }

    private void evaluateHEIActions(LinkedHashMap<String, BasePmtctHomeVisitAction> actionList, Map<String, List<VisitDetail>> details, MemberObject memberObject, Context context) throws BasePmtctHomeVisitAction.ValidationException {

        JSONObject dnaPcrForm = null;
        try {
            dnaPcrForm = FormUtils.getFormUtils().getFormJson(Constants.JsonForm.getHeiDnaPcrSampleCollection());

            JSONArray fields = dnaPcrForm.getJSONObject(Constants.JsonFormConstants.STEP1).getJSONArray(JsonFormConstants.FIELDS);
            //update visit number
            JSONObject testAtAge = org.smartregister.util.JsonFormUtils.getFieldJSONObject(fields, "test_at_age");
            testAtAge.put(JsonFormUtils.VALUE, HeiDao.getNextHivTestAge(memberObject.getBaseEntityId()));

            //loads details to the form
            if (details != null && !details.isEmpty()) {
                JsonFormUtils.populateForm(dnaPcrForm, details);
            }
        } catch (JSONException e) {
            Timber.e(e);
        }

        JSONObject antibodyTestForm = null;
        try {
            antibodyTestForm = FormUtils.getFormUtils().getFormJson(Constants.JsonForm.getHeiAntibodyTestSampleCollection());

            JSONArray fields = antibodyTestForm.getJSONObject(Constants.JsonFormConstants.STEP1).getJSONArray(JsonFormConstants.FIELDS);
            //update visit number
            JSONObject testAtAge = org.smartregister.util.JsonFormUtils.getFieldJSONObject(fields, "test_at_age");
            testAtAge.put(JsonFormUtils.VALUE, HeiDao.getNextHivTestAge(memberObject.getBaseEntityId()));

            //loads details to the form
            if (details != null && !details.isEmpty()) {
                JsonFormUtils.populateForm(antibodyTestForm, details);
            }
        } catch (JSONException e) {
            Timber.e(e);
        }

        JSONObject arvPrescriptionForHighAndLowRiskForm = null;
        try {
            arvPrescriptionForHighAndLowRiskForm = FormUtils.getFormUtils().getFormJson(Constants.JsonForm.getHeiArvPrescriptionHighOrLowRiskInfant());

            JSONArray fields = arvPrescriptionForHighAndLowRiskForm.getJSONObject(Constants.JsonFormConstants.STEP1).getJSONArray(JsonFormConstants.FIELDS);
            //update visit number
            JSONObject visitNumber = org.smartregister.util.JsonFormUtils.getFieldJSONObject(fields, "visit_number");
            visitNumber.put(JsonFormUtils.VALUE, HeiDao.getVisitNumber(memberObject.getBaseEntityId()));

            //loads details to the form
            if (details != null && !details.isEmpty()) {
                JsonFormUtils.populateForm(arvPrescriptionForHighAndLowRiskForm, details);
            }
        } catch (JSONException e) {
            Timber.e(e);
        }

        JSONObject arvPrescriptionForHighRiskForm = null;
        try {
            arvPrescriptionForHighRiskForm = FormUtils.getFormUtils().getFormJson(Constants.JsonForm.getHeiArvPrescriptionHighRiskInfant());

            JSONArray fields = arvPrescriptionForHighRiskForm.getJSONObject(Constants.JsonFormConstants.STEP1).getJSONArray(JsonFormConstants.FIELDS);
            //update visit number
            JSONObject visitNumber = org.smartregister.util.JsonFormUtils.getFieldJSONObject(fields, "visit_number");
            visitNumber.put(JsonFormUtils.VALUE, HeiDao.getVisitNumber(memberObject.getBaseEntityId()));

            //loads details to the form
            if (details != null && !details.isEmpty()) {
                JsonFormUtils.populateForm(arvPrescriptionForHighRiskForm, details);
            }
        } catch (JSONException e) {
            Timber.e(e);
        }

        JSONObject ctxPrescriptionForm = null;
        try {
            ctxPrescriptionForm = FormUtils.getFormUtils().getFormJson(Constants.JsonForm.getHeiCtxPrescription());

            JSONArray fields = ctxPrescriptionForm.getJSONObject(Constants.JsonFormConstants.STEP1).getJSONArray(JsonFormConstants.FIELDS);
            //update visit number
            JSONObject visitNumber = org.smartregister.util.JsonFormUtils.getFieldJSONObject(fields, "visit_number");
            visitNumber.put(JsonFormUtils.VALUE, HeiDao.getVisitNumber(memberObject.getBaseEntityId()));

            //loads details to the form
            if (details != null && !details.isEmpty()) {
                JsonFormUtils.populateForm(ctxPrescriptionForm, details);
            }
        } catch (JSONException e) {
            Timber.e(e);
        }

        BasePmtctHomeVisitAction DNAPCRTest = new BasePmtctHomeVisitAction.Builder(context, "DNA-PCR Sample Collection")
                .withOptional(false)
                .withDetails(details)
                .withFormName(Constants.JsonForm.getHeiDnaPcrSampleCollection())
                .withJsonPayload(dnaPcrForm.toString())
                .withHelper(new HeiDnaPcrTestAction(memberObject))
                .build();
        if (HeiDao.isEligibleForDnaCprHivTest(memberObject.getBaseEntityId()))
            actionList.put("DNA-PCR Sample Collection", DNAPCRTest);

        BasePmtctHomeVisitAction AntibodyTest = new BasePmtctHomeVisitAction.Builder(context, "Antibody Test Sample Collection")
                .withOptional(false)
                .withDetails(details)
                .withFormName(Constants.JsonForm.getHeiAntibodyTestSampleCollection())
                .withJsonPayload(antibodyTestForm.toString())
                .withHelper(new HeiAntibodyTestAction(memberObject))
                .build();
        if (HeiDao.isEligibleForAntiBodiesHivTest(memberObject.getBaseEntityId()))
            actionList.put("Antibody Test Sample Collection", AntibodyTest);

        BasePmtctHomeVisitAction CtxPrescription = new BasePmtctHomeVisitAction.Builder(context, "CTX Prescription")
                .withOptional(false)
                .withDetails(details)
                .withFormName(Constants.JsonForm.getHeiCtxPrescription())
                .withJsonPayload(ctxPrescriptionForm.toString())
                .withHelper(new HeiCtxAction(memberObject))
                .build();
        if (HeiDao.isEligibleForCtx(memberObject.getBaseEntityId()))
            actionList.put("CTX Prescription", CtxPrescription);

        BasePmtctHomeVisitAction ARVPrescriptionHighRisk = new BasePmtctHomeVisitAction.Builder(context, "ARV Prescription (AZT + 3C and NVP)")
                .withOptional(false)
                .withDetails(details)
                .withFormName(Constants.JsonForm.getHeiArvPrescriptionHighRiskInfant())
                .withJsonPayload(arvPrescriptionForHighRiskForm.toString())
                .withHelper(new HeiArvPrescrptionHighRiskInfantAction(memberObject))
                .build();
        if (HeiDao.isEligibleForArvPrescriptionForHighRisk(memberObject.getBaseEntityId()))
            actionList.put("ARV Prescription (AZT + 3C and NVP)", ARVPrescriptionHighRisk);

        BasePmtctHomeVisitAction ARVPrescriptionHighAndLowRisk = new BasePmtctHomeVisitAction.Builder(context, "ARV Prescription (NVP)")
                .withOptional(false)
                .withDetails(details)
                .withFormName(Constants.JsonForm.getHeiArvPrescriptionHighOrLowRiskInfant())
                .withJsonPayload(arvPrescriptionForHighAndLowRiskForm.toString())
                .withHelper(new HeiArvPrescriptionHighOrLowRiskInfantAction(memberObject))
                .build();
        if (HeiDao.isEligibleForArvPrescriptionForHighAndLowRisk(memberObject.getBaseEntityId()))
            actionList.put("ARV Prescription (NVP)", ARVPrescriptionHighAndLowRisk);
    }


}

