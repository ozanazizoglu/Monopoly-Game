import java.util.*;
public class Player
{
	//attributes
	private String name;
	//private String symbol;
	private boolean inJail;
	private boolean isBankrupt;
	private int position;
	private int money;
	private int jailCounter;
	private String color;
	private ArrayList<PropertyCell> properties;
	private ArrayList<StationCell> stations;
	private ArrayList<UtilityCell> utilities;
	//private int colorIndex;
	public Player(String name, String color)
	{
		this.name = name;
		properties = new ArrayList<>();
		stations = new ArrayList<>();
		utilities = new ArrayList<>();
		inJail = false;
		isBankrupt = false;
		jailCounter = 0;
		position = 0;
		money = 5000;
		this.color = color;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getColor()
	{
		return color;
	}
	
	public int getPosition()
	{
		return position;
	}
	
	public void setPosition(int position)
	{
		this.position = position;
	}
	
	public int getJailCounter()
	{
		return jailCounter;
	}
	
	public void setJailCounter( int cnt)
	{
		jailCounter = 0;
	}
	
	public void incrementJailCounter()
	{
		jailCounter = jailCounter + 1;
	}
	
	public int getMoney() 
	{
		return money;
	}
	
	public void setMoney(int money)
	{
		this.money = money;
	}
	
	public ArrayList<PropertyCell> getProperties()
	{
		return properties;
	}
	
	public void addProperty(PropertyCell cell)
	{
		properties.add(cell);
	}
	
	public ArrayList<StationCell> getStations()
	{
		return stations;
	}
	
	public void addStation(StationCell station)
	{
		stations.add(station);
	}
	
	public ArrayList<UtilityCell> getUtilities()
	{
		return utilities;
	}
	
	public void addUtility(UtilityCell utility)
	{
		utilities.add(utility);
	}
	
	public boolean getBankrupt()
	{
		return isBankrupt;
	}
	
	public void setBankrupt()
	{
		isBankrupt = true;
	}
	
	public boolean isInJail()
	{
		return inJail;
	}
	
	public void setJail(boolean jail)
	{
		inJail = jail;
	}
	
	public String toString()
	{
		String init = "Name: " + name + "\n" + "Money: " + money + "\n" + 	"Color: " + color + "\n"; 
		String prop = "Properties: \n";
		String util = "Utilities: \n";
		String stat = "Stations: \n";
		if( properties.size() > 0 )
		{
			for (PropertyCell pr :properties)
			{
				prop += pr.getName() + "\n";
			}
				
		}
		if( utilities.size() > 0 )
		{
			for (UtilityCell ut :utilities)
			{
				util += ut.getName() + "\n";
			}
				
		}
		
		if( stations.size() > 0 )
		{
			for (StationCell st :stations)
			{
				stat += st.getName() + "\n";
			}
				
		}
		return init + prop + util + stat;
	}
	
	public int getColorNum(String color)
	{
		int colorCnt = 0;
		for(int i = 0 ; i < properties.size(); i++ )
		{
			if( properties.get(i).getColor().equals(color))
			{
				colorCnt++;
			}
		}
		return colorCnt;
	}
	

}
