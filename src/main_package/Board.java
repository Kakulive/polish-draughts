package main_package;
import java.util.Scanner;

public class Board {
    Scanner scanner = new Scanner(System.in);
    private final int n;

    public Board() {
        this.n = scanner.nextInt();
    }

    private void spawnPawns(){
        int[][] pawn = new int[n][n];
        int pawnNumber = n * 2;
        int initialPawnRows = 4;
        for (int i = 0; i < initialPawnRows; i++){
            for (int j = 0; j < n; j = j+2){
                pawn[i][j] = 5;
            }
        }
    }
    //TODO - everything here

}
