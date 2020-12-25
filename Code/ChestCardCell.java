//import java.util.LinkedList;

public class ChestCardCell extends Cell {
	
	ChestCardDeck ccd;
	
	public ChestCardCell(String name, String cellType) {
		super(name, cellType);
		ccd = new ChestCardDeck(); 
	}

	public ChestCard drawCard() {
		ChestCard chest = ccd.getChestCards().remove();
		ccd.getChestCards().add(chest);
		return chest;
	}
	
	public ChestCardDeck getDeck()
	{
		return ccd;
	}
	
	public void handleCell(GameManager gm)
	{
		gm.publish("drawCard");
	}
}

