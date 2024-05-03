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
		

		

		
		//기본값
		//1.orders에 들어온 값을 받아와서 변수에 저장한다. 
		//2.행들의 전체금액을 모두 더한 값을 tableProductPayment에 저장해서 보여준다. 
		
		
		//주문건 선택이 수정될 때 
		//1. orders.cloum의 값이 0이면(선택이 해제되면)--> (tableProductPayment)-=(선택된 행의 전체금액)
		//2. orders.cloum의 값이 1이면(선택이 체크되면)--> (tableProductPayment)+=(선택된 행의 전체금액)
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
	
	
	//totalOrderPanel 화면을 보여주는 메서드(기본값) 
	public void setTotalOrderPanel() {
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
        	} else {
        		totalProductPayment -= order.getTotalPrice() * order.getQuantity();        	           		
        		
        	}
        }
        
        
        totalProductPaymentLabel.setText("선택한 상품의 결제 금액 : " + totalProductPayment + "원     +");
        // 배송비 업데이트
        if (totalProductPayment >= 100000) {
            this.totalDeliveryPayment = 0; 
        } else {
            this.totalDeliveryPayment = 2500; 
        }
        totalDeliveryPaymentLabel.setText("배송비 : " + totalDeliveryPayment + "원     =");
        totalPaymentLabel.setText("총 결제 금액 : " + (totalProductPayment + totalDeliveryPayment) + "원");
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


    public void setTotalPayment(int totalPayment) {
        this.totalPayment = totalPayment;
    }


    public int getTotalProductPayment() {
        return totalProductPayment;
    }
	
	
	
}
