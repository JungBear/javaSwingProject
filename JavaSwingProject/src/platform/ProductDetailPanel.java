package platform;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import dto.ProductDTO;
import shoppingCart.Orders;
import shoppingCart.ShoppingListPanel;

public class ProductDetailPanel extends JPanel{
	private ProductDTO productDTO;
	Orders order;
	ShoppingListPanel shoppingListPanel;
	MainFrame mainF;
	Font font = new Font("Arial", Font.BOLD, 15);

	
	public ProductDetailPanel(ProductDTO productDTO, MainFrame mainF) {
		this.productDTO = productDTO;
		this.mainF = mainF;
		shoppingListPanel = mainF.shoppingCartGUI.getShoppingListPanel();
//		System.out.println("간다" + productDTO.getImgSrc());
		// 이 판넬의 설정
		setBounds(0,200,1280,760);
		setVisible(false);
		setBackground(Color.WHITE);
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

			JLabel productImg = new JLabel(scaledLogoIcon) {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    // 테두리 그리기
                    g.setColor(Color.BLACK);
                    g.drawRect(0, 0, getWidth(), getHeight()-1);
                }
            };

			
			productImg.setBounds(100, 200, scaledLogoIcon.getIconWidth(), scaledLogoIcon.getIconHeight());
			add(productImg);
		}
		
		JLabel productInfo = new JLabel("Product Info");
		productInfo.setBounds(600, 160, 100, 100);
		productInfo.setFont(font);
		
//		JLabel productInfoText = new JLabel(productDTO.getProductInfo());
		JLabel productInfoText = new JLabel("<html>" + productDTO.getProductInfo() + "</html>");
		productInfoText.setBounds(760, 200, 400, 200);
//		productInfoText.setPreferredSize(new Dimension(400, 300));
		productInfoText.setVerticalAlignment(SwingConstants.TOP);
		
		// 가로줄 추가
        JLabel horizontalLine1 = new JLabel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.BLACK);
                g.drawLine(600, 440, 1000, 440);
            }
        };
        horizontalLine1.setBounds(600, 240, 560, 1);
		
		JLabel count = new JLabel("구매 수량");
		count.setBounds(600, 240, 100, 100);
		count.setFont(new Font("나눔고딕", Font.BOLD, 15));
		
		Integer[] quantities = {1, 2, 3, 4, 5};
		JComboBox<Integer> quantityComboBox = new JComboBox<>(quantities);
		quantityComboBox.setBounds(760, 280, 100, 30);
		
		// 가로줄 추가
        JLabel horizontalLine2 = new JLabel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.BLACK);
                g.drawLine(600, 440, 1000, 440);
            }
        };
        horizontalLine2.setBounds(600, 340, 560, 1);

        JLabel PaymentLabel = new JLabel("가격");
        PaymentLabel.setBounds(600, 340, 100, 100);
        PaymentLabel.setFont(new Font("Arial", Font.BOLD, 15));
        
        JLabel PaymentText = new JLabel((productDTO.getPrice() * (int) quantityComboBox.getSelectedItem()) + "원");
        PaymentText.setBounds(760, 340, 100, 100);
        PaymentText.setFont(new Font("나눔고딕", Font.BOLD, 15));
        
		
		JButton cart = new JButton("장바구니에 넣기");
		cart.setBounds(700,480,200,100);
		cart.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedQuantity = (int) quantityComboBox.getSelectedItem();
				addOnCart(selectedQuantity);
				
			}
		});
//		cart.addActionListener(new );
		horizontalLine1.setOpaque(true);
		add(horizontalLine1);
		
		horizontalLine2.setOpaque(true);
		add(horizontalLine2);
		
		add(productInfo);
		add(productInfoText);
		add(count);
		add(quantityComboBox);
		add(cart);
		add(productName);
		add(PaymentLabel);
		add(PaymentText);
		
		
	}
	
	public void addOnCart(int quantity) {
		 Orders order = new Orders(true, productDTO.getProductName(), productDTO.getPrice(), quantity, 1, false);
		 
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
	            System.out.println("추가 할 때 order = " + order);

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

