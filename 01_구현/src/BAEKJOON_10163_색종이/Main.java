package BAEKJOON_10163_색종이;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();// 종이 갯수

		int[][] paper = new int[1001][1001];

		for (int p = 1; p <= N; p++) {

			int x = sc.nextInt();
			int y = sc.nextInt();
			int xLen = sc.nextInt();
			int yLen = sc.nextInt();

			// 주어진 색종이 영역 채우기
			for (int i = x; i < x+ xLen; i++) {
				for (int j = y; j < y +yLen; j++) {
					paper[i][j] = p;
				}
			}
		}
		for (int p = 1; p <= N; p++) {
			int sum = 0;
			for (int i = 0; i < 1001; i++) {
				for (int j = 0; j < 1001; j++) {
					if(paper[i][j] == p) {
						sum++;
					}
				}
			}
			System.out.println(sum);
		}

	}
}
