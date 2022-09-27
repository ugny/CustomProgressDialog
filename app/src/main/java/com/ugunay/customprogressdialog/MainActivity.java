package com.ugunay.customprogressdialog;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();

        CustomProgressDialog dialog_1 = CustomProgressDialog.getInstance(fragmentManager);
        dialog_1.setCancelable(false);
        dialog_1.setMessage("Loading . . .");
        dialog_1.show();

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                dialog_1.dismiss();

                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        CustomProgressDialog.setBackgroundColor(getResources().getColor(R.color.teal_200));
                        CustomProgressDialog.setIndeterminateTintAndTextColor(Color.BLUE);

                        CustomProgressDialog dialog_2 = CustomProgressDialog.getInstance(fragmentManager);
                        dialog_2.setCancelable(false);
                        dialog_2.setMessage("Saving . . .");
                        dialog_2.show();

                        new Timer().schedule(new TimerTask() {
                            @Override
                            public void run() {
                                dialog_2.dismiss();
                            }
                        }, 5000);
                    }
                }, 2000);
            }
        }, 5000);

    }

}