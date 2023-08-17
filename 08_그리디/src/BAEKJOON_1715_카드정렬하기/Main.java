package BAEKJOON_1715_카드정렬하기;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		// 우선순위 큐 사용
		PriorityQueue<Integer> pQueue = new PriorityQueue<>();

		// 정렬하며 우선순위큐에 쌓기
		for (int i = 0; i < N; i++) {
			pQueue.add(sc.nextInt());
		}
		int sum = 0;
		while (pQueue.size() > 1) {
			int tmp1 = pQueue.poll();
			int tmp2 = pQueue.poll();
			sum += (tmp1 + tmp2);
			pQueue.add(tmp1+tmp2);
		}
		System.out.println(sum);
		sc.close();
	}
}
