package platform;



import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import dto.ProductDTO;
import product.ProductService;

public class MainPreView extends JPanel{
	ProductService productService = new ProductService();
	SmallCategoryPreviewPanel sccp;
	ArrayList<ProductDTO> products;
	
	final int KIND = 4;
	String[] kinds = {"의류", "화장품", "신발", "가방"};
	
	public MainPreView(MainHeader mainHeader, MainFrame mainF) {
		
		setLayout(null);
		setPreferredSize(new Dimension(1280, 1700)); // 높이 조정 필요에 따라
		setMaximumSize(new Dimension(1280, 1700));// 높이 조정 필요에 따라
		setVisible(true);
		
//		   JScrollPane 생성 및 추가
//        JScrollPane scrollPane = new JScrollPane(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
//        scrollPane.setBounds(0, 0, 1280, 3000); // JScrollPane의 크기 설정
//        add(scrollPane);
		
		
		
		int yOffsetOfLable = 0;
		int yOffsetOfPanel = 100;
		  // 나머지 레이블은 FlowLayout을 사용하여 추가
        for (int i = 0; i < KIND; i++) {
        	products= productService.getLastProduct(kinds[i]);
        	int xOffset = 100;
        	
//        	JPanel categoryPanel = new JPanel();
//            categoryPanel.setLayout(null); // FlowLayout 사용하여 가로 방향 배치

        	
        	for(int j = 0; j < products.size(); j++) {
        		PreviewPanel pp = new PreviewPanel(products.get(j));
        		pp.setBounds(xOffset, yOffsetOfPanel, 300, 300); // 위치 설정
        		
        		pp.addMouseListener(new MouseListener() {
    				@Override
    				public void mouseClicked(MouseEvent e) {
    					// 클릭 이벤트 처리
    					mainF.hideVisiblePanelExceptHeader();
    					SmallCategoryPreviewPanel.pdp.setVisible(true);
//    					System.out.println(productDTO);
    				}

    				@Override
    				public void mousePressed(MouseEvent e) {
    					// 눌림 이벤트 처리
    				}

    				@Override
    				public void mouseReleased(MouseEvent e) {
    					// 릴리스 이벤트 처리
    				}

    				@Override
    				public void mouseEntered(MouseEvent e) {
    					// 마우스가 패널에 들어왔을 때 처리
    					pp.setBackground(Color.LIGHT_GRAY); // 배경색 변경
    				}

    				@Override
    				public void mouseExited(MouseEvent e) {
    					// 마우스가 패널에서 나갔을 때 처리
    					pp.setBackground(Color.WHITE); // 배경색 변경
    				}
    			});
        		
        		add(pp);
        		
        		xOffset += 350;
        		
        	}
        	
//        	scrollPane.setViewportView(categoryPanel);
        	JLabel bigCategory = new JLabel(kinds[i]);
        	bigCategory.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
        	bigCategory.setBounds(100, yOffsetOfLable, 900, 100); // 첫 번째 레이블을 (100, 100)에 위치시킵니다.

        	
        	
        	
            add(bigCategory);
            yOffsetOfLable += 400;
            yOffsetOfPanel += 400;
        }
		
	}
	
}
