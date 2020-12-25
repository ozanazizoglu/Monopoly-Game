
public class JailCell extends Cell
{
	public JailCell(String name, String type)
	{
		super(name,type);
	}
	
	
	public void handleCell( GameManager gm )
	{
		gm.publish("None");
	}

}
