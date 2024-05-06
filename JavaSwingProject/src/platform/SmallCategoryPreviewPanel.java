package platform;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import dto.ProductDTO;

public class SmallCategoryPreviewPanel extends JPanel{
	
	MainFrame mainF;
	static ProductDetailPanel pdp;
	
	public SmallCategoryPreviewPanel(ArrayList<ProductDTO> pds, MainFrame mainF) {
		this.mainF = mainF;
		setBounds(0, 200, 1280, 760);
        setVisible(false);
        setLayout(null);
        setBackground(Color.white);
//        System.out.println("pds : " + pds);
        

        // Small Category 라벨 생성
        JLabel smallCategory = new JLabel(pds.get(0).getCategory());
        smallCategory.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 24)); // 폰트 설정
        smallCategory.setBounds(100, 00, 200, 100);
        add(smallCategory);
		
		int xOffset = 150; // 제품 미리보기 패널의 y축 위치 설정
		int yOffset = 100;
        for (ProductDTO productDTO : pds) {
//        	System.out.println(productDTO);
        	// 판넬 생성
            PreviewPanel pp = new PreviewPanel(productDTO);
            pdp = new ProductDetailPanel(productDTO, mainF);
            pp.setVisible(true);
            pp.setBounds(xOffset, yOffset, 300, 300); // 위치 설정
            // 판넬 추가
            add(pp);
            mainF.add(pdp);
            pp.setVisible(true);
            pp.setLayout(new FlowLayout(FlowLayout.CENTER));
            pp.setBackground(Color.white);
            
            xOffset += 300; // 다음 제품 미리보기 패널을 위한 y축 오프셋 설정
            
            // 만약 물품이 많아서 x축으로 갈수 없다면 y축으로 내리기 위해
            if(xOffset >= (1280 - 300)) {
            	xOffset = 150;
            	yOffset += 300;
            }
            
            pp.addMouseListener(new MouseListener() {
				@Override
				public void mouseClicked(MouseEvent e) {
					// 클릭 이벤트 처리
					mainF.hideVisiblePanelExceptHeader();
					pdp.setVisible(true);
					System.out.println(productDTO);
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

        }
		
		mainF.add(this);
		
		
	}
	
	public void setSmallCatogrtyPreviewPanel() {
		mainF.hideVisiblePanelExceptHeader();
		this.setVisible(true);
		
	}

}
