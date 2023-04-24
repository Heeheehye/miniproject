package com.hhh.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hhh.model.dto.hye.MenuDTO;
import com.hhh.model.dto.hye.StoreDTO;

public class Service {
	
	/* 지점별 제공가능한 메뉴를 설정, 조회하기 위해 만든 컬렉션 */
	
	private List<MenuDTO> storeMenu = new ArrayList<>();  	// 지점별 제공가능 여러 메뉴들 리스트로 셋팅 	

	// 지점(Storelist) - 지점별 제공가능메뉴(storeMenu) 
	private Map<StoreDTO, List<MenuDTO>> service = new HashMap<>();
	
	private OrderManager manager = new OrderManager(); 

	/* *************** 매장 세팅 *************** */
	
	{		
		setStoreMenu(0);
		setStoreMenu(1);
		setStoreMenu(2);
		setStoreMenu(3);
		setStoreMenu(4);
		setStoreMenu(5);
		setService(0, getStoreMenu());
		storeMenu.removeAll(storeMenu);
		
		setStoreMenu(0);
		setStoreMenu(1);
		setStoreMenu(2);
		setStoreMenu(5);
		setService(1, getStoreMenu());
		storeMenu.removeAll(storeMenu);
		
		setStoreMenu(1);
		setStoreMenu(2);
		setStoreMenu(3);
		setStoreMenu(5);
		setService(2, getStoreMenu());
		storeMenu.removeAll(storeMenu);
		
		setStoreMenu(0);
		setStoreMenu(4);
		setStoreMenu(5);
		setService(3, getStoreMenu());
		storeMenu.removeAll(storeMenu);
		
		setStoreMenu(1);
		setStoreMenu(3);
		setStoreMenu(4);
		setStoreMenu(5);
		setService(4, getStoreMenu());
		storeMenu.removeAll(storeMenu);
	}
	
	
	public Service() {	} 
	
	
	public List<MenuDTO> getStoreMenu() {
		return storeMenu;
	}

	public void setStoreMenu(int menuindex) {	// 메뉴 인덱스로 입력하기 
//		storeMenu.add(new MenuDTO().getMenulist()[menuindex]);
		storeMenu.add(manager.getMenulist()[menuindex]);
	}

	public Map<StoreDTO, List<MenuDTO>> getService() {
		return service;
	}

	public void setService(int storeindex, List<MenuDTO> storeMenu) {
//		service.put(new StoreDTO().getStorelist()[storeindex], storeMenu);
		service.put(manager.getStorelist()[storeindex], storeMenu);
	}

	
}
