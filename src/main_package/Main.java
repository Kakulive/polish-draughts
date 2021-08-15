package main_package;

public class Main {

    public static void main(String[] args) {
        Game game = new Game();
        game.playGame();
        System.out.println(ConsoleColors.RED + "X" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.PURPLE_BOLD + "Y" + ConsoleColors.RESET);
    }
}
