import java.util.Scanner;

public class BAEKJOON_2839 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();// 봉지의 개수

		int[] dp = new int[N + 1]; // N까지의 최소 봉지의 개수를 담을 배열

		// 1~3인덱스 초기화
		dp[1] = 0;
		dp[2] = 0;
		dp[3] = 1;

		for (int i = 4; i <= N; i++) {
			//4일 때는 0
			if (i == 4) {
				dp[i] = 0;
			}//5일 때는 1
			else if(i==5){
				dp[i] = 1;
			}//6이상의 경우는 5와3을 뺀 인덱스의 값이 0이 아닐 경우에 1을 더해줘서 값을 비교하는 식으로 진행
			else {
				int tmp1 = 0;
				int tmp2 = 0;
				if (dp[i - 5] != 0) {
					tmp1 = 1 + dp[i - 5];
				}
				if (dp[i - 3] != 0) {
					tmp2 = 1 + dp[i - 3];
				}

				if (tmp1 == 0 || tmp2 == 0) {
					dp[i] = Math.max(tmp1, tmp2);

				} else {
					dp[i] = Math.min(tmp1, tmp2);
				}

			}
		}
		if(dp[N]==0)
			System.out.println(-1);
		else
			System.out.println(dp[N]);
	}
}

