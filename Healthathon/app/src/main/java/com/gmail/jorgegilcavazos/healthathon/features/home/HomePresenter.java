package com.gmail.jorgegilcavazos.healthathon.features.home;

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
