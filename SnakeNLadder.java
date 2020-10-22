package com.bridgelab.program;

import java.util.Random;

public class SnakeNLadder {
	// position of the player
	static int playerPosition = 0;

	public static int rollDice(int no) {
		int check = 0;
		Random r = new Random();
		check = r.nextInt(no);
		return (check == 0 ? 1 : check);
	}

	public static void playGame() {
		int rollDice = rollDice(7);
		System.out.println("RandomValue:" + rollDice);
	}

	public static void main(String[] args) {
		System.out.println("------GameStart------------");
		playGame();
		System.out.println("--------GameEnd----------");
	}
}
