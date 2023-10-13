package BOJ_16234_인구이동;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	static int N,L,R;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		L = sc.nextInt();
		R = sc.nextInt();
		
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		int ans =0; //정답 변수
		
		while(true) {
			visited = new boolean[N][N];
			int cnt = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(!visited[i][j])
						if(bfs(i, j)) {
							cnt ++;
						}
				}
			}
			//인구이동 가능한 상태가 아니라면 while문 종료하고 ans 출력
			if(cnt == 0) break;
			ans++;//일 수 증가
		}
		System.out.println(ans);
	}
	private static boolean bfs(int row, int col) {
		visited[row][col] = true;
		Queue<int[]> queue = new LinkedList<>();
		Stack<int[]> stack = new Stack<>();
		queue.add(new int[] {row, col});
		stack.push(new int[] {row, col});
		int cnt = 1;
		int sum = map[row][col];
		
		while(!queue.isEmpty()) {
			int[] pos = queue.poll();
			for(int d=0; d<4; d++) {
				int nr = pos[0] + dr[d];
				int nc = pos[1] + dc[d];
				
				if(nr>=0 && nr<N && nc>=0 && nc<N && !visited[nr][nc]) {
					int tmp = Math.abs(map[pos[0]][pos[1]] - map[nr][nc]);
					if(tmp>=L && tmp<=R) {
						queue.add(new int[] {nr,nc});
						stack.push(new int[] {nr,nc});
						visited[nr][nc] = true;
						cnt++;
						sum += map[nr][nc];
					}
				}
			}
		}
		//인구이동이 일어났으면 이동 시켜줭
		if(cnt > 1) {
			while(!stack.isEmpty()) {
				int[] xy = stack.pop();
				map[xy[0]][xy[1]] = sum/cnt;
			}
			return true;
		}
		visited[row][col] = false;
		return false;
	}
}
