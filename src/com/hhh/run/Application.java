package com.hhh.run;

import com.hhh.controller.OrderManager;
import com.hhh.controller.Service;
import com.hhh.model.dto.StoreDTO;
import com.hhh.view.Order;

public class Application {

	public static void main(String[] args) {
		
//		Order run = new Order();
//		run.orderMain();

		
		Service service = new Service(); 
		OrderManager omg = new OrderManager(); 
		
		System.out.println(service.getService());	// 지점전체
		System.out.println(service.getService().get(omg.getStorelist()[0]));	// null
		System.out.println(service.getService().hashCode()); 
//		System.out.println(service.getService().get(omg.getStorelist()[0]).hashCode());
		System.out.println(omg.getStorelist()[0].hashCode());
		System.out.println(omg.getStorelist()[0]);	// 1번 지점
		System.out.println(omg.getStorelist()[0].toString());	// 1번 지점 
		
//		service.getService().get(storelist[i])).toString()
		
	}
}
 