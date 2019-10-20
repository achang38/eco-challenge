package com.example.eco_challenge;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

public class AddEventActivity extends AppCompatActivity {
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_event);

        final RadioButton radio_commute = findViewById(R.id.radio_commute);
        final RadioButton radio_habit = findViewById(R.id.radio_habit);
        Button button4 = findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToStartActivity(v);
            }
        });

        Button button_next = findViewById(R.id.button_next);
        button_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (radio_commute.isChecked()) {
                    goToCommuteActivity(v);
                }
                if (radio_habit.isChecked()) {
                    goToHabit(v);
                }
            }
        });


    }

    public void goToCommuteActivity(View view) {
        Intent intent = new Intent(this,AddCommute.class);
        startActivity(intent);
    }
    public void goToStartActivity(View view) {
        Intent intent = new Intent(this, StartActivity.class);
        startActivity(intent);
    }

    public void goToHabit(View view) {
        Intent intent = new Intent(this, AddHabit.class);
        startActivity(intent);
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio_habit:
                if (checked) {
                    Intent intent = new Intent(this, AddHabit.class);
                    startActivity(intent);
                    break;
                }
            case R.id.radio_commute:
                if (checked) {
                    Intent intent = new Intent(this, AddCommute.class);
                    startActivity(intent);
                    break;
                }
        }
    }
}

