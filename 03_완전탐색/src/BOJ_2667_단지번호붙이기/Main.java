package BOJ_2667_단지번호붙이기;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static int N, total, cnt;
	static char[][] map;
	static int[][] visited;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		map = new char[N][N];
		visited = new int[N][N];
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for(int i=0; i<N; i++) {
			map[i] = sc.next().toCharArray();
		}
		
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				//방문안하고, 아파트가 있으면 단지 쳌
				if(visited[i][j]==0&&map[i][j]=='1') {
					cnt=0;
					dfs(i, j);
					pq.add(cnt);
					total++;//단지수 증가
				}
			}
		}
		
		System.out.println(total);
		while(!pq.isEmpty()) {
			System.out.println(pq.poll());
		}
		
	}
	static void dfs(int row, int col) {
		visited[row][col] = 1;
		cnt++;
		for(int i=0; i<4; i++) {
			int nr = row + dr[i];
			int nc = col + dc[i];
			
			if(nr>=0 && nr<N && nc>=0 && nc<N && visited[nr][nc]==0 && map[nr][nc]=='1') {
				dfs(nr, nc);
			}
		}
	}
}
