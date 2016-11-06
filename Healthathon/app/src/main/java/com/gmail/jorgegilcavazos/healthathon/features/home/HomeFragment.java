package com.gmail.jorgegilcavazos.healthathon.features.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.gmail.jorgegilcavazos.healthathon.R;
import com.gmail.jorgegilcavazos.healthathon.features.measure.MeasureActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class HomeFragment extends Fragment implements HomeContract.View {

    private HomeContract.UserActionListener actionListener;

    @BindView(R.id.btn_blood_pressure) Button btnMeasure;
    @BindView(R.id.bar_chart_activity_measure) BarChart barChart;
    private Unbinder unbinder;

    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        actionListener = new HomePresenter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        unbinder = ButterKnife.bind(this, view);

        actionListener.loadStepChart();

        btnMeasure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actionListener.startMeasurement();
            }
        });
        return view;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        actionListener.detachView();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void showMeasurement() {
        Intent intent = new Intent(getActivity(), MeasureActivity.class);
        startActivity(intent);
    }

    @Override
    public void showBloodPressure() {

    }

    @Override
    public void showHeartRate() {

    }

    @Override
    public void showSteps() {

    }

    @Override
    public void showStepChart(BarData barData) {
        barChart.setDrawBarShadow(false);
        barChart.getDescription().setEnabled(false);
        barChart.setDrawBorders(false);
        barChart.setDrawGridBackground(false);
        barChart.getXAxis().setDrawGridLines(false);
        barChart.getXAxis().setEnabled(false);
        barChart.getAxisRight().setEnabled(false);
        barChart.getAxisRight().setDrawAxisLine(false);
        barChart.getAxisRight().setDrawGridLines(false);
        barChart.getAxisLeft().setEnabled(false);
        barChart.getAxisLeft().setDrawAxisLine(false);
        barChart.getAxisLeft().setDrawGridLines(false);
        barChart.setFitBars(true);
        barChart.getLegend().setEnabled(false);
        barChart.setScaleYEnabled(false);
        barChart.setData(barData);
    }

    @Override
    public void showReminders() {

    }

    @Override
    public void showAdvice() {

    }
}
