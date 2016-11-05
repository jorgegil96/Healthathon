package com.gmail.jorgegilcavazos.healthathon.features.home;

/**
 * Contract specification between the {@link HomeFragment} and the {@link HomePresenter}.
 */
public class HomeContract {

    interface View {
        void showBloodPressure();

        void showHeartRate();

        void showSteps();

        void showReminders();

        void showAdvice();
    }

    interface UserActionListener {
        void startMeasurement();

        void loadBloodPressure();

        void loadHeartRate();

        void loadSteps();

        void loadReminders();

        void loadAdvice();
    }
}
