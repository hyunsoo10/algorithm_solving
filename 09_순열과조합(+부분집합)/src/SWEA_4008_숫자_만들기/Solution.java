package SWEA_4008_숫자_만들기;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int[] cal, nums;
	static char[] operator;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 테스트 케이스

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			cal = new int[4];
			nums = new int[N];
			operator = new char[N - 1];
			// 연산자 개수 넣어주기
			for (int i = 0; i < 4; i++)
				cal[i] = sc.nextInt();
			int idx=0;
			//연산자 넣어주기
			for (int i = 0; i < cal[0]; i++) {
				operator[idx++] = '+';
			}
			for (int i = 0; i < cal[1]; i++) {
				operator[idx++] = '-';
			}
			for (int i = 0; i < cal[2]; i++) {
				operator[idx++] = '*';
			}
			for (int i = 0; i < cal[3]; i++) {
				operator[idx++] = '/';
			}

			// 수식에 사용될 숫자 넣어주기
			for (int i = 0; i < N; i++) nums[i] = sc.nextInt();
			
			System.out.println(Arrays.toString(nums));
			System.out.println(Arrays.toString(operator));

		}

	}
}
