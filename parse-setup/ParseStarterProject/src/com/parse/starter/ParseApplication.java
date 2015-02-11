package com.parse.starter;

import android.app.Application;

import com.parse.GetCallback;
import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseCrashReporting;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.*;

import java.text.ParseException;


public class ParseApplication extends Application {
  String objId = "";
  @Override
  public void onCreate() {
    super.onCreate();

    // Initialize Crash Reporting.
    ParseCrashReporting.enable(this);

    // Enable Local Datastore.
    Parse.enableLocalDatastore(this);



    // Add your initialization code here
    Parse.initialize(this, "APP_ID", "CLIENT_ID");


    ParseUser.enableAutomaticUser();
    ParseUser.getCurrentUser().saveInBackground();
    ParseACL defaultACL = new ParseACL();
    // Optionally enable public read access.
     //defaultACL.setPublicReadAccess(true);
    ParseACL.setDefaultACL(defaultACL, true);
    ParseObject userInfo = new ParseObject("User_Login");

    userInfo.put("First_Name","Keith");
    userInfo.put("Last_Name","Weaver");

      //userInfo.put("/","item");
      //objId

      ParseQuery<ParseObject> query = ParseQuery.getQuery("YourClassName");
      query.whereEqualTo("ID", "someID");
      query.getFirstInBackground("first_name", new GetCallback<ParseObject>() {
          public void done(ParseObject object, ParseException e) {
              if (object == null) {
                  System.out.println("score", "The getFirst request failed.");
              } else {
                  System.out.println("score", "Retrieved the object.");
              }
          }
      });


      userInfo.saveInBackground();

  }
}
