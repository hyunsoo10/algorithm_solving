package SWEA_2115_벌꿀채취;

import java.util.Arrays;
import java.util.Scanner;

public class Solution2 {
	static int N, M, C;
	static int[][] honey;
	static int[][] honeyProfit;
	static int ans, max1, max2;

	public static void main(String[] args) {
		Scanner sc = new Scanner(input);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt(); // N*N 벌통
			M = sc.nextInt(); // 선택할 수 있는 벌통의 개수 M
			C = sc.nextInt(); // 꿀을 채취할 수 있는 최대 양 C

			honey = new int[N][N]; // 꿀 양

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					honey[i][j] = sc.nextInt();
				}
			}//벌통 입력 끝
			
			//전체 행 싸이클
			for(int i=0; i<N; i++) {
				
				//1번 일꾼의 수익
				for(int x=0; x<=N-M; x++) {
					int start = x;
					int end = x+M-1;
					ans = Integer.MIN_VALUE;
					max1 = getHoney(start, end, i);
					//같은 행의 2번 일꾼
					for(int y=x+M; y<=N-M; y++) {
						max2= getHoney(y, y+M-1, i);
					}
					//최대값 갱신
					ans = Math.max(ans, max1+max2);
					
					//다른 행 2번 일꾼
					for(int y=0; y<=N-M; y++) {
						for(int k=i+1; k<N; k++) {
							max2 = getHoney(y, y+M-1, k);
						}
					}
					//다른 행 2번 일꾼 까지 다 돌고 최대값 한번 더 갱신
					ans = Math.max(ans, max1+max2);
				}	
			}
			System.out.println(Arrays.deepToString(honey));
		}
	}
	static int getHoney(int start, int end, int i) {
		int[] arr = new int[M];
		int[][] dp = new int[M+1][C+1];
		for(int idx=0; idx<M; idx++) {
			arr[idx] = start++;
		}

	}
	static String input="1\r\n" + 
			"4 2 13\r\n" + 
			"6 1 9 7    \r\n" + 
			"9 8 5 8\r\n" + 
			"3 4 5 3\r\n" + 
			"8 2 6 7";
}
