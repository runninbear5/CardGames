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
    private Player player1;
    ArrayList<Card> playerCards = new ArrayList<Card>();
    ArrayList<Card> dealerCards = new ArrayList<Card>();
    ArrayList<CardNonImage> playerCardsNon = new ArrayList<CardNonImage>();
    ArrayList<CardNonImage> dealerCardsNon = new ArrayList<CardNonImage>();
    boolean playersTurn = true;
    boolean dealersTurn = false;
    boolean endGame = false;
    boolean firstDealer = true;
    int dealerTotal = 0;
    int playerTotal = 0;
    CardMaker cm;
    /**
     * Constructor for objects of class blackjackTable.
     * 
     */
    public blackjackTable() throws IOException
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 600, 1);
        player1 = new Player("player1");
        shuffle();
        addObject(new Hit(), 392, 545);
        addObject(new Stay(), 625, 545);
    }

    public void shuffle(){
        CardNonImage tempCard = getCard();
        Card card1 = new Card(tempCard.getFileName(), tempCard.getFaceValue());
        playerCards.add(card1);
        playerCardsNon.add(tempCard);
        tempCard = getCard();
        Card card2 = new Card(tempCard.getFileName(), tempCard.getFaceValue());
        playerCards.add(card2);
        playerCardsNon.add(tempCard);
        playerTotal += card1.getFaceValue() + card2.getFaceValue();
        tempCard = getCard();
        dealerCardsNon.add(tempCard);
        Card dealersCard1 = new Card(tempCard.getFileName(), tempCard.getFaceValue());
        tempCard = getCard();
        Card dealersCard2 = new Card(tempCard.getFileName(), tempCard.getFaceValue());
        dealerTotal += dealersCard1.getFaceValue() + dealersCard2.getFaceValue();
        dealerCards.add(dealersCard1);
        dealerCards.add(dealersCard2);
        dealerCardsNon.add(tempCard);
        addObject(card1, 470, 460);
        addObject(card2, 550, 460);
        addObject(dealersCard1, 470, 115);
        addObject(new cardBack(), 550, 115);
    }

    public CardNonImage getCard(){
        return player1.getCard();
    }

    public void addPlayerCard(int x, int y){
        CardNonImage tempCard = getCard();
        Card card = new Card(tempCard.getFileName(), tempCard.getFaceValue());
        playerCards.add(card);
        playerCardsNon.add(tempCard);
        playerTotal += card.getFaceValue();
        addObject(card , x, y);
    }

    public void addDealerCard(int x, int y){
        CardNonImage tempCard = getCard();
        Card card = new Card(tempCard.getFileName(), tempCard.getFaceValue());
        dealerCards.add(card);
        dealerCardsNon.add(tempCard);
        dealerTotal += dealerCards.get(dealerCards.size()-1).getFaceValue();
        addObject(card , x, y);
    }

    public void playerHit(){
        if(playersTurn){
            addPlayerCard(getXOfLatestPlayer()+80, getYOfLatestPlayer());
        }
        for(CardNonImage cd : playerCardsNon){
            if(playerTotal>21 && cd.getFaceValue()==1){
                playerTotal -= 10;
                cd.setFaceValue(11);
            }
        }
        if(playerTotal > 21){
            Greenfoot.setWorld(new PlayerBust(playerCards, dealerCards));
        }
    }

    public void dealerHit(){
        addDealerCard(getXOfLatestDealer()+80, getYOfLatestDealer());
        for(CardNonImage cd : dealerCardsNon){
            if(dealerTotal>21 && cd.getFaceValue()==1){
                dealerTotal -= 10;
                cd.setFaceValue(11);
            }
        }
        if(dealerTotal>21){
            Greenfoot.setWorld(new WinnerScreen(playerCards, dealerCards));
        }else{
            dealer();
        }
    }

    public int getXOfLatestPlayer(){
        return playerCards.get(playerCards.size()-1).getX();
    }

    public int getYOfLatestPlayer(){
        return playerCards.get(playerCards.size()-1).getY();
    }

    public int getXOfLatestDealer(){
        if(firstDealer){
            return 550;
        }else{
            return dealerCards.get(dealerCards.size()-1).getX();
        }
    }

    public int getYOfLatestDealer(){
        return 115;
    }

    public void playerStay(){
        playersTurn = false;
        dealersTurn = true;
        dealer();
    }

    public void dealerStay(){
        dealersTurn = false;
        endGame = true;
        endGame();
    }

    public void dealer(){
        int total = 0;
        for(Card cd : dealerCards){
            total += cd.getFaceValue();
        }
        if(total <= 16){
            dealerHit();
        }else{
            dealerStay();
        }

    }

    public void endGame(){
        if(playerTotal > dealerTotal){
            Greenfoot.setWorld(new WinnerScreen(playerCards, dealerCards));
        }else{
            Greenfoot.setWorld(new LoserScreen(playerCards, dealerCards));
        }
    }
}

