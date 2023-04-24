package com.hhh.test.hye;

import java.util.ArrayList;
import java.util.List;

public class StoreDTO {
	
	private int storeNum;		// 매장 번호 	
	private String storeName; 	// 매장 지점명
	private String storePhone; 	// 매장 연락처 
	
	private List<StoreDTO> storelist = new ArrayList<>();
	
	public StoreDTO() {	}
	
	public StoreDTO(int storeNum, String storeName, String storePhone) {
		super();
		this.storeNum = storeNum;
		this.storeName = storeName;
		this.storePhone = storePhone;
	}
	public int getStoreNum() {
		return storeNum;
	}
	public void setStoreNum(int storeNum) {
		this.storeNum = storeNum;
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
	
	
	public List<StoreDTO> getStorelist() {
		return storelist;
	}
	
	@Override
	public String toString() {
		return "StoreDTO [storeNum=" + storeNum + ", storeName=" + storeName + ", storePhone=" + storePhone + "]";
	}
	  
	 
}
