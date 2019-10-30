package org.smartregister.chw.hf.presenter;

import org.apache.commons.lang3.tuple.Triple;
import org.smartregister.opd.contract.OpdRegisterActivityContract;
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
    public void onUniqueIdFetched(Triple<String, String, String> triple, String s) {
        //Overridden from the  abstract class - implementation not needed
    }

    @Override
    public void onRegistrationSaved(boolean b) {
        //Overridden from the  abstract class - implementation not needed
    }

    @Override
    public void startForm(String s, String s1, String s2, String s3) {
        //Overridden from the  abstract class - implementation not needed
    }
}