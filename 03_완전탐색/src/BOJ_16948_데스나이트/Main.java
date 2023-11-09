package BOJ_16948_데스나이트;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N;
	static int[] dr = {-2, -2, 0, 0, 2, 2};
	static int[] dc = {-1, 1, -2, 2, -1, 1};
	static int [][] map, visited;
 	public static void main(String[] args) {
		
		//(5 ≤ N ≤ 200)
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		//체스판
		map = new int[N][N];
		//방문배열
		visited= new int[N][N];
		int startR = sc.nextInt();
		int startC = sc.nextInt();
		int endR = sc.nextInt();
		int endC = sc.nextInt();
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[]{startR, startC});//시작점 집어 넣기
		while(!queue.isEmpty()) {
			int[] pos = queue.poll();
			//6방향 탐색
			for(int d = 0; d<6; d++) {
				int nr = pos[0] + dr[d];
				int nc = pos[1] + dc[d];
				
				if(nr>=0 && nr<N && nc>=0 && nc<N) {
					int tmp = visited[pos[0]][pos[1]]+1;
					if(visited[nr][nc]==0 || visited[nr][nc] > tmp) {
						visited[nr][nc] = tmp;
						queue.add(new int[] {nr, nc});
					}
					
				}
			}
		}
		
		System.out.println(visited[endR][endC] > 0 ? visited[endR][endC] : -1);
		
	}
}
