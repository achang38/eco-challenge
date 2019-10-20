package com.example.hello_world;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.databasestuff;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static android.content.ContentValues.TAG;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("user");

    myRef.addValueEventListener(new ValueEventListener() {
      @Override
      public void onDataChange(DataSnapshot dataSnapshot) {
        // This method is called once with the initial value and again
        // whenever data at this location is updated.
        Map<String,Map> value = (Map<String,Map>)dataSnapshot.getValue();
        Log.d(TAG, "Value is: " + value);
        //databasestuff.sortByValue(value);
        for (Map.Entry<String,Map> entry : value.entrySet()) {
          Log.d(TAG, "Value is: " + entry.getValue().get(1));//u.getName() + " " + u.getScore()
        }

      }

      @Override
      public void onCancelled(DatabaseError error) {
        // Failed to read value
        Log.w(TAG, "Failed to read value.", error.toException());
      }
    });


/*
    Map<String, User> users = new HashMap<>();
    for(int i = 0; i < 5; i++){
      int randomId = new Random().nextInt();
      int randomUser = new Random().nextInt();
      int randomScore = new Random().nextInt();
      users.put(String.valueOf(randomId), new User(String.valueOf(randomUser), randomScore));
    }
    myRef.setValue(users);
*/

    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

  }
}
