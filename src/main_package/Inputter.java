package main_package;

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

}
