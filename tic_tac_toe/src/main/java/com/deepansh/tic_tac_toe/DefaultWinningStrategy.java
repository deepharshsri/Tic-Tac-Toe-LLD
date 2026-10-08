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
    public boolean checkWinner(Board board,WinningCombination winningCombination) {
     
    List<List<Integer>> combinations=winningCombination.combinations;
    Map<Integer, List<Integer>> winningCombinationMap=winningCombination.winningCombinationMap;
    for(List<Integer> c:combinations){
        int a=c.get(0);
        int b=c.get(1);
        int d=c.get(2);
        User user1=board.getUserAt(winningCombinationMap.get(b)
                  .get(0),winningCombinationMap.get(b).get(1) );
        User user2=board.getUserAt(winningCombinationMap.get(a)
                  .get(0),winningCombinationMap.get(a).get(1) );
        User user3=board.getUserAt(winningCombinationMap.get(d)
                  .get(0),winningCombinationMap.get(d).get(1) );
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
