package com.gmail.jorgegilcavazos.healthathon.features.home;

import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;
import java.util.List;

public class HomePresenter implements HomeContract.UserActionListener {

    private HomeContract.View homeView;

    public HomePresenter(HomeContract.View view) {
        homeView = view;
    }

    @Override
    public void startMeasurement() {
        if (homeView != null) {
            homeView.showMeasurement();
        }
    }

    @Override
    public void loadBloodPressure() {

    }

    @Override
    public void loadHeartRate() {

    }

    @Override
    public void loadSteps() {

    }

    @Override
    public void loadStepChart() {
        List<BarEntry> barEntries = new ArrayList<>();
        barEntries.add(new BarEntry(0, 5031));
        barEntries.add(new BarEntry(1, 6850));
        barEntries.add(new BarEntry(2, 8420));
        barEntries.add(new BarEntry(3, 7122));
        barEntries.add(new BarEntry(4, 3490));

        BarDataSet barDataSet = new BarDataSet(barEntries, null);
        barDataSet.setDrawValues(false);

        List<String> labels = new ArrayList<>();
        labels.add("Lunes");
        labels.add("Martes");
        labels.add("Miercoles");
        labels.add("Jueves");
        labels.add("Viernes");

        BarData data = new BarData(barDataSet);

        homeView.showStepChart(data);
    }

    @Override
    public void loadReminders() {

    }

    @Override
    public void loadAdvice() {

    }

    @Override
    public void detachView() {
        homeView = null;
    }
}
