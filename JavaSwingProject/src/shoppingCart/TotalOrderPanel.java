package shoppingCart;

import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

public class TotalOrderPanel extends JPanel{
int totalProductPayment;//선택한or전체 상품의금액 
private int totalDeliveryPayment;//선택한or전체 상품의 배송비 - 10만원 이상이면 0원이 되도록 조건문 달아야 함 
private int totalPayment;//totalProductPayment + totalDeliveryPayment 
private ArrayList<Orders> orders;//주문내역을 받아옴 
private JLabel totalProductPaymentLabel;
private JLabel totalPaymentLabel;
private JLabel totalDeliveryPaymentLabel;

//기본값 
	

	public TotalOrderPanel(int totalProductPayment) {	
		this.totalProductPayment = totalProductPayment;
		this.totalDeliveryPayment = 2500;
		this.totalPayment = totalProductPayment + totalDeliveryPayment;
		
		//선택한 or 전체 상품의 금액을 표시하는 부분 생성 
		totalProductPaymentLabel = new JLabel("선택한 상품의 결제 금액 : " + totalProductPayment + "원     +");
		//선택한 or 전체 상품의 금액에 대한 배송비를 표시하는 부분 생성 
		totalDeliveryPaymentLabel = new JLabel("배송비 : " + totalDeliveryPayment + "원     =");
		// 총 결제 금액을 표시하는 부분 생성
		totalPaymentLabel = new JLabel("총 결제 금액 : " + getTotalPayment() + "원");

	}
	
	
	//상품 금액이 합산되는 메서드 
	public void updateTotalPayment(SoppingCartPanel scp) {
		
		//1. 선택 박스를 누르면 값을 변경해서 보여준다. 
		//쇼핑카트에 들어있는 테이블체인지 메서드가 세트 메뉴가 됨 

	    //선택한 상품들(혹은 전체 상품)을 받아와서 상품 결제금액 계산 
	    int defaultProductPayment = 0;
	    int totalDeliveryPayment = 0;
	    final int[] totalPayment = {0};
	    
	    //선택된 상품의 금액 합산 
	    
	    orders = scp.getOrders();
	    
	    
	    //orders에 추가되는 열 만큼 arraylist에 넣는다. 
	    
	    
	    for( Orders order : orders) {
	    	if(order.getSelect()) {
	   
	    		totalPayment[0] += order.getTotalPrice();
	    	}
	    }
	    
		//2.1 에서 변경된 값을 합해서 보여주는 totalprice에 보여준다. 
		
		totalProductPaymentLabel.setText("선택한 상품의 결제 금액 : " + totalProductPayment + "원         +");
		//10만원 이상이면 0원,10만원 미만이면 배송비 2500원을 부과하는 조건문 
		if (totalProductPayment >= 100000) {
	        this.totalDeliveryPayment = 0; 
	    } else {
	        this.totalDeliveryPayment = 2500; 
	    }
		totalDeliveryPaymentLabel.setText("배송비 : " + totalDeliveryPayment + "원     =");
		totalPaymentLabel.setText("총 결제 금액 : " + totalProductPayment + "원");
		 
		
		
		
	}


	public int getTotalPayment() {
		return totalPayment;
	}
	
	public void setTotalPayment(int totalPayment){
		this.totalPayment = totalPayment;
	}
	
	
	
}
