package BOJ_1260_DFS와BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N, M, V;
	static boolean[] visited;
	static int[][] adjArr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		V = sc.nextInt();
		
		//연결 관계 표시
		adjArr = new int[N+1][N+1];
		for(int i=0; i<M; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			adjArr[x][y] = 1;
			adjArr[y][x] = 1;
		}
		visited = new boolean[N+1];
		dfs(V);
		System.out.println();
		visited = new boolean[N+1];
		bfs(V);
	}
	private static void bfs(int v) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(v);
		visited[v] = true;//방문처리
		
		while(!queue.isEmpty()) {
			int curr = queue.poll();
			System.out.print(curr+" ");
			for(int i=0; i<N+1; i++) {
				if(!visited[i] && adjArr[curr][i]==1) {
					queue.add(i);
					visited[i] = true;//방문처리
				}
			}
		}
	}
	//dfs
	private static void dfs(int v) {
		System.out.print(v+" ");
		visited[v] = true;//방문처리
		
		for(int i=0; i<N+1; i++) {
			if(!visited[i] && adjArr[v][i]==1) {
				dfs(i);
			}
		}
	}
	//
}
