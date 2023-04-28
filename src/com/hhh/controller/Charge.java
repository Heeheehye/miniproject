package com.hhh.controller;

import java.util.Scanner;

public class Charge {

	static int paymoney = 0; //왜 static이 붙지 그냥은 못쓰나?
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("==================== 페이머니 충전 ====================");
		System.out.println();
		
		System.out.print("충전할 금액을 입력해주세요(최소 충전 금액 : 5000원) : ");
		int chargemoney = sc.nextInt();
		if(chargemoney < 5000) {
			System.out.println("최소 충전 금액은 5000원입니다."); 
			System.out.println("1. 충전 계속하기");
			System.out.println("2. 메인화면으로 돌아가기");
			int num = sc.nextInt();
			if(num == 1) {
				System.out.println("충전할 금액 입력해주세요로 다시 돌아가기");
			}else if(num == 2) {
				System.out.println("프로그램 종료하게 break걸려고 했는데 안됨");
			}
		}else {
			paymoney += chargemoney;
			
			System.out.println("충전이 완료되었습니다. 현재 페이머니 잔액은 " + paymoney + "원 입니다.");
			//메인화면으로 돌아가기 추가
		}
	}
	
	public int payInfo() {
		return paymoney;		
	}
	
	
	
	
}
