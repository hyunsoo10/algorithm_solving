package SWEA_4008_숫자_만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int N;
	static int[] num, op;
	static int max, min;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine()); //숫자의 개수 N은 3이상12이하의 정수(3<=N<=12)
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");//+-*/개수
			
			op = new int[4]; //연산자의 개수
			
			op[0] = Integer.parseInt(st.nextToken());
			op[1] = Integer.parseInt(st.nextToken());
			op[2] = Integer.parseInt(st.nextToken());
			op[3] = Integer.parseInt(st.nextToken());
			
			num = new int[N]; //입력 숫자
			st = new StringTokenizer(br.readLine(), " ");
			for(int i=0; i<N; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}
			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
			
			//첫번째 값 들고 시작
			dfs(1, num[0]);
			
			
			

			sb.append("#").append(tc).append(" ").append(max - min).append("\n");
		} // end of testCase
		System.out.println(sb.toString());

	} // end of main
	
	/** step : 현재 단계, val: 지금까지 결정된 연산자로 계산한 결과를 매개변수로 가지고 다니자
	 * 연산자의 순서를 바꿔서 순열을 만들어주는 메서드 */
	static void dfs(int step, int val) {
		if(step == N) { //종료 파트
			//최대 최소 업데이트
			if(max < val) max = val;
			if(min > val) min = val;
			return;
		}
		//재귀 파트
		
//		for(int i=0; i<op.length; i++) {
//			if(op[i] > 0) {
//				op[i]--;
//				switch (i) {
//				case 0:dfs(step+1, val + num[step]); break;
//				case 1:dfs(step+1, val - num[step]); break;
//				case 2:dfs(step+1, val * num[step]); break;
//				case 3:dfs(step+1, val / num[step]); break;
//				}
//
//				op[i]++;
//			}
//		}
		
		//이렇게 풀어서 쓰는게 더 빠르긴 함
		if(op[0]>0) {
			op[0]--;
			dfs(step+1, val + num[step]); // +	
			op[0]++;
		} 
		if(op[1]>0) {
			op[1]--;
			dfs(step+1, val - num[step]); // -
			op[1]++;
		} 
		if(op[2]>0) {
			op[2]--;
			dfs(step+1, val * num[step]); // *
			op[2]++;
		} 
		if(op[3]>0) {
			op[3]--;
			dfs(step+1, val / num[step]); // 나눗셈
			op[3]++;
		} 
		

	}
}
