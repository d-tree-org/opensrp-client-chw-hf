package org.smartregister.chw.hf.activity;

import android.content.Intent;
import android.support.annotation.NonNull;

import org.json.JSONObject;
import org.smartregister.chw.hf.fragment.AllClientsRegisterFragment;
import org.smartregister.chw.hf.presenter.AllClientsRegisterPresenter;
import org.smartregister.helper.BottomNavigationHelper;
import org.smartregister.opd.activity.BaseOpdRegisterActivity;
import org.smartregister.opd.contract.OpdRegisterActivityContract;
import org.smartregister.opd.presenter.BaseOpdRegisterActivityPresenter;
import org.smartregister.view.fragment.BaseRegisterFragment;

public class AllClientsRegisterActivity extends BaseOpdRegisterActivity {
    @Override
    protected BaseRegisterFragment getRegisterFragment() {
        return new AllClientsRegisterFragment();
    }

    @Override
    public void startFormActivity(JSONObject jsonObject) {
        //Overridden
    }

    @Override
    protected void onActivityResultExtended(int i, int i1, Intent intent) {
        //Overridden
    }

    @Override
    protected void registerBottomNavigation() {
        bottomNavigationHelper = new BottomNavigationHelper();
        bottomNavigationView = findViewById(org.smartregister.R.id.bottom_navigation);
        FamilyRegisterActivity.registerBottomNavigation(bottomNavigationHelper, bottomNavigationView, this);
    }

    @Override
    protected BaseOpdRegisterActivityPresenter createPresenter(@NonNull OpdRegisterActivityContract.View view, @NonNull OpdRegisterActivityContract.Model model) {
        return new AllClientsRegisterPresenter(view, model);
    }

    @Override
    public void switchToBaseFragment() {
        Intent intent = new Intent(this, FamilyRegisterActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void startRegistration() {
        //Overridden
    }
}
