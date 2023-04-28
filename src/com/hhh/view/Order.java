package com.hhh.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.hhh.controller.OrderManager;
import com.hhh.controller.drinkManager;
import com.hhh.model.dto.Init;
import com.hhh.model.dto.MyPageDTO;
import com.hhh.model.dto.StoreDTO;
import com.hhh.model.dto.drinks;

/**
 * 주문하기 화면 
 * @author hdhye
 *
 */
public class Order {

	private Scanner sc = new Scanner(System.in);
	private OrderManager omg = new OrderManager();
//	private Init init = new Init(); 
	/* ???????? 근데 이거 새로 생성하면 초기화되잖아.....?????? 일단해 */
	private MyPageDTO mypage = new MyPageDTO();
	
	drinkManager 드링크매니저 = new drinkManager();
	
	public void orderMain() {
		
		drinks orderMenu = new drinks(); 		// 주문메뉴 담을 변수
		StoreDTO orderStore = new StoreDTO();		// 주문매장 담을 변수 
		int dcPrice = 1; 				// 쿠폰적용 금액 담을 변수 
		boolean ispay = false; 			// 주문가능한지 판단할 변수 

		while(true) {
			
			System.out.println("********** 주문하기 화면 ***********");
			System.out.println("*\t1. 주문메뉴 선택\t\t*");
			System.out.println("*\t2. 주문매장 선택\t\t*");
			System.out.println("*\t3. 할인쿠폰 선택\t\t*");
			System.out.println("*\t4. 결제하기\t\t*");
			System.out.println("*\t5. 그만두고 돌아가기\t*");
			System.out.println("*********************************");
			
			System.out.print("주문하기 과정입니다. 원하는 번호를 입력하세요.");
			
			switch(sc.nextInt()) {
			
				case 1: orderMenu = omg.orderMenu(selectMenu()); 
				break;
							
				case 2: try {
					orderStore = omg.orderStore(selectStore(orderMenu));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println("없는 지점입니다. 다시 선택하세요."); break;
				} break; 
				case 3: dcPrice = omg.dcPrice(selectCoupon(), orderMenu); break; 
				case 4: ispay = isPay(orderMenu, orderStore, dcPrice);
						if(ispay) {		// ispay가 true이면 결제 실행 
							omg.payment(orderMenu, orderStore, dcPrice);
						}
				case 5: return; 
				default : System.out.println("잘못된 입력입니다. 숫자 1~5 중에 입력해주세요.");break;  
			}
		}
	}

	
	/*
	 * 희윤 : init 추가,bev 추가
	 * drinkManager클래스를 "드링크매니저"라는 변수로 불러왔음
	 * 옵션별 보기가 끝나면(4번을 누르면 종료) 다시 돌아와 이제 음료를 고를 수 있게 했음
	 * 
	 * */
	public int selectMenu() {

		Init init = new Init(); 
		drinks bev = new drinks(); 
		System.out.println("--------메뉴--------");
		System.out.println();

		for (int i = 0; i < init.getBev().length; i++) {
			System.out.println(init.getBev()[i].getNum() + ". " + init.getBev()[i].getName() + " " + init.getBev()[i].getPrice() / 1000 + ","
					+ String.valueOf(init.getBev()[i].getPrice()).substring(1, 4));
		}
		System.out.println();
		
		드링크매니저.showOptions();
		

		for (int i = 0; i < init.getBev().length; i++) {
			System.out.println(init.getBev()[i].getNum() + ". " + init.getBev()[i].getName() + " " + init.getBev()[i].getPrice() / 1000 + ","
					+ String.valueOf(init.getBev()[i].getPrice()).substring(1, 4));
		}
		System.out.print("주문하실 메뉴 번호를 입력해주세요.");
		int selectMenu = sc.nextInt(); 
		
		return selectMenu; 
	}
	
	public int selectStore(drinks orderMenu) throws Exception {
		
		ArrayList<StoreDTO> serviceStore = omg.serviceStore(orderMenu);  // 반환된 지점리스트를 저장할 리스트변수
		
		System.out.println("========== 주문가능 지점 ========= ");
		System.out.println(serviceStore);
		System.out.print("주문하실 지점의 번호를 입력해주세요.");
		
		int selectStore = sc.nextInt();
//		throw new Exception();
//		if(serviceStore.get(selectStore)==null) {
////			System.out.println("없는 지점입니다.");
//		}
		return selectStore; 
		
	}
	
	public int selectCoupon() {
		
		/* 임시 */
		int count = 1; 	// 할인율
		
		if(mypage.getCoupon() != 0 ) {
			System.out.println("할인쿠폰을 적용하시겠습니까?");
			
			String answer = sc.next().charAt(0) + "";
			
			if(answer.equalsIgnoreCase("y")) {
				System.out.println("10% 할인이 적용되었습니다.");
				return count=10; 		// 할인쿠폰 적용시 10% 할인 반환 
			} else if(answer.equalsIgnoreCase("n")) {
				System.out.println("할인이 적용되지 않습니다.");
				return count; 			// 할인쿠폰 적용이 안되면 기본값 1 반환 
			} else { 
				System.out.println("잘못입력하셨습니다. 할인이 적용되지 않습니다.");
				return count; 			// 할인쿠폰 적용이 안되면 기본값 1 반환 
			}
		} else {
			System.out.println("적용가능한 할인쿠폰이 없습니다.");
			return count; // 할인쿠폰 적용이 안되면 기본값 1 반환 
		}
		
	}
	
	public boolean isPay(drinks orderMenu, StoreDTO orderStore, int dcPrice) {
		
		if (mypage.getPaymoney() < dcPrice) {
			System.out.println("페이머니가 부족합니다. 페이머니를 먼저 충전해주세요.");
			return false; 
		} else if(orderMenu == null) {
			System.out.println("메뉴가 선택되지 않았습니다. 메뉴를 먼저 선택해주세요.");
			return false; 
		} else if(orderStore == null) {
			System.out.println("지점이 선택되지 않았습니다. 지점 먼저 선택해주세요.");
			return false; 
		} else {
			return true;
		}
		
		
	}
	
}
