package shoppingCart;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

public class TotalOrderPanel extends JPanel{
int totalProductPayment;//선택한or전체 상품의금액 
private int totalDeliveryPayment;//선택한or전체 상품의 배송비 - 10만원 이상이면 0원이 되도록 조건문 달아야 함 
private int totalPayment;//totalProductPayment + totalDeliveryPayment 
private ArrayList<Orders> orders;//주문내역을 받아옴 
private JLabel totalProductPaymentLabel;
private JLabel totalPaymentLabel;
private JLabel totalDeliveryPaymentLabel;

	
	
	public TotalOrderPanel() {
		

	}
	
	
	//totalOrderPanel 화면을 보여주는 메서드(기본값) 
	public void setTotalOrderPanel() {
		this.totalPayment = totalProductPayment + totalDeliveryPayment;
		this.totalDeliveryPayment = 2500;
		System.out.println(totalProductPayment);
		
		//선택한 or 전체 상품의 금액을 표시하는 부분 생성 
		totalProductPaymentLabel = new JLabel("선택한 상품의 결제 금액 : " + this.totalProductPayment + "원     +");
		//선택한 or 전체 상품의 금액에 대한 배송비를 표시하는 부분 생성 
		totalDeliveryPaymentLabel = new JLabel("배송비 : " + totalDeliveryPayment + "원     =");
		// 총 결제 금액을 표시하는 부분 생성
		totalPaymentLabel = new JLabel("총 결제 금액 : " + totalPayment + "원");
		
		setBounds(200,551,900,160);
		setBackground(Color.yellow);
		setVisible(true);
		add(totalProductPaymentLabel);
		add(totalDeliveryPaymentLabel);
		add(totalPaymentLabel);
	}
	
	public void setTotalProductPayment(int totalProductPayment) {
		this.totalProductPayment = totalProductPayment;
	}
	
	 // 선택한 상품의 결제 금액을 업데이트하는 메서드
    public void updateTotalPayment(ArrayList<Orders> orders) {
        int totalProductPayment = 0;
        for (Orders order : orders) {
        	if(order.getSelect()) {
        		totalProductPayment += order.getTotalPrice() * order.getQuantity();        	           		
        	} 
        }
          
        totalProductPaymentLabel.setText("선택한 상품의 결제 금액 : " + totalProductPayment + "원     +");
        
        
        // 배송비 업데이트
        if (totalProductPayment >= 100000) {
            this.totalDeliveryPayment = 0; 
        } else {
            this.totalDeliveryPayment = 2500; 
        }
        
        // 총 결제 금액 업데이트 
        totalDeliveryPaymentLabel.setText("배송비 : " + totalDeliveryPayment + "원     =");
        totalPaymentLabel.setText("총 결제 금액 : " + (totalProductPayment + totalDeliveryPayment) + "원");
    }
    
    
    
    
	
	
	
}
