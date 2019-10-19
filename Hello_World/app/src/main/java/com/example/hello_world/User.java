package com.example.hello_world;

import java.io.FileWriter
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;
public class User {
  public void displayScore() {
  }

  public void displayNames() {
  }

  public void writeData() throws IOException{
    JSONObject json = new JSONObject();
    obj.put("Name", "Bob");
    obj.put("Score", "69");
    FileWriter file = new FileWriter("test.json");
    file.write(json.toJSONString());
  }

}
