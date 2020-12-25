//import java.util.PriorityQueue;
import java.util.Queue;
import java.util.LinkedList;
public class ChanceCardDeck {
	private Queue<ChanceCard> chanceCards;
	private ChanceCard c1 = new ChanceCard("Advance to GO", 0);
	private ChanceCard c2 = new ChanceCard("Go to Kizilay", 1);
	private ChanceCard c3 = new ChanceCard("Collect $100", 2);
	private ChanceCard c4 = new ChanceCard("Go back 3 spaces", 3);
	private ChanceCard c5 = new ChanceCard("Go to Jail", 4);
	//private ChanceCard c6 = new ChanceCard("Collect $100", 5);
	//private ChanceCard c7 = new ChanceCard("Collect $50 from each player", 6);
	//private ChanceCard c8 = new ChanceCard("Go to Ankara-Istanbul railroad", 7);
	//private ChanceCard c9 = new ChanceCard("Pay $50 tax", 8);
	//private ChanceCard c10 = new ChanceCard("Pay $50 to each Player", 9);
	
	
	public ChanceCardDeck() {
		chanceCards = new LinkedList<ChanceCard>();
		chanceCards.add(c1);
		chanceCards.add(c2);
		chanceCards.add(c3);
		chanceCards.add(c4);
		chanceCards.add(c5);
		//chanceCards.add(c6);
		//chanceCards.add(c7);
		//chanceCards.add(c8);
		//chanceCards.add(c9);
		//chanceCards.add(c10);
	}
	
	public Queue<ChanceCard> getChanceCards(){
		return chanceCards;
	}
}
