package shoppingCart;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class SelecBtnFrame extends JFrame{
	private int value;
	TotalOrderPanel top;
	
	public SelecBtnFrame(int value, TotalOrderPanel top) {
		this.value = value;
		this.top = top;
		initialize();
	}
	
	private void initialize() {
		  setTitle("주문 완료");
	      setSize(500, 250);
	      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // 닫기 버튼을 누르면 창이 닫히도록 설정
	      setLocationRelativeTo(null); // 화면 중앙에 위치하도록 설정

	      JLabel label = new JLabel("선택한 상품의 주문이 완료되었습니다.\n 결제 금액은 " + formatNumber(value) + "원 입니다.");
	      label.setHorizontalAlignment(JLabel.CENTER); // 수평 정렬 설정
	      label.setVerticalAlignment(JLabel.CENTER); // 수직 정렬 설정
	      label.setFont(new Font("맑은 고딕", Font.PLAIN, 15)); // 폰트 설정
	      JButton closeButton = new JButton("닫기");
	      closeButton.setPreferredSize(new Dimension(100, 30)); // 버튼의 크기 조정
	      
	      closeButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();//팝업창 닫기 
				 // 선택된 주문건을 삭제하고 테이블을 업데이트
				ShoppingListPanel.removeSelectedOrders();//주문이 완료된(선택된) 상품을 orders에서 지우고 
				ShoppingListPanel.updateTable();//남은 정보만 update 
				top.updateTotalPayment(top.getOrders());
					
				
			}
		});
	      
	      getContentPane().add(label, BorderLayout.CENTER);
	      getContentPane().add(closeButton, BorderLayout.SOUTH);
	      
		}
	private String formatNumber(int number) {
        DecimalFormat formatter = new DecimalFormat("#,###");
        return formatter.format(number);
    }
}
