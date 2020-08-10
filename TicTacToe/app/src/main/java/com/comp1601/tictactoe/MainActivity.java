package com.comp1601.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button mbutton0;
    private Button mbutton1;
    private Button mbutton2;
    private Button mbutton3;
    private Button mbutton4;
    private Button mbutton5;
    private Button mbutton6;
    private Button mbutton7;
    private Button mbutton8;
    private Button mReset;
    private TextView xScore;
    private TextView oScore;
    private int Xcounter=0;
    private int Ocounter=0;



    private static String XCOUNTER="xcounter";//used to store the scores when rotating
    private static String OCOUNTER="ocounter";
    final TicTacToeGame tic = new TicTacToeGame();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        mbutton0=findViewById(R.id.button0);
        mbutton1=findViewById(R.id.button1);
        mbutton2=findViewById(R.id.button2);
        mbutton3=findViewById(R.id.button3);
        mbutton4=findViewById(R.id.button4);
        mbutton5=findViewById(R.id.button5);
        mbutton6=findViewById(R.id.button6);
        mbutton7=findViewById(R.id.button7);
        mbutton8=findViewById(R.id.button8);
        xScore=findViewById(R.id.xscore);
        oScore=findViewById(R.id.oscore);
        mReset=findViewById(R.id.bReset);
        final Button[]buttonarray={mbutton0,mbutton1,mbutton2,mbutton3,mbutton4,mbutton5,mbutton6,mbutton7,mbutton8};

        if(savedInstanceState != null) {
            //get the scores
            Ocounter = savedInstanceState.getInt(OCOUNTER);
            Xcounter = savedInstanceState.getInt(XCOUNTER);
            //get the board that was saved
            String[] positions=savedInstanceState.getStringArray("positions");
            //set the board in the class
            tic.setPositions(positions);
            for(int i=0;i<buttonarray.length;i++){
                //modify the buttons so that it displays the board
                if(!positions[i].equals(" ")){
                    buttonarray[i].setEnabled(false);
                    buttonarray[i].setText(positions[i]);//set text to the text found in the board

                }
            }
            win();//call win function to highlight the row that won if there was a winner before the rotation
        }
        //set the scores
        xScore.setText(String.valueOf(Xcounter));
        oScore.setText(String.valueOf(Ocounter));
        mReset.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i=0;i<buttonarray.length;i++){
                    //reset all buttons
                    buttonarray[i].setBackgroundColor(Color.LTGRAY);
                    buttonarray[i].setText("");
                    buttonarray[i].setEnabled(true);

                }
                //reset the board in the class
                int bot=tic.reset();
                //if the reset returns -1, it means that the player starts the new round
                if(bot!=-1){
                    buttonarray[bot].setText(tic.getBotRole());
                    buttonarray[bot].setEnabled(false);
                }
            }
        }));
        mbutton0.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //call play at the postion that was presssed
                //it returns the position that the bot played
                int botTurn=tic.play(tic.getPlayerRole(),0);
                Button b=(Button)v;
                //set the button
                b.setText(tic.getPlayerRole());
                b.setEnabled(false);
                //if the bot played
                if(botTurn!=-1) {
                    //set the position that the bot played
                    buttonarray[botTurn].setText(tic.getBotRole());
                    buttonarray[botTurn].setEnabled(false);
                    //if theres a winner
                }if(tic.winner()!=null){

                    //if x won
                    if(tic.winner()=="X"){
                        xScore.setText(String.valueOf(++Xcounter));
                    }else{
                        oScore.setText(String.valueOf(++Ocounter));
                    }
                    //highlight the row
                    win();//display toasts
                    Toast.makeText(MainActivity.this,
                            tic.winner()+" wins", Toast.LENGTH_SHORT).show();

                }else if(tic.drawGame()){//if tis a draw
                    Toast.makeText(MainActivity.this,
                            getString(R.string.draw), Toast.LENGTH_SHORT).show();

                }

            }
        }));
        mbutton1.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int botTurn=tic.play(tic.getPlayerRole(),1);
                Button b=(Button)v;

                b.setText(tic.getPlayerRole());
                b.setEnabled(false);
                if(botTurn!=-1) {
                    buttonarray[botTurn].setText(tic.getBotRole());
                    buttonarray[botTurn].setEnabled(false);
                }   if(tic.winner()!=null){
                    if(tic.winner()=="X"){
                        xScore.setText(String.valueOf(++Xcounter));
                    }else{
                        oScore.setText(String.valueOf(++Ocounter));
                    }
                    win();
                    Toast.makeText(MainActivity.this,
                            tic.winner()+" wins", Toast.LENGTH_SHORT).show();

                }else if(tic.drawGame()){
                    Toast.makeText(MainActivity.this,
                            getString(R.string.draw), Toast.LENGTH_SHORT).show();

                }
            }
        }));
        mbutton2.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int botTurn=tic.play(tic.getPlayerRole(),2);
                Button b=(Button)v;

                b.setText(tic.getPlayerRole());
                b.setEnabled(false);

                if(botTurn!=-1) {
                    buttonarray[botTurn].setText(tic.getBotRole());
                    buttonarray[botTurn].setEnabled(false);
                }   if(tic.winner()!=null){
                    if(tic.winner()=="X"){
                        xScore.setText(String.valueOf(++Xcounter));
                    }else{
                        oScore.setText(String.valueOf(++Ocounter));
                    }
                    win();
                    Toast.makeText(MainActivity.this,
                            tic.winner()+" wins", Toast.LENGTH_SHORT).show();

                }else if(tic.drawGame()){
                    Toast.makeText(MainActivity.this,
                            getString(R.string.draw), Toast.LENGTH_SHORT).show();

                }
            }
        }));
        mbutton3.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int botTurn=tic.play(tic.getPlayerRole(),3);
                Button b=(Button)v;

                b.setText(tic.getPlayerRole());
                b.setEnabled(false);
                if(botTurn!=-1) {
                    buttonarray[botTurn].setText(tic.getBotRole());
                    buttonarray[botTurn].setEnabled(false);
                }   if(tic.winner()!=null){
                    if(tic.winner()=="X"){
                        xScore.setText(String.valueOf(++Xcounter));
                    }else{
                        oScore.setText(String.valueOf(++Ocounter));
                    }
                    win();
                    Toast.makeText(MainActivity.this,
                            tic.winner()+" wins", Toast.LENGTH_SHORT).show();

                }else if(tic.drawGame()){
                    Toast.makeText(MainActivity.this,
                            getString(R.string.draw), Toast.LENGTH_SHORT).show();

                }
            }
        }));
        mbutton4.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int botTurn=tic.play(tic.getPlayerRole(),4);
                Button b=(Button)v;


                b.setText(tic.getPlayerRole());
                b.setEnabled(false);

                if(botTurn!=-1) {
                    buttonarray[botTurn].setText(tic.getBotRole());
                    buttonarray[botTurn].setEnabled(false);
                }   if(tic.winner()!=null){
                    if(tic.winner()=="X"){
                        xScore.setText(String.valueOf(++Xcounter));
                    }else{
                        oScore.setText(String.valueOf(++Ocounter));
                    }
                    win();
                    Toast.makeText(MainActivity.this,
                            tic.winner()+" wins", Toast.LENGTH_SHORT).show();

                }else if(tic.drawGame()){
                    Toast.makeText(MainActivity.this,
                            getString(R.string.draw), Toast.LENGTH_SHORT).show();

                }
            }
        }));
        mbutton5.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int botTurn=tic.play(tic.getPlayerRole(),5);
                Button b=(Button)v;


                b.setText(tic.getPlayerRole());
                b.setEnabled(false);

                if(botTurn!=-1) {
                    buttonarray[botTurn].setText(tic.getBotRole());
                    buttonarray[botTurn].setEnabled(false);
                }   if(tic.winner()!=null){
                    if(tic.winner()=="X"){
                        xScore.setText(String.valueOf(++Xcounter));
                    }else{
                        oScore.setText(String.valueOf(++Ocounter));
                    }
                    win();
                    Toast.makeText(MainActivity.this,
                            tic.winner()+" wins", Toast.LENGTH_SHORT).show();

                }else if(tic.drawGame()){
                    Toast.makeText(MainActivity.this,
                            getString(R.string.draw), Toast.LENGTH_SHORT).show();

                }
            }
        }));
        mbutton6.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int botTurn=tic.play(tic.getPlayerRole(),6);
                Button b=(Button)v;

                b.setText(tic.getPlayerRole());
                b.setEnabled(false);

                if(botTurn!=-1) {
                    buttonarray[botTurn].setText(tic.getBotRole());
                    buttonarray[botTurn].setEnabled(false);
                }   if(tic.winner()!=null){
                    if(tic.winner()=="X"){
                        xScore.setText(String.valueOf(++Xcounter));
                    }else{
                        oScore.setText(String.valueOf(++Ocounter));
                    }
                    win();
                    Toast.makeText(MainActivity.this,
                            tic.winner()+" wins", Toast.LENGTH_SHORT).show();

                }else if(tic.drawGame()){
                    Toast.makeText(MainActivity.this,
                            getString(R.string.draw), Toast.LENGTH_SHORT).show();

                }
            }
        }));
        mbutton7.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int botTurn=tic.play(tic.getPlayerRole(),7);
                Button b=(Button)v;

                b.setText(tic.getPlayerRole());
                b.setEnabled(false);

                if(botTurn!=-1) {
                    buttonarray[botTurn].setText(tic.getBotRole());
                    buttonarray[botTurn].setEnabled(false);
                }   if(tic.winner()!=null){
                    if(tic.winner()=="X"){
                        xScore.setText(String.valueOf(++Xcounter));
                    }else{
                        oScore.setText(String.valueOf(++Ocounter));
                    }
                    win();
                    Toast.makeText(MainActivity.this,
                            tic.winner()+" wins", Toast.LENGTH_SHORT).show();

                }else if(tic.drawGame()){
                    Toast.makeText(MainActivity.this,
                            getString(R.string.draw), Toast.LENGTH_SHORT).show();

                }
            }
        }));
        mbutton8.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int botTurn=tic.play(tic.getPlayerRole(),8);
                Button b=(Button)v;

                b.setText(tic.getPlayerRole());
                b.setEnabled(false);

                if(botTurn!=-1) {
                    buttonarray[botTurn].setText(tic.getBotRole());
                    buttonarray[botTurn].setEnabled(false);
                }   if(tic.winner()!=null){
                    if(tic.winner()=="X"){
                        xScore.setText(String.valueOf(++Xcounter));
                    }else{
                        oScore.setText(String.valueOf(++Ocounter));
                    }
                    win();
                    Toast.makeText(MainActivity.this,
                            tic.winner()+" wins", Toast.LENGTH_SHORT).show();

                }else if(tic.drawGame()){
                    Toast.makeText(MainActivity.this,
                            getString(R.string.draw), Toast.LENGTH_SHORT).show();

                }
            }
        }));



    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt(XCOUNTER,Xcounter);
        savedInstanceState.putInt(OCOUNTER,Ocounter);
        savedInstanceState.putStringArray("positions",tic.getPositions());

        System.out.println("onsavedinstance");
    }
    public void win(){
        //all winning condtions
        //used to highlight the winning row
        if(mbutton0.getText().equals(mbutton1.getText())&&mbutton1.getText().equals(mbutton2.getText())&&!mbutton0.getText().equals("")){
            mbutton0.setBackgroundColor(Color.RED);
            mbutton1.setBackgroundColor(Color.RED);
            mbutton2.setBackgroundColor(Color.RED);
        }else if(mbutton0.getText().equals(mbutton3.getText())&&mbutton3.getText().equals(mbutton6.getText())&&!mbutton0.getText().equals("")) {
            mbutton0.setBackgroundColor(Color.RED);
            mbutton3.setBackgroundColor(Color.RED);
            mbutton6.setBackgroundColor(Color.RED);
        }else if(mbutton0.getText().equals(mbutton4.getText())&&mbutton4.getText().equals(mbutton8.getText())&&!mbutton0.getText().equals("")) {
            mbutton0.setBackgroundColor(Color.RED);
            mbutton4.setBackgroundColor(Color.RED);
            mbutton8.setBackgroundColor(Color.RED);
        }else if(mbutton1.getText().equals(mbutton4.getText())&&mbutton4.getText().equals(mbutton7.getText())&&!mbutton1.getText().equals("")) {
            mbutton1.setBackgroundColor(Color.RED);
            mbutton4.setBackgroundColor(Color.RED);
            mbutton7.setBackgroundColor(Color.RED);
        }else if(mbutton3.getText().equals(mbutton4.getText())&&mbutton4.getText().equals(mbutton5.getText())&&!mbutton3.getText().equals("")){
            mbutton3.setBackgroundColor(Color.RED);
            mbutton4.setBackgroundColor(Color.RED);
            mbutton5.setBackgroundColor(Color.RED);
        }else if(mbutton6.getText().equals(mbutton7.getText())&&mbutton7.getText().equals(mbutton8.getText())&&!mbutton6.getText().equals("")){
            mbutton6.setBackgroundColor(Color.RED);
            mbutton7.setBackgroundColor(Color.RED);
            mbutton8.setBackgroundColor(Color.RED);

        }else if(mbutton2.getText().equals(mbutton5.getText())&&mbutton5.getText().equals(mbutton8.getText())&&!mbutton2.getText().equals("")){
            mbutton2.setBackgroundColor(Color.RED);
            mbutton5.setBackgroundColor(Color.RED);
            mbutton8.setBackgroundColor(Color.RED);
        }
        else if(mbutton2.getText().equals(mbutton4.getText())&&mbutton4.getText().equals(mbutton6.getText())&&!mbutton2.getText().equals("")){
            mbutton2.setBackgroundColor(Color.RED);
            mbutton4.setBackgroundColor(Color.RED);
            mbutton6.setBackgroundColor(Color.RED);
        }
    }
}
