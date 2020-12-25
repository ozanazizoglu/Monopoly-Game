import java.util.*;

public class GameManager {
	
	private ArrayList<Player> players;
	private Board board;
	private static GameManager instance;
	private int playerIndex;
	private int face1;
	private int face2;
	//private String userInterfaceMessage;
	private ArrayList<Observer> observers;
	
	public GameManager() {
		players = new ArrayList<Player>();
		observers = new ArrayList<Observer>();
		board = new Board();
		board.fillBoard();
		playerIndex = 0;
		face1 = 6;
		face2 = 6;
		//userInterfaceMessage = "";
	}
	
	public static GameManager getInstance() 
	{
		if (instance == null)
		{
            instance = new GameManager();
        }
        return instance;
	}
	
	public Board getBoard()
	{
		return board;
	}
	
	public void increaseMoney(Player player, int amount)
	{
		int total = player.getMoney() + amount;
		player.setMoney(total); 
	}
	
	public void decreaseMoney(Player player, int amount) 
	{
		int total = player.getMoney() - amount;
		player.setMoney(total);
	}
	
	public void payRent(Player player1, Player player2, int amount) 
	{
		if(player1.getMoney() >= amount)
		{
			decreaseMoney(player1, amount);
			increaseMoney(player2, amount);
		}
		else
		{
			player1.setBankrupt();
			increaseMoney(player2, player1.getMoney());
		}
	}
	
	
	public void addProperty()
	{
		Player p = whoseTurn();
		int index = p.getPosition();
		PropertyCell cell = (PropertyCell)(board.cellAt(index));
		p.addProperty(cell);	
	}
	
	public void addStation()
	{
		Player p = whoseTurn();
		int index = p.getPosition();
		StationCell cell = (StationCell)(board.cellAt(index));
		p.addStation(cell);	
	}
	
	public void addUtility()
	{
		Player p = whoseTurn();
		int index = p.getPosition();
		UtilityCell cell = (UtilityCell)(board.cellAt(index));
		p.addUtility(cell);	
	}
	
	public void rollDice()
	{
		face1 = (int) (Math.random() * 5) + 1;
		face2 = (int) (Math.random() * 5) + 1;
	}
	
	public int getFace1()
	{
		return face1;
	}
	
	public int getFace2()
	{
		return face2;
	}
	
	public int getDiceTotal()
	{
		return face1 + face2;
	}
	
	public int getPropertyNumber(Player player) 
	{
		ArrayList<PropertyCell> properties = player.getProperties();
		return properties.size();
	}
	
	public int getUtilityNumber(Player player)
	{
		ArrayList<UtilityCell> utilities = player.getUtilities();
		return utilities.size();
	}
	
	public int getStationNumber(Player player)
	{
		ArrayList<StationCell> stations = player.getStations();
		return stations.size();
	}
	
	
	public void sendToJail(Player player) 
	{
		player.setJail(true);
	}
	
	
	public void getOutFromJail(Player player)
	{
		player.setJail(false);
	}
	
	public void nextTurn()
	{
		if( getFace1() != getFace2())
		{
			/*
			while( players.get(playerIndex).getBankrupt())
			{
				players.remove(playerIndex);
			}
			*/
			playerIndex = (playerIndex + 1) % players.size();
		}
			
	}
	
	public Player whoseTurn()
	{
		while( players.get(playerIndex).getBankrupt())
		{
			players.remove(playerIndex);
		}
		return players.get(playerIndex);		
	}
	
	public void movePlayer()
	{
		Player p = whoseTurn();
		if( p.isInJail())
		{
			if(p.getJailCounter() == 3)
			{
				p.setJail(false);
				p.setJailCounter(0);
			}
			else if( getFace1() == getFace2() )
			{
				p.setJail(false);
				p.setJailCounter(0);
			}
			else
			{
				p.incrementJailCounter();
			}		
		}
			
		if(!p.isInJail())
		{		
			int withDice = p.getPosition() + getDiceTotal();
			int newPosition = ( p.getPosition() + getDiceTotal() ) % board.getCellNum();
			if(withDice > 40)
			{
				board.cellAt(0).handleCell(this);//Start pointi gecerse yine de odul almali.
			}
			p.setPosition(newPosition);	
		}
	}
	
	public void buy()
	{
		Player p = whoseTurn();
		int index = p.getPosition();
		Cell cell = board.cellAt(index);
		
		if( cell.getCellType().equals("PropertyCell") )
		{
			if( (p.getMoney() >= ((PropertyCell) cell).getPrice()))
			{
				decreaseMoney(p, ((PropertyCell) cell).getPrice());
				p.addProperty((PropertyCell)cell);
				((PropertyCell) cell).setOwner(p);				
			}
		}
		else if( cell.getCellType().equals("StationCell"))
		{
			if( p.getMoney() >= ( (StationCell) cell).getPrice())
			{
				decreaseMoney(p, ((StationCell) cell).getPrice());
				p.addStation((StationCell)cell);
				((StationCell) cell).setOwner(p);
			}
		}
		else
		{
			if( p.getMoney() >= ( (UtilityCell) cell).getPrice())
			{
				decreaseMoney(p, ((UtilityCell) cell).getPrice());
				p.addUtility((UtilityCell)cell);
				((UtilityCell) cell).setOwner(p);
			}	
		}	
	}
	
	public void buyHouse()
	{
		Player p = whoseTurn();
		PropertyCell cell = (PropertyCell)board.cellAt(p.getPosition());
		if(cell.buyHouse() && p.getMoney() >= cell.getHousePrice())
		{
			decreaseMoney(p, cell.getHousePrice());
		}
	}

	public void buyHotel()
	{
		Player p = whoseTurn();
		PropertyCell cell = (PropertyCell)board.cellAt(p.getPosition());
		if(cell.buyHotel() && p.getMoney() >= cell.getHotelPrice())
		{
			decreaseMoney(p, cell.getHotelPrice());
		}
	}
	
	public void mortgage()
	{
		Player p = whoseTurn();
		PropertyCell cell = (PropertyCell)board.cellAt(p.getPosition());
		if(!cell.getIsMortgage())
		{
			cell.mortgage();
			increaseMoney(p, cell.getMortgageVal());
		}
	}
	
	public void handleCell()
	{
		 Player p = whoseTurn();
	     Cell cell = board.cellAt(p.getPosition());
	     cell.handleCell(this);	
	}
	
	public ArrayList<Player> getPlayers()
	{
		return players;
	}
	
	public void addPlayer( Player p)
	{
		players.add(p);
	}
	
	public void removePlayer(Player p)
	{
		players.remove(playerIndex);
	}
	
	public void playCard()
	{
		Player p = whoseTurn();
		Cell cell = board.cellAt(p.getPosition());
		if (cell.getCellType().equals("ChanceCardCell"))
		{
			ChanceCardCell chanceCell = (ChanceCardCell) cell;
			ChanceCard card = chanceCell.drawCard();
			switch( card.getIndex())
			{
			case 0:
				p.setPosition(0);
				increaseMoney(p,1000);
				publish("None");
				//System.out.println()
				System.out.println(card.getInfo());
				break;
				
			case 1:
				int prevPos = p.getPosition();
				p.setPosition(16);
				if( prevPos > 16 )
				{
					increaseMoney(p,1000);
				}
				publish("None");
				System.out.println(card.getInfo());
				break;
			case 2:
				increaseMoney(p,100);
				publish("None");
				System.out.println(card.getInfo());
				break;
			case 3:
				int pos = p.getPosition();
				int newPos = pos - 3;
				if( newPos < 0)
				{
					newPos = newPos + 40;
				}
				p.setPosition(newPos);
				publish("None");
				System.out.println(card.getInfo());
				break;
			case 4:
				p.setPosition(30);
				sendToJail(p);
				publish("None");
				System.out.println(card.getInfo());
				break;
			}	
		}
		else if(cell.getCellType().equals("ChestCardCell"))
		{
			ChestCardCell chestCell = (ChestCardCell) cell;
			ChestCard chestCard = chestCell.drawCard();
			switch(chestCard.getIndex())
			{
			case 0:
				p.setPosition(0);
				increaseMoney(p,1000);
				System.out.println(chestCard.getInfo());
				break;
			case 1:
				if( p.getMoney() >= 50)
				{
					decreaseMoney(p,50);
				}
				else
				{
					p.setBankrupt();
				}
				System.out.println(chestCard.getInfo());
				break;
			case 2:
				for( Player p2 : players)
				{
					if( p2 != p)
					{
						payRent(p2,p, 50);
					}
					
				}
				System.out.println(chestCard.getInfo());
				break;
			case 3:
				if( p.getMoney() >= 150)
				{
					decreaseMoney(p,150);
				}
				else
				{
					p.setBankrupt();
				}
				System.out.println(chestCard.getInfo());
				break;
			case 4:
				increaseMoney(p,50);
				System.out.println(chestCard.getInfo());
				break;
			}
		}
	}
	
	public void subscribe(Observer observer) {
        observers.add(observer);
    }

    public void publish(String command) {
        observers.forEach(listener -> listener.observe(command));
    }
    
    /*
    public void setUIMessage( String msg )
    {
    	//UI will set the userMessage and it will be processed in userCommand method.
    	userInterfaceMessage = msg;
    }
    */
	
    /*
	public void userCommand( String command)
	{
		if(userInterfaceMessage.equals("Buy"))
		{
			buy();
		}
		
	}
	*/
	
	
}
