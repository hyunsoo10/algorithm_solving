package BOJ_1940_주몽의명령;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//재료의 개수 N
		int N = sc.nextInt();
		//갑옷을 만드는 데 필요한 수 M
		int M = sc.nextInt();
		
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		int cnt = 0;//갑옷 만든 수
		
		
		for(int i=0; i<N; i++) {
			for(int j=i+1; j<N; j++) {
				if (arr[i] + arr[j] == M) {
					cnt++;//갑옷 수 증가
				}
			}
		}
		System.out.println(cnt);
	}
}
