package com.example.garretthart.predatorandprey;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
/*
finally able to put cells on a grid and change their background.
the randomize button is just to make sure the cells are capable of changing their backgrounds
as that is very important in the app.
There is now an options menu with the random tab

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
            Cell cell = new Cell(this, i,predatorPreyModel);
            cell.makeNothing();
            predatorPreyModel.cellArray[i] = cell;
        }

        for (int i = 0; i < predatorPreyModel.numberOfCells; i++) {
            cellGrid.addView(predatorPreyModel.cellArray[i] );
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
            case R.id.moveCellItem:
                moveCells();
                return true;
            case R.id.makeNothingItem:
                makeAllNothing();
                return true;
            case R.id.makePredatorItem:
                makeAllPredator();
                return true;
            case R.id.makePreyItem:
                makeAllPrey();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    //method called when randomized button is presssed
    //the button actual just makes them all prey
    void randomizeCells() {
       predatorPreyModel.randomizeCells();
    }

    void makeAllNothing(){
        for (int i = 0; i < predatorPreyModel.numberOfCells; i++) {
            predatorPreyModel.cellArray[i].makeNothing();;
        }
    }

    void makeAllPredator(){
        for (int i = 0; i < predatorPreyModel.numberOfCells; i++) {
            predatorPreyModel.cellArray[i].makePredator();;
        }
    }

    void makeAllPrey(){
        for (int i = 0; i < predatorPreyModel.numberOfCells; i++) {
            predatorPreyModel.cellArray[i].makePrey();;
        }
    }


    //this function is not working right now
    //idk why but the rest of the program is
    //in a good state
    void moveCells(){
        predatorPreyModel.moveCell(1000);
    }
}

