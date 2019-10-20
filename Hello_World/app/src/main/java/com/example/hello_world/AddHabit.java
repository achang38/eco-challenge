package com.example.hello_world;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AddHabit extends AppCompatActivity {
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_habit);
        final TextView textView7 = findViewById(R.id.textView7);
        Button button_submit = findViewById(R.id.button_submit2);


        final SeekBar seekBar2 = findViewById(R.id.seekBar2);
        seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar2, int progress, boolean fromUser) {
                textView7.setText("Items: " + progress/5);


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
                    int points = seekBar2.getProgress()/5;
                    goToStart(v);

            }
        });
    }
    public void goToStart(View view) {
        Intent intent = new Intent(this,StartActivity.class);
        startActivity(intent);
    }
}
