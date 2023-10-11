package BOJ_17086_아기상어2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class Main {
	//12시부터 시계방향
	static int[] dr = {-1 , -1, 0, 1, 1, 1, 0 ,-1};
	static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
	
	static int[][] map;
	static int N, M, max, min;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		map  = new int[N][M];

		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		max = Integer.MIN_VALUE;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == 0) {
					bfs(i, j);
					max = Math.max(min, max);
				}
			}
		}
		System.out.println(max);
	}
	private static void bfs(int row, int col) {
		//아기상어 좌표 넣을 큐
		Queue<int[]> queue = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];
		//초기 위치 넣고
		queue.add(new int[] {row, col, 0});
		//방문처리
		visited[row][col] = true;
		min = Integer.MAX_VALUE;
		while(!queue.isEmpty()) {
			int[] curr = queue.poll();
			int x = curr[0];
			int y = curr[1];
			int depth = curr[2];
//			System.out.print("값: "+ map[x][y]);
//			System.out.println("depth: "+depth);
			//다른 아기상어를 만나면 그 깊이를 통해  max값 업데이트
			if(depth!=0 && map[x][y]==1) {
				min = Math.min(min, depth);
				break;
			}
			//8방향 탐색
			for(int i=0; i<8; i++) {
				int nr = x + dr[i];
				int nc = y + dc[i];
				if(nr>=0 && nr<N && nc>=0 && nc<M && !visited[nr][nc]) {
					queue.add(new int[] {nr, nc, depth+1});
					visited[nr][nc] = true;
				}
			}
		}	
	}
}
