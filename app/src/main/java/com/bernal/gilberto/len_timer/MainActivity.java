package com.bernal.gilberto.len_timer;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;


public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {

    private final DateTime startDate = new DateTime();
    private final DateTime finishDate = new DateTime();
    Button b_pick, b_pick1;
    TextView tv_datetimeInput, tv_datetimeOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b_pick = (Button) findViewById(R.id.b_pick);
        b_pick1 = (Button) findViewById(R.id.b_pick1);
        tv_datetimeInput = (TextView) findViewById(R.id.tv_datetimeInput);
        tv_datetimeOutput = (TextView) findViewById(R.id.tv_datetimeOutput);

        b_pick.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View view) {

                                          java.util.Calendar c = java.util.Calendar.getInstance();
                                          int defaultYear = c.get(java.util.Calendar.YEAR);
                                          int defaultMonth = c.get(java.util.Calendar.MONTH);
                                          int defaultDay = c.get(java.util.Calendar.DAY_OF_MONTH);

                                          DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, MainActivity.this, defaultYear, defaultMonth, defaultDay);
                                          datePickerDialog.show();

                                      }
                                  }

        );
        b_pick1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                java.util.Calendar c = java.util.Calendar.getInstance();
                int defaultYear = c.get(java.util.Calendar.YEAR);
                int defaultMonth = c.get(java.util.Calendar.MONTH);
                int defaultDay = c.get(java.util.Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, MainActivity.this, defaultYear, defaultMonth, defaultDay);
                datePickerDialog.show();
            }
        });
        }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {

        startDate.setYear(i);
        startDate.setMonth(i1 + 1);
        startDate.setDay(i2);
        finishDate.setYear(i);
        finishDate.setMonth(i1+1);
        finishDate.setDay(i2);
        java.util.Calendar c = java.util.Calendar.getInstance();
        int defaultHour = c.get(java.util.Calendar.HOUR_OF_DAY);
        int defaultMinute = c.get(java.util.Calendar.MINUTE);
        TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity.this, MainActivity.this, defaultHour, defaultMinute, android.text.format.DateFormat.is24HourFormat(this));
        timePickerDialog.show();


    }

    @Override
    public void onTimeSet(TimePicker timePicker, int i, int i1) {

       startDate.setHour(i);
       startDate.setMinute(i1);
        if(startDate.getHour()<12) {
            tv_datetimeInput.setText("Date Input : "+ "\n" + startDate.getYear() + " " +
                    " " + startDate.getMonth() + " " +
                    "" + startDate.getDay() + "\n " +
                    "Time : " + startDate.getHour() + " " +
                    " " + startDate.getMinute() + "\n ");
        } else {

            finishDate.setHour(i);
            finishDate.setMinute(i1);
            tv_datetimeOutput.setText("Date Output : "+"\n" + startDate.getYear() + " " +
                    " " + finishDate.getMonth() + " " +
                    "" + finishDate.getDay() + "\n " +
                    "Time : " + finishDate.getHour() + " " +
                    " " + finishDate.getMinute() + "\n ");



        }
    }

}
