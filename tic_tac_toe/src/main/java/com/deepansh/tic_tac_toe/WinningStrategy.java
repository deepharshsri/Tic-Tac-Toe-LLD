package com.deepansh.tic_tac_toe;

public interface WinningStrategy {

    boolean checkWinner(Board board,WinningCombination winningCombination);
}
