package SWEA_1859_백만장자;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			// N일
			int N = sc.nextInt();

			long ans = 0; // 최대 이익


			Deque<Integer> queue = new LinkedList<>();
			for (int i = 0; i < N; i++) {
				queue.addLast(sc.nextInt());
			}
			//queue가 빌 때 까지
			while (!queue.isEmpty()) {
				//최대값
				int max = getMax(queue);
				//매매 횟수
				int cnt = 0;
				//비용 담을 변수
				int cost = 0;
				while (true) {
					//큐에서 값 뽑기
					int tmp = queue.poll();
					//max값이면 반복문 탈출
					if (tmp == max)
						break;
					else {
						//뽑은 값 계속 cost에 더해주기
						cost += tmp;
						//매매횟수 증가
						cnt++;
					}
				}
				//최대값 * 매매횟수 - 총 구매 비용 계속 정답에 누적해주기
				ans += (max * cnt) - cost;
			}

			System.out.printf("#%d %d\n", tc, ans);
		}
	}

	public static int getMax(Deque<Integer> queue) {
		int max = 0;
		for (int a : queue) {
			if (max < a)
				max = a;
		}
		return max;
	}
}
