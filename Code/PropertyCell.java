
public class PropertyCell extends Cell
{
	private Player owner;
	private String color;
	private String type;
	private int price;
	private int baseRent;
	private int houseNum;
	private int hotelNum;
	private int mortgageVal;
	private int housePrice;
	private int hotelPrice;
	public boolean hasOwner;
	private boolean isMortgage;
	
	
	public PropertyCell(String name, String type, String color, int price, int baseRent)
	{
		super(name,type);
		this.color = color;
		this.price = price;
		this.baseRent = baseRent;
		this.type = type;
		owner = null;
		houseNum = 0;
		hotelNum = 0;
		hasOwner = false;
		isMortgage = false;
		housePrice = (int)(price / 4);
		hotelPrice = (int)(price / 2);
		mortgageVal = (int)(price / 2);
	}
	
	public Player getOwner()
	{
		return owner;
	}
	
	public void setOwner( Player p)
	{
		owner = p;
	}
	
	public String getType()
	{
		return type;
	}
	
	
	public int getPrice()
	{
		return price;
	}
	
	public int getMortgageVal()
	{
		return mortgageVal;
	}
	
	public void setPrice(int price)
	{
		this.price = price;
	}
	
	public void mortgage()
	{
		isMortgage = true;
		// para arttırma kismi yapilmali.
	}
	
	public int getHotelPrice()
	{
		return hotelPrice;
	}
	
	public int getHousePrice()
	{
		return housePrice;
	}
	
	public int getHouseNum()
	{
		return houseNum;
	}
	
	public int getHotelNum()
	{
		return hotelNum;
	}
	
	public boolean buyHouse()
	{
		if(hotelNum == 0)
		{
			if(houseNum < 4)
			{
				houseNum = houseNum + 1;
				return true;
			}
		}
		return false;
	}
	
	public boolean buyHotel()
	{
		if(hotelNum == 0)
		{
			hotelNum += 1;
			return true;
		}
		return false;
	}
	
	public boolean getIsMortgage()
	{
		return isMortgage;
	}
		
	public String getColor()
	{
		return color;
	}
	
	public String toString()
	{
		return "Name of Property: " + name + "\n" + "Price: " + price + "\n" + "Rent: " + getRent();
	}
	
	public int getRent()
	{
		if ( isMortgage)
		{
			return 0;
		}
		
		if(hotelNum == 0)
		{
			return baseRent + 50 * houseNum;
		}
		else
		{
			return baseRent + 350;
		}		
	}
	
	public void handleCell( GameManager gm)
	{
		if( owner == null)
		{
			gm.publish("buyCell");
		}
		else
		{
			Player p = gm.whoseTurn();
			if( owner.getName().equals(p.getName()) )
			{
				int colorNum = p.getColorNum(color);
				if( color.equals("brown") || color.equals("blue"))
				{
					if( colorNum == 2)
					{
						gm.publish("buyHouseORmortgage");
					}
					else
					{
						gm.publish("mortgage");
					}
				}
				else
				{
					if( colorNum == 3)
					{
						gm.publish("buyHouseORmortgage");
					}
					else
					{
						gm.publish("mortgage");
					}
				}
			}
			else
			{			
				gm.payRent(p, owner, getRent());
				gm.publish("None");
			}
		}
	}
	
}
