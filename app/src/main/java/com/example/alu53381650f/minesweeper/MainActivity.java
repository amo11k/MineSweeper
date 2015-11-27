package com.example.alu53381650f.minesweeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridLayout;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    private static final int NUM_ROWS = 50;
    private static final int NUM_COLS = 50;
    public Boton[][] buttons;
    private GridLayout tablero;
    public int[][] proxiBombs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        crearTablero(tablero = (GridLayout) findViewById(R.id.tablero));
        ponerBombas();
        proxiBombs = new int[NUM_ROWS][NUM_ROWS];

    }

    public void crearTablero(GridLayout tablero){
        buttons = new Boton[NUM_ROWS][NUM_COLS];
        for (int i = 0; i < NUM_ROWS; i++) {
            for (int j = 0; j < NUM_COLS; j++) {
                buttons[i][j] = new Boton(getApplicationContext(), i, j);
                buttons[i][j].setLayoutParams(new GridLayout.LayoutParams());
                buttons[i][j].setPadding(0, 0, 0, 0);
                tablero.addView(buttons[i][j], new GridLayout.LayoutParams(tablero.spec(i), tablero.spec(j)));
            }
        }
    }

    public void ponerBombas(){
        int contador_bombas = 0;
        while (contador_bombas <= 45) {
            int i = (int) (Math.random() * 50-1);
            int j = (int) (Math.random() * 50-1);
            buttons[i][j].setState(Estados.BOMBA);
            contador_bombas++;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

    public void comprobar(){

    }

}
