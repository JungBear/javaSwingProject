package shoppingCart;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.plaf.synth.SynthOptionPaneUI;
import javax.swing.table.DefaultTableModel;

public class QuantityComboBox extends DefaultCellEditor {
	private JComboBox<Integer> comboBox;
	private DefaultTableModel tableModel;
    private ArrayList<Orders> orders;
	protected JTable table;
	private TotalOrderPanel totalOrderPanel;

	

    public QuantityComboBox(JTable table, DefaultTableModel tableModel, ArrayList<Orders> orders, TotalOrderPanel totalOrderPanel) {
        super(new JComboBox<Integer>());
        this.table = table;
        this.tableModel = tableModel;
        this.orders = orders;
        this.totalOrderPanel = totalOrderPanel;
        
        comboBox = (JComboBox<Integer>) getComponent();
        
        for (int i = 1; i <= 99; i++) {
            comboBox.addItem(i);
        }
        
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //stopCellEditing();
                int selectedQuantity = (Integer) comboBox.getSelectedItem(); // 선택된 수량
                System.out.println("선택된 수량 : " + selectedQuantity);
                int row = table.getEditingRow(); // 현재 편집 중인 행
                System.out.println(row);
                if (row != -1) {
                    // 주문 데이터 업데이트
                    orders.get(row).setQuantity(selectedQuantity);
                    // 총 금액 열 업데이트
                    int totalPrice = orders.get(row).getPrice() * selectedQuantity;
                    System.out.println("totalPrice : " + totalPrice);
                    tableModel.setValueAt(totalPrice, row, 4);
                    totalOrderPanel.updateSelectPayment(orders); // TotalOrderPanel의 결제 금액 업데이트
               
            }

        }});
        
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