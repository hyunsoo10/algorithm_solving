package BOJ_13458_시험감독;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//N개의 시험장 N(1 ≤ N ≤ 1,000,000)
		int N = sc.nextInt();
		//arr : 각 시험장에 있는 응시자의 수 Ai (1 ≤ Ai ≤ 1,000,000)
		int[] arr = new int[N];
		for(int i=0; i<N; i++) arr[i] = sc.nextInt();
		
		//B: 총감독관의 감시가능 응시자 수 
		//C: 부 감독관의 감시가능 응시자 수(1 ≤ B, C ≤ 1,000,000)
		int B = sc.nextInt();
		int C = sc.nextInt();
		
		//어차피 총 감독관은 방마다 1명 필요하므로 cnt는 N으로 초기화
		//감독관이 필요한 수는 int 자료형을 넘어갈 수 있으므로 long 자료형을 활용해야함
		long cnt = N;
		
		//1. 각 반의 응시자수에서 총감독관이 담당할 수 있는 응시자수 빼기
		for(int i=0; i<N; i++) {
			arr[i] = arr[i] - B;
		}
		
		//2. 남은 응시자수를 기준으로 필요한 부감독관 수 구하기
		for(int i=0; i<N; i++) {
			if(arr[i]<=0) continue;
			int a = arr[i]/C;
			int b = arr[i]%C;
			//나머지가 0일 경우
			if(b == 0) cnt += a;
			else cnt += a+1;
		}
		System.out.println(cnt);
	}
}
