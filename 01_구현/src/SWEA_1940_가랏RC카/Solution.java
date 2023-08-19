package SWEA_1940_가랏RC카;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();// 커맨드 수

			int lastSpeed = 0; // 현재 저장되어 있는 가장 최근 속도
			int ans = 0; // RC카 총 이동 거리
			int speed = 0;
			for (int i = 0; i < N; i++) {
				int command = sc.nextInt();
				if (command != 0) {
					speed = sc.nextInt();
				}

				switch (command) {
				// 현재 속도 유지
				case (0):
					ans += lastSpeed;
					break;
				// 속도 증가
				case (1):
					speed += lastSpeed;
					ans += speed;
					break;
				// 속도 감속
				case (2):
					if (lastSpeed - speed > 0) {
						speed  = lastSpeed - speed;
						ans += speed;
					}else {
						speed = 0;
					}
					break;
				}
				// 최근 속도에 저장
				lastSpeed = speed;
			}
			System.out.printf("#%d %d\n", tc, ans);
		}
	}
}
