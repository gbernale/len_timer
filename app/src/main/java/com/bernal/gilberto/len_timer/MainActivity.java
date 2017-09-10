package com.bernal.gilberto.len_timer;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.bernal.gilberto.len_timer.listeners.DateTimeListener;
import com.bernal.gilberto.len_timer.listeners.DismissListener;

import java.util.Calendar;


public class MainActivity extends AppCompatActivity  {

    DateTime startDateTime = new DateTime();
    DateTime finishDateTime = new DateTime();
    Button startDateButton, finishDateButton;
    TextView startDateTextView, finishDateTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startDateButton = (Button) findViewById(R.id.b_pick);
        finishDateButton = (Button) findViewById(R.id.b_pick1);
        startDateTextView = (TextView) findViewById(R.id.tv_datetimeInput);
        finishDateTextView = (TextView) findViewById(R.id.tv_datetimeOutput);
        callFragmentHoursReport();
        startDateButton.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              showDialog(startDateTextView, startDateTime);

          }
      }

        );
        finishDateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(finishDateTextView, finishDateTime);
            }
        });
        }

    private void showDialog(final TextView dateTextView, final DateTime selectedDateTime) {
        java.util.Calendar c = java.util.Calendar.getInstance();
        int defaultYear = c.get(Calendar.YEAR);
        int defaultMonth = c.get(Calendar.MONTH);
        int defaultDay = c.get(Calendar.DAY_OF_MONTH);
        int defaultHour = c.get(java.util.Calendar.HOUR_OF_DAY);
        int defaultMinute = c.get(java.util.Calendar.MINUTE);
        boolean hourFormat = DateFormat.is24HourFormat(this);

        DateTimeListener dateTimeListener = new DateTimeListener(selectedDateTime);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, dateTimeListener,
                                                                       defaultYear,
                                                                       defaultMonth,
                                                                       defaultDay);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this, dateTimeListener,
                                                                       defaultHour,
                                                                       defaultMinute,
                                                                       hourFormat);

        // Set dismiss listener
        DialogInterface.OnDismissListener dateDismissListener = new DismissListener(dateTextView, selectedDateTime, timePickerDialog);
        datePickerDialog.setOnDismissListener(dateDismissListener);

        DialogInterface.OnDismissListener timeDismissListener = new DismissListener(dateTextView, selectedDateTime, null);
        timePickerDialog.setOnDismissListener(timeDismissListener);

        datePickerDialog.show();
    }

    private void callFragmentHoursReport()
    {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        HoursReportViewFragment hoursReportViewFragment = new HoursReportViewFragment();
        transaction.replace(R.id.fragment_container,hoursReportViewFragment,"Insurance");
        transaction.commit();
    }

}
