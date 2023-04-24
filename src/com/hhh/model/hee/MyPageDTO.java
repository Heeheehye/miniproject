package com.hhh.model.hee;

import com.hhh.view.hee.SignUp;

public class MyPageDTO {

	public MyPageDTO() {}
	
	private String name;
	private char gender;
	private String id;
	private int paymoney;
	private int coupon;
	private String orderlist;
	
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


	public int getPaymoney() {
		return paymoney;
	}


	public void setPaymoney(int paymoney) {
		this.paymoney = paymoney;
	}


	public int getCoupon() {
		return coupon;
	}


	public void setCoupon(int coupon) {
		this.coupon = coupon;
	}


	public String getOrderlist() {
		return orderlist;
	}


	public void setOrderlist(String orderlist) {
		this.orderlist = orderlist;
	}
	
	public String myInfo() {
		return  name + "(" + id + ")님" +  "\n성별 : " + gender + "\n페이잔액 : " + paymoney + "원" + "\n잔여쿠폰 : " + coupon + "개" + "\n주문내역 : " /*+메소드 호출로*/;
	}
	
}
