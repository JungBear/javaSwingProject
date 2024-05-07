package shoppingCart;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TotalBtnFrame extends JFrame{
	private int value;
	TotalOrderPanel top;
	
	public TotalBtnFrame(int value, TotalOrderPanel top) {
		this.value = value;
		this.top = top;
		initialize();
	}
	
	public void initialize() {
		  setTitle("주문 완료");
	      setSize(500, 300);
	      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // 닫기 버튼을 누르면 창이 닫히도록 설정
	      setLocationRelativeTo(null); // 화면 중앙에 위치하도록 설정

	      JLabel label = new JLabel("전체 상품의 주문이 완료되었습니다.\n 결제 금액은 " + value + "원 입니다.");
	      JButton closeButton = new JButton("닫기");
	      
	      closeButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();//팝업창 닫기
				//주문한 전체 내역 orders 초기화 하는 내용 
				ShoppingListPanel.clear(); //테이블의 orders Arraylist를 모두 지우고 
				ShoppingListPanel.updateTable(); //지운 정보를 update
				top.updateTotalPayment(top.getOrders());
				
				
				
			}
		});
	      getContentPane().add(label, BorderLayout.CENTER);
	      getContentPane().add(closeButton, BorderLayout.SOUTH);

	}
}
