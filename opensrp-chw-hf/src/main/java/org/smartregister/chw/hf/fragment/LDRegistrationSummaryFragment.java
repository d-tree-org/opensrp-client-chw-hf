package org.smartregister.chw.hf.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.smartregister.chw.hf.R;

public class LDRegistrationSummaryFragment extends Fragment {
    private TextView bmi, edd, para, pmtct, weight, height, gravida, systolic, edd_note, gest_age,
            tt_doses, hb_level, syphilis, diastolic, ipt_doses, rh_factor, pulse_rate, temperature,
            true_labour, blood_group, danger_signs, visit_number, hb_test_date, gest_age_note,
            itn_llin_used, admission_date, admission_time, children_alive, fetal_movement,
            admission_place, pmtct_test_date, respiratory_rate, fetal_heart_rate, admission_reason,
            art_prescription, labour_onset_date, labour_onset_time, ruptured_membrane, number_of_abortion,
            reason_for_referral, admitting_person_name, last_menstrual_period, membrane_ruptured_date,
            membrane_ruptured_time, management_provided_for_rh, admission_info_danger_signs,
            management_provided_for_pmtct, management_provided_for_hb_level, management_provided_for_syphilis;
    <string name="triage">Triage</string>
    <string name="systolic_blood_pressure">Systolic (Blood Pressure) :</string>
    <string name="diastolic_blood_pressure">Diastolic (Blood Pressure) :</string>
    <string name="pulse_rate_beats_per_minute">Pulse Rate (Beats per minute) :</string>
    <string name="respiratory_rate_breaths_per_minute">Respiratory Rate (Breaths per minute) :</string>
    <string name="count_fetal_heart_rate_bpm">Count Fetal Heart Rate (bpm) :</string>
    <string name="temperature_c">Temperature (C) :</string>
    <string name="weight_kg">Weight (KG) :</string>
    <string name="height_cm">Height (CM) :</string>
    <string name="body_mass_index_bmi">Body Mass Index (BMI) :</string>
    <string name="danger_signs_present">Danger signs present :</string>
    <string name="true_labour">True Labour</string>
    <string name="admission_information">Admission Information</string>
    <string name="admission_date">Admission Date :</string>
    <string name="admission_time">Admission Time :</string>
    <string name="admitting_nurse_doctor_name">Admitting Nurse/Doctor Name :</string>
    <string name="admitted_from">Admitted From :</string>
    <string name="reason_for_admission">Reason for Admission :</string>
    <string name="reason_for_referral_management_received">Reason for Referral/Management Received :</string>
    <string name="obstetric_history">Obstetric History</string>
    <string name="gravida">Gravida :</string>
    <string name="para">Para :</string>
    <string name="number_of_children_alive">Number of children alive :</string>
    <string name="number_of_abortions">Number of abortions :</string>
    <string name="last_normal_menstrual_period_lnmp">Last Normal Menstrual Period (LNMP) :</string>
    <string name="edd">Edd :</string>
    <string name="gestational_age_ga_in_weeks">Gestational Age (GA) in Weeks :</string>
    <string name="expected_date_of_delivery_edd">Expected Date of Delivery (EDD) :</string>
    <string name="gest_age">Gest Age :</string>
    <string name="anc_clinic_findings">ANC Clinic Findings</string>
    <string name="number_of_visits">Number of Visits :</string>
    <string name="ipt_doses">IPT Doses :</string>
    <string name="tt_doses">TT Doses :</string>
    <string name="was_itn_llin_used">Was ITN/LLIN used? :</string>
    <string name="last_measured_hb_level_g_dl">Last Measured HB Level (g/dl) :</string>
    <string name="was_management_provided_for_abnormal_hb_level">Was management provided for abnormal HB Level? :</string>
    <string name="last_measured_hb_date">Last Measured HB Date :</string>
    <string name="pmtct">PMTCT :</string>
    <string name="was_management_provided_for_pmtct">Was management provided for PMTCT? :</string>
    <string name="last_pmtct_test_date">Last PMTCT test Date :</string>
    <string name="art_prescription">ART/Prescription :</string>
    <string name="vdrl_syphilis">VDRL (Syphilis) :</string>
    <string name="was_management_provided_for_syphilis">Was management provided for syphilis? :</string>
    <string name="blood_group">Blood Group :</string>
    <string name="rh">Rh :</string>
    <string name="was_management_provided_for_negative_rh">Was management provided for negative RH? :</string>
    <string name="current_labour">Current Labour</string>
    <string name="labour_onset_date">Labour onset Date :</string>
    <string name="labour_onset_time">Labour onset Time :</string>
    <string name="membrane_ruptured">Membrane ruptured? :</string>
    <string name="membrane_rupture_date">Membrane rupture Date :</string>
    <string name="membrane_rupture_time">Membrane rupture Time :</string>
    <string name="fetal_movement">Fetal movement :</string>

    public LDRegistrationSummaryFragment() {
    }

    public static LDRegistrationSummaryFragment newInstance(String param1, String param2) {
        return new LDRegistrationSummaryFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_labour_and_delivery_registration_summary, container, false);

        bmi = rootView.findViewById(R.id.bmi);
        edd = rootView.findViewById(R.id.edd);
        para = rootView.findViewById(R.id.para);
        pmtct = rootView.findViewById(R.id.pmtct);
        weight = rootView.findViewById(R.id.weight);
        height = rootView.findViewById(R.id.height);
        gravida = rootView.findViewById(R.id.gravida);
        systolic = rootView.findViewById(R.id.systolic);
        edd_note = rootView.findViewById(R.id.edd_note);
        gest_age = rootView.findViewById(R.id.gest_age);
        tt_doses = rootView.findViewById(R.id.tt_doses);
        hb_level = rootView.findViewById(R.id.hb_level);
        syphilis = rootView.findViewById(R.id.syphilis);
        diastolic = rootView.findViewById(R.id.diastolic);
        ipt_doses = rootView.findViewById(R.id.ipt_doses);
        rh_factor = rootView.findViewById(R.id.rh_factor);
        pulse_rate = rootView.findViewById(R.id.pulse_rate);
        temperature = rootView.findViewById(R.id.temperature);
        true_labour = rootView.findViewById(R.id.true_labour);
        blood_group = rootView.findViewById(R.id.blood_group);
        danger_signs = rootView.findViewById(R.id.danger_signs);
        visit_number = rootView.findViewById(R.id.visit_number);
        hb_test_date = rootView.findViewById(R.id.hb_test_date);
        gest_age_note = rootView.findViewById(R.id.gest_age_note);
        itn_llin_used = rootView.findViewById(R.id.itn_llin_used);
        admission_date = rootView.findViewById(R.id.admission_date);
        admission_time = rootView.findViewById(R.id.admission_time);
        children_alive = rootView.findViewById(R.id.children_alive);
        fetal_movement = rootView.findViewById(R.id.fetal_movement);
        admission_place = rootView.findViewById(R.id.admission_place);
        pmtct_test_date = rootView.findViewById(R.id.pmtct_test_date);
        respiratory_rate = rootView.findViewById(R.id.respiratory_rate);
        fetal_heart_rate = rootView.findViewById(R.id.fetal_heart_rate);
        admission_reason = rootView.findViewById(R.id.admission_reason);
        art_prescription = rootView.findViewById(R.id.art_prescription);
        labour_onset_date = rootView.findViewById(R.id.labour_onset_date);
        labour_onset_time = rootView.findViewById(R.id.labour_onset_time);
        ruptured_membrane = rootView.findViewById(R.id.ruptured_membrane);
        number_of_abortion = rootView.findViewById(R.id.number_of_abortion);
        reason_for_referral = rootView.findViewById(R.id.reason_for_referral);
        admitting_person_name = rootView.findViewById(R.id.admitting_person_name);
        last_menstrual_period = rootView.findViewById(R.id.last_menstrual_period);
        membrane_ruptured_date = rootView.findViewById(R.id.membrane_ruptured_date);
        membrane_ruptured_time = rootView.findViewById(R.id.membrane_ruptured_time);
        management_provided_for_rh = rootView.findViewById(R.id.management_provided_for_rh);
        admission_info_danger_signs = rootView.findViewById(R.id.admission_info_danger_signs);
        management_provided_for_pmtct = rootView.findViewById(R.id.management_provided_for_pmtct);
        management_provided_for_hb_level = rootView.findViewById(R.id.management_provided_for_hb_level);
        management_provided_for_syphilis = rootView.findViewById(R.id.management_provided_for_syphilis);
        return rootView;
    }
}