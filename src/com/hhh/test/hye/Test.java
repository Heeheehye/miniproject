package com.hhh.test.hye;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hhh.model.dto.hye.MenuDTO;


public class Test {
	


	public static void main(String[] args) {
		
		String order = "아메리카노"; 
		Map<StoreDTO, List<MenuDTO>> map = new HashMap<>();
		
		
		Init init = new Init(); 
		
		List<MenuDTO> menu1 = new ArrayList<>();		//1. 종로 
		menu1.add(init.getMenuList()[0]);
		menu1.add(init.getMenuList()[1]);
		menu1.add(init.getMenuList()[2]);

		List<MenuDTO> menu2 = new ArrayList<>();		//2. 서초 
		menu2.add(init.getMenuList()[0]);
		menu2.add(init.getMenuList()[3]);
		menu2.add(init.getMenuList()[4]);
		menu2.add(init.getMenuList()[5]);
		
		map.put(init.getStoreList()[0], menu1);
		map.put(init.getStoreList()[1], menu2);
		
// 			
//		System.out.println(init.getStoreList()[0]);
		System.out.println(map.get(init.getStoreList()[0]).toString().contains("아메리카노"));
		// [MenuDTO [no=1, menuName=아메리카노, price=4000], MenuDTO [no=2, menuName=슈크림라떼, price=5000], MenuDTO [no=3, menuName=봄딸기라떼, price=5500]]
		

		for (int i = 0; i < map.size(); i++) {
			boolean isMenu = map.get(init.getStoreList()[i]).toString().contains(order);
			if(isMenu) {
				
				System.out.println(init.getStoreList()[i]);
			}
		}
		
	}
	 

}
