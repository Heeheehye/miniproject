package com.hhh.model.dto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	/* 지점별 제공가능한 메뉴를 설정, 조회하기 위해 만든 컬렉션 */
	private List<drinks> storeMenu0;  	// 종로
	private List<drinks> storeMenu1;  	// 지점별 제공가능 여러 메뉴들 리스트로 셋팅 	
	private List<drinks> storeMenu2;  	// 지점별 제공가능 여러 메뉴들 리스트로 셋팅 	
	private List<drinks> storeMenu3;  	// 지점별 제공가능 여러 메뉴들 리스트로 셋팅 	
	private List<drinks> storeMenu4;  	// 지점별 제공가능 여러 메뉴들 리스트로 셋팅 	
	// 지점(Storelist) - 지점별 제공가능메뉴(storeMenu) 
	private Map<StoreDTO, List<drinks>> service = new HashMap<>();
	
	{
/* *************** 매장 세팅 *************** */
		service.put(storeList[0], storeMenu0 = new ArrayList<drinks>());
		storeMenu0.add(bev[0]);
		storeMenu0.add(bev[1]);
		storeMenu0.add(bev[2]);
		storeMenu0.add(bev[3]);
		storeMenu0.add(bev[4]);
		storeMenu0.add(bev[5]);
		
		
		service.put(storeList[1], storeMenu1 = new ArrayList<drinks>()); // map 
		storeMenu1.add(bev[0]);
		storeMenu1.add(bev[1]);
		storeMenu1.add(bev[3]);  // list 

		service.put(storeList[2], storeMenu2 = new ArrayList<drinks>());
		storeMenu2.add(bev[1]);
		storeMenu2.add(bev[4]);
		
//		storeMenu.removeAll(storeMenu);
		service.put(storeList[3], storeMenu3 = new ArrayList<drinks>());
		storeMenu3.add(bev[0]);
		storeMenu3.add(bev[4]);
		storeMenu3.add(bev[5]);
		
//		storeMenu.removeAll(storeMenu);
		service.put(storeList[4], storeMenu4 = new ArrayList<drinks>());
		storeMenu4.add(bev[1]);
		storeMenu4.add(bev[4]);
		storeMenu4.add(bev[5]);
//		storeMenu.removeAll(storeMenu);
	}
	
//	public List<drinks> getStoreMenu() {
//		return storeMenu;
//	}

//	public void setStoreMenu(int menuindex) {	// 메뉴 인덱스로 입력하기 
////		storeMenu.add(new MenuDTO().getMenulist()[menuindex]);
//		storeMenu.add(getBev()[menuindex]);
//	}

	public Map<StoreDTO, List<drinks>> getService() {
		return service;
	}

	public void setService(int storeindex, List<drinks> storeMenu) {
//		service.put(new StoreDTO().getStorelist()[storeindex], storeMenu);
		service.put(getStoreList()[storeindex], storeMenu);
	}

	/*  -------------------------------------------- */

	
	
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
		return "Init storeList=" + Arrays.toString(storeList) + "\n bev=" + Arrays.toString(bev) + "]";
	}

}
