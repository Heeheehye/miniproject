package com.hhh.test.hye;

import java.util.Arrays;

import com.hhh.model.dto.drinks;

public class Init {

	private StoreDTO[] storeList = new StoreDTO[5]; 
	
	{  // StoreDTO 인스턴스 초기화 블록 
		storeList[0] = new StoreDTO(1, "종로점", "02-111-1111"); 
		storeList[1] = new StoreDTO(2, "서초점", "02-222-2222");
		storeList[2] = new StoreDTO(3, "강남점", "02-333-3333");
		storeList[3] = new StoreDTO(4, "영등포점", "02-444-4444");
		storeList[4] = new StoreDTO(5, "동대문점", "02-555-5555");
	}
	
	private drinks[] bev = new drinks[6];
	{
		bev[0] = new drinks(1, "아메리카노", 4000);
		bev[1] = new drinks(2, "슈크림라떼", 5000);
		bev[2] = new drinks(3, "봄 딸기 라떼", 5500);
		bev[3] = new drinks(4, "돌체 라떼", 5000);
		bev[4] = new drinks(5, "자바칩 프라푸치노", 6000);
		bev[5] = new drinks(6, "자몽 허니 블랙티", 5600);

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
	public drinks[] getBev() {
		return bev;
	}
	public void setBev(drinks[] bev) {
		this.bev = bev;
	}
	@Override
	public String toString() {
		return "Init [storeList=" + Arrays.toString(storeList) + ", bev=" + Arrays.toString(bev) + "]";
	}
	
	
}
