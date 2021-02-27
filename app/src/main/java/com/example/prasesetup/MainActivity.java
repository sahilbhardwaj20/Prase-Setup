package com.example.prasesetup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.Parse;
import com.parse.ParseAnalytics;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.SaveCallback;

import java.util.List;

import bolts.Task;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*ParseObject score = new ParseObject("Score");
        score.put("username","Vishal");
        score.put("intmarks",80);

        score.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if(e == null){
                    Log.i("Success","Score is saved");
                } else {
                    e.printStackTrace();
                }
            }
        });*/

        /*ParseQuery<ParseObject> query = ParseQuery.getQuery("Tweet");

        query.getInBackground("oQ5u20Ttca",new GetCallback<ParseObject>() {
            @Override
            public void done(ParseObject object, ParseException e) {
                if(e == null && object != null){

                    Log.i("Score",object.getString("tweetcontent"));

                } else {
                    assert e != null;
                    e.printStackTrace();
                }
            }
        });*/

        /*ParseObject tweet = new ParseObject("Tweet");
        tweet.put("username","sahilbhardwaj20");
        tweet.put("tweetcontent","i m vegan");

        tweet.saveInBackground(new SaveCallback(){

            @Override
            public void done(ParseException e) {
                if ( e == null){
                    Log.i("OK !","Save Success");
                } else {
                    e.printStackTrace();
                }
            }
        });*/

        ParseQuery<ParseObject> query = ParseQuery.getQuery("Score");

        /*query.whereEqualTo("username","Sahil");
        query.setLimit(1);*/

        //query.whereGreaterThan("intmarks",50);

        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {
                if(e == null && objects != null){
                    for(ParseObject obj : objects){

                        Log.i("Username",obj.getString("username"));
                        Log.i("Score",obj.getString("marks"));

                        /*obj.put("intmarks",obj.getInt("intmarks")-80);
                        obj.saveInBackground();*/

                    }
                }
            }
        });

        ParseAnalytics.trackAppOpenedInBackground(getIntent());
    }
}