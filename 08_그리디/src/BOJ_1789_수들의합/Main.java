package BOJ_1789_수들의합;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		long S = sc.nextLong();// 구해야 하는 합
		
		//서로 다른 자연수 N개의 수는 1, 3, 6, 10, 15, 21 등 누적합을 기점으로 증가된다.
		//누적합 담을 변수
		long sum = 0;
		//1,2,3,4 순차적으로 증가시킬 자연수
		long number = 1;
		//정답 담을 변수
		int cnt = 0;
		//누적합이 구해야 하는 합보다 낮을때까지 반복
		while(sum + number <= S) {
			//누적합 시켜주기
			sum += number;
			//숫자 증가
			number++;
			//카운트 증가
			cnt++;
		}
		System.out.println(cnt);
		sc.close();
	}
}
