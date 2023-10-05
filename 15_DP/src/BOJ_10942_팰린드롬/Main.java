package BOJ_10942_팰린드롬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		//수열의 크기 N (1 ≤ N ≤ 2,000)
//		int N = sc.nextInt();
		int N = Integer.parseInt(br.readLine());
		
		//홍준이가 칠판에 적은 수 (100,000보다 작거나 같은 자연수)
		int[] nums = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=1; i<N+1; i++) nums[i] = Integer.parseInt(st.nextToken());
		
		//홍준이가 한 질문의 개수 M (1 ≤ M ≤ 1,000,000)
		int M = Integer.parseInt(br.readLine());
		
		//dp배열
		int[][] dp = new int[N+1][N+1];
		
		//1자리인 경우
		for(int i=0; i<N+1; i++) dp[i][i] = 1;
		
		//2자리일 경우
		for(int i=1; i<N; i++) {
			if(nums[i] == nums[i+1]) dp[i][i+1] = 1;
		}
		//3자리 이상일  경우
		for(int i=2; i<N; i++) {
			for(int j=1; j+i<=N; j++) {
				if(dp[j+1][j+i-1]==1 &&nums[j]==nums[j+i]) {
					dp[j][j+i] = 1;
				}
			}
		}//for문 끝
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			if(x==y) sb.append("1\n");
			else {
				sb.append(dp[x][y]+"\n");
			}
		}
		System.out.println(sb);
	}

}
