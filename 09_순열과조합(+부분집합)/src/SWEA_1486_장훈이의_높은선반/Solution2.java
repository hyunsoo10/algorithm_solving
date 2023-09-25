package SWEA_1486_장훈이의_높은선반;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution2 {
	static int N, B, minB;
	static int[] h;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for(int testCase=1; testCase <=TC; testCase++) {
			
			//구분자를 넣어줌으로써 연산을 줄일 수 있다.
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			//정원수 : N명 탑의 높이 : B
			N = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine(), " ");
			h = new int[N];
			for(int i=0; i < N; i++) {
				h[i] = Integer.parseInt(st.nextToken()); //점원의 키 1 <= h <= 10000
			}
			
			minB = Integer.MAX_VALUE; // 부분집합의 원소의 합이 B 이상인 최소값
			subset(0, 0);
			
			sb.append("#").append(testCase).append(" ").append(0).append("\n");
		}
		System.out.println(sb.toString());
	}

	/**직원들 키로 부분집합 구해서, 원소의 합이 B 이상인 최소값 구하는 메서드
	 * index : 각 단계 depth, sumH : 지금까지 선택된 직원들의 키의 합*/
	static void subset(int index, int sumH) {
		if(index == N) { //종료 파트
			if(sumH >= B && sumH < minB) {
				minB = sumH;
			}
			return;
		}
		//재귀 파트
		subset(index+1, sumH); // 선택을 안함
		subset(index+1, sumH+h[index]); // 선택을 함	
	}
}
