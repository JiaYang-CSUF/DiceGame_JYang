package com.example.dicegame01;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    // roll to get the result vaule
    TextView rollResult1;

    // roll to get the result vaule
    TextView rollResult2;

    // btn of the game
    Button rollButton;


    // random number generator
    Random rand;

    // die1 and die2 are the computer generator
    int die1;
    int die2;

    // die3 is be long to player, and computer will genrated
    int die3;
    // player's number will create here



    //ArrayList to hold all dice values
    ArrayList<Integer> dice;

    //ArrayList to hold all the dice images
    ArrayList<ImageView> diceImageViews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        // the two results
        rollResult1 = (TextView) findViewById(R.id.rollResult1);
        rollResult2 = (TextView) findViewById(R.id.rollResult2);

        // play button
        rollButton = (Button) findViewById(R.id.rollButton);


        // Init the random number
        rand = new Random();

        // dice array
        dice = new ArrayList<Integer>();

        // image array
        ImageView die1Image = (ImageView) findViewById(R.id.die1Image);
        ImageView die2Image = (ImageView) findViewById(R.id.die2Image);
        ImageView die3Image = (ImageView) findViewById(R.id.die3Image);

        diceImageViews = new ArrayList<ImageView>();
        diceImageViews.add(die1Image);
        diceImageViews.add(die2Image);
        diceImageViews.add(die3Image);

    }



    public void rollDice(View v) {



        // computer roll dices
        die1 = rand.nextInt(6)+1;
        die2 = rand.nextInt(6)+1;
        die3 = rand.nextInt(6)+1;

        //dice values into a ArrayList
        dice.clear();
        dice.add(die1);
        dice.add(die2);
        dice.add(die3);

        // link the images from assets folder
        for (int dieofSet = 0; dieofSet < 3; dieofSet++){
            String imageName = "die_" + dice.get(dieofSet) + ".jpg";

            try{
                InputStream stream = getAssets().open(imageName);
                Drawable d = Drawable.createFromStream(stream,null);
                diceImageViews.get(dieofSet).setImageDrawable(d);

            } catch (IOException e){
                e.printStackTrace();
            }
        }

        //result the message
        String msg1 = "The computer first dice is " + die1 + ", the second dice is " + die2 + ".";

        String msg2 = "The player dice is " + die3 + "." + " Player need to select number...";

        //player need to select number.................

        //display the result message
        rollResult1.setText(msg1);
        rollResult2.setText(msg2);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

