
public class StartCell extends Cell
{
	int reward;
	public StartCell(String name, String type)
	{
		super(name,type);
		reward = 1000;
	}
	
	public void handleCell( GameManager gm)
	{
		Player p = gm.whoseTurn();
		gm.increaseMoney( p, reward);
		gm.publish("None");
	}

}
