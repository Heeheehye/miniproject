package com.hhh.view.yoon;

import com.hhh.controller.yoon.drinkManager;
import com.hhh.model.yoon.drinks;

import java.util.*;

public class Menu {

	private static drinkManager dr = new drinkManager();
	
	public static void searchMenu() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("검색할 키워드를 입력하세요 : ");
		String drinkName = scan.nextLine();
		
		drinks[] search = dr.searchMenu(drinkName);
		
		for(drinks d : search) {
			if(d!=null) {
				System.out.println(d.getNum() + ". " + d.getName() + " " + d.getPrice() / 1000 + ","
						+ String.valueOf(d.getPrice()).substring(1, 4));
			}
			
		}
		
	}
	
	
	public static void main(String[] args) {

		//System.out.println("----회원가입을 축하합니다.----");
		//System.out.println();
		/*
		 * System.out.println("	(  )   (   )  )");
		 * System.out.println("    ) (   )  (  (");
		 * System.out.println("    ( )  (    ) )");
		 * System.out.println("    _____________");
		 * System.out.println("   <_____________> ___");
		 * System.out.println("   |             |/ _ \\");
		 * System.out.println("   |               | | |");
		 * System.out.println("   |               |_| |");
		 * System.out.println("___|             |\\___/");
		 * System.out.println("/    \\___________/    \\");
		 * System.out.println("\\_____________________/ "); System.out.println();
		 */

		//System.out.println("😁 원하시는 기능을 선택하세요 😁");
		
		System.out.println("@메뉴 보여주기");
		dr.showMenu();
		System.out.println("===========================");
		System.out.println();
		
		System.out.println("@메뉴 검색하기 ");
		searchMenu();
		System.out.println("===========================");
		System.out.println();
		
		System.out.println("@메뉴보기 설정 변경");
		dr.showOptions();
		

	}

}
