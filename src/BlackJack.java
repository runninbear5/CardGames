import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class BlackJack {
	public boolean playBlackJack() {
		Player player1 = new Player("player1");//gets instance of player class
	    Deck dk = new Deck();
	    //get 2 cards here //gets 2 cards for dealer
		ArrayList<Card> playerCards = new ArrayList<Card>();
		ArrayList<Card> dealerCards = new ArrayList<Card>();
		playerCards.add(dk.getCard());//adds one player card
		playerCards.add(dk.getCard());//adds a second player card
		dealerCards.add(dk.getCard());//adds one dealer card
		dealerCards.add(dk.getCard());//adds a second dealer car
		Scanner sc = new Scanner(System.in);// creates a scanner
	    int playersTotalValue = 0;//inits players cards value
	    int dealersTotalValue = 0;//inits daealers card value
	    boolean playersTurn = true;//inits players turn to true
	    boolean dealersTurn = true;//inits dealers turn to true
	    boolean notBust = true; //boolean saying if busted or not, used at the end
	    
	    for(int i=0; i<playerCards.size(); i++){//gets the players total cards value
	        System.out.println("Your " +i+ "th card is " +playerCards.get(i));
	        playersTotalValue += playerCards.get(i).getFaceValue();
	    } 
	    
	    for(int i=0; i<dealerCards.size(); i++) { //gets the dealers total card value
	    	dealersTotalValue += dealerCards.get(i).getFaceValue();
	    }
	    System.out.println("Your total card value is " +playersTotalValue); //prints to the players total value
	    System.out.println("The dealers face up card is " +dealerCards.get(0).getFaceValue()); //prints the dealers first card
	    
	    while(playersTurn){//checks to see if its the dealer turn
	       
	       if(sc.nextLine().toLowerCase().equals("hit")) {//checks to see what to do
	    	   //Get new card
	    	   playerCards.add(player1.getCard());
	    	   playersTotalValue = player1.hit(playersTotalValue, playerCards.get(playerCards.size()-1).cardValue());
	       }else if(sc.nextLine().toLowerCase().equals("stay")){
	    	  playersTurn =  player1.stay(playersTotalValue);
	       }
	       
	       for(Card card: playerCards) {
		       if(playersTotalValue > 21 && card.getFaceValue()==11) {//looks for ace and if found removes 10 to make ace equal to 1
		    	   playersTotalValue -= 10;
		       }else if(playersTotalValue > 21) {//checks to see if player busted
		    	   System.out.println("You have busted with a total value of " +playersTotalValue+
		    			   				"The dealer has a total value of "+dealersTotalValue);
		    	   playersTurn = false;//stops player from contnuing if bust
		    	   dealersTurn = false;//stops dealer from starting if bust
		    	   notBust = false;//changes ending of the game 
		       }
	       }
	    }
	    
	    while(dealersTurn) {//while dealer can still go
	    	Dealer dealer = new Dealer();//creates new instance of dealer
	    	if(dealersTotalValue <= 16) {//checks to see if dealer should hit or stay
	    		//get new card
	    		dealerCards.add(/*new card*/);
	    		dealersTotalValue = dealer.hit(dealersTotalValue/*, new card */);
	    	}else {//stays if over 16
	    		dealersTurn = dealer.stay();
	    	}
	    	for(Cards card: dealerCards) {
		    	if(dealersTotalValue > 21 && card.getValue()) {//looks for ace and if found removes 10 to make ace equal to 1
			    	   dealersTotalValue -= 10;
			    }else if(dealersTotalValue > 21) {//checks for dealer bust
		    		System.out.println("The delaer has busted with a total value of " +dealersTotalValue+
			   				"You won! You have a total value of "+playersTotalValue);
		    		dealersTurn = false;//stops dealer from starting if bust
		    		notBust = false;
		    	}
	    	}
	    }
	    if(notBust) {//checks to make sure no one has busted
		    if(playersTotalValue > dealersTotalValue) {
		    	System.out.println("You win, you had a total value of " +playersTotalValue+ "/n"+ 
		    						"The dealer had a total value of " +dealersTotalValue);
		    }else {
		    	System.out.println("The dealer won, you had a total value of " +playersTotalValue+ "/n"+ 
						"The dealer had a total value of " +dealersTotalValue);
		    }
	    }
	    System.out.println("Do you want to play again?");
	    return sc.nextLine().toLowerCase().equals("yes");//looks to see if play again
	}
}
