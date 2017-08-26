package com.example.garretthart.predatorandprey;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Xml;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;

import java.util.Random;
/*
finally able to put cells on a grid and change their background.
the randomize button is just to make sure the cells are capable of changing their backgrounds
as that is very important in the app.
There is now an options menu with the random tab

 */

public class simulationActivity extends AppCompatActivity {

    GridLayout cellGrid;
    PredatorAndPreyModel predatorPreyModel;

    String[] cellStates = new String[]{
            "",
            "R.drawable.predator",
            "R.drawable.prey",
            "R.drawable.nothing"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simulation);

        predatorPreyModel = new PredatorAndPreyModel();
        cellGrid = (GridLayout) findViewById(R.id.cellGrid);

        for (int i = 0; i < predatorPreyModel.numberOfCells; i++) {
            TextView cell = new TextView(this);
            cell.setBackgroundResource(R.drawable.nothing);
            predatorPreyModel.cell1dArray[i] = cell;
        }

        for (int i = 0; i < predatorPreyModel.numberOfCells; i++) {
            cellGrid.addView(predatorPreyModel.cell1dArray[i] );
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        // return true so that the menu pop up is opened
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.randomizeItem:
                randomizeCells();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    //method called when randomized button is presssed
    //the button actual just makes them all prey
    void randomizeCells() {
        for(int i = 0; i < predatorPreyModel.numberOfCells; i ++){
            predatorPreyModel.cell1dArray[i].setBackgroundResource(R.drawable.prey);
        }
    }

}

