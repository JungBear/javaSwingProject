package product;
import java.io.*;
import java.util.ArrayList;

import dto.ProductDTO;

public class ProductService {
	
	private static ArrayList<ProductDTO> products = new ArrayList<ProductDTO>();
	
	public ProductService() {
		// TODO Auto-generated constructor stub
	}
	
	public ArrayList<ProductDTO> readData(String catogory) {
//		BufferedReader br = new BufferedReader(new FileReader(fileName));
//		
//
//		try {
//			
//			
//			int read = 0;
//			while((read = fr.read()) != -1) {
//				System.out.print((char)read);
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//		} finally {
//			try {
//				fr.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
		
		
		return products;
	}
	

}
