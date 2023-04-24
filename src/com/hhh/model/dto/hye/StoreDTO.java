package com.hhh.model.dto.hye;


public class StoreDTO {
	
	private int storeNo;
	private String storeName;
	private String storePhone;
	
	
	public StoreDTO() {
		super();
	}
	
	
	public StoreDTO(int storeNo, String storeName, String storePhone) {
		super();
		this.storeNo = storeNo;
		this.storeName = storeName;
		this.storePhone = storePhone;
	}
	
	
	public int getStoreNo() {
		return storeNo;
	}
	public void setStoreNo(int storeNo) {
		this.storeNo = storeNo;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getStorePhone() {
		return storePhone;
	}
	public void setStorePhone(String storePhone) {
		this.storePhone = storePhone;
	}
	
	@Override
	public String toString() {
		return "지점정보 [지점번호 : " + storeNo + ", 지점명 : " + storeName + ", 지점연락처 : " + storePhone + "]";
	}
	
	

}
