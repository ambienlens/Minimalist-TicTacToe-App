//DEBAYAN MAJUMDER 2020
package com.example.minimalisttictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //player1: cross ; player2: circle
    int activePlayer=1;
    boolean activeGame = true;
    int[] tracker = {2, 2, 2, 2, 2, 2, 2, 2, 2 };
    int[][] winPosition = {{1,2,3},{4,5,6},{7,8,9},{1,4,7},{2,5,8},{3,6,9},{1,5,9},{3,5,7}};

    public void resetGame(View view)
    {
        TextView  winOut=(TextView)findViewById(R.id.winOutput);
        Button resetButton=(Button)findViewById(R.id.winButton);
        winOut.setAlpha(0);
        resetButton.setVisibility(View.INVISIBLE);

        activePlayer=1;
        activeGame=true;
        for(int i=1;i<=9;i++)
        {
            tracker[i-1]=2;
        }

        ImageView image1=(ImageView)findViewById(R.id.image1);
        ImageView image2=(ImageView)findViewById(R.id.image2);
        ImageView image3=(ImageView)findViewById(R.id.image3);
        ImageView image4=(ImageView)findViewById(R.id.image4);
        ImageView image5=(ImageView)findViewById(R.id.image5);
        ImageView image6=(ImageView)findViewById(R.id.image6);
        ImageView image7=(ImageView)findViewById(R.id.image7);
        ImageView image8=(ImageView)findViewById(R.id.image8);
        ImageView image9=(ImageView)findViewById(R.id.image9);

        image1.setAlpha(0f);
        image1.setImageDrawable(null);
        image2.setAlpha(0f);
        image2.setImageDrawable(null);
        image3.setAlpha(0f);
        image3.setImageDrawable(null);
        image4.setAlpha(0f);
        image4.setImageDrawable(null);
        image5.setAlpha(0f);
        image5.setImageDrawable(null);
        image6.setAlpha(0f);
        image6.setImageDrawable(null);
        image7.setAlpha(0f);
        image7.setImageDrawable(null);
        image8.setAlpha(0f);
        image8.setImageDrawable(null);
        image9.setAlpha(0f);
        image9.setImageDrawable(null);

        Log.i("Info:","Button Pressed");
    }

    public void startGame(View view) {
        TextView winOut = (TextView) findViewById(R.id.winOutput);
        Button resetButton = (Button) findViewById(R.id.winButton);

        ImageView counter = (ImageView) view;
        String getTag = counter.getTag().toString();
        int tag = Integer.parseInt(getTag);

        if (tracker[tag] == 2) {
            counter.animate().alpha(0);
            tracker[tag] = activePlayer;

            if (activePlayer == 1) {
                counter.setImageResource(R.drawable.tictactoe_cross);
                activePlayer = 0;
            } else if (activePlayer == 0) {
                counter.setImageResource(R.drawable.tictactoe_circle);
                activePlayer = 1;
            }
            counter.animate().alpha(1).setDuration(500);

            for (int i = 0; i < 8; i++) {
                int a = winPosition[i][0] - 1;
                int b = winPosition[i][1] - 1;
                int c = winPosition[i][2] - 1;


                if ((tracker[a] == tracker[b]) && (tracker[b] == tracker[c]) && (tracker[a] != 2) && (activeGame)) {
                    if (tracker[a] == 1) {
                        winOut.setText("Game Over! Cross wins");
                    } else {
                        winOut.setText("Game Over! Circle wins");
                    }
                    winOut.setAlpha(1);
                    resetButton.setVisibility(View.VISIBLE);
                    activeGame = false;
                }
            }
            int c1 = 0;
                    for (int k = 0; k < 9; k++) {
                        if (tracker[k] == 2)
                            c1++;
                    }

                    if (c1 == 0) {
                        winOut.setText("Game Tied!");
                        winOut.setAlpha(1);
                        resetButton.setVisibility(View.VISIBLE);
                        activeGame = false;
                    }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}