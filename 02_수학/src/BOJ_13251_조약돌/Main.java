package BAEKJOON_13251_조약돌;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int M = sc.nextInt(); // 조약돌 색상

		// 각 색상 갯수 받을 배열
		int[] arr = new int[M];
		int totalStone = 0;
		for (int i = 0; i < M; i++) {
			arr[i] = sc.nextInt();
			totalStone += arr[i];
		}

		// 뽑는 횟수
		int K = sc.nextInt();
		
		double answer = 0;
		
		for (int i = 0; i < M; i++) {
			double temp_answer = 1;
			if (arr[i] >= K) {
				// 하나씩 계산해줘야 값 오류가 안난다
				for (int j = 0; j < K; j++) {
					temp_answer *= (double)(arr[i]-j) / (totalStone-j);
				}
				answer += temp_answer;
			}
			

		}

		// 확률 담을 변수
	
		//M or K가 1이면 확률 1 고정
		if (M == 1 || K == 1) {
			System.out.println(1.0);
		} else {
			System.out.println(answer);
		}
	}


}
