import com.example.hello_world.User;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class databasestuff {
  public void readData() {
  }
  public void writeData() {
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("users");
    //Map <String, User> =
  }
  public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm)
  {
    // Create a list from elements of HashMap
    List<Map.Entry<String, Integer> > list =
            new LinkedList<Map.Entry<String, Integer> >(hm.entrySet());

    // Sort the list
    Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() {
      public int compare(Map.Entry<String, Integer> o1,
                         Map.Entry<String, Integer> o2)
      {
        return (o1.getValue()).compareTo(o2.getValue());
      }
    });

    // put data from sorted list to hashmap
    HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
    for (Map.Entry<String, Integer> aa : list) {
      temp.put(aa.getKey(), aa.getValue());
    }
    return temp;
  }
};
