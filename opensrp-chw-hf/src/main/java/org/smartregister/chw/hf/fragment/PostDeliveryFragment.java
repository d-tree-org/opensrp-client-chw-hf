package org.smartregister.chw.hf.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.smartregister.chw.hf.R;


public class PostDeliveryFragment extends Fragment {
    private TextView vagina_observation;
    private TextView vaginal_bleeding_observation;
    private TextView perineum_observation;
    private TextView degree_of_perineum_tear;
    private TextView perineum_repair_person_name;
    private TextView perineum_repair_occupation;
    private TextView cervix_observation;
    private TextView systolic;
    private TextView diastolic;
    private TextView pulse_rate;
    private TextView temperature;
    private TextView uterus_contraction;
    private TextView urination;
    private TextView observation_date;
    private TextView observation_time;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_post_delivery, container, false);
        vagina_observation = rootView.findViewById(R.id.pd_vagina_observation);
        vaginal_bleeding_observation = rootView.findViewById(R.id.pd_vaginal_bleeding_observation);
        perineum_observation = rootView.findViewById(R.id.pd_perineum_observation);
        degree_of_perineum_tear = rootView.findViewById(R.id.pd_degree_of_perineum_tear);
        perineum_repair_person_name = rootView.findViewById(R.id.pd_perineum_repair_person_name);
        perineum_repair_occupation = rootView.findViewById(R.id.pd_perineum_repair_occupation);
        cervix_observation = rootView.findViewById(R.id.pd_cervix_observation);
        systolic = rootView.findViewById(R.id.pd_systolic);
        diastolic = rootView.findViewById(R.id.pd_diastolic);
        pulse_rate = rootView.findViewById(R.id.pd_pulse_rate);
        temperature = rootView.findViewById(R.id.pd_temperature);
        uterus_contraction = rootView.findViewById(R.id.pd_uterus_contraction);
        urination = rootView.findViewById(R.id.pd_urination);
        observation_date = rootView.findViewById(R.id.pd_observation_date);
        observation_time = rootView.findViewById(R.id.pd_observation_time);
        return rootView;
    }
}