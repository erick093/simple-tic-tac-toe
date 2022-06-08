# Simple Tic-Tac-Toe

## About
Everybody remembers this paper-and-pencil game from childhood: Tic-Tac-Toe, also known as Noughts and crosses or Xs and Os. 
A single mistake usually costs you the game, but thankfully it is simple enough that most players discover the best strategy quickly. 
The project is part of the **Java Developer learning track** of JetBrains Academy.

## Objectives

The objective of this task is to implement a simple game of Tic-Tac-Toe.
The tasks are the following:

    1. Prints an empty grid at the beginning of the game.
    2. Creates a game loop where the program asks the user to enter the cell coordinates, analyzes the move for correctness and shows a grid with the changes if everything is okay.
    3. Ends the game when someone wins or there is a draw.


## Examples
The following are examples of the game grid:
   
    ---------
    |       |
    |       |
    |       |
    ---------
    Enter the coordinates: 2 2
    ---------
    |       |
    |   X   |
    |       |
    ---------
    Enter the coordinates: 2 2
    This cell is occupied! Choose another one!
    Enter the coordinates: two two
    You should enter numbers!
    Enter the coordinates: 1 4
    Coordinates should be from 1 to 3!
    Enter the coordinates: 1 1
    ---------
    | O     |
    |   X   |
    |       |
    ---------
    Enter the coordinates: 3 3
    ---------
    | O     |
    |   X   |
    |     X |
    ---------
    Enter the coordinates: 2 1
    ---------
    | O     |
    | O X   |
    |     X |
    ---------
    Enter the coordinates: 3 1
    ---------
    | O     |
    | O X   |
    | X   X |
    ---------
    Enter the coordinates: 2 3
    ---------
    | O     |
    | O X O |
    | X   X |
    ---------
    Enter the coordinates: 3 2
    ---------
    | O     |
    | O X O |
    | X X X |
    ---------
    X wins!
# License
MIT License.
