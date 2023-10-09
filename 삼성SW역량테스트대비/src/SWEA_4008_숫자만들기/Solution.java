package SWEA_4008_숫자만들기;

import java.util.Scanner;

public class Solution {
	static int N, max, min;
	static int[] operation, nums;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		 //테스트케이스
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			
			//숫자의 개수
			N = sc.nextInt();
			//연산자 + - * / 순서
			operation = new int[4];
			for(int i=0; i<4; i++) operation[i] = sc.nextInt();
			
			//수식에 사용되는 숫자
			nums = new int[N];
			for(int i=0; i<N; i++) nums[i] = sc.nextInt();
			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
			dfs(nums[0], 0);
			
			System.out.printf("#%d %d\n",tc, max-min);
		}//end testCase
		
	}//end main
	
	//연산 수행할 dfs 메서드
	private static void dfs(int value, int idx) {
		//연산 모두 수행했다면
		if(idx == N-1) {
			//최대값 최소값 각각 갱신하고 리턴
			max = Math.max(max, value);
			min = Math.min(min, value);
			return;
		}
		
		//4개의 연산 작업
		if(operation[0] > 0) {
			operation[0]--;//연산자 사용
			dfs(value+nums[idx+1], idx+1); //dfs 재귀 호출
			operation[0]++;
		}
		if(operation[1] > 0) {
			operation[1]--;//연산자 사용
			dfs(value-nums[idx+1], idx+1); //dfs 재귀 호출
			operation[1]++;
		}
		if(operation[2] > 0) {
			operation[2]--;//연산자 사용
			dfs(value*nums[idx+1], idx+1); //dfs 재귀 호출
			operation[2]++;
		}
		if(operation[3] > 0) {
			operation[3]--;//연산자 사용
			dfs(value/nums[idx+1], idx+1); //dfs 재귀 호출
			operation[3]++;
		}
	}
	
}//end class
