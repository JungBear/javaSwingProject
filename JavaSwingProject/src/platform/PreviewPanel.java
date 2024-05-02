package platform;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dto.ProductDTO;

public class PreviewPanel extends JPanel{

	ProductDTO product;
	
	public PreviewPanel(ProductDTO product,int idx) {
		this.product = product;
		
		ImageIcon logoIcon = new ImageIcon("src/img/" + product.getProductName() + idx + ".jpg"); // 로고 이미지 파일 경로에 따라 변경하세요
//		System.out.println(l);
		ImageIcon scaledLogoIcon = new ImageIcon(logoIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH));
		JLabel productImg = new JLabel(scaledLogoIcon);
		
		JLabel productName = new JLabel(product.getProductName());
		
		add(productName);
		add(productImg);
	}
	
}
