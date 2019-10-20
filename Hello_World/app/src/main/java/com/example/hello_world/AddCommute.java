package com.example.hello_world;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AddCommute extends AppCompatActivity {
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_commute);

        final RadioButton bike = findViewById(R.id.commute_bike);
        final RadioButton carpool = findViewById(R.id.commute_carpool);
        final RadioButton pub_transport = findViewById(R.id.commute_pub_transport);
        final RadioButton walk = findViewById(R.id.commute_walk);
        final TextView textView6 = findViewById(R.id.textView6);
        Button button_submit = findViewById(R.id.button_submit);

        final SeekBar seekBar = findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textView6.setText("Minutes: " + progress);


            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            });

        button_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bike.isChecked()) {
                    int points = seekBar.getProgress()/5;
                    goToStart(v);
                }
                else if (carpool.isChecked()) {
                    int points = seekBar.getProgress()/6;
                    goToStart(v);
                }
                else if (pub_transport.isChecked()) {
                    int points = seekBar.getProgress()/7;
                    goToStart(v);
                }
                else if (walk.isChecked()) {
                    int points = seekBar.getProgress()/8;
                    goToStart(v);
                }
                else {
                    goToStart(v);
                }
            }
        });
    }
    public void goToStart(View view) {
        Intent intent = new Intent(this,StartActivity.class);
        startActivity(intent);
    }
}