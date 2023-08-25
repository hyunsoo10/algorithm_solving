package SWEA_1952_수영장;

import java.util.Scanner;

public class Solution2 {
	public static int day, month, threeMonth, year;
	public static int[] plan;
	public static int answer;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			day = sc.nextInt(); //1일 이용 요금
			month = sc.nextInt(); //1개월 이용 요금
			threeMonth = sc.nextInt();//3개월 이용 요금
			year = sc.nextInt(); //1년 이용 요금
			
			//0번 인덱스 제외한 월 이용 요금 담을 배열
			plan = new int[13];

			for(int i=1; i<=12; i++) {
				plan[i] = sc.nextInt();
			}
			
			//1년 가격을 default로 정답 초기화
			answer = year;
			dfs(1, 0);
			System.out.printf("#%d %d\n", tc, answer);


		}
		
	}
	public static void dfs(int mon, int costSum) {
		if(answer <= costSum) return; //최소값을 넘어선 순간 더 볼 것도 없이 종료
		
		//탐색을 다 끝냈을 경우 두 값중 최솟값을 answer에 담는다.
		if(mon > 12) {
			answer = Math.min(answer, costSum);
			return;
		}
		
		//1일 이용권 이용할 경우
		dfs(mon+1, costSum + plan[mon] * day);
		//1개월 이용권
		dfs(mon+1, costSum + month);
		dfs(mon+3, costSum + threeMonth);
		
	}
}

