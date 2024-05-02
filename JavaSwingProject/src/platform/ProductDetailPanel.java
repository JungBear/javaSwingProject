package platform;

import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dto.ProductDTO;

public class ProductDetailPanel extends JPanel{
	ProductDTO productDTO;
	
	public ProductDetailPanel(ProductDTO productDTO) {
		this.productDTO = productDTO;
		// 이 판넬의 설정
		setBounds(0,200,1280,760);
		setVisible(false);
		setLayout(null);
		
		// 상품의 이름 
		JLabel productName = new JLabel(productDTO.getProductName());
		productName.setBounds(100, 0, 600, 200);
		productName.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 24)); // 폰트 설정
		
		// 이미지 보여주기
		ImageIcon logoIcon = new ImageIcon(productDTO.getImgSrc());
		Image image = logoIcon.getImage();
		ImageIcon scaledLogoIcon;
		JLabel productImg = null;
	        
		if (image != null) {
			scaledLogoIcon = new ImageIcon(image.getScaledInstance(400, 400, Image.SCALE_SMOOTH));
	  
			productImg = new JLabel(scaledLogoIcon);
			productImg.setBounds(100, 200, scaledLogoIcon.getIconWidth(), scaledLogoIcon.getIconHeight());

		}
		
		JButton cart = new JButton("장바구니에 넣기");
//		cart.addActionListener(new );
		
		
		add(productName);
		add(productImg);
		
	}
	
	public ProductDTO addOnCart() {
		
		return this.productDTO;
	}
}
