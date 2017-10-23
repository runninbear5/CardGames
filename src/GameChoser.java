import java.io.IOException;
import java.util.Scanner;

public class GameChoser {
	public static void main(String[] args) throws IOException {
		String blackJack = "blackjack";// setting game names
		Scanner sc = new Scanner(System.in);// init scanner
		boolean play = true;// allows while loop to run at least once
		boolean cont = true;
		while (play) {
			System.out.println("Welcome to game center, would you like to play: BlackJack");
			String gameChoice = sc.nextLine().toLowerCase();// looking for user input
			if (gameChoice.equals(blackJack)) {// checks if equal to blackjack to then play blackjack
				System.out.println("Welcome to Black Jack, where the money is fake but the fun is real");
				while(cont) {
					BlackJack bj = new BlackJack();
					cont = bj.playBlackJack();
				}
			}
		}
	}
}