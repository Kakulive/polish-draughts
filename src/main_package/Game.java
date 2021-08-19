package main_package;

import java.util.Objects;

public class Game {

    Inputter userHandler = new Inputter();
    gameChecker validator = new gameChecker();

    Player player1 = new Player(1,0, true,"BLUE Player", "blue");
    Player player2 = new Player(2,0, false,"RED Player", "red");

    public void playGame() {
        Pawn[][] board =  initGame();
        while (Objects.equals(validator.whichPlayerWon(board), "nobody")){
            Player activePlayer = getActivePlayer(player1, player2);
            singleRound(board, activePlayer);
            //TODO gameplay
        }
    }

    private void singleRound(Pawn[][] board, Player activePlayer){
        View.clearScreen();
        System.out.println(ConsoleColors.GREEN_BRIGHT + activePlayer.getName() + "'s turn:" + ConsoleColors.RESET);
        View.printBoard(board);
        int[] pawnCoordinates = userHandler.choosePawn(board);
        Pawn pawnToMove = board[pawnCoordinates[0]][pawnCoordinates[1]];
        while (!validator.verifyCorrectPlayersPawn(board,pawnToMove.getCoordinateX(), pawnToMove.getCoordinateY(),activePlayer)){
            System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "That's not your Pawn you dirty cheater! " +
                    "Choose the correct one!" + ConsoleColors.RESET);
            pawnCoordinates = userHandler.choosePawn(board);
            pawnToMove = board[pawnCoordinates[0]][pawnCoordinates[1]];
        }
        int pawnPreviousX = pawnToMove.getCoordinateX();
        int pawnPreviousY = pawnToMove.getCoordinateY();
        int[] moveCoordinates = userHandler.getMoveCoordinates(board);
        pawnToMove.setCoordinateX(moveCoordinates[0]);
        pawnToMove.setCoordinateY(moveCoordinates[1]);
        updateBoard(board, pawnPreviousX, pawnPreviousY, pawnToMove.getCoordinateX(), pawnToMove.getCoordinateY());
        View.clearScreen();
        changeActivePlayer(player1, player2);
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
            player2.setActive(false);
        }
    }

    private Player getActivePlayer (Player player1, Player player2){
        if (player1.isActive()){
            return player1;
        } else {
            return player2;
        }
    }

    private void updateBoard(Pawn[][] board, int oldX, int oldY, int newX, int newY){
        board[newX][newY] = board[oldX][oldY];
        board[oldX][oldY] = null;
    }



}
