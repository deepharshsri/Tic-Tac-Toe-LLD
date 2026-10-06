package com.deepansh.tic_tac_toe;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TicTacToeApplication {

	public static void main(String[] args) throws IOException,Exception {
		SpringApplication.run(TicTacToeApplication.class, args);
		Board board=new Board();
		WinningCombination winningCombination=new WinningCombination();
		WinningStrategy winningStrategy=new DefaultWinningStrategy(winningCombination);
		User user1=new User("1","Deepansh" );
		User user2=new User("2","Deepak" );
	
		Game game=new Game(user1,user2,board,winningStrategy);
		game.assignSymbols(Symbol.X,user1);
		game.startGame();
		while(game.getGameStatus()==GameStatus.IN_PROGRESS){
			game.makeMove(-1,-1);
			game.checkGameStatus(winningStrategy.checkWinner(board));
	}
	   if(game.getGameStatus()==GameStatus.TIE){
		   System.out.println("Game Draw");
	   }
	   else{
		   System.out.println("Winner is "+game.getWinner().getName());
	   }
	}
}
