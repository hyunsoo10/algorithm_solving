package SWEA_4014_활주로건설;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
//		int T = 1;

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); // N*N활주로
			int x = sc.nextInt(); // 경사로 길이

			int[][] map = new int[N][N];

			// 활주로 정보 입력 받기
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			// 활주로 건설 가능 여부 카운팅
			int cnt1 = 0;
			int cnt2 = 0;

			// 1. 가로 탐색
			for (int i = 0; i < N; i++) {
				// 해당 구역 활주로 건설 가능 여부(true로 초기화)
				boolean flag = true;
				
				// 해당 가로의 가장 첫번째 구역 높이
				int height = map[i][0];
				// 첫번째 인덱스
				int idx = 0;
				for (int j = 1; j < N; j++) {
					// 두 높이의 차가 1보다 크면 활주로 건설 불가능
					if (Math.abs(map[i][j] - height) > 1) {
						flag = false;
						break;
					} else if (Math.abs(map[i][j] - height) == 1) {
						// 큰 높이가 나올 경우
						if (map[i][j] > height) {
							if (x > j - idx) {
								flag = false;
								break;
							}
							//위치랑 높이 초기화
							idx = j;
							height = map[i][j];
						}
						// 작은 높이가 나올 경우
						else {
							int len = 1;
							height = map[i][j];
							idx = j+1;
							while (idx < N && map[i][idx] == height) {
								len++;
								idx++;
							}
							
							// 건설 가능 길이가 활주로 길이보다 짧은 경우 불가능
							if (len < x) {
								flag = false;
								break;
							}
							//높이랑 위치 초기화
							j = idx-1;
							height = map[i][j];
						}
					}
					
				}
				if (flag)
					cnt1++;
			}
			//세로 탐색
			for (int j = 0; j < N; j++) {
				// 해당 구역 활주로 건설 가능 여부(true로 초기화)
				boolean flag = true;
				
				// 해당 가로의 가장 첫번째 구역 높이
				int height = map[0][j];
				// 첫번째 인덱스
				int idx = 0;
				for (int i = 1; i < N; i++) {
					// 두 높이의 차가 1보다 크면 활주로 건설 불가능
					if (Math.abs(map[i][j] - height) > 1) {
						flag = false;
						break;
					} else if (Math.abs(map[i][j] - height) == 1) {
						// 큰 높이가 나올 경우
						if (map[i][j] > height) {
							if (x > i - idx) {
								flag = false;
								break;
							}
							//위치랑 높이 초기화
							idx = i;
							height = map[i][j];
							
						}
						// 작은 높이가 나올 경우
						else {
							int len = 1;
							height = map[i][j];
							idx = i+1;
							while (idx < N && map[idx][j] == height) {
								len++;
								idx++;
							}
							
							// 건설 가능 길이가 활주로 길이보다 짧은 경우 불가능
							if (len < x) {
//								System.out.println(i);
								flag = false;
								break;
							}
							//높이랑 위치 초기화
							i = idx-1;
							height = map[i][j];
						}
					}
					
				}
				if (flag)
					cnt2++;
			}
//			System.out.println(cnt1);
//			System.out.println(cnt2);
			System.out.println(cnt1+cnt2);

		}
	}
}
