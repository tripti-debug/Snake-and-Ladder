package io.tini.snakeAndLadder;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SnakeAndLadder {

    // players
    //won or not
    // where are the snakes and where are the ladders
    //rules for dice
    //mark the position

    private int[] players;
    private final Map<Integer, Integer> snakes = Stream.of(new Integer[][] {
            {99,7},
            {92,67},
            {85,63},
            {72,15},
            {55,2},
            {43,23},
            {37,9}
    }).collect(Collectors.toMap(data -> data[0], data -> data[1]));
    private final Map<Integer, Integer> ladder = Stream.of(new Integer[][] {
            {8,22},
            {19,78},
            {24,44},
            {36,68},
            {47,90},
            {58,74}
    }).collect(Collectors.toMap(data -> data[0], data -> data[1]));

    private List<Integer> winners;

    public SnakeAndLadder(int numberOfPlayers){
        this.players = new int[numberOfPlayers];
        this.winners = new ArrayList<>();
    }

    public int rollDice(){
        Random random=new Random();
        return random.nextInt(6) + 1;
    }

    public void markPosition(int playerIndex,int newPosition){
        if(newPosition<=100) {
            players[playerIndex]=newPosition;
            System.out.println("Your new position is: "+newPosition);
        }
    }
    public int getCurrentPosition(int playerIndex){
        return players[playerIndex];
    }

    public void addWinner(int playerIndex){
        this.winners.add(playerIndex);
    }

    public Map<Integer, Integer> getSnakes() {
        return snakes;
    }

    public Map<Integer, Integer> getLadder() {
        return ladder;
    }

    public List<Integer> getWinners() {
        return winners;
    }
}
