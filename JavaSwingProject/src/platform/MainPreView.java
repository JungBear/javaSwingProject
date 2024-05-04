package platform;



import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import product.ProductService;

public class MainPreView extends JPanel{
	ProductService productService = new ProductService();
	SmallCategoryPreviewPanel sccp1, sccp2, sccp3;
	
	final int KIND = 4;
	String[] kinds = {"의류", "화장품", "신발", "가방"};
	
	public MainPreView(MainHeader mainHeader, MainFrame mainF) {
		setBounds(0, 200, 1280, 2000);
		setLayout(null);
		setPreferredSize(new Dimension(1280, 2000)); // 높이 조정 필요에 따라
		setMaximumSize(new Dimension(1280, 2000));// 높이 조정 필요에 따라
		
		int yOffset = 0;	
		  // 나머지 레이블은 FlowLayout을 사용하여 추가
        for (int i = 0; i < KIND; i++) {
        	JLabel bigCategory = new JLabel(kinds[i]);
        	bigCategory.setBounds(100, yOffset, 900, 100); // 첫 번째 레이블을 (100, 100)에 위치시킵니다.
        	bigCategory.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
//            bigCategory.setPreferredSize(new Dimension(900, 100));
            add(bigCategory);
            yOffset += 400;
        }
		
	}
	
}
