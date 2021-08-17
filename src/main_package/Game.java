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
            Player activePlayer = getActivePlayer(player1, player2);
            singleRound(board, activePlayer);
            //TODO gameplay
        }
    }

    private void singleRound(Pawn[][] board, Player activePlayer){
        View.clearScreen();
        System.out.println(activePlayer.getName() + "'s turn:");
        View.printBoard(board);
        int[] pawnCoordinates = userHandler.choosePawn(board);
        Pawn pawnToMove = board[pawnCoordinates[0]][pawnCoordinates[1]];
        int[] moveCoordinates = userHandler.getMoveCoordinates(board);
        pawnToMove.setCoordinateX(moveCoordinates[0]);
        pawnToMove.setCoordinateY(moveCoordinates[1]);
        View.clearScreen();
        View.printBoard(board);
        //TODO continue :)
    }

    private Pawn[][] initGame(){
        int boardSize = userHandler.getBoardSize();
        return Board.initBoard(boardSize);
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

    private Player getActivePlayer (Player player1, Player player2){
        if (player1.isActive()){
            return player1;
        } else {
            return player2;
        }
    }



}
