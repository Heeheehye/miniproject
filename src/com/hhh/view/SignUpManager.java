package com.hhh.view;

import java.util.Scanner;

import com.hhh.controller.ChargeManager;
import com.hhh.model.dto.MyPageDTO;

public class SignUpManager {

	
	MyPageDTO md = new MyPageDTO();
	
	
	public SignUpManager() {
		// TODO Auto-generated constructor stub
	}
	public MyPageDTO getMd() {
		return md;
	}
	
	public void setMd(MyPageDTO md) {
		this.md = md;
	}
	

	// 회원가입 정보 입력받기
	public void signUp() {
		ChargeManager pm = new ChargeManager();	
		int coupon = 0;
		int paymoney = 0; 
		Scanner sc = new Scanner(System.in);
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
		System.out.println();
		md = new MyPageDTO(name, id, gender, pm.payInfo(), coupon);
		return;
	}

	
}
