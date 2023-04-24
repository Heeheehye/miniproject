package com.hhh.view.hye;

import java.util.ArrayList;
import java.util.Scanner;

import com.hhh.controller.hye.OrderManager;
import com.hhh.model.dto.hye.MenuDTO;
import com.hhh.model.dto.hye.MyPageDTO;
import com.hhh.model.dto.hye.StoreDTO;

public class Order {

	private Scanner sc = new Scanner(System.in);
	private OrderManager omg = new OrderManager();
	
	/* ???????? 근데 이거 새로 생성하면 초기화되잖아.....?????? 일단해 */
	private MyPageDTO mypage = new MyPageDTO();
	
	public void orderMain() {
		
		MenuDTO orderMenu = null; 		// 주문메뉴 담을 변수
		StoreDTO orderStore = null;		// 주문매장 담을 변수 
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
			
				case 1: orderMenu = omg.orderMenu(selectMenu()); break;
				case 2: orderStore = omg.orderStore(selectStore(orderMenu)); break; 
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
	public int selectMenu() {
		
		System.out.print("주문하실 메뉴 번호를 입력해주세요.");
		int selectMenu = sc.nextInt(); 
		
		return selectMenu; 
	}
	
	public int selectStore(MenuDTO orderMenu) {
		
		ArrayList<StoreDTO> serviceStore = omg.serviceStore(orderMenu);  // 반환된 지점리스트를 저장할 리스트변수
		
		System.out.println("========== 주문가능 지점 ========= ");
		System.out.println(serviceStore + "\n");
		System.out.print("주문하실 지점의 번호를 입력해주세요.");
		
		int selectStore = sc.nextInt();
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
	
	public boolean isPay(MenuDTO orderMenu, StoreDTO orderStore, int dcPrice) {
		
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
