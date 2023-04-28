package com.hhh.view;

import java.util.Scanner;

import com.hhh.controller.ChargeManager;
import com.hhh.model.dto.MyPageDTO;


public class MainPage {

	
	public static void main(String[] args) {
		SignUpManager su = new SignUpManager();
		ChargeManager pm = new ChargeManager();
		Scanner sc = new Scanner(System.in);
		Order order = new Order();

		while(true) {
			System.out.println("             ☕ WELCOME TO MINI CAFE 🍰 ");
			System.out.println();
			System.out.println("   *  *      *      1. 회원가입     *               *");
			System.out.println("   *           *    2. 마이페이지           *        *");
			System.out.println("  *       *         3. 충전하기       *            ");
			System.out.println("        *           4. 전체메뉴조회       *        *");
			System.out.println("   *         *      5. 주문하기                      *");
			System.out.println("  *        *        0. 앱종료하기    *         *   *");
			
			int num = sc.nextInt();
			
			switch(num) {
			case 1: su.signUp(); break;
			case 2: System.out.printf("%s (%s)님\n성별 : %c\n페이잔액 : %d원\n잔여쿠폰 : %d개\n" , MyPageDTO.getName(), MyPageDTO.getId(), MyPageDTO.getGender(), MyPageDTO.getPaymoney(),MyPageDTO.getCoupon()); 
			  		System.out.println(MyPageDTO.getOrderlist());
				break;
			case 3: pm.charge(); break;
			case 4: 
			case 5: order.orderMain(); break;
			case 0: System.out.println("프로그램을 종료합니다.\n"); return;
			default: break;
			}
		}
	}
	
	
}
