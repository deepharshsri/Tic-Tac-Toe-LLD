package com.deepansh.tic_tac_toe;

import java.util.List;
import java.util.Map;

/**
 * WinningCombination
 */
public class WinningCombination {
public  List<List<Integer>> combinations;
public Map<Integer, List<Integer>> winningCombinationMap;



public WinningCombination getDefaultWinningCombination() {
    combinations = List.of(
            List.of(0, 1, 2),
            List.of(3, 4, 5),
            List.of(6, 7, 8),
            List.of(0, 3, 6),
            List.of(1, 4, 7),
            List.of(2, 5, 8),
            List.of(0, 4, 8),
            List.of(2, 4, 6)
    );
    winningCombinationMap = Map.of(
            0, List.of(0, 0),
            1, List.of(0, 1),
            2, List.of(0, 2),
            3, List.of(1, 0),
            4, List.of(1, 1),
            5, List.of(1, 2),
            6, List.of(2, 0),
            7, List.of(2, 1),
            8, List.of(2, 2)
    );

    
    return this;
}


}
