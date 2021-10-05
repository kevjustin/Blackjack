/*
* RST.java
* Plays a game of 21
* Kevin Justin
* ICS3U
* 11/3/2020
*/

package RST;

import java.util.Random;
import java.util.Scanner;

public class Game {
	
	/*Variable Declaration*/
	private int oneValue, cardValue, card;
	private static int userChoice;
	private int cardsDrawn = 0;
	private int currentTotal = 0;
	
	static Scanner input = new Scanner(System.in);
	
	//Displays introduction statements
	//post: Statement is printed
	public static void displayIntro(){
		System.out.println("Welcome to the Game of 21!");
		System.out.println("In 21 the player must grab cards from a deck and combine them.");
		System.out.println("The goal is to get as close to 21 as possible without going over it.");
	}
	
	//Displays ending statements
	//post: Statement is printed
	public static void displayOutro(){
		System.out.println("Thank you for playing the Game of 21!");
	}
	
	//Displays that it's Player 1's turn
	//post: Statement is printed
	public static void displayPlayer1Turn(){
		System.out.println("\nPlayer 1's Turn: ");
		System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
	}
	
	//Displays that it's Player 2's turn
	//post: Statement is printed
	public static void displayPlayer2Turn(){
		System.out.println("\nPlayer 2's Turn: ");
		System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
	}
	
	//Displays that it's showing the winner
	//post: Prints statements
	public static void displayWinningStatement(){
		System.out.println("\nCalculating Winner: ");
		System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
	}
	
	//Sets a random number from 1-13 to card
	//post: card is assigned a number
	public void drawCard(){
		
		/*Variable Declaration*/
		final int minValue = 1;
		final int maxValue = 13;
		Random r = new Random();
		
		card = r.nextInt((maxValue - minValue) + 1) + minValue;	//Formula to get random number within a range
	}
	
	//Prints a statement based on what num card is
	//post: Statement of the num as a word printed
	public void cardToString(){
		
		switch(card){
		case 1:	System.out.println("You drew an Ace!");
				break;
		case 2:
		case 3:
		case 4:
		case 5:
		case 6:
		case 7:
		case 8:
		case 9:
		case 10: System.out.println("You drew a " + card + "!");
				 break;
		case 11: System.out.println("You drew a Jack!");
				 break;
		case 12: System.out.println("You drew a Queen!");
				 break;
		case 13: System.out.println("You drew a King!");
				 break;
		}
	}
	
	/*Sets the value of the card (King = 10)
	 *pre: card needs to have a value
	 *post: cardValue has been assigned a value*/
	public void setCardValue(){
		
		//If card's value is 1 then it continually asks user for a value until its 1 or 11
		switch(card){
		case 1:	do{
					System.out.print("Enter 1 or 11 for how much you want your Ace to be worth: ");
					oneValue = input.nextInt();
						if(oneValue == 1){
							cardValue = 1;
						}else{
							cardValue = 11;
						}
				}while(oneValue != 1 && oneValue != 11);
				break;
				
		case 2: cardValue = 2;
				break;
		case 3: cardValue = 3;
				break;
		case 4: cardValue = 4;
				break;
		case 5: cardValue = 5;
				break;
		case 6: cardValue = 6;
				break;
		case 7: cardValue = 7;
				break;
		case 8: cardValue = 8;
				break;
		case 9: cardValue = 9;
				break;
		case 10: cardValue = 10;
				 break;
		case 11: cardValue = 10;	//Jack has a value of 10
				 break;
		case 12: cardValue = 10;	//Queen has a value of 10
				 break;
		case 13: cardValue = 10;	//King has a value of 10
				 break;
		}
	}
	
	/*Increases the total by the cardValue
	 *pre: cardValue needs to have a value
	 *post: total has been increased*/
	public void increaseTotal(){
		currentTotal+=cardValue;
	}
	
	/*Returns the total value
	 *pre: currentTotal needs to have a value
	 *post: Total value has been returned*/
	public int getTotal(){
		return(currentTotal);
	}
	
	/*Displays the total value
	 *pre: current Total needs a value
	 *post: currentTotal has been displayed*/
	public void displayTotal(){
		
		if(getTotal() < 21){
		System.out.println("Your total is " + currentTotal + ".");
		}else{
			System.out.println("You went over 21.");	//If the total value is over 21 then it displays this
		}
	}
	
	/*Returns the amount of cardsDrawn
	 *pre: cardsDrawn needs a value
	 *post: cardsDrawn has been returned*/
	public int getCardsDrawn(){
		return(cardsDrawn);
	}
	
	//Sets userChoice to the default 0
	//post: userChoice has been assigned 0
	public static void setDefaultChoice(){
		userChoice = 0;
	}
	
	//Gets user to input 1 or 2
	//userChoice has been assigned 1 or 2
	public void setChoice(){
		
		System.out.print("Press 1 to draw another card or 2 to stand: ");
		userChoice = input.nextInt();
	}
	
	//Returns getChoice
	//post userChoice has been returned
	public int getChoice(){
		return(userChoice);
	}
	
	/*Checks if user's input was valid(1 or 2)
	 *pre: input needs to have a value
	 *post: method has returned either true or false*/
	public boolean isValidInput(int input){
		
		if(input == 1){
			return(true);
		}else if(input == 2){
			return(true);
		}else{
			System.out.println("Invalid response.");
			return(false);
		}
	}
	
	/*Determines the winner between each player
	 *pre: cardsDrawn needs a value, currentTotal needs a value
	 *post: a winner has been determined and displayed*/
	public static void determineWinner(Game player1, Game player2){
		
		//Shows who won if a player drew 5 cards
		if(player1.getCardsDrawn() == 5 && player2.getCardsDrawn() == 5){
			System.out.println("Both players drew 5 cards. Player 1 \ndrew 5 first. Player 1 won.");
		}else if(player1.getCardsDrawn() == 5){
			System.out.println("Player 1 drew 5 cards. Player 1 won.");
		}else if(player2.getCardsDrawn() == 5){
			System.out.println("Player 2 drew 5 cards. Player 2 won.");
		}
			//Shows who won if a player exceeded 21
			else if(player1.getTotal() > 21 && player2.getTotal() > 21){
				System.out.println("Both players went over 21. Player 1 \nwent over 21 first. Player 2 won.");
			}else if(player1.getTotal() > 21){
				System.out.println("Player 1 went over 21. Player 2 won.");
			}else if(player2.getTotal() > 21){
				System.out.println("Player 2 went over 21. Player 1 won.");
			}
				//Shows who won if both players held their hand
				else if(player1.getTotal() > player2.getTotal()){
					System.out.println("Player 1 is closer to 21. Player 1 won.");
				}else if(player1.getTotal() < player2.getTotal()){
					System.out.println("Player 2 is closer to 21. Player 2 won.");
				}else if(player1.getTotal() == player2.getTotal()){
					System.out.println("Boths players have the same number. It's a tie.");
				}
	}
	
	//Calls on other methods to simulate the first round which draws 2 cards
	public void firstRound(){
		
		drawCard();
		cardToString();
		setCardValue();
		increaseTotal();
		
		drawCard();
		cardToString();
		setCardValue();
		increaseTotal();
		
		cardsDrawn+=2;
		displayTotal();
	}
	
	//Calls on other methods to simulate a single round which draws 1 card
	public void Round(){
		
		drawCard();
		cardToString();
		setCardValue();
		increaseTotal();
		
		cardsDrawn++;
		displayTotal();
	}
	
	//Calls on Round method if user inputs 1
	public void playerTurn(){
		
		//Asks for an input until its valid(1 or 2)
		do{
			setChoice();
		}while(isValidInput(userChoice) == false);
		
		if(getChoice() == 1){
			Round();
		}
		
		if(cardsDrawn == 5){
			userChoice = 2;		//If 5 cards are drawn then it sets this to 2 ending the turn
		}
	}
	
	//Client code: creates object and calls on other methods
	public static void main(String[] args){
		
		Game player1 = new Game();
		Game player2 = new Game();
		
		Game.displayIntro();
		
		Game.displayPlayer1Turn();
		player1.firstRound();
		
		Game.displayPlayer2Turn();
		player2.firstRound();
			
		Game.displayPlayer1Turn();
		while(player1.getChoice() != 2 && player1.getTotal() < 21){		//Runs this code until current amount of stones reaches 0
			
			player1.playerTurn();
		}
		Game.setDefaultChoice();
		
		Game.displayPlayer2Turn();
		while(player2.getChoice() != 2 && player2.getTotal() < 21){		//Runs this code until current amount of stones reaches 0
		
			player2.playerTurn();
		}
		
		Game.displayWinningStatement();
		determineWinner(player1, player2);
		input.close();
		Game.displayOutro();
	}
}

