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
	
	public MainDownPanel(String name, int x, int y) {
		setName(name);
		setBounds(x, y, 60, 120);
		setBackground(Color.GRAY);
		setBorder(new EmptyBorder(5,3,5,3));
		setVisible(false);
		switch(name) {
		case "cloth":
			smallCategory1 = new TopNavBtn("상의", x, y);
			smallCategory2 = new TopNavBtn("아우터", x, y+40);
			smallCategory3 = new TopNavBtn("바지", x, y+80);
			smallCategory4 = new TopNavBtn("원피스", x, y+120);
			break;
		case "cosmetics":
			//스킨케어, 클렌징, 네일, 맨즈케어
			smallCategory1 = new TopNavBtn("스킨케어", x, y);
			smallCategory2 = new TopNavBtn("클렌징", x, y);
			smallCategory3 = new TopNavBtn("네일", x, y);
			smallCategory4 = new TopNavBtn("맨즈케어", x, y);
			break;
		case "shoes": 
			//구두, 로퍼, 스니커즈, 샌들
			smallCategory1 = new TopNavBtn("구두", x, y);
			smallCategory2 = new TopNavBtn("로퍼", x, y);
			smallCategory3 = new TopNavBtn("스니커즈", x, y);
			smallCategory4 = new TopNavBtn("샌들", x, y);
			break;
		case "bag":
			//백팩, 숄더백, 토트백, 에코백
			smallCategory1 = new TopNavBtn("백팩", x, y);
			smallCategory2 = new TopNavBtn("숄더백", x, y);
			smallCategory3 = new TopNavBtn("토트백", x, y);
			smallCategory4 = new TopNavBtn("에코백", x, y);
			break;
		}
		add(smallCategory1);
		add(smallCategory2);
		add(smallCategory3);
		add(smallCategory4);
		TopNavBtn[] btnList = {smallCategory1, smallCategory2, smallCategory3, smallCategory4};
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
