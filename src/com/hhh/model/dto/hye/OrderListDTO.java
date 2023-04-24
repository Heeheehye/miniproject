package com.hhh.model.dto.hye;

import java.util.ArrayList;
import java.util.List;

public class OrderListDTO {

	private MenuDTO orderMenu;
	private int dcPrice; 
	private StoreDTO orderStore;
	
//	private List<OrderListDTO> orderlist = new ArrayList<>(); 
			
//	private OrderListDTO() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
	public OrderListDTO(MenuDTO orderMenu, int dcPrice, StoreDTO orderStore) {
		super();
		this.orderMenu = orderMenu;
		this.dcPrice = dcPrice;
		this.orderStore = orderStore;
	}
	
//	// 컨트롤러에서 주문완료시 주문내역 셋팅되서 리스트로 관리됨  
//	public void setOrderlist (MenuDTO orderMenu, int dcPrice, StoreDTO orderStore){
//		
//		orderlist.add(new OrderListDTO(orderMenu, dcPrice, orderStore)); 
//	}
//	// 마이페이지에서 조회할때 
//	public List<OrderListDTO> getOrderlist (){
//		
//		return orderlist; 
//	}

	@Override
	public String toString() {
		return "주문내역  : " + orderMenu + 
				", 결제금액 : " + dcPrice + orderStore;
	}
	

	
	
}
