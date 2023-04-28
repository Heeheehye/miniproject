package com.hhh.controller;

import java.util.*;

import com.hhh.model.dto.drinks;
import com.hhh.view.Menu;

public class drinkManager {

	private drinks[] bev = new drinks[6];
	{
		bev[0] = new drinks(1, "아메리카노", 4000);
		bev[1] = new drinks(2, "슈크림라떼", 5000);
		bev[2] = new drinks(3, "봄 딸기 라떼", 5500);
		bev[3] = new drinks(4, "돌체 라떼", 5000);
		bev[4] = new drinks(5, "자바칩 프라푸치노", 6000);
		bev[5] = new drinks(6, "자몽 허니 블랙티", 5600);

	}

	public drinks[] searchMenu(String drinkName) {
		drinks[] search = new drinks[6];
		int cnt = 0;

		for (int i = 0; i < bev.length; i++) {
			if (bev[i].getName().contains(drinkName)) {
				search[cnt] = bev[i];
				cnt++;
			}//
		}
		return search;
	}

	// 전체 메뉴 보여주기
	public void showMenu() {

		System.out.println();
		System.out.println("--------메뉴--------");
		System.out.println();

		for (int i = 0; i < bev.length; i++) {
			System.out.println(bev[i].getNum() + ". " + bev[i].getName() + " " + bev[i].getPrice() / 1000 + ","
					+ String.valueOf(bev[i].getPrice()).substring(1, 4));
		}

	}

	// 옵션별(가나다순,높은 가격순,낮은 가격순으로 선택하는 메소드)
	public void showOptions() {

		System.out.println();
		System.out.println("---원하시는 기능을 선택하세요---");
		System.out.println("1. 가나다순으로 보기");
		System.out.println("2. 높은 가격순으로 보기");
		System.out.println("3. 낮은 가격순으로 보기");
		System.out.println("4. 종료");
		System.out.println();


		Arrays.asList(bev);
		Scanner scan = new Scanner(System.in);

		// 1 :가나다순 2: 높은 가격순 3: 낮은 가격순
		while (true) {
			int select = scan.nextInt();

			if (select == 1) {
				System.out.println("이름순으로 나열했어요 ");
				Arrays.sort(bev, (a, b) -> a.getName().compareTo(b.getName()));
				System.out.println(
						" " + Arrays.asList(bev).toString().replace("[", "").replace("]", "").replace(",", ""));
			} else if (select == 2) {
				System.out.println("높은 가격순으로 나열했어요 ");
				Arrays.sort(bev, (a, b) -> (a.getPrice() != b.getPrice()) ? (b.getPrice() - a.getPrice())
						: (a.getName().compareTo(b.getName()))

				);

				System.out.println(
						" " + Arrays.asList(bev).toString().replace("[", "").replace("]", "").replace(",", ""));
			
			} else if (select == 3) {
				System.out.println("낮은 가격순으로 나열했어요 ");
				Arrays.sort(bev, (a, b) -> (a.getPrice() != b.getPrice()) ? (a.getPrice() - b.getPrice())
						: (a.getName().compareTo(b.getName()))

				);

				System.out.println(
						" " + Arrays.asList(bev).toString().replace("[", "").replace("]", "").replace(",", ""));
			
			}
			
			else if(select==4) {
				System.out.println("메뉴 보기를 종료하고 이제 음료 선택으로 돌아갑니다.");
			
				break;
				
			}
			
			
			else {
				System.out.println("잘못된 입력입니다.");
				break;
			}
			
			
			
		}

		
		
	}

}
