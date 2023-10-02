package SWEA_1970_쉬운거스름돈;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			//거슬러 줘야할 금액
			int N = sc.nextInt();
			
			int[] money = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
			//거슬러주어야할 화폐의 개수를 담을 배열
			int[] type = new int[8];
			
			//5만원 지폐부터 거슬러 줄 수 있는 지 체크
			for(int i=0; i<8; i++) {
				
				if(N >= money[i]) {
					int tmp = N/money[i];
					//해당 지폐로 최대한 거슬러 줄 수 있는 만큼 거슬러준다.
					N -= tmp*money[i];
					//해당 지폐 사용 횟수를 배열에 담아준다.
					type[i] = tmp;
				}
			}//end for
			
			System.out.printf("#%d\n", tc);
			for(int t : type) System.out.print(t + " ");
			System.out.println();
		}
	}
}
