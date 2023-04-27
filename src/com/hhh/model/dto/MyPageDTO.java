package com.hhh.model.dto;

import java.util.List;

import com.hhh.controller.OrderManager;
import com.hhh.view.SignUp;

public class MyPageDTO {

	public MyPageDTO() {}
	
	private String name;
	private char gender;
	private String id;
	private static int paymoney ;
	private static int coupon;
//	private String orderlist;
	
	SignUp su = new SignUp();
	
	
	public MyPageDTO(String name, String id, char gender, int paymoney, int coupon /*String orderlist*/) {

		this.name = name;
		this.gender = gender;
		this.id = id;
		this.paymoney = paymoney;
		this.coupon = coupon;
//		this.orderlist = orderlist;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public char getGender() {
		return gender;
	}


	public void setGender(char gender) {
		this.gender = gender;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public static int getPaymoney() {
		return paymoney;
	}


	public static void setPaymoney(int paymoney) {
		MyPageDTO.paymoney = paymoney;
	}


	public static int getCoupon() {
		return coupon;
	}


	public static void setCoupon(int coupon) {
		MyPageDTO.coupon += coupon;
	}


	public List<OrderListDTO> getOrderlist() {
		return OrderManager.orderlist;
	}


//	public void setOrderlist(String orderlist) {
//		this.orderlist = orderlist;
//	}
//	
	public String myInfo() {
		return  name + "(" + id + ")님" +  "\n성별 : " + gender + "\n페이잔액 : " + paymoney + "원" + "\n잔여쿠폰 : " + coupon + "개" + "\n주문내역 : " /*+메소드 호출로*/;
	}
	
}
