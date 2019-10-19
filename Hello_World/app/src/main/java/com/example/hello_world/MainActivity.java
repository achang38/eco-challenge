package com.example.hello_world;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

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
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    DatabaseReference usersRef = ref.child("users");
    Map<String, User> users = new HashMap<>();
    users.put("alanisawesome", new User("June 23, 1912", "Alan Turing"));
    users.put("gracehop", new User("December 9, 1906", "Grace Hopper"));
    usersRef.setValue(users);
  }
}
