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
	public static int snakeBiteRolls = 0;
	public static int noPlayRolls = 0;

	public static int rollDice(int no) {
		int check = 0;
		Random r = new Random();
		check = r.nextInt(no);
		return (check == 0 ? 1 : check);
	}

	public static int playGame() {
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
			return calculatePosition;
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

	public static boolean isWin(int player) {
		return winPosition == player;
	}

	public static void twoPlayer() {
		int player1 = 0, player2 = 0;
		int currentPlayer = -1;
		int diceValue = 0;
		do {
			System.out.println(currentPlayer == -1 ? "\n\nFirst Player Chance" : "\n\nSecond Player Chance");
			diceValue = rollDice(7);

			if (currentPlayer == -1) {
				player1 = playGame();
				System.out.println("First Player :: " + player1);
				System.out.println("Second Player :: " + player2);
				System.out.println("------------------");
				if (isWin(player1)) {
					System.out.println("First player wins");
					return;
				}
			} else {
				player2 = calculatePlayerLadderPosition(player2, diceValue);
				System.out.println("First Player :: " + player1);
				System.out.println("Second Player :: " + player2);
				System.out.println("------------------");
				if (isWin(player2)) {
					System.out.println("Second player wins");
					return;
				}
			}
			currentPlayer = -currentPlayer;
		} while (player1 != 100 || player2 != 100);
	}

	public static void main(String[] args) {
		twoPlayer();
		System.out.println("No. of winningRoll Dice :: " + winingRolls);
		System.out.println("No. of snakeBiteRoll Dice :: " + snakeBiteRolls);
		System.out.println("No. of noPlaRoll Dice :: " + noPlayRolls);
	}
}
