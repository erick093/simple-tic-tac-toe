package tictactoe;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        char[][] gameBoard = new char[3][3];
        Scanner scanner = new Scanner(System.in);

        // Initialize the game board
        constructGameGrid(gameBoard);
        printGameGrid(gameBoard);
        boolean isGameOver = false;

        // Play the game
        while (!isGameOver) {
            // Playing X
            Coordinates coordinatesX = getCoordinates(scanner);
            while (areCoordinatesInvalid(coordinatesX.getX(), coordinatesX.getY(), gameBoard)) {
                coordinatesX = getCoordinates(scanner);
            }
            updateGameBoard(coordinatesX.getX(), coordinatesX.getY(), gameBoard, 'X');
            printGameGrid(gameBoard);
            isGameOver = checkResult(gameBoard);
            if (isGameOver) {
                return;
            }

            // Playing O
            Coordinates coordinatesO = getCoordinates(scanner);
            while (areCoordinatesInvalid(coordinatesO.getX(), coordinatesO.getY(), gameBoard)) {
                coordinatesO = getCoordinates(scanner);
            }
            updateGameBoard(coordinatesO.getX(), coordinatesO.getY(), gameBoard, 'O');
            printGameGrid(gameBoard);
            isGameOver = checkResult(gameBoard);
        }
    }

    public static Coordinates getCoordinates(Scanner scanner) {
        System.out.print("Enter the coordinates: ");
        String x = scanner.next();
        String y = scanner.next();
        return new Coordinates(x, y);
    }

    public static void constructGameGrid(char[][] gameBoard) {
        for (int i = 0; i < gameBoard.length; i++) {
            Arrays.fill(gameBoard[i], ' ');
        }
    }

    public static void printGameGrid(char[][] gameBoard) {
        System.out.println("---------");
        for (int i = 0; i < gameBoard.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < gameBoard[i].length; j++) {
                System.out.print(gameBoard[i][j] + " ");
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println("---------");
    }

    public static boolean checkResult(char[][] gameBoard) {
        boolean isXWin = isTheWinner(gameBoard, 'X');
        boolean isOWin = isTheWinner(gameBoard, 'O');
        boolean gameOver = false;

        if (isXWin) {
            System.out.println("X wins");
            gameOver = true;
        } else if (isOWin) {
            System.out.println("O wins");
            gameOver = true;
        } else if (isTheBoardFull(gameBoard)) {
            System.out.println("Draw");
            gameOver = true;
        }
        return gameOver;
    }

    private static boolean isTheWinner(char[][] gameBoard, char symbol) {
        return (gameBoard[0][0] == symbol && gameBoard[0][1] == symbol && gameBoard[0][2] == symbol) ||
                (gameBoard[1][0] == symbol && gameBoard[1][1] == symbol && gameBoard[1][2] == symbol) ||
                (gameBoard[2][0] == symbol && gameBoard[2][1] == symbol && gameBoard[2][2] == symbol) ||

                (gameBoard[0][0] == symbol && gameBoard[1][0] == symbol && gameBoard[2][0] == symbol) ||
                (gameBoard[0][1] == symbol && gameBoard[1][1] == symbol && gameBoard[2][1] == symbol) ||
                (gameBoard[0][2] == symbol && gameBoard[1][2] == symbol && gameBoard[2][2] == symbol) ||

                (gameBoard[0][0] == symbol && gameBoard[1][1] == symbol && gameBoard[2][2] == symbol) ||
                (gameBoard[0][2] == symbol && gameBoard[1][1] == symbol && gameBoard[2][0] == symbol);
    }

    public static boolean areCoordinatesInvalid(String xCoordinate, String yCoordinate, char[][] gameBoard) {
        int x;
        int y;
        try {
            x = Integer.parseInt(xCoordinate);
            y = Integer.parseInt(yCoordinate);
        } catch (NumberFormatException e) {
            System.out.println("You should enter numbers!");
            return true;
        }
        if (x < 1 || x > 3 || y < 1 || y > 3) {
            System.out.println("Coordinates should be from 1 to 3!");
            return true;
        } else if (gameBoard[x - 1][y - 1] == 'X' || gameBoard[x - 1][y - 1] == 'O') {
            System.out.println("This cell is occupied! Choose another one!");
            return true;
        } else {
            return false;
        }

    }

    public static void updateGameBoard(String xCoordinate, String yCoordinate, char[][] gameBoard, char symbol) {
        int x = Integer.parseInt(xCoordinate);
        int y = Integer.parseInt(yCoordinate);
        gameBoard[x - 1][y - 1] = symbol;
    }

    public static boolean isTheBoardFull(char[][] gameBoard) {
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                if (gameBoard[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}
