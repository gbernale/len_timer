package com.bernal.gilberto.len_timer.listeners;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.TextView;

import com.bernal.gilberto.len_timer.DateTime;

public class DismissListener implements DialogInterface.OnDismissListener {
    private TextView dateTextView;
    private DateTime selectedDateTime;
    private AlertDialog alertDialog;

    public DismissListener(TextView dateTextView, DateTime selectedDateTime, AlertDialog alertDialog) {
        this.dateTextView = dateTextView;
        this.selectedDateTime = selectedDateTime;
        this.alertDialog = alertDialog;
    }

    @Override
    public void onDismiss(DialogInterface dialogInterface) {
        updateDateTimeView(dateTextView, selectedDateTime);
        if (alertDialog != null) {
            alertDialog.show();
        }
    }

    private void updateDateTimeView(TextView textView, DateTime selectedDateTime) {
        textView.setText("Date Input : " + "\n" + selectedDateTime.getYear() + " " +
                " " + selectedDateTime.getMonth() + " " +
                "" + selectedDateTime.getDay() + "\n " +
                "Time : " + selectedDateTime.getHour() + " " +
                " " + selectedDateTime.getMinute() + "\n ");
    }

}
