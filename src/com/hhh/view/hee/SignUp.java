package com.hhh.view.hee;

import java.util.Scanner;

import com.hhh.controller.hee.Charge;
import com.hhh.model.hee.MyPageDTO;

public class SignUp {

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int coupon = 0;
		Charge pm = new Charge();	
		int paymoney = 0; 
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
		System.out.println(md.myInfo()); 
	}
	
}
