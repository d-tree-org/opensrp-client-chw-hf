package org.smartregister.chw.hf.presenter;

import android.support.annotation.NonNull;

import org.apache.commons.lang3.tuple.Triple;
import org.smartregister.opd.contract.OpdRegisterActivityContract;
import org.smartregister.opd.pojos.RegisterParams;
import org.smartregister.opd.presenter.BaseOpdRegisterActivityPresenter;

public class AllClientsRegisterPresenter extends BaseOpdRegisterActivityPresenter {

    public AllClientsRegisterPresenter(OpdRegisterActivityContract.View view, OpdRegisterActivityContract.Model model) {
        super(view, model);
    }

    @Override
    public void onNoUniqueId() {
        //Overridden from the abstract class - implementation not needed
    }

    @Override
    public void onRegistrationSaved(boolean b) {
        //Overridden from the  abstract class - implementation not needed
    }

    @Override
    public void onUniqueIdFetched(Triple<String, String, String> triple, String s) {
        //Overridden from the  abstract class - implementation not needed
    }

    @Override
    public void saveForm(String s, @NonNull RegisterParams registerParams) {
        //Overridden from the  abstract class - implementation not needed
    }
}
