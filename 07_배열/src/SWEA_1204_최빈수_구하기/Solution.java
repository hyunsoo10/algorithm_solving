package SWEA_1204_최빈수_구하기;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int t = sc.nextInt();

			int ans = 0;
			int max = 0;
			// 0부터 100점까지 점수 빈도수 담을 배열
			int[] scores = new int[101];
			for (int i = 0; i < 1000; i++) {
				scores[sc.nextInt()]++;
			}

			// 빈도수 최대 점수 출력하기
			for (int i = 0; i <= 100; i++) {
				if (max <= scores[i]) {
					max = scores[i];
					ans = i;
				}
			}

			System.out.printf("#%d %d\n", t, ans);
		}
	}
}
