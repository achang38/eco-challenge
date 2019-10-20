package com.example;

import android.util.Log;

import com.example.hello_world.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static android.content.ContentValues.TAG;

public class databasestuff {
  private DatabaseReference myRef = FirebaseDatabase.getInstance().getReference("users");
  Map<String, User> users = new HashMap<>();

  public void readData() {

  }


  public void writeData() {
    for(int i = 0; i < 5; i++){
      int randomId = new Random().nextInt();
      int randomUser = new Random().nextInt();
      int randomScore = new Random().nextInt();
      users.put(String.valueOf(randomId), new User(String.valueOf(randomUser), randomScore));
    }
    myRef.setValue(users);
  }

  public static HashMap<String, User> sortByValue(HashMap<String, User> hm)
  {
    List<Map.Entry<String, User> > list = new LinkedList<Map.Entry<String, User> >(hm.entrySet());

    Collections.sort(list, new Comparator<Map.Entry<String, User> >() {
      public int compare(Map.Entry<String, User> o1,
                         Map.Entry<String, User> o2)
      {
        return (new Integer(o1.getValue().getScore())).compareTo(new Integer(o2.getValue().getScore()));
      }
    });

    HashMap<String, User> temp = new LinkedHashMap<String, User>();
    for (Map.Entry<String, User> aa : list) {
      temp.put(aa.getKey(), aa.getValue());
    }
    return temp;
  }
};
