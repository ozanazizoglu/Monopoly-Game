
public class FreeParkCell extends Cell
{
	public FreeParkCell(String name, String type)
	{
		super(name, type);
	}
	
	public void handleCell(GameManager gm)
	{
		gm.publish("None");
	}

}
