package com.gmail.jorgegilcavazos.healthathon.features.measure;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.gmail.jorgegilcavazos.healthathon.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MeasureActivity extends AppCompatActivity implements MeasureContract.View {
    private static final String TAG = "MeasureActivity";

    private MeasureContract.UserActionListener actionListener;

    private int counter;
    private BarChart barChart;
    @BindView(R.id.toolbar_activity_measure) Toolbar toolbar;
    @BindView(R.id.tv_measure_pressure) TextView tvCounter;
    @BindView(R.id.tv_measure_start) TextView tvStart;
    @BindView(R.id.iv_heart) ImageView ivHeart;
    @BindView(R.id.btn_restart) Button btnRestart;
    @BindView(R.id.btn_cancel) Button btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_measure);
        ButterKnife.bind(this);

        setUpToolbar();
        setTitle("Medición");

        actionListener = new MeasurePresenter(this);
        counter = 0;
        setCounter(false);
        setHeartImage(true);
        setStartTitle(true);

        tvStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actionListener.startMeasurement();
            }
        });

        ivHeart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actionListener.startMeasurement();
            }
        });

        btnRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actionListener.restartMeasurement();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actionListener.cancelMeasurement();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setUpToolbar() {
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            ActionBar actionBar = getSupportActionBar();
            if (actionBar != null) {
                actionBar.setDisplayHomeAsUpEnabled(true);
            }
        }
    }

    @Override
    public void setStartTitle(boolean enable) {
        if (enable) {
            tvStart.setVisibility(View.VISIBLE);
        } else {
            tvStart.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void setCounter(boolean enable) {
        if (enable) {
            tvCounter.setVisibility(View.VISIBLE);
        } else {
            tvCounter.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void showCounterValue(final int counter) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                tvCounter.setText(String.valueOf(counter));
            }
        });
    }

    @Override
    public void setHeartImage(final boolean enable) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (enable) {
                    ivHeart.setVisibility(View.VISIBLE);
                } else {
                    ivHeart.setVisibility(View.INVISIBLE);
                }
            }
        });
    }
}
