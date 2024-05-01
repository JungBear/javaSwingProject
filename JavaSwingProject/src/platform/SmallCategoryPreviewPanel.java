package platform;

import java.util.ArrayList;

import javax.swing.JPanel;

import dto.ProductDTO;
import product.ProductService;

public class SmallCategoryPreviewPanel extends JPanel{
	ArrayList<ProductDTO> pds; 
	
	public SmallCategoryPreviewPanel(ArrayList<ProductDTO> pds) {
		this.pds = pds;
		
		setBounds(0,200,1280,760);
		setVisible(false);
//		System.out.println(pds);
		
		
		
	}

}
