package BOJ_5585_거스름돈;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//타로가 지불할 돈
		int N = sc.nextInt();
		
		//타로가 받아야하는 거스름돈
		int change = 1000-N;
		//거스름돈 횟수
		int cnt = 0;
		
		while(change != 0) {
			if(change>=500) {
				change -= 500;
				cnt++;
			}
			else if(change >= 100) {
				change -= 100;
				cnt++;
			}
			else if(change >= 50) {
				change -= 50;
				cnt++;
			}
			else if (change >= 10) {
				change -= 10;
				cnt++;
			}
			else if(change >= 5) {
				change -= 5;
				cnt++;
			}else {
				change -= 1;
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}