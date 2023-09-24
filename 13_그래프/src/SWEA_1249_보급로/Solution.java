package SWEA_1249_보급로;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
	static int N;
	static int[][] map, cost;
	
	//상하좌우 4방향 탐색
	static int [] dr = {-1,1,0,0};
	static int [] dc = {0,0,-1,1};
	static final int INF = Integer.MAX_VALUE;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			// N*N 맵
			N = sc.nextInt();
			map = new int[N][N];
			cost = new int[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) cost[i][j] = INF;
			}
			for(int i=0; i<N; i++) {
				String str = sc.next();
				for(int j=0; j<N; j++) {
					map[i][j] = str.charAt(j)-'0';
				}
			}

			PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
				
				public int compare(int[] o1, int[] o2) {
					return o1[2] - o2[2];
				}
			});
			
			//초기 값 세팅
			pq.add(new int[] {0, 0, map[0][0]});
			
			while(!pq.isEmpty()) {
				int[] pos = pq.poll(); //cost가 가장 적은 정보 가져오기
				
				for(int i=0; i<4; i++) {
					//해당 좌표에서 갈 수 있는 4가지 좌표
					int nr = pos[0] + dr[i];
					int nc = pos[1] + dc[i];
					
					//1. 범위 쳌
					if(nr>=0&&nr<N && nc>=0 && nc<N) {
						//이전 위치 + 가고자 하는 위치에 대한 비용을 합쳐서 tmpCost에 담는다
						int tmpCost = map[nr][nc] + pos[2];
						if(tmpCost < cost[nr][nc]) {
							cost[nr][nc] = tmpCost;
							pq.add(new int[] {nr, nc, tmpCost});
						}
					}
				}
				
				if(pos[0] == N-1 && pos[1]==N-1) break;
			}
			System.out.printf("#%d %d\n", tc, cost[N-1][N-1]);
		}// end testCase
	}
}
