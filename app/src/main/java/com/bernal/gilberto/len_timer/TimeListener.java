package com.bernal.gilberto.len_timer;

import android.app.TimePickerDialog;
import android.widget.TimePicker;

public class TimeListener implements TimePickerDialog.OnTimeSetListener{

    private DateTime selectedDateTime;

    public TimeListener(DateTime dateTime) {
        this.selectedDateTime = dateTime;
    }

    @Override
    public void onTimeSet(TimePicker timePicker, int i, int i1) {
        selectedDateTime.setHour(i);
        selectedDateTime.setMinute(i1);
    }
}
