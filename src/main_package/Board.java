package main_package;

public class Board {
    public static Pawn[][] initBoard(int boardSize){
        Pawn[][] board = new Pawn[boardSize][boardSize];
        int firstBottomRow = board.length - 1;
        int secondBottomRow = firstBottomRow - 1;
        int thirdBottomRow = secondBottomRow - 1;
        int fourthBottomRow = thirdBottomRow - 1;

        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board.length; j++){
                if (i == 0){
                    board[i][j] = (j % 2 == 0 ? new Pawn(i, j, "blue") : null);
                }
                else if (i == 1){
                    board[i][j] = (j % 2 != 0 ? new Pawn(i, j, "blue") : null);
                }
                else if (i == 2){
                    board[i][j] = (j % 2 == 0 ? new Pawn(i, j, "blue") : null);
                }
                else if (i == 3){
                    board[i][j] = (j % 2 != 0 ? new Pawn(i, j, "blue") : null);
                }

                else if (i == fourthBottomRow){
                    board[i][j] = (j % 2 == 0 ? new Pawn(i, j, "red") : null);
                }
                else if (i == thirdBottomRow){
                    board[i][j] = (j % 2 != 0 ? new Pawn(i, j, "red") : null);
                }
                else if (i == secondBottomRow){
                    board[i][j] = (j % 2 == 0 ? new Pawn(i, j, "red") : null);
                }
                else if (i == firstBottomRow){
                    board[i][j] = (j % 2 != 0 ? new Pawn(i, j, "red") : null);
                }
            }
        }
        return board;
    }
}
