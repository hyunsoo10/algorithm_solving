package BOJ_10986_나머지합;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt(); //구간합을 나눌 숫자
		
		long answer = 0; //정답 담을 변수
		
		long[] arr = new long[N];
		
		for(int i = 0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		//구간합 만들기
		for(int i=1; i<N; i++) {
			arr[i]+=arr[i-1];
		}
		
		long[] C = new long[M];//나머지 갯수 카운팅할 배열
		
		//구간합을 M으로 나눈 값으로 바꾸기
		//바꾸면서 나머지가 0이면 answer에 카운팅
		for(int i=0; i<N; i++) {
			arr[i] %= M;
			C[(int)arr[i]]++;
			if(arr[i]==0)
				answer++;
		}
		//2. 구간합 나머지가 같은 인덱스 조합 2개 뽑기
		for(int i = 0; i<M; i++) {
			if(C[i]>1)
				answer += (C[i]*(C[i]-1))/2;
		}
		System.out.println(answer);
		
	}
}
