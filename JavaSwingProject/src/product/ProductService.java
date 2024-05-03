package product;
import java.io.*;
import java.util.ArrayList;

import dto.ProductDTO;

public class ProductService {
	
	private static ArrayList<ProductDTO> products = new ArrayList<ProductDTO>();
	
	
	public ProductService() {
		
	}
	
	public ArrayList<ProductDTO> readData(String category, String smallCategory) {
		products.clear();
		switch(category) {
		case "의류":
			category = "cloth";
			break;
		case "화장품":
			category = "cosmetic";
			break;
		case "신발":
			category = "shoes";
			break;
		case "가방":
			category = "bag";
			break;
		
		}
		BufferedReader br = null;
		String temp = null;
		StringBuilder copyTemp = new StringBuilder();
		String[] databaseData = null; 
//		System.out.println("category :" + category);
//		System.out.println(category);
		try {
			
			br = new BufferedReader(new FileReader("src/database/" + category + ".txt"));
			while( (temp = br.readLine()) != null ) {
//				System.out.println(temp);
//				System.out.println("-----줄단위 읽기 확인");
				copyTemp.append(temp).append(", ");
				}
			databaseData = copyTemp.toString().split(", ");
//			System.out.println(databaseData.length);
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				if(br != null) {
					
					br.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		System.out.println(databaseData.length);
		for (int i = 0; i < databaseData.length; i+=5) {
			
//			System.out.println("smallcategory :" + smallCategory);
			int j =0;
			if(databaseData[i].equals(smallCategory)) {
				ProductDTO product = new ProductDTO();
//				System.out.println("이름 : " + databaseData[i+1]);
//				System.out.println("가격 : " + databaseData[i+4]);
//				System.out.println("소분류 : " + databaseData[i]);
//				System.out.println("주소 : " + databaseData[i+3]);
				product.setCategory(databaseData[i]);
				product.setProductName(databaseData[i+1]);
				product.setProductInfo(databaseData[i+2]);
				product.setImgSrc(databaseData[i+3]);
				product.setPrice(Integer.parseInt(databaseData[i+4]));
				products.add(product);
			}
			
			j++;
			
		}
		
		return products;
	}
	
	
	

}
