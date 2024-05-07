package platform;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import dto.ProductDTO;
import shoppingCart.Orders;
import shoppingCart.ShoppingListPanel;

public class ProductDetailPanel extends JPanel{
	private ProductDTO productDTO;
	Orders order;
	ShoppingListPanel shoppingListPanel;
	MainFrame mainF;

	
	public ProductDetailPanel(ProductDTO productDTO, MainFrame mainF) {
		this.productDTO = productDTO;
		this.mainF = mainF;
		shoppingListPanel = mainF.shoppingCartGUI.getShoppingListPanel();
//		System.out.println("간다" + productDTO.getImgSrc());
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
	        
		if (image != null) {
			ImageIcon scaledLogoIcon = new ImageIcon(image.getScaledInstance(400, 400, Image.SCALE_SMOOTH));

			JLabel productImg = new JLabel(scaledLogoIcon);
			
			productImg.setBounds(100, 200, scaledLogoIcon.getIconWidth(), scaledLogoIcon.getIconHeight());
			add(productImg);
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
		
		
	}
	
	public void addOnCart() {
		 Orders order = new Orders(true, productDTO.getProductName(), productDTO.getPrice(), 1, 1, false);
		 
		  // Check if the order already exists in the shopping cart
		 // 지금 장바구니에 이상품이 있는지 체크
	        boolean orderExists = false;
	        for (Orders existingOrder : shoppingListPanel.getOrders()) {
	            if ((existingOrder.getInfo()).equals(order.getInfo())) {
	                orderExists = true;
	                break;
	            }
	        }

	        if (orderExists) {
	            // Display an alert message indicating the product is already in the cart
	            JOptionPane.showMessageDialog(null, "이미 같은 상품이 장바구니에 있습니다.", "중복 상품", JOptionPane.WARNING_MESSAGE);
	        } else {
	            // Add the order to the shopping cart
//	        	System.out.println("추가전 장바구니 : " + shoppingListPanel.getOrders());
	            shoppingListPanel.add(order);

	            // Update the table model to reflect the added order
	            shoppingListPanel.tableModel.fireTableDataChanged();
//	            System.out.println("추가후 장바구니 : " + shoppingListPanel.getOrders());

	            // Update the total order panel
	            mainF.shoppingCartGUI.totalOrderPanel.setTotalProductPayment(shoppingListPanel.selectAdd());
	            mainF.shoppingCartGUI.totalOrderPanel.setTotalOrderPanel();
	        }
	    }

	public ProductDTO getProductDTO() {
		return productDTO;
	}

	public void setProductDTO(ProductDTO productDTO) {
		this.productDTO = productDTO;
	}
		 
		

	   
}

