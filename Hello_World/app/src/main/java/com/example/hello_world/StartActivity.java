package com.example.hello_world;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static android.content.ContentValues.TAG;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        final DatabaseReference myRef = FirebaseDatabase.getInstance().getReference().child("users");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                FirebaseUser currUser = FirebaseAuth.getInstance().getCurrentUser();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    if(snapshot.getKey().equals(currUser.getUid())) {
                        User user = snapshot.getValue(User.class);
                        TextView t = findViewById(R.id.userInfo);
                        t.setText(String.valueOf(user.getDailyScore()));
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_activity);

        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);

        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                goToMainActivity(v);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                goToAddEventActivity(v);
            }
        });
    }
    public void goToMainActivity(View view){
        System.out.println("" + view.toString());
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void goToAddEventActivity(View view) {
        System.out.println(AddEventActivity.class);
        Intent intent = new Intent(this, AddEventActivity.class);
        startActivity(intent);
    }
}

