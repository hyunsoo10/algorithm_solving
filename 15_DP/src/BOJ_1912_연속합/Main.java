package BOJ_1912_연속합;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] nums = new int[N+1];
		
		for(int i=1; i<N+1; i++) nums[i] = sc.nextInt();
		
		//dp 배열
		int[] dp =new int[N+1];
		//1값 초기화
		dp[1] = nums[1];
		
		for(int i=2; i<N+1; i++) {
			//i-1번째 dp의 값이 음수이면 그 값을 더해줄 필요 없음
			if(dp[i-1] < 0) dp[i] = nums[i];
			//만약 그 다음 수를 더했는데 음수가 나오면 dp배열을 초기화할 필요 없음
			else if(nums[i] + dp[i-1] < 0) {
				dp[i] = nums[i];
			}else {
				dp[i] = dp[i-1] + nums[i];
			}
		}
		//음수 최대 값을 고려해서 dp[0]에 MIN_VALUE 넣어주기
		dp[0] = Integer.MIN_VALUE;
		Arrays.sort(dp);
		System.out.println(dp[N]);	
	}
}
