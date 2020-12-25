
public class UtilityCell extends Cell
{
	private int baseRent;
	private int evenRent;
	private int price;
	private Player owner;
	
	
	public UtilityCell(String name, String type,int price, int baseRent, int evenRent)
	{
		super(name,type);
		this.baseRent = baseRent;
		this.evenRent = evenRent;
		this.price = price;
		owner = null;
	}
	
	public Player getOwner()
	{
		return owner;
	}
	
	public void setOwner(Player p)
	{
		owner = p;
	}
	
	public boolean hasOwner()
	{
		return owner != null;
		
	}
	
	public int getPrice()
	{
		return price;
	}
	
	public String toString()
	{
		return "Name of Utility: " + name + "\n" + "Price: " + price + "\n" + "Base Rent: " + baseRent;
	}
	
	public int getRent( int numOfUtility , int die1, int die2)
	{
		if( numOfUtility == 1 )
		{
			return baseRent * (die1 + die2);
		}
			
		return evenRent * (die1 + die2);
	}
	
	public void handleCell( GameManager gm)
	{
		if(!hasOwner())
		{
			gm.publish("buyCell");
		}
		else
		{
			Player p = gm.whoseTurn();
			
			if( !p.getName().equals(owner.getName()))
			{
				int face1;
				int face2;
				int utilityNum = gm.getUtilityNumber(owner);
				face1 = gm.getFace1();
				face2 = gm.getFace2();
				
				gm.payRent(p, this.getOwner(), this.getRent(utilityNum,face1,face2));
				gm.publish("None");
			}		
		}
	}
}
