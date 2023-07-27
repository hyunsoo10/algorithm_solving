import java.util.Scanner;

public class BAEKJOON_2477 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();// 1단위당 자라는 참외의 개수

		int[][] k_melon = new int[6][2];
		int[] info = new int[5];

		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 2; j++) {
				k_melon[i][j] = sc.nextInt();
			}
		}
		int big_square = 1;

		// info 리스트의 인덱스의 요소가 의미하는 것은 그 인덱스의 방향이 몇번 나왔는지
		for (int i = 0; i < 6; i++) {
			info[k_melon[i][0]]++;
		}
		for (int i = 0; i < 6; i++) {
			if (info[k_melon[i][0]] == 1) {
				big_square *= k_melon[i][1];
			}
		}

		int small_square = 1;

		for (int i = 0; i < 6; i++) {

			if (k_melon[i][0] == k_melon[(i + 2) % 6][0]) {
				small_square *= k_melon[(i + 1) % 6][1];
			}

		}
		int result = (big_square - small_square) * N;
		System.out.println(result);

	}
}
