package Hisse;

public class Hisse {
	private final String NAME;
	private double price;
	private double yesterdaysPrice;
	private double change;
	private double tavan;
	private double taban;
	
	public Hisse(String NAME, double price, double yesterdaysPrice, double change, double tavan, double taban) {
		super();
		this.NAME = NAME;
		this.price = price;
		this.yesterdaysPrice = yesterdaysPrice;
		this.change = change;
		this.tavan = tavan;
		this.taban = taban;
	}
	
	public String getNAME() {
		return NAME;
	}

	public double getPrice() {
		return price;
	}

	public double getYesterdaysPrice() {
		return yesterdaysPrice;
	}

	public double getChange() {
		return change;
	}

	public double getTavan() {
		return tavan;
	}

	public double getTaban() {
		return taban;
	}

	protected void setPrice(double price) {
		this.price = price;
	}

	protected void setYesterdaysPrice(double yesterdaysPrice) {
		this.yesterdaysPrice = yesterdaysPrice;
	}

	protected void setChange(double change) {
		this.change = change;
	}

	protected void setTavan(double tavan) {
		this.tavan = tavan;
	}

	protected void setTaban(double taban) {
		this.taban = taban;
	}

	@Override
	public String toString() {
		return "Hisse " + NAME + ", Fiyat = " + price + ", Dun = " + yesterdaysPrice + ", Degisim = %" + change
				+ ", Tavan = " + tavan + ", Taban = " + taban;
	}	
}
