package BOJ_11724_연결요소의개수;

import java.util.Scanner;

public class Main {
	static int N, M, cnt;
	static int[][] adjArr;
	static boolean [] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		adjArr = new int[N+1][N+1];
		for(int i=0; i<M; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			//인접 쳌
			adjArr[x][y] =1;
			adjArr[y][x] =1;
		}
		
		cnt = 0;
		visited = new boolean[N+1];
		for(int i=1; i<N+1; i++) {
			//방문 안했으면 dfs 고
			if(!visited[i]) {
				dfs(i);
				cnt++;
			}
		}
		System.out.println(cnt);
		
	}
	private static void dfs(int v) {
		visited[v] = true;
		for(int i=1; i<N+1; i++) {
			if(adjArr[v][i] == 1 && !visited[i]) dfs(i); 
		}
	}
}

