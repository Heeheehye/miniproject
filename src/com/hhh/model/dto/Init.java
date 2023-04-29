package com.hhh.model.dto;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 초기화용 클래스 
 * 지점과 메뉴의 초기값을 세팅한다. 
 * @author hdhye
 *
 */
public class Init {

	/* 전체 지점 초기값을 담을 객체배열 */
	private StoreDTO[] storeList = new StoreDTO[5]; 
	
	{  // StoreDTO 인스턴스 초기화 블록 
		storeList[0] = new StoreDTO(1, "종로점", "02-111-1111"); 
		storeList[1] = new StoreDTO(2, "서초점", "02-222-2222");
		storeList[2] = new StoreDTO(3, "강남점", "02-333-3333");
		storeList[3] = new StoreDTO(4, "영등포점", "02-444-4444");
		storeList[4] = new StoreDTO(5, "동대문점", "02-555-5555");
	}
	
	/* 전체 메뉴 초기값을 담을 객체배열 */ 
	private drinks[] bev = new drinks[6];
	{
		bev[0] = new drinks(1, "아메리카노", 4000);
		bev[1] = new drinks(2, "슈크림라떼", 5000);
		bev[2] = new drinks(3, "봄 딸기 라떼", 5500);
		bev[3] = new drinks(4, "돌체 라떼", 5000);
		bev[4] = new drinks(5, "자바칩 프라푸치노", 6000);
		bev[5] = new drinks(6, "자몽 허니 블랙티", 5600);

	}
	/* 지점별 제공가능한 메뉴를 설정, 조회하기 위해 만든 Set 컬렉션 */
	private Set<drinks> storeMenu0;  	// 종로점 셋팅 
	private Set<drinks> storeMenu1;  	// 서초점 셋팅
	private Set<drinks> storeMenu2;  	// 강남점 셋팅 
	private Set<drinks> storeMenu3;  	// 영등포점 셋팅 
	private Set<drinks> storeMenu4;  	// 동대문전 셋팅 
	
	// 지점(Storelist) - 지점별 제공 가능메뉴(storeMenu)를 담을 Map   
	private Map<StoreDTO, Set<drinks>> service = new HashMap<>();
	
	{
       /* *************** 매장별 제공(service)가능한 메뉴들 세팅 *************** */
		// 종로점 셋팅 
		service.put(storeList[0], storeMenu0 = new HashSet<drinks>());
		storeMenu0.add(bev[0]);
		storeMenu0.add(bev[1]);
		storeMenu0.add(bev[2]);
		storeMenu0.add(bev[3]);
		storeMenu0.add(bev[4]);
		storeMenu0.add(bev[5]);
		
		// 서초점 셋팅
		service.put(storeList[1], storeMenu1 = new HashSet<drinks>()); // map 
		storeMenu1.add(bev[0]);
		storeMenu1.add(bev[1]);
		storeMenu1.add(bev[3]);  
		// 강남점 셋팅 
		service.put(storeList[2], storeMenu2 = new HashSet<drinks>());
		storeMenu2.add(bev[1]);
		storeMenu2.add(bev[4]);
		// 영등포점 셋팅
		service.put(storeList[3], storeMenu3 = new HashSet<drinks>());
		storeMenu3.add(bev[0]);
		storeMenu3.add(bev[4]);
		storeMenu3.add(bev[5]);
		// 동대문점 셋팅
		service.put(storeList[4], storeMenu4 = new HashSet<drinks>());
		storeMenu4.add(bev[1]);
		storeMenu4.add(bev[4]);
		storeMenu4.add(bev[5]);
	}
	
	/**
	 * 기본 생성자
	 */
	public Init() {	}
	
	/**
	 * 지점정보 전체 배열 getter 
	 * @return
	 */
	public StoreDTO[] getStoreList() {
		return storeList;
	}
	
	public void setStoreList(StoreDTO[] storeList) {
		this.storeList = storeList;
	}
	
	/**
	 * 메뉴정보 전체 배열 getter 
	 * @return 
	 */
	public drinks[] getBev() {
		return bev;
	}
	
	public void setBev(drinks[] bev) {
		this.bev = bev;
	}
	
	
	/**
	 * getter 
	 * @return 지점별 제공가능메뉴 리스트 
	 */
	public Map<StoreDTO, Set<drinks>> getService() {
		return service;
	}

	/**
	 * setter 
	 * @param storeList 지점정보 
	 * @param storeMenu 제공가능한 메뉴들 Set 
	 */
	public void setService(StoreDTO storeList, Set<drinks> storeMenu) {
		service.put(storeList, storeMenu);
	}

	/**
	 * 지점 - 음료목록 
	 */
	@Override
	public String toString() {
		
		return "Init storeList=" + Arrays.toString(storeList) + "\n bev=" + Arrays.toString(bev) + "]";
	}

}
