import java.util.*;
public class Board 
{
	private HashMap<Integer, Cell> gameBoard;
	private int cellNum;
	private CellFactory cells;
	
	public Board()
	{
		cells = CellFactory.getInstance();
		cellNum = 40;
		gameBoard = new HashMap<Integer, Cell>(cellNum);
	}
	
	public void fillBoard()
	{
		for(int i = 0 ; i < cellNum ; i++)
		{
			Integer intObj = new Integer(i);
			gameBoard.put(intObj, cells.createCells(i));
		}
	}
	
	
	public int getCellNum()
	{
		return cellNum;
	}
	
	public Cell cellAt(int position)
	{
		return gameBoard.get(position);
	}
	

}
