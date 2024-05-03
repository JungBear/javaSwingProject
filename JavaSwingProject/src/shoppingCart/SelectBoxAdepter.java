package shoppingCart;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

public class SelectBoxAdepter implements ItemListener {
	private TotalOrderPanel totalOrderPanel;
	private ArrayList<Orders> orders;
	private Orders selectOrder;
	
	public SelectBoxAdepter(TotalOrderPanel totalOrderPanel, ArrayList<Orders> orders) {
		this.totalOrderPanel = totalOrderPanel;
		this.orders = orders;
		this.selectOrder = selectOrder;
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		System.out.println("시작");
		System.out.println(e.getID());
//		if (e.getStateChange() == ItemEvent.SELECTED) { // 선택된 경우
//            // 현재 주문의 가격과 수량을 totalProductPayment에 추가
//			totalProductPayment += order.getTotalPrice() * order.getQuantity();
//        } else { // 선택이 해제된 경우
//            // 현재 주문의 가격과 수량을 totalProductPayment에서 차감
//            totalOrderPanel.setTotalProductPayment(totalOrderPanel.getTotalProductPayment() - selectOrder.getTotalPrice() * selectOrder.getQuantity());
//        }
        // totalPayment 업데이트
        totalOrderPanel.updateTotalPayment(orders);
		
	}
 }
