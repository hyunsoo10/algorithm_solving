package BOJ_1003_피보나치함수;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//테스트 케이스
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			//피보나치로 구할 숫자 N
			int N = sc.nextInt();
			// 0 1 2 3 4 5 6
 			// 0 1 1 2 3 5 8

			//0과1의 숫자를 호출한 횟수를 담은 dp배열
			int[] dp0 = new int[N+1];
			int[] dp1 = new int[N+1];
			
			//초기값 세팅
			dp0[0] = 1;
			if(N >= 1) dp1[1] = 1;
			if(N >= 2) {
				dp1[2] = 1;
				dp0[2] = 1;
			}
			
			//3부터  dp배열에 담기
			for(int i=3;  i<= N; i++) {
				dp0[i] = dp0[i-1] + dp0[i-2]; 
				dp1[i] = dp1[i-1] + dp1[i-2]; 
			}
			
			System.out.printf("%d %d\n", dp0[N], dp1[N]);
			
			
		}//end testCase
		
		
	}
}