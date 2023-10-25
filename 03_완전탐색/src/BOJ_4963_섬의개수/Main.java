package BOJ_4963_섬의개수;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int h ,w, cnt;
	static int[][] map;
	static boolean [][] visited;
	static int [] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int [] dc = {0, 1, 1, 1, 0, -1, -1, -1,};
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			w = sc.nextInt();
			h = sc.nextInt();
			
			if(w==0 && h==0) break;
			
			map = new int[h][w];
			for(int i=0; i<h; i++) {
				for(int j=0; j<w; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			visited = new boolean[h][w];
			//개수 초기화
			cnt = 0;
			for(int i=0; i<h; i++) {
				for(int j=0; j<w; j++) {
					//방문 안했고 1이라면 탐색
					if(!visited[i][j] && map[i][j]==1) {
						dfs(i, j);
						cnt++;
					}
				}
			}//end for
			System.out.println(cnt);
		}
	}
	private static void dfs(int row, int col) {
		visited[row][col] = true;//방문 처리
		
		for(int d=0; d<8; d++) {
			int nr = row + dr[d];
			int nc = col + dc[d];
			
			if(nr>=0 && nr<h && nc>=0 && nc <w && !visited[nr][nc] && map[nr][nc]==1) {
				dfs(nr, nc);
			}
		}
	}
}
