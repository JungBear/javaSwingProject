package shoppingCart;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class QuantityComboBox extends DefaultCellEditor {
	private JComboBox<Integer> comboBox;
	private DefaultTableModel tableModel;
    private ArrayList<Orders> orders;
	protected JTable table;
	

    public QuantityComboBox() {
        super(new JComboBox<Integer>());
        this.table = table;
        this.tableModel = tableModel;
        this.orders = orders;
        
        comboBox = (JComboBox<Integer>) getComponent();
        
        for (int i = 1; i <= 99; i++) {
            comboBox.addItem(i);
        }
        
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stopCellEditing();
                int selectedQuantity = (Integer) comboBox.getSelectedItem(); // 선택된 수량
                int row = table.getEditingRow(); // 현재 편집 중인 행
                if (row != -1) {
                    // 주문 데이터 업데이트
                    orders.get(row).setQuantity(selectedQuantity);
                    // 총 금액 열 업데이트
                    int totalAmount = orders.get(row).getTotalPrice();
                    tableModel.setValueAt(totalAmount, row, 4);
               }
            }
        });
        
    }
    
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
    	comboBox.setSelectedItem(value);
    	return comboBox;
    }
    
    @Override
    public Object getCellEditorValue() {
    	return comboBox.getSelectedItem();
    }
    
}