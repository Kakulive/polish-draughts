package main_package;

import java.util.Objects;

public class Game {

    Inputter userHandler = new Inputter();
    gameChecker gameChecker = new gameChecker();

    Player player1 = new Player(1,0, true,"BLUE Player");
    Player player2 = new Player(2,0, false,"RED Player");

    public void playGame() {
        Pawn[][] board =  initGame();
        View.printBoard(board);
        while (Objects.equals(gameChecker.whichPlayerWon(board), "nobody")){
            //TODO gameplay
        }
    }

    private Pawn[][] initGame(){
        int boardSize = userHandler.getBoardSize(); // get board size from user
        return Board.initBoard(boardSize); // initialize board
    }

    private void changeActivePlayer(Player player1, Player player2){
        if (player1.isActive()){
            player1.setActive(false);
            player2.setActive(true);
        } else {
            player1.setActive(true);
            player1.setActive(false);
        }
    }

}
