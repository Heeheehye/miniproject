package com.hhh.view;

import java.util.Scanner;

import com.hhh.controller.Charge;
import com.hhh.model.MyPageDTO;

public class SignUp {

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int coupon = 0;
		Charge pm = new Charge();	
		int paymoney = 0; // Charge에서 입력받은 페이머니를 어떻게 받아와야될까????? 
		System.out.println("==================== 회원 정보를 입력해주세요 ====================");
		System.out.println();
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.print("성별 (남/여) : ");
		char gender = sc.nextLine().charAt(0);
		System.out.print("아이디 : "); 
		String id = sc.nextLine();
		System.out.print("비밀번호 : ");
		String pwd = sc.nextLine();
		System.out.print("전화번호 : ");
		String phone = sc.nextLine();

		coupon++;
		System.out.println();
		System.out.println("회원가입이 완료되었습니다🎉 신규가입 쿠폰이 지급되었습니다!📩");
		MyPageDTO md = new MyPageDTO(name, id, gender, pm.payInfo(), coupon);
		System.out.println(md.myInfo()); // 메인에서 마이페이지 누르면 이거 출력하면됨
	}
	
}
