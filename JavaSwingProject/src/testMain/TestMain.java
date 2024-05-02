package testMain;

import platform.MainFrame;
import product.ProductService;

public class TestMain {
	
	public static MainFrame mainF;
	public static ProductService productService = new ProductService();
	
	public static void main(String[] args) {
		
		mainF = new MainFrame();
        mainF.setMainFrame();
	}
}
