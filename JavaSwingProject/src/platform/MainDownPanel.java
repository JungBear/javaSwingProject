package platform;

import java.awt.Color;
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
			smallCategoryBtn1.setName("tee");
			
			
			smallCategoryBtn2 = new TopNavBtn("아우터", x, y);
			smallCategoryBtn2.setName("outer");
			
			smallCategoryBtn3 = new TopNavBtn("바지", x, y);	
			smallCategoryBtn3.setName("pants");
			
			smallCategoryBtn4 = new TopNavBtn("원피스", x, y);
			smallCategoryBtn4.setName("onepiece");
			
			// 카테고리별 페이지 만들기
			scpp1 = new SmallCategoryPreviewPanel(productService.readData(name, smallCategoryBtn1.getName()), mainF);
			scpp2 = new SmallCategoryPreviewPanel(productService.readData(name, smallCategoryBtn2.getName()), mainF);
			scpp3 = new SmallCategoryPreviewPanel(productService.readData(name, smallCategoryBtn3.getName()), mainF);
			scpp4 = new SmallCategoryPreviewPanel(productService.readData(name, smallCategoryBtn4.getName()), mainF);
			
			
			break;
		case "cosmetic":
			//스킨케어, 클렌징, 네일, 맨즈케어
			smallCategoryBtn1 = new TopNavBtn("스킨케어", x, y);
			smallCategoryBtn1.setName("skincare");
			
			smallCategoryBtn2 = new TopNavBtn("클렌징", x, y);
			smallCategoryBtn2.setName("cleansing");
			
			smallCategoryBtn3 = new TopNavBtn("네일", x, y);
			smallCategoryBtn3.setName("nail");
			
			smallCategoryBtn4 = new TopNavBtn("맨즈케어", x, y);
			smallCategoryBtn4.setName("manscare");
			// 카테고리별 페이지 만들기
			scpp1 = new SmallCategoryPreviewPanel(productService.readData(name, smallCategoryBtn1.getName()), mainF);
			scpp2 = new SmallCategoryPreviewPanel(productService.readData(name, smallCategoryBtn2.getName()), mainF);
			scpp3 = new SmallCategoryPreviewPanel(productService.readData(name, smallCategoryBtn3.getName()), mainF);
			scpp4 = new SmallCategoryPreviewPanel(productService.readData(name, smallCategoryBtn4.getName()), mainF);
			break;
		case "shoes": 
			//구두, 로퍼, 스니커즈, 샌들
			smallCategoryBtn1 = new TopNavBtn("구두", x, y);
			smallCategoryBtn1.setName("dressShoes");
			
			smallCategoryBtn2 = new TopNavBtn("로퍼", x, y);
			smallCategoryBtn2.setName("loafers");
			
			smallCategoryBtn3 = new TopNavBtn("스니커즈", x, y);
			smallCategoryBtn3.setName("sneakers");
			
			smallCategoryBtn4 = new TopNavBtn("샌들", x, y);
			smallCategoryBtn4.setName("sandal");
			// 카테고리별 페이지 만들기
			scpp1 = new SmallCategoryPreviewPanel(productService.readData(name, smallCategoryBtn1.getName()), mainF);
			scpp2 = new SmallCategoryPreviewPanel(productService.readData(name, smallCategoryBtn2.getName()), mainF);
			scpp3 = new SmallCategoryPreviewPanel(productService.readData(name, smallCategoryBtn3.getName()), mainF);
			scpp4 = new SmallCategoryPreviewPanel(productService.readData(name, smallCategoryBtn4.getName()), mainF);
			break;
		case "bag":
			//백팩, 숄더백, 토트백, 에코백
			smallCategoryBtn1 = new TopNavBtn("백팩", x, y);
			smallCategoryBtn1.setName("backpack");
			
			smallCategoryBtn2 = new TopNavBtn("숄더백", x, y);
			smallCategoryBtn2.setName("shoulderbag");
			
			smallCategoryBtn3 = new TopNavBtn("토트백", x, y);
			smallCategoryBtn3.setName("totebag");
			
			smallCategoryBtn4 = new TopNavBtn("에코백", x, y);
			smallCategoryBtn4.setName("echobag");
			// 카테고리별 페이지 만들기
			scpp1 = new SmallCategoryPreviewPanel(productService.readData(name, smallCategoryBtn1.getName()), mainF);
			scpp2 = new SmallCategoryPreviewPanel(productService.readData(name, smallCategoryBtn2.getName()), mainF);
			scpp3 = new SmallCategoryPreviewPanel(productService.readData(name, smallCategoryBtn3.getName()), mainF);
			scpp4 = new SmallCategoryPreviewPanel(productService.readData(name, smallCategoryBtn4.getName()), mainF);
			break;
		}
		add(smallCategoryBtn1);
		add(smallCategoryBtn2);
		add(smallCategoryBtn3);
		add(smallCategoryBtn4);
		
		TopNavBtn[] btnList = {smallCategoryBtn1, smallCategoryBtn2, smallCategoryBtn3, smallCategoryBtn4};
		
		// 각각의 소분류에 마우스리스너랑 마우스 엑션리스너 추가
		// 마우스 리스너 -> 마우스를 올리면 소분류 유지, 클릭하면 소분류에 맞는 상품들 나열되어있는 페이지로 이동, 마우스 나가면 안보이게
        for (TopNavBtn topNavBtn : btnList) {
        	topNavBtn.setVisible(true);
        	outer:switch(topNavBtn.getName()) {

			case "tee":
				topNavBtn.addMouseListener(new SmallBtnMouseAdapter(scpp1, this, mainF));
				break outer;
			case "outer":
				topNavBtn.addMouseListener(new SmallBtnMouseAdapter(scpp2, this, mainF));
				break outer;
			case "pants":
				topNavBtn.addMouseListener(new SmallBtnMouseAdapter(scpp3, this, mainF));
				break outer;
			case "onepiece":
				topNavBtn.addMouseListener(new SmallBtnMouseAdapter(scpp4, this, mainF));
				break outer;

			case "skincare":
				topNavBtn.addMouseListener(new SmallBtnMouseAdapter(scpp1, this, mainF));
				break;
			case "cleansing":
				topNavBtn.addMouseListener(new SmallBtnMouseAdapter(scpp2, this, mainF));
				break;
			case "nail":
				topNavBtn.addMouseListener(new SmallBtnMouseAdapter(scpp3, this, mainF));
				break;
			case "manscare":
				topNavBtn.addMouseListener(new SmallBtnMouseAdapter(scpp4, this, mainF));
				break;

				
			case "dressShoes":
				topNavBtn.addMouseListener(new SmallBtnMouseAdapter(scpp1, this, mainF));
				break;
			case "loafers":
				topNavBtn.addMouseListener(new SmallBtnMouseAdapter(scpp2, this, mainF));
				break;
			case "sneakers":
				topNavBtn.addMouseListener(new SmallBtnMouseAdapter(scpp3, this, mainF));
				break;
			case "sandal":
				topNavBtn.addMouseListener(new SmallBtnMouseAdapter(scpp4, this, mainF));
				break;
				
			case "backpack":
				topNavBtn.addMouseListener(new SmallBtnMouseAdapter(scpp1, this, mainF));
				break;
			case "shoulderbag":
				topNavBtn.addMouseListener(new SmallBtnMouseAdapter(scpp2, this, mainF));
				break;
			case "totebag":
				topNavBtn.addMouseListener(new SmallBtnMouseAdapter(scpp3, this, mainF));
				break;
			case "echobag":
				topNavBtn.addMouseListener(new SmallBtnMouseAdapter(scpp4, this, mainF));
				break;


        	}
		}
		
	}
	
	
}
