package io.tini.snakeAndLadder;

public class GameEngine {

    private SnakeAndLadder snakeAndLadder;
    private int numberOfPlayers;
    public GameEngine(int numberOfPlayers) {
        this.numberOfPlayers=numberOfPlayers;
        snakeAndLadder=new SnakeAndLadder(numberOfPlayers);
    }

    public void play() throws InterruptedException {
        int playerIndex=0;
        while(snakeAndLadder.getWinners().size()!=numberOfPlayers){
            if(!snakeAndLadder.getWinners().contains(playerIndex)) {
                System.out.println("Player: "+(playerIndex+1));
                int diceNumber=snakeAndLadder.rollDice();
                System.out.println("Dice: "+diceNumber);
                int newPosition=snakeAndLadder.getCurrentPosition(playerIndex)+diceNumber;
                if(snakeAndLadder.getSnakes().containsKey(newPosition)){
                    newPosition=snakeAndLadder.getSnakes().get(newPosition);
                    System.out.println("aiyo snake bite. Your new position is: "+newPosition);
                }
                if(snakeAndLadder.getLadder().containsKey(newPosition)){
                    System.out.println("ambo you got promotion. Your new position is: "+newPosition);
                    newPosition=snakeAndLadder.getLadder().get(newPosition);
                }
                snakeAndLadder.markPosition(playerIndex,newPosition);
                if(newPosition==100){
                    snakeAndLadder.addWinner(playerIndex);
                    System.out.println("Tadaaaaaa!!!!! Player " + (playerIndex + 1) + " wins" );
                }
            }
            playerIndex = (playerIndex+1) % numberOfPlayers;
            Thread.sleep(1000);
        }
        System.out.println("Winner List");
        snakeAndLadder.getWinners().stream().forEach(System.out::println);
    }
}
