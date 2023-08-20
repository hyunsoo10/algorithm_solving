package SWEA_2805_농작물수확하기;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();

			// 입력값이 공백 없이 주어지기 때문에 String배열로 받기
			String[][] map = new String[N][N];
			for (int i = 0; i < N; i++) {
				map[i] = sc.next().split("");
			}

			// 정답 담을 변수
			int ans = 0;

			// N의 중간값 인덱스
			int mid = N / 2;

			// step1 .중간 행 까지
			for (int i = 0; i <= mid; i++) {
				for (int j = mid - i; j <= mid + i; j++) {
					ans += Integer.parseInt(map[i][j]);
				}
			}
			// step2. 중간행 아래부터 끝까지
			for (int i = mid + 1, idx = 0; i < N; i++) {
				for (int j = 1 + idx; j < N - 1 - idx; j++) {
					ans += Integer.parseInt(map[i][j]);
				}
				idx++;
			}

			System.out.printf("#%d %d\n", tc, ans);
		}

	}
}
