package com.bridgelab.program;

import java.util.Random;

public class SnakeNLadder {
	// position of the player
	static int playerPosition = 0;
	static int winPosition = 100;
	static int calculatePosition = 0;

	// switchCase
	final static int LadderUp = 1;
	final static int SnakeBite = 2;
	final static int Noplay = 3;

	public static int winingRolls = 0;
	public static int counter = 0;
	public static int snakeBiteRolls = 0;
	public static int noPlayRolls = 0;

	public static int rollDice(int no) {
		int check = 0;
		Random r = new Random();
		counter++;
		check = r.nextInt(no);
		return (check == 0 ? 1 : check);
	}

	public static void playGame() {
		do {
			int value = rollDice(4);
			int rollDice = rollDice(7);
			switch (value) {
			case 1:
				winingRolls++;
				System.out.println("--------------WinningRolls-----------------");
				calculatePosition = calculatePlayerLadderPosition(calculatePosition, rollDice);
				System.out.println("Position of	user is :: " + calculatePosition);
				break;
			case 2:
				snakeBiteRolls++;
				System.out.println("--------------SnakeBittingRolls-----------------");
				calculatePosition = calculatePlayerSnakeBitePosition(calculatePosition, rollDice);
				System.out.println("Position after snakeBitting is :: " + calculatePosition);
				break;
			case 3:
				noPlayRolls++;
				System.out.println("-------------NoPlayRolls-----------------");
				// playerPosition = playerPosition + rollDice;
				System.out.println("Position in noplay position :: " + calculatePosition);
				break;
			default:
				break;
			}
		} while (calculatePosition != winPosition);
	}

	public static int calculatePlayerLadderPosition(int position, int dicevalue) {
		position = position + dicevalue;
		if (position > 100) {
			position = position - dicevalue;
		} else if (position == 100) {
			return position;
		}
		return position;
	}

	public static int calculatePlayerSnakeBitePosition(int position, int dicevalue) {
		position = position - dicevalue;
		if (position < 0) {
			position = 0;
		}
		return position;
	}

	public static void main(String[] args) {
		System.out.println("------Start------------");
		playGame();
		System.out.println("--------End----------");
		System.out.println("No. of winningRoll Dice :: " + winingRolls);
		System.out.println("No. of snakeBiteRoll Dice :: " + snakeBiteRolls);
		System.out.println("No. of noPlaRoll Dice :: " + noPlayRolls);
	}
}
