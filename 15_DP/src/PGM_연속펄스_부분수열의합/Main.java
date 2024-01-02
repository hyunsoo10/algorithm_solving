package PGM_연속펄스_부분수열의합;

public class Main {
	public static void main(String[] args) {
		int[] seq = {2, 3, -6, 1, 3, -1, 2, 4};
		long ans = solution(seq);
		System.out.println(ans);
	}
    public static long solution(int[] sequence) {
        long answer = 0;
        
        int n = sequence.length; 
        //dp[i][k] : i번째 원소를 마지막으로 하는 부분수열의 최대합 저장 dp 배열
        //k=0 : i번째 양수, k=1  : i번째 음수
        long[][] dp = new long[n][2];
        
        dp[0][0] = sequence[0];
        dp[0][1] = -sequence[0];
        
        long max = Long.MIN_VALUE;
        max = Math.max(dp[0][0], dp[0][1]);
        
        for(int i=1; i<n; i++){
            dp[i][0] = Math.max(sequence[i], dp[i-1][1] + sequence[i]);
            dp[i][1] = Math.max(-sequence[i], dp[i-1][0] - sequence[i]);
            
            max = Math.max(dp[i][0], max);
            max = Math.max(dp[i][1], max);
        }
        
        answer = max;
        return answer;
    }
}
