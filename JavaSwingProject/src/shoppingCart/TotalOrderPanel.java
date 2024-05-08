package shoppingCart;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TotalOrderPanel extends JPanel{
int totalProductPayment;//선택한or전체 상품의금액 
private int totalDeliveryPayment;//선택한or전체 상품의 배송비 - 10만원 이상이면 0원이 되도록 조건문 달아야 함 
private int totalPayment;//totalProductPayment + totalDeliveryPayment 
private ArrayList<Orders> orders;//주문내역을 받아옴 
private JLabel totalProductPaymentLabel;
private JLabel totalPaymentLabel;
private JLabel totalDeliveryPaymentLabel;
	
	
	public TotalOrderPanel() {
		this.totalPayment = totalProductPayment + totalDeliveryPayment;
		this.totalDeliveryPayment = 2500;


		
		//선택한 or 전체 상품의 금액을 표시하는 부분 생성 
		totalProductPaymentLabel = new JLabel("선택한 상품의 결제 금액 : " + formatNumber(this.totalProductPayment) + "원  +   ");
		//선택한 or 전체 상품의 금액에 대한 배송비를 표시하는 부분 생성 
		totalDeliveryPaymentLabel = new JLabel("   배송비 : " + formatNumber(totalDeliveryPayment) + "원    =");
		// 총 결제 금액을 표시하는 부분 생성
		totalPaymentLabel = new JLabel("총 결제 금액 : " + formatNumber(totalPayment) + "원"+"\n");
		
		
		//폰트 사이즈 설정
        Font font = new Font("맑은 고딕", Font.PLAIN, 16);
        totalProductPaymentLabel.setFont(font);
        totalDeliveryPaymentLabel.setFont(font);
        totalPaymentLabel.setFont(font);
        
        
		//totalOrderPanel의 영역 사이즈 설정
		setBounds(325,551,650,100);
		//setBackground(Color.yellow);
		setVisible(true);
		setLayout(new BorderLayout());
		add(totalProductPaymentLabel,BorderLayout.WEST);
		add(totalDeliveryPaymentLabel, BorderLayout.CENTER);
		add(totalPaymentLabel, BorderLayout.EAST);
		
		//선택한 상품 주문버튼, 전체 주문버튼 추가 
		JButton selectOrderbtn = new JButton("선택한 상품 주문");
		JButton totalOrderbtn = new JButton("전체 상품 주문");
		selectOrderbtn.setPreferredSize(new Dimension(150, 50)); // 버튼의 크기 조정
		totalOrderbtn.setPreferredSize(new Dimension(150, 50)); // 
		// 버튼의 폰트 크기 조정
		Font buttonFont = new Font("맑은 고딕", Font.BOLD, 14); //버튼 폰트 설정
		selectOrderbtn.setFont(buttonFont);
		totalOrderbtn.setFont(buttonFont);
        selectOrderbtn.setForeground(Color.BLACK);//버튼의 폰트 색
        totalOrderbtn.setForeground(Color.BLACK);
		
		JPanel buttonPanel = new JPanel(); // 버튼을 담을 패널 생성
        add(buttonPanel, BorderLayout.SOUTH); // 하단에 버튼 패널 추가
       // buttonPanel.setBackground(Color.WHITE);
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 0)); // 버튼을 가운데 정렬 및 간격 추가
        buttonPanel.add(selectOrderbtn, BorderLayout.WEST);
        buttonPanel.add(totalOrderbtn, BorderLayout.EAST);

		
		//선택한 상품 주문버튼 누를 때 작동하는 리스너 
		selectOrderbtn.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				//totalOrderPanel.updateTotalPrice 값만 받아와서 
				//선택한 상품이 주문 되었습니다. 결제 금액은 ""입니다. 팝업 띄우기 
				 getTotalPayment();
				 
				 showSelectPopup(totalProductPayment+totalDeliveryPayment);
				
				
			}
		});
		//전체 상품 주문버튼 누를 때 작동하는 리스너 
		totalOrderbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//totalOrderPanel업데이트 되기 전 모든 상품의 totalPrice 값을 받아와서 
				//전체 상품이 주문 되었습니다. 결제금액은 ""입니다.  팝업 띄우기 
				 
				updateTotalPayment(orders);
				
				 showTotalPopup(totalProductPayment+totalDeliveryPayment);
				
			}
		});
	
	}
	
	//선택 주문 누를 때 팝업창 띄우기
	private void showSelectPopup(int value) {
		SelecBtnFrame popup = new SelecBtnFrame(value, this);
        popup.setVisible(true);
        
    }
	//전체 주문 누를 때 팝업창 띄우기
	private void showTotalPopup(int value) {
		TotalBtnFrame popup = new TotalBtnFrame(value, this);
		popup.setVisible(true);
		popup.initialize();
	}
	
	
	
	
	//totalOrderPanel 화면을 보여주는 메서드(기본값) 
	public void setTotalOrderPanel() {
		
	}
	
	public void setTotalProductPayment(int totalProductPayment) {
		this.totalProductPayment = totalProductPayment;
	}
	
	 // 선택한 상품의 결제 금액을 업데이트하는 메서드
    public void updateSelectPayment(ArrayList<Orders> orders) {
        this.totalProductPayment = 0;
        for (Orders order : orders) {
        	if(order.getSelect()) {      	           		
        		totalProductPayment += order.getPrice() * order.getQuantity() ;        	           		
        	} 
        }
          
        totalProductPaymentLabel.setText("선택한 상품의 결제 금액 : " + formatNumber(totalProductPayment)  + "원    +   ");
     
        
        
        // 배송비 업데이트
        if (totalProductPayment >= 100000) {
            this.totalDeliveryPayment = 0; 
        } else {
            this.totalDeliveryPayment = 2500; 
        }
        
        // 총 결제 금액 업데이트 
        totalDeliveryPaymentLabel.setText("   배송비 : " + formatNumber(totalDeliveryPayment) + "원    =");
        totalPaymentLabel.setText("총 결제 금액 : " + formatNumber(totalProductPayment + totalDeliveryPayment) + "원"+"\n");
    }
    
    //전체 상품의 결제 금액을 업데이트하는 메서드
    public void updateTotalPayment(ArrayList<Orders> orders) {
    	this.totalProductPayment = 0;
    	for (Orders order : orders) {
    			System.out.println(orders);
    			totalProductPayment += order.getPrice() * order.getQuantity();        	           		
    	}
    	
    	totalProductPaymentLabel.setText("선택한 상품의 결제 금액 : " + formatNumber(totalProductPayment) + "원   +");
    	
    	
    	// 배송비 업데이트
    	if (totalProductPayment >= 100000) {
    		this.totalDeliveryPayment = 0; 
    	} else {
    		this.totalDeliveryPayment = 2500; 
    	}
    	
    	// 총 결제 금액 업데이트 
    	totalDeliveryPaymentLabel.setText("    배송비 : " + formatNumber(totalDeliveryPayment) + "원    =");
    	totalPaymentLabel.setText("총 결제 금액 : " +formatNumber(totalProductPayment + totalDeliveryPayment) + "원"+"\n");
    }



    public int getTotalDeliveryPayment() {
        return totalDeliveryPayment;
    }


    public void setTotalDeliveryPayment(int totalDeliveryPayment) {
        this.totalDeliveryPayment = totalDeliveryPayment;
    }


    public int getTotalPayment() {
        return totalPayment;
    }


    public void setTotaPayment(int totalPayment) {
        this.totalPayment = totalPayment;
    }


    public int getTotalProductPayment() {
        return totalProductPayment;
    }

	public ArrayList<Orders> getOrders() {
		return orders;
	}

	public void setOrders(ArrayList<Orders> orders) {
		this.orders = orders;
	}
	
	//금액에 콤마를 찍어서 표시하게 하는 메서드
	private String formatNumber(int number) {
        DecimalFormat formatter = new DecimalFormat("#,###");
        return formatter.format(number);
    }
	
	
}
