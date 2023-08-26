package SWEA_2115_벌꿀채취;

import java.util.Scanner;

public class Solution {
	static int N, M, C;
	static int[][] honey;
	static int[][] honeyProfit;
	static int max;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			N = sc.nextInt(); //N*N 벌통
			M = sc.nextInt(); //선택할 수 있는 벌통의 개수 M
			C = sc.nextInt(); //꿀을 채취할 수 있는 최대 양 C
			
			honey = new int[N][N]; // 꿀 양
			honeyProfit = new int[N][N]; // 꿀 수익

			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					honey[i][j] = sc.nextInt();
					honeyProfit[i][j] = honey[i][j]*honey[i][j];
				}
			}
			
			int answer = 0;
			//N개에서 M개의 범위 를 뽑는다
			//ex.(0,2) -> 범위 3의 부분집합
			for(int i=0; i<N; i++) {
				//1번 일꾼의 최대 수익 구하기
				for(int x=0; x<=N-M; x++) {

					max = Integer.MIN_VALUE;
					combo(x, x+M-1, i);

					int max1 = max;// 1번 일꾼 최대 값
					
					//2번 일꾼 같은행
					max = Integer.MIN_VALUE;
					for(int y=x+M; y<=N-M; y++) {
						combo(y, y+M-1, i);

					}
					answer = Math.max(answer, max1+max);
					//2번 일꾼 다른 행
					max = Integer.MIN_VALUE;
					for(int y=0; y<=N-M; y++) {
						for(int k=i+1; k<N; k++) {
							combo(y, y+M-1, k);
						
						}
					}
					//1번 일꾼 + 2번 일꾼 합친 최대값 갱신
					answer = Math.max(answer, max1+max);
		
				}
			}
			System.out.printf("#%d %d\n", tc, answer);

		}
	}
	
	static void combo(int x, int y, int row) {
		//전체 집합의 원소 담을 배열
		int[] arr = new int[M];
		//방문 여부 체크 배열
		boolean[] visited = new boolean[M];
		for(int i=x, idx=0; i<=y; i++, idx++) {
			arr[idx] = i;
		}
		powerSet(arr, visited, 0, row);
	}
	
	static void powerSet(int[] arr, boolean[] visited, int idx, int row) {
		if(idx == M) {
		
			int tmp=0;
			int tmpProfit=0;
			for(int i=0; i<M; i++) {
				//부분집합 찍기
				//부분집합으로 구한 집합의 꿀의 양 더하기
				if(visited[i]) {

					tmp += honey[row][arr[i]];
					tmpProfit += honeyProfit[row][arr[i]];
				}
				
				//만약 그 꿀의 양이 C 이하라면 수익의 최대 값 갱신
				if(tmp <= C) {
					max= Math.max(max, tmpProfit);
				}

			}
			return;
		}
		visited[idx] = true;
		powerSet(arr, visited, idx+1, row);
		visited[idx] = false;
		powerSet(arr, visited, idx+1, row);
		
	}
}
