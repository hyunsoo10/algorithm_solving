package BAEKJOON_3985_롤케이크;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 롤 케이크 길이
		int L = sc.nextInt();

		// 방청객의 수
		int N = sc.nextInt();

		// 롤 케이크 배열
		int[] cakes = new int[L + 1];

		// 방청객들 롤케이크 정보 담을 HashMap

		Map<Integer, int[]> map = new HashMap<>();

		for (int i = 1; i <= N; i++) {
			int[] arr = new int[3];
			arr[0] = sc.nextInt();
			arr[1] = sc.nextInt();
			arr[2] = arr[1] - arr[0]; //원하는 케익 갯수
			map.put(i, arr);
		}

		// 가장 많이 받을 것으로 기대한 방청객
		int answer1 = 0;
		int max = 0;

		//map.get(i)[2]에 예상 케익 갯수가 담겨 있으므로, 그 값이 최대인 값이 answer1
		//1번부터 탐색하고, 같은 경우에는 값을 변경하지 않기 때문에, 작은 번호의 방청객이 출력
		for (int i = 1; i <= N; i++) {
			if (map.get(i)[2] > max) {
				max = map.get(i)[2];
				answer1 = i;
			}
		}

		// 롤케이크 분배
		for (int i = 1; i <= N; i++) {
			for (int j = map.get(i)[0]; j <= map.get(i)[1]; j++) {
				if (cakes[j] == 0)
					cakes[j] = i;
			}
		}
		int answer2 = 0;
		int maxSum = 0;
		//실질적으로 케이크 분배 받은 정보 탐색
		for (int i = 1; i <= N; i++) {
			int cnt = 0;
			//분배 받은 방청객 수 구하기
			for (int j = 1; j < L; j++) {
				if (cakes[j] == i)
					cnt++;
			}
			//많이 받은 갯수와 그 방청객 정보 업데이트
			if (cnt > maxSum) {
				maxSum = cnt;
				answer2 = i;
			}
		}
		System.out.println(answer1);
		System.out.println(answer2);

	}
}
