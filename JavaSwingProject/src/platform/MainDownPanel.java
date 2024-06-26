package platform;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import product.ProductService;

public class MainDownPanel extends JPanel{
	TopNavBtn smallCategoryBtn1, smallCategoryBtn2, smallCategoryBtn3, smallCategoryBtn4; 
	ProductService productService = new ProductService();
	SmallCategoryPreviewPanel scpp1, scpp2, scpp3, scpp4;
	MainFrame mainF;
	Font font = new Font("맑은 고딕", Font.PLAIN, 13);
	
	public MainDownPanel(String name, int x, int y, MainFrame mainF) {
		this.mainF = mainF;
		setName(name);
		setBounds(x, y, 60, 150);
		setBackground(Color.GRAY);
		setBorder(new EmptyBorder(5,3,5,3));
		setVisible(false);
		switch(name) {
		case "cloth":
			smallCategoryBtn1 = new TopNavBtn("상의", x, y);
			
			smallCategoryBtn2 = new TopNavBtn("아우터", x, y);
			
			smallCategoryBtn3 = new TopNavBtn("바지", x, y);	
			
			smallCategoryBtn4 = new TopNavBtn("원피스", x, y);
			
			// 카테고리별 페이지 만들기
			scpp1 = new SmallCategoryPreviewPanel(productService.readData(name, smallCategoryBtn1.getText()), mainF);
			scpp2 = new SmallCategoryPreviewPanel(productService.readData(name, smallCategoryBtn2.getText()), mainF);
			scpp3 = new SmallCategoryPreviewPanel(productService.readData(name, smallCategoryBtn3.getText()), mainF);
			scpp4 = new SmallCategoryPreviewPanel(productService.readData(name, smallCategoryBtn4.getText()), mainF);
			
			
			break;
		case "cosmetic":
			//스킨케어, 클렌징, 네일, 맨즈케어
			smallCategoryBtn1 = new TopNavBtn("스킨케어", x, y);		
			
			smallCategoryBtn2 = new TopNavBtn("클렌징", x, y);
			
			smallCategoryBtn3 = new TopNavBtn("네일", x, y);
			
			smallCategoryBtn4 = new TopNavBtn("맨즈케어", x, y);
			// 카테고리별 페이지 만들기
			scpp1 = new SmallCategoryPreviewPanel(productService.readData(name, smallCategoryBtn1.getText()), mainF);
			scpp2 = new SmallCategoryPreviewPanel(productService.readData(name, smallCategoryBtn2.getText()), mainF);
			scpp3 = new SmallCategoryPreviewPanel(productService.readData(name, smallCategoryBtn3.getText()), mainF);
			scpp4 = new SmallCategoryPreviewPanel(productService.readData(name, smallCategoryBtn4.getText()), mainF);
			break;
		case "shoes": 
			//구두, 로퍼, 스니커즈, 샌들
			smallCategoryBtn1 = new TopNavBtn("구두", x, y);
			
			smallCategoryBtn2 = new TopNavBtn("로퍼", x, y);
			
			smallCategoryBtn3 = new TopNavBtn("스니커즈", x, y);
			
			smallCategoryBtn4 = new TopNavBtn("샌들", x, y);
			// 카테고리별 페이지 만들기
			scpp1 = new SmallCategoryPreviewPanel(productService.readData(name, smallCategoryBtn1.getText()), mainF);
			scpp2 = new SmallCategoryPreviewPanel(productService.readData(name, smallCategoryBtn2.getText()), mainF);
			scpp3 = new SmallCategoryPreviewPanel(productService.readData(name, smallCategoryBtn3.getText()), mainF);
			scpp4 = new SmallCategoryPreviewPanel(productService.readData(name, smallCategoryBtn4.getText()), mainF);
			break;
		case "bag":
			//백팩, 숄더백, 토트백, 에코백
			smallCategoryBtn1 = new TopNavBtn("백팩", x, y);
			
			smallCategoryBtn2 = new TopNavBtn("숄더백", x, y);
			
			smallCategoryBtn3 = new TopNavBtn("토트백", x, y);
			
			smallCategoryBtn4 = new TopNavBtn("에코백", x, y);
			// 카테고리별 페이지 만들기
			scpp1 = new SmallCategoryPreviewPanel(productService.readData(name, smallCategoryBtn1.getText()), mainF);
			scpp2 = new SmallCategoryPreviewPanel(productService.readData(name, smallCategoryBtn2.getText()), mainF);
			scpp3 = new SmallCategoryPreviewPanel(productService.readData(name, smallCategoryBtn3.getText()), mainF);
			scpp4 = new SmallCategoryPreviewPanel(productService.readData(name, smallCategoryBtn4.getText()), mainF);
			break;
		}
		smallCategoryBtn1.setFont(font);
		smallCategoryBtn2.setFont(font);
		smallCategoryBtn3.setFont(font);
		smallCategoryBtn4.setFont(font);
		
		add(smallCategoryBtn1);
		add(smallCategoryBtn2);
		add(smallCategoryBtn3);
		add(smallCategoryBtn4);
		
		TopNavBtn[] btnList = {smallCategoryBtn1, smallCategoryBtn2, smallCategoryBtn3, smallCategoryBtn4};
		
		// 각각의 소분류에 마우스리스너랑 마우스 엑션리스너 추가
		// 마우스 리스너 -> 마우스를 올리면 소분류 유지, 클릭하면 소분류에 맞는 상품들 나열되어있는 페이지로 이동, 마우스 나가면 안보이게
        for (TopNavBtn topNavBtn : btnList) {
        	topNavBtn.setVisible(true);
        	
        	outer:switch(topNavBtn.getText()) {

			case "상의":
				topNavBtn.addMouseListener(new SmallBtnMouseAdapter(scpp1, this, mainF));
				break outer;
			case "아우터":
				topNavBtn.addMouseListener(new SmallBtnMouseAdapter(scpp2, this, mainF));
				break outer;
			case "바지":
				topNavBtn.addMouseListener(new SmallBtnMouseAdapter(scpp3, this, mainF));
				break outer;
			case "원피스":
				topNavBtn.addMouseListener(new SmallBtnMouseAdapter(scpp4, this, mainF));
				break outer;

			case "스킨케어":
				topNavBtn.addMouseListener(new SmallBtnMouseAdapter(scpp1, this, mainF));
				break;
			case "클렌징":
				topNavBtn.addMouseListener(new SmallBtnMouseAdapter(scpp2, this, mainF));
				break;
			case "네일":
				topNavBtn.addMouseListener(new SmallBtnMouseAdapter(scpp3, this, mainF));
				break;
			case "맨즈케어":
				topNavBtn.addMouseListener(new SmallBtnMouseAdapter(scpp4, this, mainF));
				break;

				
			case "구두":
				topNavBtn.addMouseListener(new SmallBtnMouseAdapter(scpp1, this, mainF));
				break;
			case "로퍼":
				topNavBtn.addMouseListener(new SmallBtnMouseAdapter(scpp2, this, mainF));
				break;
			case "스니커즈":
				topNavBtn.addMouseListener(new SmallBtnMouseAdapter(scpp3, this, mainF));
				break;
			case "샌들":
				topNavBtn.addMouseListener(new SmallBtnMouseAdapter(scpp4, this, mainF));
				break;
				
			case "백팩":
				topNavBtn.addMouseListener(new SmallBtnMouseAdapter(scpp1, this, mainF));
				break;
			case "숄더백":
				topNavBtn.addMouseListener(new SmallBtnMouseAdapter(scpp2, this, mainF));
				break;
			case "토트백":
				topNavBtn.addMouseListener(new SmallBtnMouseAdapter(scpp3, this, mainF));
				break;
			case "에코백":
				topNavBtn.addMouseListener(new SmallBtnMouseAdapter(scpp4, this, mainF));
				break;


        	}
		}
		
	}
	
	
}
