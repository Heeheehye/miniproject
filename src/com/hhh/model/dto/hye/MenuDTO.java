package com.hhh.model.dto.hye;

public class MenuDTO {
	
	private int num; 
	private String menuName; 
	private int price; 
	
//	private MenuDTO[] menulist; 
//
//	{  // MenuDTO 인스턴스 초기화 블록 
//		menulist = new MenuDTO[6];
//		menulist[0] = new MenuDTO(1, "아메리카노", 4000 );
//		menulist[1] = new MenuDTO(2, "슈크림라떼", 5000 );
//		menulist[2] = new MenuDTO(3, "봄딸기라떼", 5500 );
//		menulist[3] = new MenuDTO(4, "돌체라떼", 5000 );
//		menulist[4] = new MenuDTO(5, "자바칩 프라푸치노", 6000 );
//		menulist[5] = new MenuDTO(6, "자몽허니블랙티", 5600 );
//	}
//	
//	
//	public MenuDTO[] getMenulist() {
//		return menulist;
//	}
//
//	public void setMenulist(MenuDTO[] menulist) {
//		this.menulist = menulist;
//	}

	public MenuDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
		public MenuDTO(int num, String menuName, int price) {
		super();
		this.num = num;
		this.menuName = menuName;
		this.price = price;
	}

		public int getNum() {
			return num;
		}

		public void setNum(int num) {
			this.num = num;
		}

		public String getMenuName() {
			return menuName;
		}

		public void setMenuName(String menuName) {
			this.menuName = menuName;
		}

		public int getPrice() {
			return price;
		}

		public void setPrice(int price) {
			this.price = price;
		}

		@Override
		public String toString() {
			return "MenuDTO [num=" + num + ", menuName=" + menuName + ", price=" + price + "]";
		}



}
