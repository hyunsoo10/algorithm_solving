package BOJ_N과M.BOJ_15649_N과M1;

import java.util.Scanner;

public class Main {
	static int[] arr,sel;
	static boolean[] visited;
	static int N, M;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		arr = new int[N];
		visited = new boolean[N];
		sel = new int[M];
		
		for(int i=0, num=1; i<N; i++) {
			arr[i] = num++;
		}
		
		dfs(0);
	}
	static void dfs(int sidx) {
		//M개를 뽑았으면 return
		if(sidx == M) {
			for(int i=0; i<M; i++)
				System.out.print(sel[i]+" ");
			System.out.println();
			return;
		}
		
		//전체 싸이클은 N만큼 돌아야 됌
		for(int i=0; i<N; i++) {
			//아직 방문하지 않았다면 
			if(!visited[i]) {
				visited[i] = true;//방문 찍고
				sel[sidx] = arr[i];
				dfs(sidx+1);
				visited[i]=false;
			}
		}
		
	}
}
