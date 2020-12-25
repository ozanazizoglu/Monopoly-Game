
public class GoToJailCell extends Cell
{
	public GoToJailCell(String name, String type)
	{
		super(name,type);
	}
	
	public void handleCell( GameManager gm )
	{
		Player p = gm.whoseTurn();
		p.setPosition(10);
		gm.sendToJail(p);
		gm.publish("None");
	}
}
