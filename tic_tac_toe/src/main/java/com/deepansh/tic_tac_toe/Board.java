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
    
    public boolean isCellEmpty(int row,int col) throws Exception{
       
           try{
              if(board[row][col]==null){
                  return true;
              }
              else{
                  throw new Exception("Cell is already occupied");
              }
              
           }
           catch(InputMismatchException e){
               System.out.println("Invalid input. Enter row and column for your move (0-2): ");
               return false;
           }  
           catch(ArrayIndexOutOfBoundsException e){
               System.out.println("Invalid input. Enter row and column for your move (0-2): ");
               return false;
           }
           catch(Exception e){
               System.out.println(e.getMessage());
               return false;
           }
             
  
    }

    public boolean isBoardFull() {
        return cellsLeft==0;
    }
}
