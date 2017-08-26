package com.example.garretthart.predatorandprey;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;
/*
finally able to put cells on a grid and change their background.
the randomize button is just to make sure the cells are capable of changing their backgrounds
as that is very important in the app
 */

public class simulationActivity extends AppCompatActivity {

    GridLayout cellGrid;
    PredatorAndPreyModel predatorPreyModel;

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


    //method called when randomized button is presssed
    void randomizeCells(View v) {

    }

}

