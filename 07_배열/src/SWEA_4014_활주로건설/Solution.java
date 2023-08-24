package SWEA_4014_활주로건설;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

//		int T = sc.nextInt();
		int T = 1;

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

			// 가로 탐색
			for (int i = 0; i < N; i++) {
				//해당 구역 활주로 건설 가능 여부(true로 초기화)
				boolean flag = true;
				// 해당 가로의 가장 첫번째 구역 높이
				int startHeight = map[i][0];
				for (int j = 1; j < N; j++) {
					// 첫번째 구역의 높이와 다른 구역이 나올 경우

					// 1. 더 큰 높이인 경우
					if (map[i][j] > startHeight) {
						// 두 높이 차이가 1보다 크면 건설 불가능
						if(map[i][j] - startHeight > 1) {
							flag = false;
							break;
						}
						//활주로 길이보다 더 짧은 경우
						if(x > j) {
							flag = false;
							break;
						}
					}
					// 2. 더 작은 높이인 경우
					else if(map[i][j] < startHeight) {
						
					}
				}
			}

		}
	}
}
