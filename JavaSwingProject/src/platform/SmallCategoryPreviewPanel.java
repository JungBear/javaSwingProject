package platform;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import dto.ProductDTO;

public class SmallCategoryPreviewPanel extends JPanel{
	ArrayList<ProductDTO> pds; 
	
	public SmallCategoryPreviewPanel(ArrayList<ProductDTO> pds) {
		
		setBounds(0, 200, 1280, 760);
        setVisible(false);
        setLayout(null);

        // Small Category 라벨 생성
        JLabel smallCategory = new JLabel("상의");
        smallCategory.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 24)); // 폰트 설정
        smallCategory.setBounds(100, 00, 200, 100);

        add(smallCategory);
		
		int xOffset = 0; // 제품 미리보기 패널의 y축 위치 설정
		int yOffset = 100;
        for (ProductDTO productDTO : pds) {
        	// 이미지파일을 가져오기 위한 인덱스 번호 주기
        	int i = 1;
        	
        	// 판넬 생성
            PreviewPanel pp = new PreviewPanel(productDTO, i);
            pp.setVisible(true);
            pp.setBounds(xOffset, yOffset, 300, 300); // 위치 설정
            // 판넬 추가
            add(pp);
            
            xOffset += 300; // 다음 제품 미리보기 패널을 위한 y축 오프셋 설정
            
            // 만약 물품이 많아서 x축으로 갈수 없다면 y축으로 내리기 위해
            if(xOffset >= (1280 - 300)) {
            	xOffset = 0;
            	yOffset += 400;
            }
            i++;
            
        }
		
		
		
		
		
		
	}

}
