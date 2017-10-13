import java.util.Scanner;
public class BlackJack {
	public boolean playBlackJack() {
		//call card class here// creates an instance of the card class
	    //get 2 cards here //gets 2 cards for player
	    //get 2 cards here //gets 2 cards for dealer
		Scanner sc = new Scanner(System.in);// creates a scanner
	    int playersTotalValue = 0;//inits players cards value
	    int dealersTotalValue = 0;//inits daealers card value
	    boolean playersTurn = true;//inits players turn to true
	    boolean dealersTurn = true;//inits dealers turn to true
	    boolean notBust = true; //boolean saying if busted or not, used at the end
	    
	    for(int i=0; i</*playersCards*/.length; i++){//gets the players total cards value
	        System.out.println("Your " +i+ "th card is " +/*Get players card name and suit*/);
	        playersTotalValue += /*get card value*/;
	    } 
	    
	    for(int i=0; i</*dealers cards*/.length, i++) { //gets the dealers total card value
	    	dealersTotalValue += /*get one of the cards values*/;
	    }
	    System.out.println("Your total card value is " +playersTotalValue); //prints to the players total value
	    System.out.println("The dealers face up card is " +/*get dealers first card*/); //prints the dealers first card
	    
	    while(playersTurn){//checks to see if its the dealer sturn
	       Player player = new Player();//gets instance of player class
	       if(sc.nextLine().toLowerCase().equals("hit")) {//checks to see what to do
	    	   playersTotalValue = player.hit(playersTotalValue /*get new card*/);
	       }else if(sc.nextLine().toLowerCase().equals("stay")){
	    	  playersTurn =  player.stay(playersTotalValue);
	       }
	       
	       if(playersTotalValue > 21) {//checks to see if player busted
	    	   System.out.println("You have busted with a total value of " +playersTotalValue+
	    			   				"The dealer has a total value of "+dealersTotalValue);
	    	   playersTurn = false;//stops player from contnuing if bust
	    	   dealersTurn = false;//stops dealer from starting if bust
	    	   notBust = false;//changes ending of the game 
	       }
	    }
	    
	    while(dealersTurn) {//while dealer can still go
	    	Dealer dealer = new Dealer();//creates new instance of dealer
	    	if(dealersTotalValue <= 16) {//checks to see if dealer should hit or stay
	    		dealersTotalValue = dealer.hit(dealersTotalValue/*, new card */);
	    	}else {//stays if over 16
	    		dealersTurn = dealer.stay();
	    	}
	    	if(dealersTotalValue > 21) {//checks for dealer bust
	    		System.out.println("The delaer has busted with a total value of " +dealersTotalValue+
		   				"You won! You have a total value of "+playersTotalValue);
	    		dealersTurn = false;//stops dealer from starting if bust
	    		notBust = false;
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
	    return sc.nextLine().toLowerCase().equals("yes");//looks to see if play agin
	}
}
