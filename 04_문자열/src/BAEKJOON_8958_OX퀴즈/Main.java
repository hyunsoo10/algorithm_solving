package BAEKJOON_8958_OX퀴즈;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 테스트 케이스 개수
		int N = sc.nextInt();

		int[] arr = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			//총 스코어 합 담을 변수
			int sum = 0;
			//스코어 누적합 변수
			int score = 1;
			String quiz = sc.next();
			//전체 문자열을 받아서 배열로 변경
			String[] temp = quiz.split("");
			//배열 탐색
			for(int j = 0; j<temp.length; j++) {
				//O일 경우
				if(temp[j].equals("O")) {
					//sum을 score의 누적합으로 갱신해주고, score에 +1(연속정답 고려)
					sum += score++;
				}
				//X가 나온 순간 score 누적합을 1로 갱신
				else {
					score = 1;
				}
			}
			arr[i] = sum;
		}
		for(int i = 1; i<=N; i++) {
			System.out.println(arr[i]);
		}
	}
}
