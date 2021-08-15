package main_package;

public class Game {
    public void playGame() {
        Inputter userHandler = new Inputter();
        int boardSize = userHandler.getBoardSize(); // get board size from user
        Pawn[][] board = Board.initBoard(boardSize); // initialize board
        Player player1 = new Player(1,0,"BLUE Player");
        Player player2 = new Player(2,0,"RED Player");
        View.printBoard(board);
    }
}
