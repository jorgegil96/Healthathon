package com.gmail.jorgegilcavazos.healthathon.features.measure;

public class MeasureContract {
    public interface View {
        void setStartTitle(boolean enable);

        void setCounter(boolean enable);

        void showCounterValue(int counter);

        void setHeartImage(boolean enable);
    }

    public interface UserActionListener {
        void startMeasurement();

        void cancelMeasurement();

        void restartMeasurement();
    }
}
