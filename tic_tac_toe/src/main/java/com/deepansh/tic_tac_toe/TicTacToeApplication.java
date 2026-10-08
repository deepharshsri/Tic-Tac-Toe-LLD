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
		WinningCombination combination=winningCombination.getDefaultWinningCombination();
		WinningStrategy winningStrategy=new DefaultWinningStrategy(winningCombination);
		User user1=new User("1","Deepansh" );
		User user2=new User("2","Deepak" );
	
		Game game=new Game(user1,user2,board,winningStrategy);
		game.assignSymbols(Symbol.X);
		game.startGame();
		while(game.getGameStatus()==GameStatus.IN_PROGRESS){
			game.makeMove();
			game.updateGameStatus(winningStrategy.checkWinner(board,combination));
	}
	   if(game.getGameStatus()==GameStatus.DRAW){
		   System.out.println("Game Draw");
	   }
	   else{
		   System.out.println("Winner is "+game.getWinner().getName());
	   }
	}
}
