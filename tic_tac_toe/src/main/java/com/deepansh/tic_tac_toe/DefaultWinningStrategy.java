package com.deepansh.tic_tac_toe;

import java.util.List;
import java.util.Map;

public class DefaultWinningStrategy  implements WinningStrategy{
    
    private  WinningCombination winningCombination;

    //constructor
    public DefaultWinningStrategy(WinningCombination winningCombination) {
        this.winningCombination = winningCombination;
    }

    @Override
    public boolean checkWinner(Board board) {
     
    List<List<Integer>> combinations=winningCombination.combinations;

    for(int i=0;i<combinations.size();i++){
        int row1=combinations.get(i).get(0)/3;
        int col1=combinations.get(i).get(0)%3;
        int row2=combinations.get(i).get(1)/3;
        int col2=combinations.get(i).get(1)%3;
        int row3=combinations.get(i).get(2)/3;
        int col3=combinations.get(i).get(2)%3;  
        User user1=board.getUserAt(row1,col1);
        User user2=board.getUserAt(row2,col2);
        User user3=board.getUserAt(row3,col3);
        if(user1!=null&&user1==user2&&user2==user3){
            return true;
        }
        else{
            continue;
        }

    }
    return false;

    }
}
