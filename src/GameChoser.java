import java.util.Scanner;
public class GameChoser{
    public static void main(String [] args){
        String blackJack = "blackjack";//setting game names
        Scanner sc = new Scanner(System.in);//init scanner
        System.out.println("Welcome to game center, would you like to play: BlackJack");
        String gameChoice = sc.nextLine().toLowerCase();//looking for user input
        boolean play = true;//allows while loop to run at least once
        while(play){
            if(gameChoice.equals(blackJack)){//checks if equal to blackjack to then play blackjack
                System.out.println("Welcome to Black Jack, where the money is fake but the fun is real");
                boolean cont = true;
                while(cont){
                	BlackJack bj = new BlackJack();
                	cont = bj.playBlackJack();
                	//test
                }
            }
        }
    }
}