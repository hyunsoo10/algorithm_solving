package BOJ_2133_타일채우기;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int dp[] = new int[N+1];
		
		//N이 홀수일 때는 항상 0 임
		//채울 수 있는 타일은 짝수 칸 만큼인데, N이 홀수이면 총 홀수 칸을 채워야 하므로 절대 채울 수 없다.

		//dp[0]=1로 초기화해서 이후 점화식에 사용하기 위함
		dp[0] = 1;
		//3*2 를 채울 수 있는 방법은 총 3가지
		if(N>=2) dp[2] = 3;
		
		//짝수 N만 검사하면 됨
		for(int i=4; i<=N; i+=2) {
			
			dp[i] = dp[i-2]*3;
			
			for(int j=i-4; j>=0; j--) dp[i] += dp[j]*2;

		}// end for
		System.out.println(dp[N]);
	}
}
