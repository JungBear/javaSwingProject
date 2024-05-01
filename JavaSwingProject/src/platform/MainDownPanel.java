package platform;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import product.ProductService;

public class MainDownPanel extends JPanel{
	TopNavBtn smallCategory1, smallCategory2, smallCategory3, smallCategory4; 
	ProductService productService = new ProductService();
	SmallCategoryPreviewPanel scpp1, scpp2, scpp3, scpp4;
	MainFrame mainF;
	
	public MainDownPanel(String name, int x, int y, MainFrame mainF) {
		this.mainF = mainF;
		setName(name);
		setBounds(x, y, 60, 160);
		setBackground(Color.GRAY);
		setBorder(new EmptyBorder(5,3,5,3));
		setVisible(false);
		switch(name) {
		case "cloth":
			smallCategory1 = new TopNavBtn("상의", x, y);
			smallCategory2 = new TopNavBtn("아우터", x, y+40);
			smallCategory3 = new TopNavBtn("바지", x, y+80);			
			smallCategory4 = new TopNavBtn("원피스", x, y+120);
			
			// 카테고리별 페이지 만들기
			scpp1 = new SmallCategoryPreviewPanel(productService.readData(name, smallCategory1.getText()));
			scpp2 = new SmallCategoryPreviewPanel(productService.readData(name, smallCategory2.getText()));
			scpp3 = new SmallCategoryPreviewPanel(productService.readData(name, smallCategory3.getText()));
			scpp4 = new SmallCategoryPreviewPanel(productService.readData(name, smallCategory4.getText()));
			break;
		case "cosmetic":
			//스킨케어, 클렌징, 네일, 맨즈케어
			smallCategory1 = new TopNavBtn("스킨케어", x, y);
			smallCategory2 = new TopNavBtn("클렌징", x, y);
			smallCategory3 = new TopNavBtn("네일", x, y);
			smallCategory4 = new TopNavBtn("맨즈케어", x, y);
			// 카테고리별 페이지 만들기
			scpp1 = new SmallCategoryPreviewPanel(productService.readData(name, smallCategory1.getText()));
			scpp2 = new SmallCategoryPreviewPanel(productService.readData(name, smallCategory2.getText()));
			scpp3 = new SmallCategoryPreviewPanel(productService.readData(name, smallCategory3.getText()));
			scpp4 = new SmallCategoryPreviewPanel(productService.readData(name, smallCategory4.getText()));
			break;
		case "shoes": 
			//구두, 로퍼, 스니커즈, 샌들
			smallCategory1 = new TopNavBtn("구두", x, y);
			smallCategory2 = new TopNavBtn("로퍼", x, y);
			smallCategory3 = new TopNavBtn("스니커즈", x, y);
			smallCategory4 = new TopNavBtn("샌들", x, y);
			// 카테고리별 페이지 만들기
			scpp1 = new SmallCategoryPreviewPanel(productService.readData(name, smallCategory1.getText()));
			scpp2 = new SmallCategoryPreviewPanel(productService.readData(name, smallCategory2.getText()));
			scpp3 = new SmallCategoryPreviewPanel(productService.readData(name, smallCategory3.getText()));
			scpp4 = new SmallCategoryPreviewPanel(productService.readData(name, smallCategory4.getText()));
			break;
		case "bag":
			//백팩, 숄더백, 토트백, 에코백
			smallCategory1 = new TopNavBtn("백팩", x, y);
			smallCategory2 = new TopNavBtn("숄더백", x, y);
			smallCategory3 = new TopNavBtn("토트백", x, y);
			smallCategory4 = new TopNavBtn("에코백", x, y);
			// 카테고리별 페이지 만들기
			scpp1 = new SmallCategoryPreviewPanel(productService.readData(name, smallCategory1.getText()));
			scpp2 = new SmallCategoryPreviewPanel(productService.readData(name, smallCategory2.getText()));
			scpp3 = new SmallCategoryPreviewPanel(productService.readData(name, smallCategory3.getText()));
			scpp4 = new SmallCategoryPreviewPanel(productService.readData(name, smallCategory4.getText()));
			break;
		}
		add(smallCategory1);
		add(smallCategory2);
		add(smallCategory3);
		add(smallCategory4);
		
		TopNavBtn[] btnList = {smallCategory1, smallCategory2, smallCategory3, smallCategory4};
		
		// 각각의 소분류에 마우스리스너랑 마우스 엑션리스너 추가
		// 마우스 리스너 -> 마우스를 올리면 소분류 유지, 클릭하면 소분류에 맞는 상품들 나열되어있는 페이지로 이동, 마우스 나가면 안보이게
        for (TopNavBtn topNavBtn : btnList) {
        	switch(topNavBtn.getText()) {
        	case "의류":
        		topNavBtn.addMouseListener(new BtnMouseAdapter(this));
        		break;
        	case "화장품":
        		topNavBtn.addMouseListener(new BtnMouseAdapter(this));
        		break;
        	case "신발":
        		topNavBtn.addMouseListener(new BtnMouseAdapter(this));
        		break;
        	case "가방":
        		topNavBtn.addMouseListener(new BtnMouseAdapter(this));
        		break;
        		
        	}
		}
		
	}
	
	
}
