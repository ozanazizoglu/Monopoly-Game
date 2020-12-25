
public class StationCell extends Cell
{
	private int baseRent;
	private int price;
	private Player owner;
	public StationCell(String name, String type,int price, int baseRent)
	{
		super(name,type);
		this.price = price;
		owner = null;
		this.baseRent = baseRent;
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
	
	
	public int getRent( int numOfStations)
	{
		return baseRent * numOfStations;
	}
	
	public String toString()
	{
		return "Name of Station: " + name + "\n" + "Price: " + price + "\n" + "Base Rent: " + baseRent;
	}
	
	public void handleCell(GameManager gm)
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
				int stationNum = gm.getStationNumber(owner);
				gm.payRent(p, this.getOwner(), this.getRent(stationNum));
				gm.publish("None");
			}					
		}		
	}	
}
