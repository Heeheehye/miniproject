package com.hhh.view;

import java.util.Scanner;
import java.util.Set;

import com.hhh.controller.OrderManager;
import com.hhh.controller.drinkManager;
import com.hhh.model.dto.StaticUnity;
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
//	private MyPageDTO mypage = new MyPageDTO();
	
	drinkManager 드링크매니저 = new drinkManager();
	
	public void orderMain() {
		
		drinks orderMenu = new drinks(); 			// 주문메뉴 담을 변수
		StoreDTO orderStore = new StoreDTO();		// 주문매장 담을 변수 
		int dcPrice = 0; 				// 쿠폰적용 금액 담을 변수 
		boolean ispay = false; 			// 주문가능한지 판단할 변수 
		label:
		while(true) {
			System.out.println("\t\t            💰 주문하기 💰 ");
			System.out.println();
			System.out.println("   *  *      *      1. 주문메뉴 선택     *               *");
			System.out.println("   *           *    2. 주문매장 선택           *        *");
			System.out.println("  *       *         3. 할인쿠폰 선택       *            ");
			System.out.println("   *         *      4. 결제하기                      *");
			System.out.println("  *        *        0. 메인으로 돌아가기    *         *   *");
					
			int num;
			try {
				System.out.print("주문하기 페이지입니다. 원하는 번호를 입력하세요.");
				num = sc.nextInt();
			} catch (Exception e1) {
				sc.nextLine();
				System.out.println("숫자로만 입력하세요. 메인화면으로 돌아갑니다.");
				break;
			}
			
			switch(num) {
			
				case 1: orderMenu = omg.orderMenu(selectMenu()); 
				break;
							
				case 2:	
					try { orderStore = omg.orderStore(selectStore(orderMenu));
				    } catch (Exception e) {
					  } break;
				case 3: dcPrice = omg.dcPrice(selectCoupon(), orderMenu); 
						System.out.println("결제할 금액 : " + dcPrice );			
						break; 
				case 4: ispay = isPay(orderMenu, orderStore, dcPrice);
						if(ispay) {		// ispay가 true이면 결제 실행 
							omg.payment(orderMenu, dcPrice, orderStore);
						} 
						else { continue label;}
				case 0: return; 
				default : System.out.println("잘못된 입력입니다. 숫자 1~4 중에 입력해주세요.");break;  
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

//		drinks bev = new drinks(); 
		System.out.println("--------메뉴--------");
		System.out.println();

		for (int i = 0; i < StaticUnity.init.getBev().length; i++) {
			System.out.println(StaticUnity.init.getBev()[i].getNum() + ". " + StaticUnity.init.getBev()[i].getName() 
								+ " " + StaticUnity.init.getBev()[i].getPrice() / 1000 + ","
								+ String.valueOf(StaticUnity.init.getBev()[i].getPrice()).substring(1, 4));
		}
		System.out.println();
		
		드링크매니저.showOptions();
		

		System.out.print("주문하실 메뉴 번호를 입력해주세요.");
		int selectMenu = sc.nextInt(); 
		
		return selectMenu; 
	}
	
	public String selectStore(drinks orderMenu) throws Exception {
		
		if(orderMenu.getName() == null) {
			System.out.println("메뉴가 선택되지 않았습니다. 메뉴를 먼저 선택해주세요.");
			return null; 
		} else {
			Set<StoreDTO> serviceStore = omg.serviceStore(orderMenu);  // 반환된 지점리스트를 저장할 리스트변수
			
			System.out.println("========== 주문가능 지점 ========= ");
			serviceStore.stream().map(StoreDTO->StoreDTO.toString()).forEach(System.out::println);		
			System.out.print("주문하실 지점의 지점명을 입력해주세요.");
			sc.nextLine();
			String selectStore;
			try {
				selectStore = sc.nextLine();
				return selectStore; 
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("불가능한 지점입니다. 다시 입력하세요.");
				return null; 
			}
		}
	}
	
	public int selectCoupon() {
		
		/* 임시 */
		int count = 0; 	// 할인율
		
		if(StaticUnity.mypage.getCoupon() != 0 ) {
			System.out.println("할인쿠폰을 적용하시겠습니까? (y/n)");
			
			String answer = sc.next().charAt(0) + "";
			
			if(answer.equalsIgnoreCase("y")) {
				System.out.println("10% 할인이 적용되었습니다.");
				return count=10; 		// 할인쿠폰 적용시 10% 할인 반환 
			} else if(answer.equalsIgnoreCase("n")) {
				System.out.println("할인이 적용되지 않습니다.");
				return count; 			// 할인쿠폰 적용이 안되면 기본값 0 반환 
			} else { 
				System.out.println("잘못입력하셨습니다. 할인이 적용되지 않습니다.");
				return count; 			// 할인쿠폰 적용이 안되면 기본값 0 반환 
			}
		} else {
			System.out.println("적용가능한 할인쿠폰이 없습니다.");
			return count; // 할인쿠폰 적용이 안되면 기본값 0 반환 
		}
		
	}
	
	public boolean isPay(drinks orderMenu, StoreDTO orderStore, int dcPrice) {
		
		  if (StaticUnity.mypage.getPaymoney() < dcPrice) {
			System.out.println("페이머니가 부족합니다. 페이머니를 먼저 충전해주세요.");
			return false; 
		} else if(orderMenu.getName() == null) {
			System.out.println("메뉴가 선택되지 않았습니다. 메뉴를 먼저 선택해주세요.");
			return false; 
		} else if(orderStore.getStoreName() == null) {
			System.out.println("지점이 선택되지 않았습니다. 지점 먼저 선택해주세요.");
			return false; 
		} else {
			return true;
		}
		
		
	}
	
}
