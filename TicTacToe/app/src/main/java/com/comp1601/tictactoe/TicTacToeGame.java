package com.comp1601.tictactoe;

import java.util.Random;
import android.util.Log;
public class TicTacToeGame {


    private String playerRole="X";
    private String botRole="O";
    private Random rand= new Random();
    //keeps tack of the board
    private String[] positions={" "," "," "," "," "," "," "," "," "};
    private  final String TAG = this.getClass().getSimpleName() + " @" + System.identityHashCode(this);

    public TicTacToeGame(){

    }
    //sets the array so that it survives screen rotations
    public void setPositions(String[] positionArray){
        positions=positionArray;
    }
    //returns the board
    public String[] getPositions(){
        return positions;
    }
    public String getBotRole(){
        return botRole;
    }
    public String getPlayerRole(){
        return playerRole;
    }
    //checks if the position is valid
    public Boolean checkPosition(int position){
        return (positions[position].equals(" "));
    }
    //bot's move
    public int botPlay(){
        //if the game is a draw dont keep placing
        if(drawGame()){
            return -1;

        }
        //random position
        int position=rand.nextInt(9);
        //find a valid position
        while(!checkPosition(position)){
            position=rand.nextInt(9);

        }
        //store the position at the correct slot
        positions[position]=botRole;
        //print the board
        print();
        //if theres a someone won
        if(winner()!=null){
            try {
                //print to the logcat
                Log.i(TAG, winner());
            }catch(Exception e){
                //if using the JUnitTest print using print statements
                System.out.println(winner());
            }

        }
        //returns the position that the bot played
        return position;


    }
    public int reset(){
        for (int i = 0; i < positions.length; i++) {
            //reset the board
            positions[i]=" ";

        }
        //if the previous turn, the bot was "O", it now starts the game as "X"
        if(botRole=="O") {
            botRole = "X";
            playerRole="O";
            return  botPlay();
        }else{
            botRole="O";
            playerRole="X";
            return -1;
        }

    }
    //person's move
    public int play(String player,int position){
        //if its a valid position
        if(checkPosition(position)) {
            //store at the proper slot
            positions[position] = player;
            //print the board
            print();
            //if theres a winner
            if(winner()!=null){
                try {
                    //print to logat
                    Log.i(TAG, winner());
                }catch(Exception e){
                    //if using JUnitTest print using print statements
                    System.out.println(winner());
                }
                //return -1 so that the bot doesnt play if there is a winner
                return -1;
            }
            //call function for the bot to play right after
            return botPlay();
        }
        //if the position is invalid
        return -1;

    }
    public boolean drawGame(){
        //if theres a winenr than its not a draw
        if(winner()!=null)
            return false;
        //loop through all slots of the board
        for(String pos:positions){
            //if there is a empty slot then its not a draw yet
            if(pos.equals(" ")){

                return false;
            }

        }
        try {
            //print out draw with logcat
            Log.i(TAG, "DRAW");
        }catch(Exception e){
            //using JUnit print using print statements
            System.out.println("Draw");
        }
        return true;
    }
    public String winner(){
        //all possible win conditions which returns either "X" or "O"
        if(positions[0].equals(positions[1])&&positions[1].equals(positions[2])&&!positions[0].equals(" ")){
            return positions[0];//first row
        }else if(positions[0].equals(positions[3])&&positions[3].equals(positions[6])&&!positions[0].equals(" ")) {
            return positions[0];//first column
        }else if(positions[0].equals(positions[4])&&positions[4].equals(positions[8])&&!positions[0].equals(" ")) {
            return positions[0];//diagonal
        }else if(positions[1].equals(positions[4])&&positions[4].equals(positions[7])&&!positions[1].equals(" ")) {
            return positions[1];
        }else if(positions[3].equals(positions[4])&&positions[4].equals(positions[5])&&!positions[3].equals(" ")){
            return positions[3];
        }else if(positions[6].equals(positions[7])&&positions[7].equals(positions[8])&&!positions[6].equals(" ")){
            return positions[6];
        }else if(positions[2].equals(positions[5])&&positions[5].equals(positions[8])&&!positions[2].equals(" ")){
            return positions[2];
        }
        else if(positions[2].equals(positions[4])&&positions[4].equals(positions[6])&&!positions[2].equals(" ")){
            return positions[2];
        }
        //if theres no winner
        return null;
    }
    public void print() {
        try {
            //printing to logcat
            String s = " ";
            //loop through the board
            for (int i = 0; i < positions.length; i++) {
                //go to new line after each row
                if (i % 3 == 0) {
                    s += "\n";
                }
                //print each column
                s += positions[i] + " | ";
            }
            s += "\n";
            Log.i(TAG, s);

        }catch (Exception e){
            //if using JUnitTest do same thing but with print statements since JUnitTest does not support log.i()
            for (int i = 0; i < positions.length; i++) {

                if (i % 3 == 0) {
                    System.out.print("\n");
                }
                System.out.print(positions[i] + " | ");
            }
            System.out.println("\n");


        }

    }

}
