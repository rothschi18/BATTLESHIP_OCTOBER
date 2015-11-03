package com.example.administrator.battleship;

/**
 * Created by rothschi18 on 9/23/2015.
 */
public class Player {
    protected int[][] squares;
    protected int playerIdentifier;
    protected String playerName;
    protected LocationInfo[][] shipGrid;

    public Player(int playerIdentifier, String playerName)
    {
        this.playerName=playerName;
        this.playerIdentifier=playerIdentifier;
        squares = new int[10][10];
        shipGrid = new LocationInfo[10][10];

    }

    /*
    *  Empty Constructor if you want to programatically set instance variables
     */
    public Player(){squares = new int[10][10];}

    /*
    * Sets the players board to its initial state
    * (all squares are 0 = all squares empty, no misses or hits or ships)
     */
    public void initSquares()
    {
        int x, y;
        for(x=0; x<10; x++)
            for(y=0; y<10; y++)
                squares[x][y]= 0;
    }


    /*
    * Getter Methods for current instance variables
     */
    public int getPlayerIdentifier(){return playerIdentifier;}
    public String getPlayerName(){return  playerName;}


    /*
    * Setter methods for current instance variables
     */
    public void setPlayerIdentifier(int identifier)
    {
        playerIdentifier=identifier;
    }

    public void setPlayerName(String name)
    {
        playerName = name;
    }

    public boolean addShipToGrid(int x, int y, boolean isH, int shipLength, int shipID)
    {
        /**
         * Loop through the array of squares and add the code for saying there is a ship there
         * If orientation is Horizontal, set the squares from x to shiplength
         * and vice versa if ship is vertical
         */

        if(isH) {
            for (int i = x; i < x+shipLength; i++){

                //If the spot is out of bounds, or all ready occupied, return that the method was a failure
                if(i>9 || squares[i][y] == 1) return false;

                squares[i][y] = 1;

            }
            //The ship has been added, return true
            return true;
        }

        if(!isH){
            for(int i = y; i<y+shipLength; i++){

                if(i>9 || squares[x][i] == 1) return false;

                squares[x][i] = 1;

            }
            return true;
        }

        return true;
    }

    public void deleteShip(int shipID)
    {
        for(int i = 0; i<9; i++)
            for(int j = 0; j<9; j++)
            {
                if(squares[i][j] == shipID) squares[i][j] = 0;

            }


    }


}
