package main_package;
import java.util.HashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Inputter {
    final Scanner sc = new Scanner(System.in);
    final gameChecker validator = new gameChecker();

    public int getBoardSize(){
        System.out.println("Choose your board size (10-20): ");
        int boardSize = 0;
        while (boardSize < 10 || boardSize > 20) {
            try {
                int userInput = sc.nextInt();
                sc.nextLine();
                if (userInput < 10 || userInput > 20 ) {
                    System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "Choose a valid board size between 10 and 20!"
                            +ConsoleColors.RESET);
                } else {
                    boardSize = userInput;
                }
            } catch (Exception e) {
                System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "A board size must be a number!" +
                        " Choose a valid board size between 10 and 20!" + ConsoleColors.RESET);
                sc.nextLine();
            }
        }
        return boardSize;
    }

    public int[] choosePawn(Pawn[][] board){
        System.out.println("Which pawn would you like to move next?: ");
        HashMap<String,int[]> validCoordinates = createCoordinatesMap(board);
        String pawnToMove = sc.nextLine();
        while (!validCoordinates.containsKey(pawnToMove.toUpperCase())){
            System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "Apologies, but I don't think this coordinate is a" +
                    " valid one... Choose again! " + ConsoleColors.RESET);
            pawnToMove = sc.nextLine();
        }
        return validCoordinates.get(pawnToMove.toUpperCase());
    }

    public int[] getMoveCoordinates(Pawn[][] board){
        System.out.println("Where would you like to place your next move?: ");
        String nextMoveCoordinates = sc.nextLine();
        HashMap<String,int[]> validCoordinates = createCoordinatesMap(board);
        while (!validCoordinates.containsKey(nextMoveCoordinates.toUpperCase()) || !validator.isSpaceFree(board,
                validCoordinates.get(nextMoveCoordinates.toUpperCase())[0],
                validCoordinates.get(nextMoveCoordinates.toUpperCase())[1])){
            System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "Apologies, but I don't think this coordinate is a" +
                    " valid one... Choose again! " + ConsoleColors.RESET);
            nextMoveCoordinates = sc.nextLine();
        }
        return validCoordinates.get(nextMoveCoordinates.toUpperCase());
    }

    private HashMap<String, int[]> createCoordinatesMap(Pawn[][] board){
        char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        String[] digits = new String[board.length];
        for (int i = 0; i<board.length; i++){
            digits[i] = String.valueOf(i);
        }

        HashMap<String, int[]> dictionary = new HashMap<String, int[]>();
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board.length; j++){
                if (i % 2 == 0 && j % 2 == 0){
                    dictionary.put(String.valueOf(alphabet[i])+digits[j], new int[]{i, j});
                } else if (i % 2 == 1 && j % 2 == 1) {
                    dictionary.put(String.valueOf(alphabet[i])+digits[j], new int[]{i, j});
                }
            }
        }
        return dictionary;
    }


}
