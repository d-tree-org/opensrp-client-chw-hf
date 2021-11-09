package org.smartregister.chw.hf.presenter;

import org.apache.commons.lang3.tuple.Triple;
import org.smartregister.chw.core.contract.CorePmtctProfileContract;
import org.smartregister.chw.core.presenter.CorePmtctMemberProfilePresenter;
import org.smartregister.chw.hf.contract.PmtctProfileContract;
import org.smartregister.chw.hf.model.HivTbReferralTasksAndFollowupFeedbackModel;
import org.smartregister.chw.pmtct.domain.MemberObject;
import org.smartregister.opd.contract.OpdRegisterActivityContract;
import org.smartregister.opd.pojo.OpdDiagnosisAndTreatmentForm;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class PmtctProfilePresenter extends CorePmtctMemberProfilePresenter implements PmtctProfileContract.Presenter, PmtctProfileContract.InteractorCallback, OpdRegisterActivityContract.InteractorCallBack {
    public PmtctProfilePresenter(CorePmtctProfileContract.View view, CorePmtctProfileContract.Interactor interactor, MemberObject memberObject) {
        super(view, interactor, memberObject);
    }
    //TODO: Implement tasks for the presenter
    @Override
    public void fetchReferralTasks() {

    }

    @Override
    public void updateReferralTasksAndFollowupFeedback(List<HivTbReferralTasksAndFollowupFeedbackModel> tasksAndFollowupFeedbackModels) {

    }

    @Override
    public void onNoUniqueId() {

    }

    @Override
    public void onUniqueIdFetched(Triple<String, String, String> triple, String s) {

    }

    @Override
    public void onRegistrationSaved(boolean b) {

    }

    @Override
    public void onEventSaved() {

    }

    @Override
    public void onFetchedSavedDiagnosisAndTreatmentForm(@Nullable OpdDiagnosisAndTreatmentForm opdDiagnosisAndTreatmentForm, @NonNull String s, @Nullable String s1) {

    }
}
