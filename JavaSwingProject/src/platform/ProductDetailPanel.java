package platform;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import dto.ProductDTO;
import shoppingCart.Orders;
import shoppingCart.ShoppingListPanel;

public class ProductDetailPanel extends JPanel{
	ProductDTO productDTO;
	Orders order;
	ShoppingListPanel shoppingListPanel;
	MainFrame mainF;
	
	public ProductDetailPanel(ProductDTO productDTO, MainFrame mainF) {
		this.productDTO = productDTO;
		this.mainF = mainF;
		shoppingListPanel = mainF.shoppingCartGUI.getShoppingListPanel();
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
		cart.setBounds(600,600,200,100);
		cart.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				addOnCart();
				
			}
		});
//		cart.addActionListener(new );
		
		add(cart);
		add(productName);
		add(productImg);
		
	}
	
	public void addOnCart() {
		 Orders order = new Orders(true, productDTO.getProductName(), productDTO.getPrice(), 1, 1, false);
		 
		 Iterator<Orders> iterator = shoppingListPanel.getOrders().iterator();
		 while (iterator.hasNext()) {
		        Orders existingOrder = iterator.next();
//		        if(existingOrder.getProductName().equals(productDTO.getProductName())) {
//					 JOptionPane.showMessageDialog(null, "이미 추가된 상품입니다");
//					 break;
//				 }
		    }
		 
		
		 shoppingListPanel.add(order);

		 System.out.println(shoppingListPanel.getOrders());
		 
		 // shoppingListPanel의 테이블 모델 업데이트
		 shoppingListPanel.tableModel.fireTableDataChanged();
	    // shoppingListPanel의 orders 목록에 order 추가
	   
	}
}
