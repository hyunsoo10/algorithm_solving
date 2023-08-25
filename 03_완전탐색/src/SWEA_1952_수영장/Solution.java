package SWEA_1952_수영장;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int day = sc.nextInt(); // 1일 이용 요금
			int month = sc.nextInt(); // 1개월 이용 요금
			int threeMonth = sc.nextInt();// 3개월 이용 요금
			int year = sc.nextInt(); // 1년 이용 요금

			// 0번 인덱스 제외한 월 이용 날짜 담을 배열
			int[] plan = new int[13];
			// 이용할 월만 담은 리스트
			for (int i = 1; i <= 12; i++) {
				plan[i] = sc.nextInt();
			}

			// 최소 비용 갱신해가면서 담을 dp 배열
			int[] dp = new int[13];

			// 1월 최소비용은 미리담아두기
			dp[1] = Math.min(month, plan[1] * day);
			dp[2] = Math.min(dp[1] + month, dp[1] + plan[2] * day);
			// 3월 이후부터는 전월 최소 요금 + 해당 일 요금, 전월 최소요금 + 해당 월요금, 3개월 요금 셋 중에 비교해서 최솟값
			for (int i = 3; i <= 12; i++) {
				dp[i] = Math.min(dp[i - 3] + threeMonth, Math.min(dp[i - 1] + month, dp[i - 1] + plan[i] * day));
			}
			// dp[12]에 담긴 값과 1년 이용요금을 마지막으로 비교해서 더 작은 값을 정답으로 담는다.
			int answer = year;
			if (answer > dp[12])
				answer = dp[12];
			System.out.printf("#%d %d\n", tc, answer);

		}
	}
}
