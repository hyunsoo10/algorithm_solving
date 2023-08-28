package BOJ_11659_구간합4;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); //N 개의 수
		int M = sc.nextInt(); //M개의 구간합
		
		int[] sumArr = new int [N+1];
		//구간합으로 배열 받기
		for(int i = 1; i <=N; i++) {
			sumArr[i] = sumArr[i-1] + sc.nextInt();
		}
		for(int i = 0; i < M; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			System.out.println(sumArr[end] - sumArr[start-1]);
		}
	}
}
