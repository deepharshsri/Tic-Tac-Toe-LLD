package com.deepansh.tic_tac_toe;

import java.util.InputMismatchException;

public class Board {


    private User[][] board=new User[3][3];
    private int cellsLeft=9;

    public User getUserAt(int row,int col) {
        return board[row][col];
    }

    public void setUserAt(int row,int col,User user) {
        board[row][col]=user;
        cellsLeft--;
    }
    
    public boolean isCellEmpty(int row,int col){
       
           return board[row][col]==null;
             
  
    }

    public boolean isValidCell(int row,int col) {
        return row>=0 && row<3 && col>=0 && col<3;
    }

    public boolean isBoardFull() {
        return cellsLeft==0;
    }
}
