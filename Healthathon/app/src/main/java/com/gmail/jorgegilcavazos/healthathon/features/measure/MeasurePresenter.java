package com.gmail.jorgegilcavazos.healthathon.features.measure;

import java.util.Random;

public class MeasurePresenter implements MeasureContract.UserActionListener {

    private MeasureContract.View measureView;
    private boolean heartShown, canceled, capped;
    private int counter, factor, constant;

    public MeasurePresenter(MeasureContract.View view) {
        measureView = view;
    }

    @Override
    public void startMeasurement() {
        heartShown = true;
        factor = 1;
        counter = 0;
        constant = 3;
        canceled = false;
        capped = false;
        measureView.showCounterValue(counter);
        measureView.setStartTitle(false);
        measureView.setCounter(true);
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    while (!isInterrupted()) {
                        Thread.sleep(500);
                        if (counter < 200 && !canceled) {
                            heartShown = !heartShown;
                            measureView.setHeartImage(heartShown);
                            measureView.showCounterValue(counter);
                            counter += factor * (constant + new Random().nextInt(4));
                        } else {
                            capped = true;
                            counter = 199;
                            constant = 0;
                            factor = -1;
                        }

                        if (capped && counter < 85) {
                            capped = false;
                            constant = 3;
                            break;
                        }
                    }
                } catch (InterruptedException e) {
                    // Handle exception
                }
            }
        };
        thread.start();
    }

    @Override
    public void cancelMeasurement() {
        canceled = true;
        counter = 0;
        factor = 1;
        constant = 3;
        capped = false;
        heartShown = true;
        measureView.setHeartImage(true);
        measureView.setCounter(false);
        measureView.setStartTitle(true);
    }

    @Override
    public void restartMeasurement() {

    }
}
