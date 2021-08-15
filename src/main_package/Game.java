package main_package;

public class Game {
    public void playGame() {
        Inputter userHandler = new Inputter();
        int boardSize = userHandler.getBoardSize();

        Pawn[][] board = Board.initBoard(boardSize);
        View.printBoard(board);
    }
}
