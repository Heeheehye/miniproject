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
		MyPageDTO md = new MyPageDTO();
		while(true) {
			System.out.println("========== 메뉴 ==========");
			System.out.println("1. 회원가입");
			System.out.println("2. 마이페이지");
			System.out.println("3. 충전하기");
			System.out.println("4. 전체메뉴조회");
			System.out.println("5. 주문하기");
			System.out.println("0. 프로그램 종료하기");
			int num = sc.nextInt();
			sc.nextLine();
			System.out.println();
			
			switch(num) {
			case 1: su.signUp(); break;
			case 2: System.out.println(su.getMd()); break;
			case 3: pm.charge();
			case 4: // 전체메뉴조회
			case 5: order.orderMain();
			case 0: System.out.println("프로그램을 종료합니다.\n"); break;
			default: break;
			}
		}
	}
	
	
}
