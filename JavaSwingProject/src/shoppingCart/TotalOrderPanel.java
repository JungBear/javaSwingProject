package shoppingCart;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class TotalOrderPanel extends JPanel{
private int totalProductPayment;//선택한or전체 상품의금액 
private int totalDeliveryPayment;//선택한or전체 상품의 배송비 - 10만원 이상이면 0원이 되도록 조건문 달아야 함 
private int totalPayment;//totalProduvtPayment + totalDeliveryPayment 
	

	public TotalOrderPanel(int totalProductPayment, int totalDeliveryPayment, int totalPayment) {
		this.totalProductPayment = totalProductPayment;
		this.totalDeliveryPayment = totalDeliveryPayment;
		this.totalPayment = totalProductPayment + totalDeliveryPayment;
		
		//선택한 or 전체 상품의 금액을 표시하는 부분 생성 
		JLabel totalProductPaymentLabel = new JLabel("선택한 상품의 결제 금액 : " + totalProductPayment + "원");
		add(totalProductPaymentLabel);
		
		//선택한 or 전체 상품의 금액에 대한 배송비를 표시하는 부분 생성 
		JLabel totalDeliveryPaymentLabel = new JLabel("배송비 : " + totalDeliveryPayment + "원");
		add(totalDeliveryPaymentLabel);
		
		//총 결제 금액을 표시하는 부분 생성 
		JLabel totalPaymentLabel = new JLabel("총 결제 금액 : " + totalPayment + "원");
		add(totalPaymentLabel);
	}
}
