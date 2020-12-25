import java.util.Queue;
import java.util.LinkedList;
public class ChestCardDeck {
	
	private Queue<ChestCard> chestCards;
	private ChestCard c1 = new ChestCard("Advance to GO", 0);
	private ChestCard c2 = new ChestCard("Doctor's fee - Pay $50", 1);
	private ChestCard c3 = new ChestCard("Opera Night - Collect $50 from each player", 2);
	private ChestCard c4 = new ChestCard("Pay Schools fee - Pay $150", 3);
	private ChestCard c5 = new ChestCard("Income tax refund - Collect $50", 4);
	//private ChestCard c6 = new ChestCard("It is your birthday! - Collect $20 from each player", 5);
	//private ChestCard c7 = new ChestCard("You inherit $100", 6);
	//private ChestCard c8 = new ChestCard("You won beauty contest - Collect $25", 7);
	//private ChestCard c9 = new ChestCard("From sale of stock you get $50", 8);
	//private ChestCard c10 = new ChestCard("You are injured! - Pay $100 to hospital",9);
	
	
	
	public ChestCardDeck() {
		chestCards = new LinkedList<ChestCard>();
		chestCards.add(c1);
		chestCards.add(c2);
		chestCards.add(c3);
		chestCards.add(c4);
		chestCards.add(c5);
		//chestCards.add(c6);
		//chestCards.add(c7);
		//chestCards.add(c8);
		//chestCards.add(c9);
		//chestCards.add(c10);	
	}
	
	public Queue<ChestCard> getChestCards(){
		return chestCards;
	}

}
