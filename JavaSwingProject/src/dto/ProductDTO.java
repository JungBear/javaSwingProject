package dto;

public class ProductDTO {
	
	private String Category;
	private String productName;
	private String productInfo;
	private String imgSrc;
	private int price;
	
	public ProductDTO(String category, String productName, String productInfo, String imgSrc, int price) {
		super();
		Category = category;
		this.productName = productName;
		this.productInfo = productInfo;
		this.imgSrc = imgSrc;
		this.price = price;
	}


	public String getCategory() {
		return Category;
	}


	public void setCategory(String category) {
		Category = category;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public String getProductInfo() {
		return productInfo;
	}


	public void setProductInfo(String productInfo) {
		this.productInfo = productInfo;
	}


	public String getImgSrc() {
		return imgSrc;
	}


	public void setImgSrc(String imgSrc) {
		this.imgSrc = imgSrc;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
}
