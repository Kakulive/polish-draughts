package main_package;

import java.util.Objects;

public class gameChecker {

    public int countPawns(Pawn[][] board, String color){
        int counter = 0;
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board.length; j++){
                if (board[i][j] != null){
                    if (Objects.equals(board[i][j].getColor(), color)){
                        counter++;
                    }
                }
            }
        }
        return counter;
    }

    public String whichPlayerWon(Pawn[][] board){
        int redPawns = countPawns(board, "red");
        int bluePawns = countPawns(board, "blue");

        if (redPawns == 0){
            return "blue";
        } else if (bluePawns == 0){
            return "red";
        } else {
            return "nobody";
        }
    }

    public boolean isSpaceFree(Pawn[][] board, int x, int y){
        return board[x][y] == null;
    }

    //TODO validation of moves
    //TODO validation of coordinates input
}
