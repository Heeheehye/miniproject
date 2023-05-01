package com.hhh.controller;

//import static com.hhh.model.dto.StaticUnity.*;

import java.util.LinkedHashSet;

import com.hhh.model.dto.OrderListDTO;
import com.hhh.model.dto.StoreDTO;
import com.hhh.model.dto.StaticUnity;
import com.hhh.model.dto.drinks;


public class OrderManager {

	/* 서비스지점 담을 변수 */
	private LinkedHashSet<StoreDTO> servicestore;
	
	/**
	 * 사용자가 메뉴번호로 입력하여 선택한 메뉴 담기 
	 * @param selectMenu 사용자가 입력한 메뉴번호
	 * @return 메뉴번호에 해당하는 메뉴정보 
	 */
	public drinks orderMenu(int selectMenu) {
		
		// drinks  선택한 메뉴 담을 변수 
		drinks bev = new drinks(); 
		
		if(selectMenu > StaticUnity.init.getBev().length) {
			System.out.println("선택하신 메뉴번호는 없는 메뉴입니다.");	
		return bev;		// null값 
		} else {
			for (int i = 0; i < StaticUnity.init.getBev().length; i++) {
				
				if(selectMenu == StaticUnity.init.getBev()[i].getNum()) {
					System.out.println("선택 메뉴 : " + StaticUnity.init.getBev()[i]);	
					bev = StaticUnity.init.getBev()[i];
					break; 
				} 
			}
			return bev; 
		}
	}
	
	/**
	 * 전달받은 메뉴를 제공가능한 지점 찾기 
	 * @param orderMenu 찾을 메뉴 
	 * @return	지점리스트 
	 */
	public LinkedHashSet<StoreDTO> serviceStore(drinks orderMenu){
		servicestore = new LinkedHashSet<>();  // 초기화 
		for (int i = 0; i < StaticUnity.init.getService().size(); i++) {
			
			if((StaticUnity.init.getService().get(StaticUnity.init.getStoreList()[i]))
					   .toString().contains(orderMenu.getName())) {		
				servicestore.add(StaticUnity.init.getStoreList()[i]); 
			} 

		}
		return servicestore;
	}
	
	/**
	 * 선택한 지점 반환하기 
	 * @param selectStore 선택한 지점 글자로 입력받음 
	 * @return
	 */
	public StoreDTO orderStore(String selectStore) {
		StoreDTO store = new StoreDTO();  // 초기화 
		
		if(!(servicestore.toString().contains(selectStore))) {
			System.out.println("불가능한 지점입니다. 다시 선택하세요."); 
		} else{
			for (int i = 0; i < StaticUnity.init.getService().size(); i++) {
				if(servicestore.toString().contains(selectStore)){
					if(StaticUnity.init.getStoreList()[i].getStoreName().contains(selectStore)){
						store = StaticUnity.init.getStoreList()[i];
						System.out.printf("[%s] 지점을 선택하셨습니다.\n", store.getStoreName());
						break;
					}
				}
			}
		}
		return store; 
	}
	
	/**
	 * 할인쿠폰 적용한 금액 계산하기
	 * @param selectCoupon 쿠폰 할인율 (10이면 10%, 1이면 없음) 
	 * @param orderMenu 선택한 메뉴
	 * @return 할인적용된 결제할금액 반환 
	 */
	public int dcPrice(int selectCoupon, drinks orderMenu) {
	
		return	(int)((orderMenu.getPrice())*(1.0-(selectCoupon/100.0)));
	}
	
	public void payment(drinks orderMenu, int dcPrice, StoreDTO orderStore) {
		
		if(dcPrice == 0 ){
			dcPrice = orderMenu.getPrice(); 
		}
		if(dcPrice < orderMenu.getPrice()) {
			StaticUnity.mypage.setCoupon(StaticUnity.mypage.getCoupon()-1);
		}

		OrderListDTO ordersuccess = new OrderListDTO(orderMenu, dcPrice, orderStore);
		StaticUnity.orderlist.setOrderlist(ordersuccess);
		System.out.println("주문완료!! 주문하신 정보는 마이페이지 주문내역에서 확인해주세요.");
		StaticUnity.mypage.setPaymoney(StaticUnity.mypage.getPaymoney()-dcPrice);
	
		
	}
	

}
