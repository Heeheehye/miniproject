package com.hhh.controller;

import java.util.Scanner;

public class ChargeManager {

	int paymoney = 0; 
	public void  charge() {
		
		System.out.println("==================== 페이머니 충전 ====================");
		System.out.println();
		
		System.out.print("충전할 금액을 입력해주세요(최소 충전 금액 : 5000원) : ");
		Scanner sc = new Scanner(System.in);
		int chargemoney = sc.nextInt();
		if(chargemoney < 5000) {
			System.out.println("최소 충전 금액은 5000원입니다."); 
			System.out.println("1. 충전 계속하기");
			System.out.println("2. 메인화면으로 돌아가기");
			int num = sc.nextInt();
			switch(num) {
			case 1: 
			case 2: return;
			}
		}else {
			
			paymoney += chargemoney;
			System.out.println("충전이 완료되었습니다. 현재 페이머니 잔액은 " + paymoney + "원 입니다.");
		
		}
	}
	
	public int payInfo() {
		return paymoney;		
	}
}
