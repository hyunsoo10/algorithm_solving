package BOJ_9251_LCS;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String str1 = sc.next();
		String str2 = sc.next();

		// LCS 담을 배열
		int[][] dp = new int[str1.length() + 1][str2.length() + 1];

		for (int i = 1; i <= str1.length(); i++) {
			for (int j = 1; j <= str2.length(); j++) {

				// 만약 두 문자열이 같다면
				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					// 다르다면
					// 기준 문자열(str1)의 이전 최대 길이 vs. 비교문자열(str2)의 이전 최대 길이
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		System.out.println(dp[str1.length()][str2.length()]);
	}
}
