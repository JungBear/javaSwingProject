package platform;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.text.DecimalFormat;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dto.ProductDTO;

public class PreviewPanel extends JPanel{

	ProductDTO product;
	
	public PreviewPanel(ProductDTO product) {
		this.product = product;
		setBackground(Color.WHITE);
		
		
		ImageIcon logoIcon = new ImageIcon(product.getImgSrc());
		Image image = logoIcon.getImage();
        
		if (image != null) {
			ImageIcon scaledLogoIcon = new ImageIcon(image.getScaledInstance(200, 200, Image.SCALE_SMOOTH));
    	  
			JLabel productImg = new JLabel(scaledLogoIcon);
			JLabel productName = new JLabel(product.getProductName());
			productName.setFont(new Font("맑은 고딕", Font.BOLD, 13));
			
			JLabel productPrice = new JLabel(formatNumber(product.getPrice())+"원");
			productPrice.setFont(new Font("맑은 고딕", Font.BOLD, 12));
    	  
			productImg.setBounds(0, 0, scaledLogoIcon.getIconWidth(), scaledLogoIcon.getIconHeight());
    	  
			Dimension panelSize = this.getSize();
    	  
			productName.setPreferredSize(new Dimension(300, 20)); // 높이는 20으로 설정하고 너비를 패널의 너비와 동일하게 설정// productName의 텍스트를 중앙으로 정렬
			productName.setHorizontalAlignment(JLabel.CENTER);
    	  
			add(productImg);
			add(productName);
			add(productPrice);
        }
	      

	}
   	private static String formatNumber(int number) {
        DecimalFormat formatter = new DecimalFormat("#,###");
        return formatter.format(number);
    }
	
}
