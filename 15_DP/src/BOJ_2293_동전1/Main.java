package BOJ_2293_동전1;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//n가지 종류의 동전으로 k원 만들기
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] coins = new int[n+1];
		for(int i=1; i<n+1; i++) coins[i] = sc.nextInt();
		
		//경우의 수는 2의 31제곱보다 작으므로 int자료형으로 담을 수 있다.
		int[] dp = new int[k+1];
		
		//첫번째 코인부터 사용하면서 dp배열 갱신
		for(int i=1; i<n+1 ;i++) {
			for(int j=1; j<k+1; j++) {
				//해당 동전을 사용하지 않고 만들었던 경우의 수를 그대로 가져와야 하기때문에 dp배열에 누적
				//1. 해당 코인으로만 만들 수 있는 경우가 처음 생기면 +1
				if(j == coins[i]) dp[j] ++;
				//2. 그 이후 해당 코인으로 만들 수 있는 경우라면, 이전 인덱스 정보를 활용해서 dp[j]에 값 추가시켜주기
				if(j>coins[i]) {
					dp[j] += dp[j-coins[i]];
				}
			}
		}
		System.out.println(dp[k]);
	}
}
