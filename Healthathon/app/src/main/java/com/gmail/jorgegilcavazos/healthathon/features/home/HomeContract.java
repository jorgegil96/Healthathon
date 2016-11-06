package com.gmail.jorgegilcavazos.healthathon.features.home;

import com.github.mikephil.charting.data.BarData;

/**
 * Contract specification between the {@link HomeFragment} and the {@link HomePresenter}.
 */
public class HomeContract {

    interface View {
        void showMeasurement();

        void showBloodPressure();

        void showHeartRate();

        void showSteps();

        void showStepChart(BarData data);

        void showReminders();

        void showAdvice();
    }

    interface UserActionListener {
        void startMeasurement();

        void loadBloodPressure();

        void loadHeartRate();

        void loadSteps();

        void loadStepChart();

        void loadReminders();

        void loadAdvice();

        void detachView();
    }
}
