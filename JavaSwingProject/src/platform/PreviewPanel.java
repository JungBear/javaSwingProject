package platform;

import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dto.ProductDTO;

public class PreviewPanel extends JPanel{

	ProductDTO product;
	
	public PreviewPanel(ProductDTO product) {
		this.product = product;
		
		  ImageIcon logoIcon = new ImageIcon(product.getImgSrc());
	      Image image = logoIcon.getImage();
	        
	      if (image != null) {
	    	  ImageIcon scaledLogoIcon = new ImageIcon(image.getScaledInstance(200, 200, Image.SCALE_SMOOTH));
	    	  
	    	  JLabel productImg = new JLabel(scaledLogoIcon);
	    	  JLabel productName = new JLabel(product.getProductName());
	    	  JLabel productPrice = new JLabel(product.getPrice()+"원");
	    	  
	    	  productImg.setBounds(0, 0, scaledLogoIcon.getIconWidth(), scaledLogoIcon.getIconHeight());
	    	  
	    	  Dimension panelSize = this.getSize();
	    	  int labelWidth = panelSize.width; // 패널의 너비
	    	  
	    	  productName.setPreferredSize(new Dimension(300, 20)); // 높이는 20으로 설정하고 너비를 패널의 너비와 동일하게 설정// productName의 텍스트를 중앙으로 정렬
	    	  productName.setHorizontalAlignment(JLabel.CENTER);
	    	  
	    	  add(productImg);
	    	  add(productName);
	    	  add(productPrice);
	        }
	}
	
}
