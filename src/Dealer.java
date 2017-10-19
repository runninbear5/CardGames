
public class Dealer {
	public int hit(int totalCardValue, Card newCard){
		totalCardValue += newCard.getFaceValue();
		return totalCardValue;
	}
	public boolean stay() {
		return false;
	}
}
