package com.hhh.controller;

import java.util.ArrayList;
import java.util.List;

import com.hhh.model.dto.MenuDTO;
import com.hhh.model.dto.OrderListDTO;
import com.hhh.model.dto.StoreDTO;

public class OrderManager {
	/* 초기화 블럭, 리스트 있는 클래스를 통합?????????? */
	private OrderListDTO order; 
	private List<OrderListDTO> orderlist = new ArrayList<>(); 

//	StoreDTO store = new StoreDTO(); 
	private StoreDTO[] storelist = new StoreDTO[5]; 
	
		{  
			// StoreDTO 인스턴스 초기화 블록 
			storelist[0] = new StoreDTO(1, "종로점", "02-111-1111"); 
			storelist[1] = new StoreDTO(2, "서초점", "02-222-2222");
			storelist[2] = new StoreDTO(3, "강남점", "02-333-3333");
			storelist[3] = new StoreDTO(4, "영등포점", "02-444-4444");
			storelist[4] = new StoreDTO(5, "동대문점", "02-555-5555");
		}
	
	private MenuDTO[] menulist = new MenuDTO[6];
	
		{  // MenuDTO 인스턴스 초기화 블록 
			menulist[0] = new MenuDTO(1, "아메리카노", 4000 );
			menulist[1] = new MenuDTO(2, "슈크림라떼", 5000 );
			menulist[2] = new MenuDTO(3, "봄딸기라떼", 5500 );
			menulist[3] = new MenuDTO(4, "돌체라떼", 5000 );
			menulist[4] = new MenuDTO(5, "자바칩 프라푸치노", 6000 );
			menulist[5] = new MenuDTO(6, "자몽허니블랙티", 5600 );
		}
	
	
	public MenuDTO orderMenu(int selectMenu) {

		int i = 0 ;  
		for (;;) {
			if(menulist[i++].getNum() == selectMenu ) {
				System.out.println("선택하신 메뉴는 " + menulist[i] + "입니다.");	
				return menulist[i]; 
			} 
			else {
				System.out.println("선택하신 메뉴 번호는 없는 메뉴입니다. 다시 진행해주세요.");
				return null; 
			}
		}
	}
	
	/**
	 * 전달받은 메뉴를 제공가능한 지점 찾기 
	 * @param orderMenu 찾을 메뉴 
	 * @return	지점리스트 
	 */
	public ArrayList<StoreDTO> serviceStore(MenuDTO orderMenu){
		
		ArrayList<StoreDTO> servicestore = new ArrayList<>();
		Service service = new Service();
		
		for (int i = 0; i < service.getService().size(); i++) {
			/* */
			if((service.getService().get(storelist[i])).toString().equals((orderMenu.getMenuName()).toString())) {		// ********************************************
				servicestore.add(storelist[i]); 
			} else {
				System.out.println("선택하신 메뉴를 제공가능한 지점이 없습니다.");
				servicestore = null;
			}
		}
		return servicestore;
	}
	public StoreDTO orderStore(int selectStore) {
		
//		if(storelist[selectStore] == null) { 
//			System.out.println("선택하신 번호는 없는 지점입니다. 다시 진행해주세요.");
//		}

		int i = 0; 
	
		for (;;) {
			if(storelist[i++].getStoreNo() == selectStore) {
				System.out.printf("%s 지점을 선택하셨습니다.", storelist[i].getStoreName());
				break;
			}
		} // 잘못 선택했을 때 반환값 지정해야 함 
		
		return storelist[i];
	}
	
	public int dcPrice(int selectCoupon, MenuDTO orderMenu) {
		
		return	(orderMenu.getPrice())*(1-selectCoupon/100);
	}
	
	public void payment(MenuDTO orderMenu, StoreDTO orderStore, int dcPrice) {
		
		order = new OrderListDTO(orderMenu, dcPrice, orderStore);
		System.out.println("주문완료!! 주문하신 정보는 마이페이지 주문내역에서 확인해주세요.");
		
	}
	
	public OrderListDTO getOrderlist() {
		return order;
	}

	public StoreDTO[] getStorelist() {
		return storelist;
	}

	public MenuDTO[] getMenulist() {
		return menulist;
	}

}
