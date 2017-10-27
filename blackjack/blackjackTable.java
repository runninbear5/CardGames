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
    private static Player player1;
    static ArrayList<Card> playerCards = new ArrayList<Card>();
    static ArrayList<Card> dealerCards = new ArrayList<Card>();
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
        //         String[] cards = {"ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king"};
        //         String[] suits = {"hearts", "diamonds", "clubs", "spades"};
        //         int randomValueCard1 = (int)(Math.random()*13);
        //         int randomSuitCard1 = (int)(Math.random()*4);
        //         int randomValueCard2 = (int)(Math.random()*13);
        //         int randomSuitCard2 = (int)(Math.random()*4);
        //         while(randomValueCard1 == randomValueCard2 && randomSuitCard1 == randomSuitCard2){
        //             randomValueCard2 = (int)(Math.random()*13);
        //             randomSuitCard2 = (int)(Math.random()*4);
        //         }
        //         String randomCard1 = cards[randomValueCard1]+"_of_"+suits[randomSuitCard1]+".png";
        //         String randomCard2 = cards[randomValueCard2]+"_of_"+suits[randomSuitCard2]+".png";
        //         Card card1 = new Card(randomCard1);
        //         Card card2 = new Card(randomCard2);
        //         addObject(card1, 470,460);
        //         addObject(card2, 550, 460);
        CardNonImage tempCard = getCard();
        Card card1 = new Card(tempCard.getFileName(), tempCard.getFaceValue());
        playerCards.add(card1);
        tempCard = getCard();
        Card card2 = new Card(tempCard.getFileName(), tempCard.getFaceValue());
        playerCards.add(card2);
        tempCard = getCard();
        Card dealersCard1 = new Card(tempCard.getFileName(), tempCard.getFaceValue());
        tempCard = getCard();
        Card dealersCard2 = new Card(tempCard.getFileName(), tempCard.getFaceValue());
        dealerCards.add(dealersCard1);
        dealerCards.add(dealersCard2);
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
        addObject(card , x, y);
    }
    public void addDealerCard(int x, int y){
        CardNonImage tempCard = getCard();
        Card card = new Card(tempCard.getFileName(), tempCard.getFaceValue());
        dealerCards.add(card);
        dealerTotal += dealerCards.get(dealerCards.size()-1).getFaceValue();
        addObject(card , x, y);
    }
    public void playerHit(){
        if(playersTurn){
            addPlayerCard(getXOfLatestPlayer()+80, getYOfLatestPlayer());
        }
    }
    public void dealerHit(){
            addDealerCard(getXOfLatestDealer()+80, getYOfLatestDealer());
    }
    public int getXOfLatestPlayer(){
        return playerCards.get(playerCards.size()-1).getX();
    }
    public int getYOfLatestPlayer(){
        return playerCards.get(playerCards.size()-1).getY();
    }
    public int getXOfLatestDealer(){
        if(firstDealer){
            return dealerCards.get(dealerCards.size()-1).getX();
        }else{
            return dealerCards.get(dealerCards.size()-1).getX();
        }
    }
    public int getYOfLatestDealer(){
        return dealerCards.get(dealerCards.size()-1).getY();
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
        for(Card cd : dealerCards){
                dealerTotal += cd.getFaceValue();
        }
        while(dealersTurn){
            if(dealerTotal <= 16){
                dealerHit();
            }else{
                dealerStay();
            }
        }
       
    }
    public void endGame(){
         for(Card cd: playerCards){
            playerTotal += cd.getFaceValue();
        }
        if(playerTotal > 16){
            Greenfoot.setWorld(new WinnerScreen());
        }else{
            
        }
    }
    }

