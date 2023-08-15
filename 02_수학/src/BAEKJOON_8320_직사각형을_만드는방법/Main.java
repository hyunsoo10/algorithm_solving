package BAEKJOON_8320_직사각형을_만드는방법;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		//각 N개의 상자가 주어졌을 때의 가능한 상자 수를 담을 배열(1부터 시작하기 위해 N+1 크기로 배열 설정)
		int[] arr = new int[N+1];
		
		//배열의 총합 담을 변수(배열 요소의 총 합)
		int sum = 0;
		
		for(int i = 1; i <=N; i++) {
			//temp = 약수의 갯수
			int temp = 0;
			for(int j = 1; j <=N; j++) {
				//약수의 갯수 temp에 담기
				if(i%j==0)
					temp++;
			}
			//약수가 1개이거나 2개이면 만들 수 있는 직사각형은 1개뿐
			if(temp == 1 || temp == 2) {
				arr[i] = 1;
			}
			//약수가 3개 이상일 경우에 그 갯수가 홀수일 경우와 짝수일 경우를 나눠서 계산
			else {
				// 약수의 갯수가 홀수일 경우
				if(temp%2 == 0)
					arr[i] = temp/2;
				// 약수의 갯수가 짝수일 경우
				else
					arr[i] = (temp/2) +1;
			}
		}
		
		for(int i = 1; i<=N; i++) {
			sum += arr[i];
		}
		System.out.println(sum);
	}
}
