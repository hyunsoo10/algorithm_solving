package BOJ_2644_촌수계산;

import java.util.Scanner;

public class Main {
	static int N, A, B, cnt;
	static boolean[] visited;
	static int[][] relation;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//전체 사람의 수 1 ≤ N ≤ 100
		N = sc.nextInt();
		//촌수를 구해야되는 두 사람
		A = sc.nextInt();
		B = sc.nextInt();
		
		//관계의 개수
		int m = sc.nextInt();
		
		//관계 표현할 인접 배열
		relation = new int[101][101];
		
		for(int i=0; i<m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			//관계가 있다면 서로 1표시
			relation[x][y] = 1;
			relation[y][x] = 1;
		}
		
		//dfs할때 방문 체크할 배열
		visited = new boolean[101];
		//촌수 변수 초기화
		cnt = 0;
		dfs(A, 0);
		System.out.println(cnt==0 ? -1 : cnt);
	}
	static void dfs(int start, int depth) {
		visited[start] = true;
		//end와의 관계를 찾았을 때의 depth가 곧 촌수임
		if(start == B) {
			cnt = depth;
			return;
		}
		for(int i=1; i<=N; i++) {
			if(relation[start][i]==1 && !visited[i]) dfs(i, depth+1);
		}
	}
}
