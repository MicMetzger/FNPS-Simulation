import java.util.*;




public abstract class Item {
	private String name;
	private Date   dayArrived;
	private Date   daySold;
	private double purchasePrice;
	private double listPrice;
	private double salePrice;


	public Item(String name, Date dayArrived, Date daySold, double purchasePrice, double listPrice, double salePrice) {
		this.name = name;
		this.dayArrived = dayArrived;
		this.daySold = daySold;
		this.purchasePrice = purchasePrice;
		this.listPrice = listPrice;
		this.salePrice = salePrice;
	}


	public Item() {}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getPurchasePrice() {
		return purchasePrice;
	}


	public void setPurchasePrice(double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}


	public double getListPrice() {
		return listPrice;
	}


	public void setListPrice(double listPrice) {
		this.listPrice = listPrice;
	}


	public double getSalePrice() {
		return salePrice;
	}


	public void setSalePrice(double salePrice) {
		this.salePrice = salePrice;
	}


	public Date getDayArrived() {
		return dayArrived;
	}


	public void setDayArrived(Date dayArrived) {
		this.dayArrived = dayArrived;
	}


	public Date getDaySold() {
		return daySold;
	}


	public void setDaySold(Date daySold) {
		this.daySold = daySold;
	}

}
