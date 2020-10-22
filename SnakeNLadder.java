package com.bridgelab.program;

import java.util.Random;

public class SnakeNLadder {
	// position of the player
	static int playerPosition = 0;
	static int winPosition = 100;

	// switchCase
	final static int LadderUp = 1;
	final static int SnakeBite = 2;
	final static int Noplay = 3;

	public static int rollDice(int no) {
		int check = 0;
		Random r = new Random();
		check = r.nextInt(no);
		return (check == 0 ? 1 : check);
	}

	public static void playGame() {
		do {
			int value = rollDice(4);
			int rollDice = rollDice(7);
			switch (value) {
			case 1:
				System.out.println("--------------WinningRolls-----------------");
				playerPosition = playerPosition + rollDice;
				System.out.println("Position of	user is :: " + playerPosition);
				break;
			case 2:
				System.out.println("--------------SnakeBittingRolls-----------------");
				playerPosition = playerPosition + rollDice;
				System.out.println("Position after snakeBitting is :: " + playerPosition);
				break;
			case 3:
				System.out.println("-------------NoPlayRolls-----------------");
				// playerPosition = playerPosition + rollDice;
				System.out.println("Position in noplay position :: " + playerPosition);
				break;
			default:
				break;
			}
			if (playerPosition < 0) {
				playerPosition = 0;
			}
		} while (playerPosition != 100);
	}

	public static void main(String[] args) {
		System.out.println("------GameStart------------");
		playGame();
		System.out.println("--------GameEnd----------");
	}
}
