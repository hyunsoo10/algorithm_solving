package SWEA_4193_수영대회결승전;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int N;
	static int[][]map;
	//우 하 좌 상 방향
	static int d[][] = {{0,1}, {1,0},{0,-1},{-1,0}};
	static int startX, startY, endX, endY;
	public static void main(String[] args) {
		//섬 : 1
		//소용돌이 : 2 - 2초동안 유지, 1초 동안 잠잠
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			N = sc.nextInt(); //N*N 맵
			map = new int[N][N];
			startX = sc.nextInt();
			startY = sc.nextInt();
			endX = sc.nextInt();
			endY = sc.nextInt();
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			bfs(startX, startY);
		}
	}
	
	//bfs
	static void bfs(int row, int col) {
		
		//4방향 검사
		for(int i=0; i<4; i++) {
			//nr, nc방향 이동
			int nr = row + d[i][0];
			int nc = row + d[i][1];
			//범위 내에 있으면
			if(nr>=0 && nr<N && nc>=0 && nc<N) {
				
			}
		}
	}
}
