package com.hhh.test.hye;

import java.util.Arrays;

import com.hhh.model.dto.hye.MenuDTO;

public class Init {

	private StoreDTO[] storeList = new StoreDTO[5]; 
	
	{  // StoreDTO 인스턴스 초기화 블록 
		storeList[0] = new StoreDTO(1, "종로점", "02-111-1111"); 
		storeList[1] = new StoreDTO(2, "서초점", "02-222-2222");
		storeList[2] = new StoreDTO(3, "강남점", "02-333-3333");
		storeList[3] = new StoreDTO(4, "영등포점", "02-444-4444");
		storeList[4] = new StoreDTO(5, "동대문점", "02-555-5555");
	}
	
	private MenuDTO[] menuList = new MenuDTO[6];
	{  // MenuDTO 인스턴스 초기화 블록 
		menuList[0] = new MenuDTO(1, "아메리카노", 4000 );
		menuList[1] = new MenuDTO(2, "슈크림라떼", 5000 );
		menuList[2] = new MenuDTO(3, "봄딸기라떼", 5500 );
		menuList[3] = new MenuDTO(4, "돌체라떼", 5000 );
		menuList[4] = new MenuDTO(5, "자바칩 프라푸치노", 6000 );
		menuList[5] = new MenuDTO(6, "자몽허니블랙티", 5600 );
	}
	public Init() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StoreDTO[] getStoreList() {
		return storeList;
	}
	public void setStoreList(StoreDTO[] storeList) {
		this.storeList = storeList;
	}
	public MenuDTO[] getMenuList() {
		return menuList;
	}
	public void setMenuList(MenuDTO[] menuList) {
		this.menuList = menuList;
	}
	@Override
	public String toString() {
		return "Init [storeList=" + Arrays.toString(storeList) + ", menuList=" + Arrays.toString(menuList) + "]";
	} 
	
	
}
