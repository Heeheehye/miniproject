package com.hhh.controller;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import com.hhh.model.dto.Init;
import com.hhh.model.dto.MyPageDTO;
import com.hhh.model.dto.OrderListDTO;
import com.hhh.model.dto.StoreDTO;
import com.hhh.model.dto.drinks;

public class OrderManager {
	/* 초기화 블럭, 리스트 있는 클래스를 통합?????????? */
	private OrderListDTO order; 
	/* 서비스지점 담을 변수 */
	private LinkedHashSet<StoreDTO> servicestore;
	/* 주문내역 담을 리스트 변수 */
	public static List<OrderListDTO> orderlist = new ArrayList<>(); 

	private Init init = new Init(); 
	
	public drinks orderMenu(int selectMenu) {
		drinks bev = new drinks(); 	// drinks  담을 변수 
		 
		/*0428 유희윤 
		System.out.println("--------메뉴--------");
		System.out.println();

		for (int i = 0; i < init.getBev().length; i++) {
			System.out.println(init.getBev()[i].getNum() + ". " + init.getBev()[i].getName() + " " + init.getBev()[i].getPrice() / 1000 + ","
					+ String.valueOf(init.getBev()[i].getPrice()).substring(1, 4));
		}
		System.out.println();
		
		*/
		
		
		for (int i = 0; i < init.getBev().length; i++) {
			
			if(Init.getBev()[i].getNum() == selectMenu ) {
				System.out.println("선택 메뉴 : " + Init.getBev()[i]);	
				bev = Init.getBev()[i];
				break; 
			}  
		}
		if(Init.getBev().length < selectMenu) {
			System.out.println("선택하신 메뉴번호는 없는 메뉴입니다.");	
		}
		return bev; 
	}
	
	/**
	 * 전달받은 메뉴를 제공가능한 지점 찾기 
	 * @param orderMenu 찾을 메뉴 
	 * @return	지점리스트 
	 */
	public LinkedHashSet<StoreDTO> serviceStore(drinks orderMenu){
		servicestore = new LinkedHashSet<>();  // 초기화 
		for (int i = 0; i < Init.getService().size(); i++) {
			
			if((Init.getService().get(Init.getStoreList()[i]))
					   .toString().contains(orderMenu.getName())) {		// ********************************************
				servicestore.add(Init.getStoreList()[i]); 
			} 

		}
		return servicestore;
	}
	public StoreDTO orderStore(String selectStore) {
		StoreDTO store = new StoreDTO();  // 초기화 
				for (int i = 0; i < Init.getService().size(); i++) {
					if(servicestore.toString().contains(selectStore)){
						if(Init.getStoreList()[i].getStoreName().contains(selectStore)){
							store = Init.getStoreList()[i];
							System.out.printf("%s 지점을 선택하셨습니다.\n", store.getStoreName());
							break;
							}
						}
					}
				return store; 
	}
	public int dcPrice(int selectCoupon, drinks orderMenu) {
		
		return	(orderMenu.getPrice())*(1-selectCoupon/100);
	}
	
	public void payment(drinks orderMenu, StoreDTO orderStore, int dcPrice) {
		
		/* */ 
		order = new OrderListDTO(orderMenu, dcPrice, orderStore);
		orderlist.add(order); 
		System.out.println("주문완료!! 주문하신 정보는 마이페이지 주문내역에서 확인해주세요.");
		MyPageDTO.setPaymoney(MyPageDTO.getPaymoney()-dcPrice);
		MyPageDTO.setCoupon(-1);
	}
	
	public static List<OrderListDTO> getOrderlist() {
		return orderlist;
	}
	
	

}
