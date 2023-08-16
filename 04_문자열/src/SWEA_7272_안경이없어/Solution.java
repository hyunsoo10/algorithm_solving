package SWEA_7272_안경이없어;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();// 테스트 케이스

		String zero = "CEFGHIJKLMNSTUVWXYZ";
		String one = "ADOPQR";
		String two = "B";

		for (int tc = 1; tc <= T; tc++) {
			String first = sc.next();
			String second = sc.next();

			String answer = "SAME";// answer SAME로 초기화
			for (int i = 0; i < first.length(); i++) {
				int firstValue = 0; //첫번째 문자열 체크 변수
				int secondValue = 0; //두번째 문자열 체크 변수
				//길이가 다르면 DIFF 대입하고 break
				if (first.length() != second.length()) {
					answer = "DIFF";
					break;
				} else {
					//one 알파벳이라면 firstValue에 1대입, two라면 2대입, 그 외는 그냥  0 유지
					if(one.contains(String.valueOf(first.charAt(i)))){
						firstValue = 1;
					}else if(two.contains(String.valueOf(first.charAt(i)))) {
						firstValue = 2;
					}
					if(one.contains(String.valueOf(second.charAt(i)))){
						secondValue = 1;
					}else if(two.contains(String.valueOf(second.charAt(i)))) {
						secondValue = 2;
					}
					
					//한번 검사할때마다 firstValue와 secondValue 검사해서 다르면 DIFF대입하고 바로 break
					if(firstValue != secondValue) {
						answer = "DIFF";
						break;
					}
				}
			}

			System.out.printf("#%d %s\n", tc, answer);
		}
	}
}
