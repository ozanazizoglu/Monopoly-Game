public abstract class Card {
	private String info;
	private int index;
	
	public Card(String info, int index) {
		this.info = info;
		this.index = index; 
	}	


	public void setInfo(String info) {
		this.info = info;
	}
	
	public String getInfo() {
		return info;
	}
	
	public void setIndex(int index) {
		this.index = index;
	}
	
	public int getIndex() {
		return index;
	}

	
}
