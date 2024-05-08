package shoppingCart;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

public class DeleteButton extends AbstractCellEditor implements TableCellRenderer, TableCellEditor, ActionListener {
	JTable table;
    JButton renderButton;
    JButton editButton;
    Object editorValue;
    int column;
    private TotalOrderPanel totalOrderPanel ;
    private ArrayList<Orders> orders;
    
    
    
    public DeleteButton(JTable table, int column, TotalOrderPanel totalOrderPanel,  ArrayList<Orders> orders) {
    	super();
        this.table = table;
        this.column = column;
        this.totalOrderPanel = totalOrderPanel;
        this.orders = orders;
        
        //버튼 생성 
        renderButton = new JButton("삭제");
        editButton = new JButton("삭제");
        editButton.setFocusPainted(false);
        editButton.addActionListener(this);
        editButton.setForeground(Color.BLACK); // 폰트 색상을 검정색으로 설정
        editButton.setFont(new Font("맑은 고딕", Font.PLAIN, 15));//폰트 속성

        TableColumnModel columnModel = table.getColumnModel();
        columnModel.getColumn(column).setCellRenderer(this);
        columnModel.getColumn(column).setCellEditor(this);
    }
    
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
    		int row, int column) {
    	if (hasFocus) {
            renderButton.setForeground(Color.BLACK);
            renderButton.setBackground(UIManager.getColor("Button.background"));
        } else if (isSelected) {
            renderButton.setForeground(Color.gray);
            renderButton.setBackground(table.getSelectionBackground());
        } else {
            renderButton.setForeground(Color.BLACK);
            renderButton.setBackground(UIManager.getColor("Button.background"));
        }

        renderButton.setText("삭제");
        return renderButton;
    }
    
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
    	editorValue = value;
        editButton.setText("삭제");
        return editButton;
    }
    
    @Override
    public Object getCellEditorValue() {
    	 return editorValue;
    }
    
    //주문 삭제하는 메서드 
    private void deleteOrder(int row) {
        if (row != -1 && row < orders.size()) { // 선택된 행이 유효한지 확인
            orders.remove(row); // 주문 리스트에서 해당 주문 삭제
            DefaultTableModel model = (DefaultTableModel) table.getModel(); // 테이블 데이터 변경 이벤트 발생
            model.fireTableDataChanged();
            totalOrderPanel.updateSelectPayment(orders); // TotalOrderPanel에 변경된 주문 정보 반영
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
    	int row = table.getSelectedRow(); // 선택된 행 인덱스 가져오기
    	fireEditingStopped();
    	((DefaultTableModel) table.getModel()).removeRow(table.convertRowIndexToModel(row)); // 해당 행을 테이블 모델에서 삭제 
        deleteOrder(row);
    }
    
}
