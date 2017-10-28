import greenfoot.*;
import java.io.IOException;
import java.util.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class blackjackTable here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class blackjackTable extends World
{
    private Player player1;//declares player
    ArrayList<Card> playerCards = new ArrayList<Card>();//inits the array list for player
    ArrayList<Card> dealerCards = new ArrayList<Card>();//inits the array list for dealer
    boolean playersTurn = true;//sets players turn
    boolean firstDealer = true;//used for dealer card placement
    int dealerTotal = 0;//inits the dealer total
    int playerTotal = 0;//inits the player total
    PlayerTotal playerTotalText = new PlayerTotal(playerTotal);
    /**
     * Constructor for objects of class blackjackTable.
     * 
     */
    public blackjackTable() throws IOException
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 600, 1);//generates field
        player1 = new Player("player1");//creates the player
        shuffle();
        addObject(new Hit(), 392, 545);//places the hit box
        addObject(new Stay(), 625, 545);//places the stay box
    }
    
    public void act(){
        removeObject(playerTotalText);
        playerTotalText = new PlayerTotal(playerTotal);
        addObject(playerTotalText, 100,545);
    }

    public void shuffle(){//places two player cards and one dealer card face up and one face down
        CardNonImage tempCard = getCard();//gets the new card
        Card card1 = new Card(tempCard.getFileName(), tempCard.getFaceValue());//creates the image of it
        playerCards.add(card1);//adds to the array list
        tempCard = getCard();//gets new card and repeats the cycle
        Card card2 = new Card(tempCard.getFileName(), tempCard.getFaceValue());
        playerCards.add(card2);
        playerTotal += card1.getFaceValue() + card2.getFaceValue();//adds the new total
        tempCard = getCard();
        Card dealersCard1 = new Card(tempCard.getFileName(), tempCard.getFaceValue());//creates the dealers card
        tempCard = getCard();
        Card dealersCard2 = new Card(tempCard.getFileName(), tempCard.getFaceValue());
        dealerTotal += dealersCard1.getFaceValue() + dealersCard2.getFaceValue();//adds dealer new total
        dealerCards.add(dealersCard1);//adds to dealer array
        dealerCards.add(dealersCard2);
        addObject(card1, 470, 460);//adds player cards
        addObject(card2, 550, 460);
        addObject(dealersCard1, 470, 115);//adds one dealer card
        addObject(new cardBack(), 550, 115);//adds the card back
    }

    public CardNonImage getCard(){//creates a new card
        return player1.getCard();
    }

    public void addPlayerCard(int x, int y){//adds a player card and takes x and y of last card placement
        CardNonImage tempCard = getCard();
        Card card = new Card(tempCard.getFileName(), tempCard.getFaceValue());
        playerCards.add(card);
        playerTotal += card.getFaceValue();
        addObject(card , x, y);
    }

    public void addDealerCard(int x, int y){//adds a dealer card takes x and y of last card placement
        CardNonImage tempCard = getCard();
        Card card = new Card(tempCard.getFileName(), tempCard.getFaceValue());
        dealerCards.add(card);
        dealerTotal += card.getFaceValue();
        addObject(card , x, y);
    }

    public void playerHit(){//runs when hit button is pressed 
        if(playersTurn){//makes sure its the players turn
            addPlayerCard(getXOfLatestPlayer()+80, getYOfLatestPlayer());//gets new card if it is
        }
        for(Card cd : playerCards){
            if(playerTotal>21 && cd.getFaceValue()==11){//checks to see if a card is an ace and if it is subtract 10 from total if busted
                playerTotal -= 10;//subtract the ten
                cd.setFaceValue(1);//sets the ace's value to 1
            }
        }
        if(playerTotal > 21){//checks to see if it busted
            Greenfoot.setWorld(new PlayerBust(playerCards, dealerCards));//sets world to busted world
        }
    }

    public void dealerHit(){//runs when dealers turn
        addDealerCard(getXOfLatestDealer()+80, getYOfLatestDealer());//gets new card
        for(Card cd : dealerCards){
            if(dealerTotal>21 && cd.getFaceValue()==11){//checks if busted and has an ace, if so subtracts 10
                dealerTotal -= 10;//subtract 10 from total
                cd.setFaceValue(1);//set ace value to 1
            }
        }
        if(dealerTotal>21){//checks for bust
            Greenfoot.setWorld(new WinnerScreen(playerCards, dealerCards));//sets winner world
        }else{
            dealer();//if not busted calls dealer to see what to do next
        }
    }

    public int getXOfLatestPlayer(){//returns the x of the latest card
        return playerCards.get(playerCards.size()-1).getX();
    }

    public int getYOfLatestPlayer(){//returns the y of the latest card
        return playerCards.get(playerCards.size()-1).getY();
    }

    public int getXOfLatestDealer(){//returns x of latest card
        if(firstDealer){//if first deal set card to 115 since card back is not in array so dosen't know last Y
            return 115;
        }else{//returns Y of last card
            return dealerCards.get(dealerCards.size()-1).getX();
        }
    }

    public int getYOfLatestDealer(){//returns the dealers y
        if(firstDealer){//if first deal set card to 550 since card back is not in array so dosen't know last x
            return 550;
        }else{//returns x of last card
            return dealerCards.get(dealerCards.size()-1).getY();
        }
    }

    public void playerStay(){//ends the players turn
        playersTurn = false;
        dealer();//calls dealer to see what to do next
    }

    public void dealerStay(){//ends dealers turn
        endGame();//calls endgame to see who wins
    }

    public void dealer(){//checks to see what dealer should do
        if(dealerTotal <= 16){//if 16 or over hit
            dealerHit();
        }else{//else stay
            dealerStay();
        }

    }

    public void endGame(){//checks to see who won and sets appropiate screen
        if(playerTotal > dealerTotal){
            Greenfoot.setWorld(new WinnerScreen(playerCards, dealerCards));
        }else{
            Greenfoot.setWorld(new LoserScreen(playerCards, dealerCards));
        }
    }
}

