package io.tini.snakeAndLadder;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter number of players: ");
        int numberOfPlayers=scanner.nextInt();
        GameEngine gameEngine=new GameEngine(numberOfPlayers);
        gameEngine.play();
    }
}
