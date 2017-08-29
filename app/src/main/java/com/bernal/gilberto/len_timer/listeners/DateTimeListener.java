package com.bernal.gilberto.len_timer.listeners;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.widget.DatePicker;
import android.widget.TimePicker;

import com.bernal.gilberto.len_timer.DateTime;

public class DateTimeListener implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {


    private DateTime selectedDateTime;

    public DateTimeListener(DateTime dateTime) {
        this.selectedDateTime = dateTime;
    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
        selectedDateTime.setYear(i);
        selectedDateTime.setMonth(i1 + 1);
        selectedDateTime.setDay(i2);
    }

    @Override
    public void onTimeSet(TimePicker timePicker, int i, int i1) {
        selectedDateTime.setHour(i);
        selectedDateTime.setMinute(i1);
    }
}
