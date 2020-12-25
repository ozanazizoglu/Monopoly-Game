
public class ChanceCardCell extends Cell {
	
	ChanceCardDeck ccd;
	
	public ChanceCardCell(String name, String cellType) {
		super(name, cellType);
		ccd = new ChanceCardDeck(); 
	}

	public ChanceCard drawCard() {
		ChanceCard chance = ccd.getChanceCards().remove();
		ccd.getChanceCards().add(chance);
		return chance;
	}
	
	public ChanceCardDeck getDeck()
	{
		return ccd;
	}
	
	public void handleCell(GameManager gm)
	{
		gm.publish("drawCard");
	}
}
