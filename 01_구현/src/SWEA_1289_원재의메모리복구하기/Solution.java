package SWEA_1289_원재의메모리복구하기;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int ans = 0;
			String input = sc.next();


			int[] original = new int[input.length()];// 만들어야 하는 메모리 정보
			int[] memory = new int[input.length()];// 초기화 상태 메모리
			for (int i = 0; i < input.length(); i++) {
				original[i] = input.charAt(i) - '0';
			}

			// 메모리 1 위치를 만났는데, 내 현재 메모리 상태가 0이면 바꿔줘야 한다.
			for (int i = 0; i < memory.length; i++) {
				if (memory[i] == 0 && original[i] == 1) {
					int idx = i;
					while (idx < memory.length) {
						memory[idx++] = 1;
					}
					ans++; // 횟수 추가
					// 같으면 반복문 탈출
					if (memory.equals(original)) {
						break;
					}
				}
				// 원래의 메모리 정보가 0인곳은 다시 0으로 바꿔줘야 한다.
				else if (memory[i] == 1 && original[i] == 0) {
					int idx = i;
					while (idx < memory.length) {
						memory[idx++] = 0;
					}
					ans++; // 횟수 추가
					//같으면 반복문 탈출
					if (memory.equals(original)) {
						break;
					}
				}
			}

			System.out.printf("#%d %d\n", tc, ans);
		}
	}
}
