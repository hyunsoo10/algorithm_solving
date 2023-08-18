package SWEA_1220_Magnetic;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;

		for (int tc = 1; tc <= T; tc++) {
			int ans = 0;

			int N = sc.nextInt();

			int[][] map = new int[100][100];
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			for (int j = 0; j < 100; j++) {
				int current = 0; // 현재 내려오고 있는 자성체를 가리키는 변수
				for (int i = 0; i < 100; i++) {
					// 1(N극)은 2를 만날때 교착상태가 된다
					if (map[i][j] == 1)
						current = 1;
					// 2(S극)을 만나면
					else if (map[i][j] == 2) {
						// 내려오고 있는 N극을 만나서 교착상태 생성
						if (current == 1) {
							ans++;
						}
						current = 2; // 현재 자성체 2로 변경
					}
				}
			}

			System.out.printf("#%d %d\n", tc, ans);
		}
	}
}
