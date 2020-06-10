package org.smartregister.chw.hf.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import org.smartregister.chw.core.activity.CoreTbProfileActivity;
import org.smartregister.chw.core.activity.CoreTbUpcomingServicesActivity;
import org.smartregister.chw.core.utils.CoreConstants;
import org.smartregister.chw.hf.R;
import org.smartregister.chw.hf.adapter.ReferralCardViewAdapter;
import org.smartregister.chw.hf.contract.TbProfileContract;
import org.smartregister.chw.hf.interactor.HfTbProfileInteractor;
import org.smartregister.chw.hf.presenter.TbProfilePresenter;
import org.smartregister.chw.tb.activity.BaseTbRegistrationFormsActivity;
import org.smartregister.chw.tb.domain.TbMemberObject;
import org.smartregister.chw.tb.util.Constants;
import org.smartregister.chw.tb.util.TbUtil;
import org.smartregister.commonregistry.CommonPersonObjectClient;
import org.smartregister.domain.Task;

import java.util.Date;
import java.util.Set;

import static org.smartregister.chw.core.utils.FormUtils.getFormUtils;

public class TbProfileActivity extends CoreTbProfileActivity
        implements TbProfileContract.View {

    private CommonPersonObjectClient commonPersonObjectClient;

    public static void startTbProfileActivity(Activity activity, TbMemberObject memberObject) {
        Intent intent = new Intent(activity, TbProfileActivity.class);
        intent.putExtra(Constants.ActivityPayload.MEMBER_OBJECT, memberObject);
        activity.startActivity(intent);
    }

    public void startTbFollowupActivity(Activity activity, String baseEntityID) {
        Intent intent = new Intent(activity, BaseTbRegistrationFormsActivity.class);
        intent.putExtra(Constants.ActivityPayload.BASE_ENTITY_ID, baseEntityID);
        intent.putExtra(Constants.ActivityPayload.JSON_FORM, getFormUtils().getFormJsonFromRepositoryOrAssets(CoreConstants.JSON_FORM.getTbFollowupVisit()).toString());
        intent.putExtra(Constants.ActivityPayload.USE_DEFAULT_NEAT_FORM_LAYOUT, false);

        activity.startActivityForResult(intent, org.smartregister.chw.anc.util.Constants.REQUEST_CODE_HOME_VISIT);
    }

    public void setReferralTasks(Set<Task> taskList) {
        if (notificationAndReferralRecyclerView != null && taskList.size() > 0) {
            RecyclerView.Adapter mAdapter = new ReferralCardViewAdapter(taskList, this, getCommonPersonObjectClient(), CoreConstants.REGISTERED_ACTIVITIES.FP_REGISTER_ACTIVITY);
            notificationAndReferralRecyclerView.setAdapter(mAdapter);
            notificationAndReferralLayout.setVisibility(View.VISIBLE);
            findViewById(R.id.view_notification_and_referral_row).setVisibility(View.VISIBLE);
        }
    }

    @Override
    protected void onCreation() {
        super.onCreation();
        setCommonPersonObjectClient(getClientDetailsByBaseEntityID(getTbMemberObject().getBaseEntityId()));
    }

    @Override
    protected void onResume() {
        super.onResume();
        ((TbProfileContract.Presenter) getTbProfilePresenter()).fetchReferralTasks();
        if (notificationAndReferralRecyclerView != null && notificationAndReferralRecyclerView.getAdapter() != null) {
            notificationAndReferralRecyclerView.getAdapter().notifyDataSetChanged();
        }
    }

    public CommonPersonObjectClient getCommonPersonObjectClient() {
        return commonPersonObjectClient;
    }

    public void setCommonPersonObjectClient(CommonPersonObjectClient commonPersonObjectClient) {
        this.commonPersonObjectClient = commonPersonObjectClient;
    }

    @Override
    protected void initializePresenter() {
        showProgressBar(true);
        setTbProfilePresenter(new TbProfilePresenter(this, new HfTbProfileInteractor(this), getTbMemberObject()));
        fetchProfileData();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int itemId = item.getItemId();
        if (itemId == R.id.action_tb_outcome) {
            TbRegisterActivity.startTbFormActivity(this, getTbMemberObject().getBaseEntityId(),CoreConstants.JSON_FORM.getTbOutcome(),getFormUtils().getFormJsonFromRepositoryOrAssets(CoreConstants.JSON_FORM.getTbOutcome()).toString());
            return true;
        } else if (itemId == R.id.action_issue_tb_community_followup_referral) {
            TbRegisterActivity.startTbFormActivity(this, getTbMemberObject().getBaseEntityId(),CoreConstants.JSON_FORM.getTbIssueCommunityFollowupReferral(),getFormUtils().getFormJsonFromRepositoryOrAssets(CoreConstants.JSON_FORM.getTbIssueCommunityFollowupReferral()).toString());
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(org.smartregister.chw.core.R.menu.tb_profile_menu, menu);
        menu.findItem(R.id.action_tb_outcome).setVisible(true);
        menu.findItem(R.id.action_issue_tb_community_followup_referral).setVisible(true);
        return true;
    }

    @Override
    protected void removeMember() {
        // Not required for HF (as seen in other profile activities)?
    }

    @Override
    protected void startTbCaseClosure() {
        TbRegisterActivity.startTbFormActivity(this, getTbMemberObject().getBaseEntityId(), CoreConstants.JSON_FORM.getTbCaseClosure(), getFormUtils().getFormJsonFromRepositoryOrAssets(CoreConstants.JSON_FORM.getTbCaseClosure()).toString());
    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
        int id = view.getId();
        if (id == R.id.record_tb_followup_visit) {
            openFollowUpVisitForm(false);
        }
    }

    @Override
    public Context getContext() {
        return null;
    }

    @Override
    public void verifyHasPhone() {
        // Implement
    }

    @Override
    public void notifyHasPhone(boolean b) {
        // Implement
    }

    @Override
    public void openMedicalHistory() {
        //TODO implement
    }

    @Override
    public void openTbRegistrationForm() {
        TbRegisterActivity.startTbFormActivity(this, getTbMemberObject().getBaseEntityId(), CoreConstants.JSON_FORM.getTbRegistration(), getFormUtils().getFormJsonFromRepositoryOrAssets(CoreConstants.JSON_FORM.getTbRegistration()).toString());

    }

    @Override
    public void openUpcomingServices() {
        CoreTbUpcomingServicesActivity.startMe(this, TbUtil.toMember(getTbMemberObject()));
    }

    @Override
    public void openFamilyDueServices() {
        Intent intent = new Intent(this, FamilyProfileActivity.class);

        intent.putExtra(org.smartregister.family.util.Constants.INTENT_KEY.FAMILY_BASE_ENTITY_ID, getTbMemberObject().getFamilyBaseEntityId());
        intent.putExtra(org.smartregister.family.util.Constants.INTENT_KEY.FAMILY_HEAD, getTbMemberObject().getFamilyHead());
        intent.putExtra(org.smartregister.family.util.Constants.INTENT_KEY.PRIMARY_CAREGIVER, getTbMemberObject().getPrimaryCareGiver());
        intent.putExtra(org.smartregister.family.util.Constants.INTENT_KEY.FAMILY_NAME, getTbMemberObject().getFamilyName());

        intent.putExtra(CoreConstants.INTENT_KEY.SERVICE_DUE, true);
        startActivity(intent);
    }

    @Override
    public void openFollowUpVisitForm(boolean isEdit) {
        if (!isEdit)
            startTbFollowupActivity(this, getTbMemberObject().getBaseEntityId());
    }


    @Override
    public void updateLastVisitRow(Date lastVisitDate) {
        //overriding showing of last visit row
    }

    @Override
    public void setupFollowupVisitEditViews(boolean isWithin24Hours) {
        //overriding setupFollowupVisitEditViews row
    }


}
