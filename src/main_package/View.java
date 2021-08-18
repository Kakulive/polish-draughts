package main_package;

import java.util.Objects;

public class View {

    public static void printBoard(Pawn[][] board) {
        String whiteEmptyField = ConsoleColors.WHITE_BACKGROUND + "   " + ConsoleColors.RESET;
        String blackEmptyField = ConsoleColors.BLACK_BACKGROUND + "   " + ConsoleColors.RESET;
        String bluePawnOnWhite = ConsoleColors.WHITE_BACKGROUND + ConsoleColors.BLUE_BOLD_BRIGHT + " O " + ConsoleColors.RESET;
        String bluePawnOnBlack = ConsoleColors.BLACK_BACKGROUND + ConsoleColors.BLUE_BOLD_BRIGHT + " O " + ConsoleColors.RESET;
        String redPawnOnWhite = ConsoleColors.WHITE_BACKGROUND + ConsoleColors.RED_BOLD_BRIGHT + " O " + ConsoleColors.RESET;
        String redPawnOnBlack = ConsoleColors.BLACK_BACKGROUND + ConsoleColors.RED_BOLD_BRIGHT + " O " + ConsoleColors.RESET;
        char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

        StringBuilder firstString = new StringBuilder();
        firstString.append("   ");
        for (int i = 0; i < board.length; i++){
            firstString.append(" ").append(ConsoleColors.CYAN_BOLD_BRIGHT).append(i).append(ConsoleColors.RESET).append(" ");
        }
        System.out.println(firstString);


        for (int i = 0; i < board.length; i++) {
            StringBuilder rowString = new StringBuilder();
            rowString.append(" ").append(ConsoleColors.CYAN_BOLD_BRIGHT).append(alphabet[i]).append(ConsoleColors.RESET).append(" ");
            for (int j = 0; j < board.length; j++){

                if (i % 2 == 0){
                    if (j % 2 == 0){
                        if (board[i][j] == null){
                            rowString.append(whiteEmptyField);
                        } else if (board[i][j] != null){
                            String pawnColor = board[i][j].getColor();
                            if (Objects.equals(pawnColor, "blue")){
                                rowString.append(bluePawnOnWhite);
                            } else {
                                rowString.append(redPawnOnWhite);
                            }
                        }
                    } else if (j % 2 != 0){
                        if (board[i][j] == null){
                            rowString.append(blackEmptyField);
                        } else if (board[i][j] != null){
                            String pawnColor = board[i][j].getColor();
                            if (Objects.equals(pawnColor, "blue")){
                                rowString.append(bluePawnOnBlack);
                            } else {
                                rowString.append(redPawnOnBlack);
                            }
                        }
                    }

                } else if (i % 2 != 0){
                    if (j % 2 == 0){
                        if (board[i][j] == null){
                            rowString.append(blackEmptyField);
                        } else if (board[i][j] != null){
                            String pawnColor = board[i][j].getColor();
                            if (Objects.equals(pawnColor, "blue")){
                                rowString.append(bluePawnOnBlack);
                            } else {
                                rowString.append(redPawnOnBlack);
                            }
                        }
                    } else if (j % 2 != 0){
                        if (board[i][j] == null){
                            rowString.append(whiteEmptyField);
                        } else if (board[i][j] != null){
                            String pawnColor = board[i][j].getColor();
                            if (Objects.equals(pawnColor, "blue")){
                                rowString.append(bluePawnOnWhite);
                            } else {
                                rowString.append(redPawnOnWhite);
                            }
                        }
                    }
                }

            }
            System.out.println(rowString);
        }
    }

    public static void clearScreen(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}