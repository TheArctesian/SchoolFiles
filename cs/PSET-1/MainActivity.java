package edu.cis.pset1_twitteranalysis;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.StrictMode;
import edu.cis.pset1_twitteranalysis.twitter.TwitterController;


public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //This is not great, for extra credit you can fix this so that network calls happen on a different thread
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        //TODO 1: Tweet something!
        TwitterController myC = new TwitterController(this);
        myC.postTweet("i think i have fixed it"); //this will tweet to your account
        System.out.println("printed");

    }

}