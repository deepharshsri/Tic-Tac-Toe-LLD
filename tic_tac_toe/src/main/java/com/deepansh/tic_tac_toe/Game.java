package com.deepansh.tic_tac_toe;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {

    private User player1;
    private User player2;
    private Board board;
    private GameStatus gameStatus= GameStatus.NOT_STARTED;
    private User winner;
    private WinningStrategy winningStrategy;
    private Boolean currentPlayer;
    Scanner scanner=new Scanner(System.in);

    public Game(User player1, User player2, Board board, WinningStrategy winningStrategy) {
        this.player1 = player1;
        this.player2 = player2;
        this.board = board;
        this.winningStrategy = winningStrategy;
        this.currentPlayer=true;
    }

    public GameStatus getGameStatus(){
        return gameStatus;
    }
    private void setGameStatus(GameStatus gameStatus){
        this.gameStatus=gameStatus;
    }
    public User getWinner(){
        return winner;
    }
    private void updateTurn(){
        currentPlayer=!currentPlayer;
    }

    public boolean getCurrentPlayer(){
        return currentPlayer;
    }

    public void startGame(){
        setGameStatus(GameStatus.IN_PROGRESS);
    }

    public void assignSymbols(Symbol symbol1,User player1){
         player1.setUserSymbol(symbol1);
         player2.setUserSymbol((symbol1==Symbol.O)? Symbol.X :Symbol.O);
    }
     
    public void makeMove(int row,int col) throws IOException,Exception{
       
        System.out.println((currentPlayer)? "Player 1's turn": "Player 2's turn");
        DrawBoard();
        System.out.println("Enter row and column for your move (0-2): ");
        while(true){
        try{
            int r=scanner.nextInt();
            int c=scanner.nextInt();
             while(!board.isCellEmpty(r,c)){
                DrawBoard();
                r=scanner.nextInt();
                c=scanner.nextInt();
               
            }
            board.setUserAt(r,c,(currentPlayer)? player1:player2);
            break;
        }
        catch(InputMismatchException e){
            System.out.println("Invalid input. Enter row and column for your move (0-2): ");
            scanner.nextLine();
        }
    }
  
        
       
        
            // winner=(winningStrategy.checkWinner(board)?(currentPlayer)? player1:player2:null);
        }

    public void checkGameStatus(boolean res){
            if(res){
                winner=(currentPlayer)? player1:player2;
                setGameStatus(GameStatus.WON);

            }
            else if(board.isBoardFull()){
                setGameStatus(GameStatus.TIE);
            }
            else{
                updateTurn();

        }
       
    }

    public void DrawBoard() throws Exception{
        System.out.println("Current Board:");
    for(int i=0;i<3;i++){
        for(int j=0;j<3;j++){
            if(board.getUserAt(i,j)==null){
                System.out.print(" ");
            }
            else{
                System.out.print(board.getUserAt(i, j).symbol);
            }
            if(j!=2){
                System.out.print("|");
            }
        }
        System.out.println();
        if(i!=2){
            System.out.println("-----");
        }
    }
}
    
}
