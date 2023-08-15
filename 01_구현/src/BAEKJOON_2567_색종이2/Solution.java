package BAEKJOON_2567_색종이2;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 색종이 갯수

		int[][] paper = new int[101][101];

		for (int t = 0; t < N; t++) {
			int x = sc.nextInt();
			int y = sc.nextInt();

			// 색종이 영역 1로 채우기
			for (int i = x; i < x + 10; i++) {
				for (int j = y; j < y + 10; j++) {
					paper[i][j] = 1;
				}
			}

		}


		// 상우하좌 탐색
		int[] dr = { -1, 0, 1, 0 };
		int[] dc = { 0, 1, 0, -1 };

		int answer = 0;

		// paper 전체 탐색
		for (int i = 0; i <= 100; i++) {
			for (int j = 0; j <= 100; j++) {
				for (int k = 0; k < 4; k++) {
					if ((i + dr[k] > 0) && (i + dr[k] <= 100) && (j + dc[k] > 0) && (j + dc[k] <= 100)) {
						if(paper[i][j]==0)
							answer += paper[i + dr[k]][j + dc[k]];
					}
				}
			}
		}
		System.out.println(answer);
	}
}
