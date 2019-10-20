package com.example.hello_world;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.MutableData;
import com.google.firebase.database.Transaction;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static android.content.ContentValues.TAG;


//Allen's import statements
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ProgressBar;


public class MainActivity extends AppCompatActivity {

  private static int scoreGoal = 250;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    final DatabaseReference myRef = FirebaseDatabase.getInstance().getReference().child("users");

    myRef.addValueEventListener(new ValueEventListener() {
      @Override
      public void onDataChange(DataSnapshot dataSnapshot) {
        List<User> users = new ArrayList<User>();
        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
          User user = snapshot.getValue(User.class);
          users.add(user);
        }
        Collections.sort(users,new UserComparator());
        for(int i = 0; i < users.size(); i++){
          Log.d(TAG,"Value: "+users.get(i).getName());
        }

        int[] rowUsers = {R.id.user1,R.id.user2,R.id.user3,R.id.user4,R.id.user5};
        int[] rowDaily = {R.id.user1daily,R.id.user2daily,R.id.user3daily,R.id.user4daily,R.id.user5daily};
        int[] rowTotal = {R.id.user1total, R.id.user2total, R.id.user3total, R.id.user4total, R.id.user5total};
        int[] progressBars = {R.id.progressBar1, R.id.progressBar2, R.id.progressBar3,R.id.progressBar4, R.id.progressBar5};
        for(int i = 0; i < rowUsers.length; i++){
          TextView t = findViewById(rowUsers[i]);
          if(i < users.size())
            t.setText(users.get(i).getName());
        }
        for(int i = 0; i < rowDaily.length; i++){
          TextView t = findViewById(rowDaily[i]);
          if(i < users.size())
            t.setText(String.valueOf(users.get(i).getDailyScore()));
        }
        for(int i = 0; i < rowTotal.length; i++){
          TextView t = findViewById(rowTotal[i]);
          if(i < users.size())
            t.setText(String.valueOf(users.get(i).getTotalScore()));
        }

        //progress bars.................
        for (int i = 0; i < rowUsers.length; ++i) {
          ProgressBar pb1 = findViewById(progressBars[i]);
          pb1.setMax(scoreGoal);
          pb1.setProgress(users.get(i).getTotalScore());
        }

      }

      @Override
      public void onCancelled(DatabaseError error) {
        // Failed to read value
        Log.w(TAG, "Failed to read value.", error.toException());
      }
    });

    // Create users
 /*   for(int i = 1; i < 6; i++){
      //int randomId = new Random().nextInt();
      //int randomUser = new Random().nextInt();
      //int randomScore = new Random().nextInt();
      User user = new User("User"+String.valueOf(i), 100+i*10, 100+i*10);
      myRef.child(String.valueOf(i)).setValue(user);//String.valueOf(randomId)
    }*/

    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    //Allen's code
    Button button1 = findViewById(R.id.button);
    button1.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        //updateScore(2);
        goToStartActivity(v);
      }
    });

  }

  public void goToStartActivity(View view){

    Intent intent = new Intent(this, StartActivity.class);
    startActivity(intent);
  }

  public class UserComparator implements Comparator<User> {
    @Override
    public int compare(User o1, User o2) {
      if(o1.getDailyScore() < o2.getDailyScore()) return 1;
      else return -1;
    }
  }

  public static void updateScore(final int value) {
    FirebaseUser currUser = FirebaseAuth.getInstance().getCurrentUser();
    DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
    DatabaseReference userRef = rootRef.child("users").child(currUser.getUid());
    userRef.runTransaction(new Transaction.Handler() {
      @Override
      public Transaction.Result doTransaction(MutableData mutableData) {
        User user = mutableData.getValue(User.class);
        if (user == null) {
          return Transaction.success(mutableData);
        }
        user.dailyScore += value;
        mutableData.setValue(user);
        return Transaction.success(mutableData);
      }

      @Override
      public void onComplete(DatabaseError databaseError, boolean b, DataSnapshot dataSnapshot) {}
    });
  }

}
