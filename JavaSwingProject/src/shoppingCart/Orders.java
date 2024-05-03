package shoppingCart;

public class Orders {
	
	private boolean select;
	private String info;
	private int  price;
	private int quantity;
	private int totalPrice;
	private int delivery;
	private boolean delete;

	
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
	
	//상품별 배송비는 기본값 2500원 
	public int getDelivery() {
		return 2500;
	}
	public void setDelivery(int delivery) {
		this.delivery = delivery;
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
