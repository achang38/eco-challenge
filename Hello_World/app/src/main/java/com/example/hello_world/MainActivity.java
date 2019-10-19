package com.example.hello_world;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

  private class User {
    public User(String a, String b) {
      this.a = a;
      this.b = b;
    }
    private String a;
    private String b;
  };
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("message");

    myRef.setValue("Hello, World!");

    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

  }
}
