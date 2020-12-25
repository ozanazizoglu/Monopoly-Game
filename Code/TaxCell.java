
public class TaxCell extends Cell
{
	private boolean isExpensive;
	private int lowTax;
	private int highTax;
	
	public TaxCell(String name, String type, boolean isExpensive,int lowTax, int highTax)
	{
		super(name,type);
		this.isExpensive = isExpensive;
		this.lowTax = lowTax;
		this.highTax = highTax;
	}
	
	public int calculateFee()
	{
		if(isExpensive)
		{
			return highTax;
		}
		return lowTax;
	}
	
	public void handleCell( GameManager gm)
	{
		Player p = gm.whoseTurn();
		gm.decreaseMoney(p , calculateFee());
		gm.publish("None");
	}

}
