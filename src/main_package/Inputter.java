package main_package;
import java.util.HashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Inputter {
    final Scanner sc = new Scanner(System.in);

    public int getBoardSize(){
        System.out.println("Choose your board size (10-20): ");
        int boardSize = 0;
        while (boardSize < 10 || boardSize > 20) {
            try {
                int userInput = sc.nextInt();
                if (userInput < 10 || userInput > 20 ) {
                    System.out.println("Choose a valid board size between 10 and 20!");
                } else {
                    boardSize = userInput;
                }
            } catch (Exception e) {
                System.out.println("A board size must be a number! Choose a valid board size between 10 and 20!");
                sc.nextLine();
            }
        }
        return boardSize;
    }

    public int[] choosePawn(Pawn[][] board){
        System.out.println("Which pawn would you like to move next?: ");
        String pawnToMove = "";
        HashMap<String,int[]> validCoordinates = createCoordinatesMap(board);
        while (!validCoordinates.containsKey(pawnToMove.toUpperCase())){
            pawnToMove = sc.nextLine();
        }
        return validCoordinates.get(pawnToMove.toUpperCase());
    }

    public int[] getMoveCoordinates(Pawn[][] board){
        System.out.println("Where would you like to place your next move?: ");
        String nextMoveCoordinates = "";
        HashMap<String,int[]> validCoordinates = createCoordinatesMap(board);
        while (!validCoordinates.containsKey(nextMoveCoordinates.toUpperCase())){
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
