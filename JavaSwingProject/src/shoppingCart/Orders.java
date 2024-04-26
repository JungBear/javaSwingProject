package shoppingCart;

public class Orders {
	
	boolean select;
	String info;
	int  price;
	String quantity;
	String allPrice;
	String delivery;
	String delete;
	
	public Orders(boolean select, String info, int price, String quantity, String allPrice, String delivery, String delete) {
		this.select = select;
		this.info = info;
		this.price = price;
		this.quantity = quantity;
		this.allPrice = allPrice;
		this.delivery = delivery;
		this.delete = delete;
		
		
	}
	
	public boolean getSelect() {
		return select;
	}
	public void setSelect(boolean select) {
		this.select = select;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getQuantity() {
		
		return quantity;
	}
	public void setQuantity(String quantity) {
		
		this.quantity = quantity;
	}
	public String getAllPrice() {
		return allPrice;
	}
	public void setAllPrice(String allPrice) {
		this.allPrice = allPrice;
	}
	public String getDelivery() {
		return delivery;
	}
	public void setDelivery(String delivery) {
		this.delivery = delivery;
	}
	public String getDelete() {
		return delete;
	}
	public void setDelete(String delete) {
		this.delete = delete;
	}
	
}
