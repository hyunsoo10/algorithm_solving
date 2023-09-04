package SWEA_2112_보호필름;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int D, W, K, ans;
	static int[][] film, newFilm;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 총 테스트 케이스
		for (int tc = 1; tc <= T; tc++) {
			D = sc.nextInt(); // D:두께
			W = sc.nextInt(); // W:가로크기
			K = sc.nextInt(); // K:합격기준

			film = new int[D][W];
			newFilm = new int[D][W];
			for (int i = 0; i < D; i++) {
				for (int j = 0; j < W; j++) {
					film[i][j] = sc.nextInt();					
					newFilm[i][j] = film[i][j];					
				}
			}
			ans = Integer.MAX_VALUE;

			// 합격 기준이 1일 경우에는 검사할 필요 없이 정답 0

			// 필름이 성능 검사를 바로 통과하면 ans = 0
			if (check())
				ans = 0;
			else {
				injection(0, 0);
			}

			System.out.printf("#%d %d\n", tc, ans);
		}
	}

	static void injection(int cnt, int row) {
		// 주입 해야하는 약의 개수가 이미 담긴 정답보다 높은 경우는 볼 것도 없음
		if (cnt >= ans) return;

		// 마지막 행 까지 검사했을 경우
		if (row == D) {
			if (check()) {
				// ans와 cnt중에 더 작은 값을 ans 에 담는다.
				ans = ans > cnt ? cnt : ans;
			}
			return;
		}

		// 주입 X
		injection(cnt, row + 1);
		// A주입
		for (int j = 0; j < W; j++)
			newFilm[row][j] = 0;
		injection(cnt + 1, row + 1);
		// B주입
		for (int j = 0; j < W; j++)
			newFilm[row][j] = 1;
		injection(cnt + 1, row + 1);
		// 되돌리기
		for (int j = 0; j < W; j++)
			newFilm[row][j] = film[row][j];
		injection(cnt + 1, row + 1);
	}

	static boolean check() {
		boolean[] pass = new boolean[W];
		for (int j = 0; j < W; j++) {
			// 연속 숫자 셀 임시 카운트 변수
			int cnt = 1;
			boolean flag = false;
			for (int i = 0; i < D - 1; i++) {
				// cnt == K를 만족하면 그 열은 성능 통과
				if (cnt == K) {
					flag = true;
					break;
				}
				// 다음 열과 동일할 경우 cnt 증가
				if (newFilm[i][j] == newFilm[i + 1][j]) {
					cnt++;
				} else
					cnt = 1;

				// 마지막 열 끝나고도 cnt == K 체크
				if (cnt == K)
					flag = true;
			} // 열 성능 검사 끝
			pass[j] = flag;
		}
		for (boolean tf : pass) {
			if (!tf)
				return false;
		}
		return true;
	}
}
