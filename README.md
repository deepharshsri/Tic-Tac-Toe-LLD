# Tic Tac Toe LLD(JAVA)

Console based Tic Tac Toe game for two users using Strategy Pattern.
## Functional Requirement: 

1. Two user can play this game
2. User can take ‘ O ‘ or ‘X’ and User B will take the other symbol.
3. Board will have dimension 3*3 i.e 3 column and 3 rows
4. List of winning positions is already given. If the positions a user occupied contain any winning combination , the user wins the game.
5. User plays alternative turn.
6. If all the positions are occupied and with no winning combination get matched at last, game will be a draw.
7. Game will have status like not started, draw, winner, in progress as ENUM classs.

## Non Functional Requirement: 

1. Latency: Position status should be updated in O(1). if occupied or not.
2. Maintainability: Code should follow design principles and patterns. In the future, any developer who wants to change anything in the code should not affect other modules.
3. Extensibility : Code should follow OCP. In the future, any new feature to be introduced without modifying the old code.

## Core Entities:

1. **User:** id, name, symbol. The second user's symbol is assigned by the game.
2. **Symbol (enum):** X, O.
3. **Board:** a 3x3 grid, `User[3][3]` (null means empty). It gets the user at a cell, places a user in a cell, and checks whether a cell is empty.
4. **WinningCombination:** holds all 8 combinations (3 rows, 3 columns, 2 diagonals), each made of 3 cells. A user wins by satisfying at least one.
5. **GameStatus (enum):** NOT_STARTED, IN_PROGRESS, DRAW, WINNER.
6. **Game:** holds the two users, the board, the status, the current turn, and the winner. After each move Main will ask `WinningStrategy` whether any user won; otherwise, it checks for a draw, otherwise switches the turn.
7. **WinningStrategy (interface):** has `checkWinner(Board)`. The default implementation checks every combination, and if all 3 cells of any one belong to the user, that user wins.

## Relationship :

1. User has-a Symbol.
2. Game has two Users, a Board, a GameStatus, and a WinningStrategy.
3. Board has a `User[3][3]` grid.
4. DefaultWinningStrategy implements WinningStrategy.
5. DefaultWinningStrategy has-a WinningCombination.
6. WinningStrategy uses a Board (method parameter in `checkWinner(Board)`), and returns a User.

## Class Diagram
<img width="2472" height="2438" alt="Blank diagram" src="https://github.com/user-attachments/assets/83bab7c9-80a9-4c37-930d-c1beb46a5fd2" />
