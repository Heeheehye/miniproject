package com.hhh.model.dto;

import java.util.ArrayList;
import java.util.List;

public class OrderListDTO {

	private drinks orderMenu;
	private int dcPrice; 
	private StoreDTO orderStore;

			
	private OrderListDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderListDTO(drinks orderMenu, int dcPrice, StoreDTO orderStore) {
		super();
		this.orderMenu = orderMenu;
		this.dcPrice = dcPrice;
		this.orderStore = orderStore;
	}

	@Override
	public String toString() {
		return "주문내역  : " + orderMenu + 
				", 결제금액 : " + dcPrice + orderStore;
	}
	

	
	
}
