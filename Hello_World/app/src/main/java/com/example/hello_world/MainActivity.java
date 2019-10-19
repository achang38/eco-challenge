package com.example.hello_world;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("users");

    Map<String, User> users = new HashMap<>();
    users.put("alanisawesome", new User("June 23, 1912", "Alan Turing"));
    users.put("gracehop", new User("December 9, 1906", "Grace Hopper"));

    myRef.setValue(users);

    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

  }
}
