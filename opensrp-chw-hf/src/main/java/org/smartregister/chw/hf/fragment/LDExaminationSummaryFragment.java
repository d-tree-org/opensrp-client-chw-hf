package org.smartregister.chw.hf.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import org.smartregister.chw.hf.R;

public class LDExaminationSummaryFragment extends Fragment {
    private TextView general_condition;
    private TextView pulse_rate;
    private TextView respiratory_rate;
    private TextView temperature;
    private TextView systolic;
    private TextView diastolic;
    private TextView urine_protein;
    private TextView urine_acetone;
    private TextView fundal_height;
    private TextView lie;
    private TextView presentation;
    private TextView contraction_frequency;
    private TextView contraction_in_ten_minutes;
    private TextView fetal_heart_rate;
    private TextView level;
    private TextView vaginal_exam_date;
    private TextView labour_onset_time;
    private TextView vaginal_exam_time;
    private TextView cervix_state;
    private TextView cervix_dilation;
    private TextView presenting_part;
    private TextView occiput_position;
    private TextView mento_position;
    private TextView sacro_position;
    private TextView dorso_position;
    private TextView moulding;
    private TextView moulding_options;
    private TextView station;
    private TextView amniotic_fluid;
    private TextView decision;
    private TextView forecasted_svd_time;
    private TextView hb_test_conducted;
    private TextView reason_for_not_conducting_hb_test;
    private TextView hb_level;
    private TextView management_provided_for_hb_level;
    private TextView hb_test_date;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_ld_examination_summary, container, false);
        general_condition = rootView.findViewById(R.id.ge_general_condition);
        pulse_rate = rootView.findViewById(R.id.ge_pulse_rate);
        respiratory_rate = rootView.findViewById(R.id.ge_respiratory_rate);
        temperature = rootView.findViewById(R.id.ge_temperature);
        systolic = rootView.findViewById(R.id.ge_systolic);
        diastolic = rootView.findViewById(R.id.ge_diastolic);
        urine_protein = rootView.findViewById(R.id.ge_urine_protein);
        urine_acetone = rootView.findViewById(R.id.ge_urine_acetone);
        fundal_height = rootView.findViewById(R.id.ge_fundal_height);
        lie = rootView.findViewById(R.id.ge_lie);
        presentation = rootView.findViewById(R.id.ge_presentation);
        contraction_frequency = rootView.findViewById(R.id.ge_contraction_frequency);
        contraction_in_ten_minutes = rootView.findViewById(R.id.ge_contraction_in_ten_minutes);
        fetal_heart_rate = rootView.findViewById(R.id.ge_fetal_heart_rate);
        level = rootView.findViewById(R.id.ge_level);
        vaginal_exam_date = rootView.findViewById(R.id.ge_vaginal_exam_date);
        labour_onset_time = rootView.findViewById(R.id.ge_labour_onset_time);
        vaginal_exam_time = rootView.findViewById(R.id.ge_vaginal_exam_time);
        cervix_state = rootView.findViewById(R.id.ge_cervix_state);
        cervix_dilation = rootView.findViewById(R.id.ge_cervix_dilation);
        presenting_part = rootView.findViewById(R.id.ge_presenting_part);
        occiput_position = rootView.findViewById(R.id.ge_occiput_position);
        mento_position = rootView.findViewById(R.id.ge_mento_position);
        sacro_position = rootView.findViewById(R.id.ge_sacro_position);
        dorso_position = rootView.findViewById(R.id.ge_dorso_position);
        moulding = rootView.findViewById(R.id.ge_moulding);
        moulding_options = rootView.findViewById(R.id.ge_moulding_options);
        station = rootView.findViewById(R.id.ge_station);
        amniotic_fluid = rootView.findViewById(R.id.ge_amniotic_fluid);
        decision = rootView.findViewById(R.id.ge_decision);
        forecasted_svd_time = rootView.findViewById(R.id.ge_forecasted_svd_time);
        hb_test_conducted = rootView.findViewById(R.id.ge_hb_test_conducted);
        reason_for_not_conducting_hb_test = rootView.findViewById(R.id.ge_reason_for_not_conducting_hb_test);
        hb_level = rootView.findViewById(R.id.ge_hb_level);
        management_provided_for_hb_level = rootView.findViewById(R.id.ge_management_provided_for_hb_level);
        hb_test_date = rootView.findViewById(R.id.ge_hb_test_date);
        return rootView;
    }
}