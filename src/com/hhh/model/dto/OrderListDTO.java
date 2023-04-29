package com.hhh.model.dto;

import java.util.ArrayList;
import java.util.List;

public class OrderListDTO {

	private drinks orderMenu;
	private int dcPrice; 
	private StoreDTO orderStore;
	private List<OrderListDTO> orderlist = new ArrayList<>(); 

	public OrderListDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderListDTO(drinks orderMenu, int dcPrice, StoreDTO orderStore) {
		this.orderMenu = orderMenu;
		this.dcPrice = dcPrice;
		this.orderStore = orderStore;
	}

	public drinks getOrderMenu() {
		return orderMenu;
	}

	public void setOrderMenu(drinks orderMenu) {
		this.orderMenu = orderMenu;
	}

	public int getDcPrice() {
		return dcPrice;
	}

	public void setDcPrice(int dcPrice) {
		this.dcPrice = dcPrice;
	}

	public StoreDTO getOrderStore() {
		return orderStore;
	}

	public void setOrderStore(StoreDTO orderStore) {
		this.orderStore = orderStore;
	}

	public List<OrderListDTO> getOrderlist() {
		return orderlist;
	}

	public void setOrderlist(OrderListDTO ordersuccess) {
		this.orderlist.add(ordersuccess);
	}
	
	@Override
	public String toString() {
		return  orderMenu + 
				"\t 결제금액 : " + dcPrice + "\n\t" + orderStore + "\n\t";
	}
	
	
}
