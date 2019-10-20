package com.example.hello_world;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static android.content.ContentValues.TAG;


//Allen's import statements
import android.content.Intent;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference().child("users");

    myRef.addValueEventListener(new ValueEventListener() {
      @Override
      public void onDataChange(DataSnapshot dataSnapshot) {
        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
          User user = snapshot.getValue(User.class);
          Log.d(TAG,"Value is: "+ user.name);
        }
      }

      @Override
      public void onCancelled(DatabaseError error) {
        // Failed to read value
        Log.w(TAG, "Failed to read value.", error.toException());
      }
    });
/*    for(int i = 0; i < 5; i++){
      int randomId = new Random().nextInt();
      int randomUser = new Random().nextInt();
      int randomScore = new Random().nextInt();
      User user = new User(String.valueOf(randomUser), randomScore);
      myRef.child(String.valueOf(randomId)).setValue(user);
    }*/

    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    //Allen's code
    Button button1 = findViewById(R.id.button);
    button1.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        goToStartActivity(v);
      }
    });
  }

  public void goToStartActivity(View view){

    Intent intent = new Intent(this, StartActivity.class);
    startActivity(intent);
  }

}
