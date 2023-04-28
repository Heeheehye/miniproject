package com.hhh.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.hhh.model.dto.Init;
import com.hhh.model.dto.MyPageDTO;
import com.hhh.model.dto.OrderListDTO;
import com.hhh.model.dto.StoreDTO;
import com.hhh.model.dto.drinks;

public class OrderManager {
	/* 초기화 블럭, 리스트 있는 클래스를 통합?????????? */
	private OrderListDTO order; 
	private List<OrderListDTO> orderlist = new ArrayList<>(); 

	private Init init = new Init(); 
	
	public drinks orderMenu(int selectMenu) {
		drinks bev = new drinks(); 
		
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
			
			if(init.getBev()[i].getNum() == selectMenu ) {
				System.out.println("선택 메뉴 : " + init.getBev()[i]);	
				bev = init.getBev()[i];
				break; 
			}  
		} 
		if(init.getBev().length < selectMenu) {
			System.out.println("선택하신 메뉴번호는 없는 메뉴입니다.");	
		}
		return bev; 
	}
	
	/**
	 * 전달받은 메뉴를 제공가능한 지점 찾기 
	 * @param orderMenu 찾을 메뉴 
	 * @return	지점리스트 
	 */
	public ArrayList<StoreDTO> serviceStore(drinks orderMenu){
		
		ArrayList<StoreDTO> servicestore = new ArrayList<>();
		
		for (int i = 0; i < init.getService().size(); i++) {
			/* */
			if((init.getService().get(init.getStoreList()[i]))
										   .toString().contains(orderMenu.getName())) {		// ********************************************
				servicestore.add(init.getStoreList()[i]); 
			} 
//			else {
//				System.out.println("선택하신 메뉴를 제공가능한 지점이 없습니다.");
//				servicestore = null;
//			}
		}
		return servicestore;
	}
	public StoreDTO orderStore(int selectStore) {
		

			System.out.printf("%s 지점을 선택하셨습니다.\n", init.getStoreList()[selectStore-1].getStoreName());
			
		return init.getStoreList()[selectStore-1];
	}
	
	public int dcPrice(int selectCoupon, drinks orderMenu) {
		
		return	(orderMenu.getPrice())*(1-selectCoupon/100);
	}
	
	public void payment(drinks orderMenu, StoreDTO orderStore, int dcPrice) {
		
		order = new OrderListDTO(orderMenu, dcPrice, orderStore);
		System.out.println("주문완료!! 주문하신 정보는 마이페이지 주문내역에서 확인해주세요.");
		MyPageDTO mypage = new MyPageDTO(); 
		mypage.setPaymoney(mypage.getPaymoney()-dcPrice);
	}
	
	public List<OrderListDTO> getOrderlist() {
		return orderlist;
	}
	
	

}
