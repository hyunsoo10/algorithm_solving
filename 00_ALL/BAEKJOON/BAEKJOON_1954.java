import java.util.Scanner;
import java.io.FileInputStream;


class BAEKJOON_1954 {
	public static void main(String args[]) throws Exception {

		System.setIn(new FileInputStream("/swea_1954.txt"));

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {

			int N = sc.nextInt();
			int[][] snail = new int[N][N];

			int x = 0; // x축 좌표
			int y = 0; // y축 좌표
			int num = 1; // start 숫자
			int f = N;

			for (int i = 0; i < 2 * N - 1; i++) {
				switch (i % 4) {
				case 0: // right way
					for (int k = 0; k < f; k++) {
						snail[y][x++] = num++;
					}
					x--;// 마지막에 플러스 된 x축 다시 원상복귀
					y++;// y축 하나 위로
					f--; // 최대 갈 수 있는거리 -1
					break;
				case 1: // under way
					for (int k = 0; k < f; k++) {
						snail[y++][x] = num++;
					}
					y--; // 마지막에 내려간 y축 다시 원상복귀
					x--; // x축 하나 왼쪽으로
					break;
				case 2: // left way
					for (int k = 0; k < f; k++) {
						snail[y][x--] = num++;
					}
					x++;// x축 다시 원상복귀
					y--;// y축 하나 위로 올리기

					f--;// 최대 갈수 있는거리 -1
					break;
				case 3: // up way
					for (int k = 0; k < f; k++) {
						snail[y--][x] = num++;
					}
					y++; // y원상복귀
					x++; // x축 오른쪽으로 - > right way 준비
					break;
				}
			}

			System.out.printf("#%d", test_case);
			System.out.println();

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(snail[i][j] + " ");
				}
				System.out.println();
			}
		}
	}
}