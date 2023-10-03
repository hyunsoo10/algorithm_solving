package BOJ_2565_전깃줄;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//전깃줄의 개수
		int N = sc .nextInt();
		
		//전깃줄 정보 입력
		int[][] line = new int[N+1][2];
		for(int i=1; i<N+1; i++) {
			line[i][0] = sc.nextInt();
			line[i][1] = sc.nextInt();
		}
		
		//최소 철거 개수는 전체 전깃줄 개수에서 교차하지 않고 설치할 수 있는 최대 전깃줄 개수를 빼는 것과 동일
		//최대 전깃줄 설치 개수를 저장할  dp 배열
		int[] dp = new int[N+1];
		
		//LIS 알고리즘을 사용하기 위한 오름차순 정렬
		Arrays.sort(line, new Comparator<int[]>() {

			//A 전봇대 번호 기준으로 오름차순
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
			
		});
		
		//LIS 알고리즘으로 최대 전깃줄 개수 구하기
		int max = 1;
		for(int i=1; i<N+1; i++) {
			//일단 해당 전깃줄 하나는 무조건 설치할 수 있으므로 1로 초기화해서 비교 시작
			dp[i] = 1;
			for(int j=0; j<i; j++) {
				//이미 설치된 전깃줄들과 교차하지 않은 전깃줄 설치 방법 최대 값 갱신
				if(line[i][1] > line[j][1]) {
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
			}
			//정답 최대값 갱신
			max = Math.max(dp[i], max);
		}
		
		System.out.println(N-max);
	}
}
