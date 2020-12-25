
public class CellFactory 
{
	private static CellFactory instance;
	
	private CellFactory()
	{
		
	}
	
	public static CellFactory getInstance()
	{
		if(instance == null)
		{
			instance = new CellFactory();
		}
		return instance;
	}
	
	public Cell createCells( int boardIndex)
	{
		switch(boardIndex)
		{
			case 0: return new StartCell("Starting Cell", "StartCell");
			case 1: return new PropertyCell("Pursaklar","PropertyCell","brown",100,10);
			case 2: return new ChestCardCell("Kamu Fonu","ChestCardCell");
			case 3: return new PropertyCell("Haymana","PropertyCell","brown",120,15);
			case 4: return new TaxCell("Gelir Vergisi","TaxCell",false,500,1000);
			case 5: return new StationCell("Ankara-Eskisehir Treni","StationCell", 200,80);
			case 6: return new PropertyCell("Yuzuncu Yil","PropertyCell","lightblue",200,20);
			case 7: return new ChanceCardCell("Sans","ChanceCardCell");
			case 8: return new PropertyCell("Ovecler","PropertyCell","lightblue",200,20);
			case 9: return new PropertyCell("Eryaman","PropertyCell","lightblue",220,25); 
			case 10: return new JailCell( "Kodes", "JailCell");
			case 11: return new PropertyCell("GOP","PropertyCell","pink",300,30); 
			case 12: return new UtilityCell("Tedas","UtilityCell",200,75,150);
			case 13: return new PropertyCell("Ulus","PropertyCell","pink",300,30); 
			case 14: return new PropertyCell("Tunali","PropertyCell","pink",330,40); 
			case 15: return new StationCell( "Ankara-Konya Treni", "StationCell",200,80);
			case 16: return new PropertyCell("Kizilay","PropertyCell","orange",400,45);
			case 17: return new ChestCardCell("Kamu Fonu","ChestCardCell");
			case 18: return new PropertyCell("Kucukesat","PropertyCell","orange",400,45);
			case 19: return new PropertyCell("Tunus","PropertyCell","orange",440,50);
			case 20: return new FreeParkCell("Ucretsiz otopark", "FreeParkCell");
			case 21: return new PropertyCell("Mustafa Kemal Mahallesi","PropertyCell","red",500,55);
			case 22: return new ChanceCardCell("Sans","ChanceCardCell");
			case 23: return new PropertyCell("Dikmen","PropertyCell","red",550,60);
			case 24: return new PropertyCell("Hosdere","PropertyCell","red",550,60);
			case 25: return new StationCell( "Ankaray", "StationCell",200,80);
			case 26: return new PropertyCell("Oran","PropertyCell","yellow",600,65);
			case 27: return new UtilityCell("Sular Idaresi","UtilityCell",200,75,150);
			case 28: return new PropertyCell("Birlik","PropertyCell","yellow",600,65);
			case 29: return new PropertyCell("Yasamkent","PropertyCell","yellow",650,70);
			case 30: return new GoToJailCell("Kodese Git","GoToJailCell");
			case 31: return new PropertyCell("incek","PropertyCell","green",700,75);
			case 32: return new PropertyCell("Beytepe","PropertyCell","green",700,75);
			case 33: return new ChestCardCell("Kamu Fonu","ChestCardCell");
			case 34: return new PropertyCell("Umitkoy","PropertyCell","green",750,80);
			case 35: return new StationCell( "Koru Metrosu", "StationCell",200,80);
			case 36: return new ChanceCardCell("Sans","ChanceCardCell");
			case 37: return new PropertyCell("Altindag","PropertyCell","blue",700,75);
			case 38: return new TaxCell("Gelir Vergisi","TaxCell",true,500,1000);
			case 39: return new PropertyCell("Cayyolu","PropertyCell","blue",800,80);			
		}
		return null;
	}

}
