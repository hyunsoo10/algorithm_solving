package SWEA_1860_진기의_최고급_붕어빵;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); // N명의 사람
			int M = sc.nextInt(); // M초의 시간
			int K = sc.nextInt(); // K개의 붕어빵

			int current = 0;// 현재 붕어빵 갯수
			String answer = "Possible";// 정답 Possible로 초기화
			// 각 초에 몇명 오는지
			int[] time = new int[11112];
			for (int i = 0; i < N; i++) {
				time[sc.nextInt()]++;
			}

			// M은 1이상
			for (int i = 1; i < time.length; i++) {
				//0초에 오는 사람이 있으면 무조건 impossible임
				if (time[0] != 0) {
					answer = "Impossible";
					break;
				}

				// M초의 시간이 될때 마다 K붕어빵이 만들어진다.
				if (i % M == 0)
					current += K;

				// 해당 초에 오는 사람이 있는 경우 남은 붕어빵이 있는지 검사
				if (time[i] != 0) {
					// 현재 붕어빵 갯수가 부족하다면
					if (time[i] > current) {
						answer = "Impossible";
						break;
					}
					// 부족하지 않다면 붕어빵 차감
					current -= time[i];
				}

			} // 가능 불가능 여부 체크 끝
			System.out.printf("#%d %s\n", tc, answer);

		}
	}
}
