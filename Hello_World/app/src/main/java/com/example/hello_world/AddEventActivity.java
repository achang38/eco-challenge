package com.example.hello_world;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class AddEventActivity extends AppCompatActivity {
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_event);

        Button button4 = findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToStartActivity(v);
            }
        });
    }

    public void goToStartActivity(View view) {
        Intent intent = new Intent(this, StartActivity.class);
        startActivity(intent);
    }
}

