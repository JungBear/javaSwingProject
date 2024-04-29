package shoppingCart;

public class Orders {
	
	private boolean select;
	private String info;
	private int  price;
	private int quantity;
	private int totalPrice;
	private int delivery;
	private boolean delete;
	
	// 지명님 코드
//	public Orders(boolean select, String info, int price, int quantity, int totalPrice, int delivery, boolean delete) {
//		this.select = select;
//		this.info = info;
//		this.price = price;
//		this.quantity = quantity;
//		this.totalPrice = totalPrice;
//		this.delivery = delivery;
//		this.delete = delete;
//	}
	
	// 내코드
	public Orders(boolean select, String info, int price, int quantity, int delivery, boolean delete) {
		this.select = select;
		this.info = info;
		this.price = price;
		this.quantity = quantity;
		this.totalPrice = price * quantity;
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
	public int getQuantity() {
		
		return quantity;
	}
	public void setQuantity(int quantity) {
		
		this.quantity = quantity;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setAllPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public int getDelivery() {
		return delivery;
	}
	public void setDelivery(int delivery) {
		this.delivery = delivery;
	}
	
	//배송비 계산하는 메서드 
	public int calculateDelivery() {
		if(totalPrice > 100000) {
			return 0;
		} else {
			return 5000;
		}
		
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public boolean getDelete() {
		return delete;
	}
	public void setDelete(boolean delete) {
		this.delete = delete;
	}
	
}
