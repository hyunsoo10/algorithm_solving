package BOJ_N과M.BOJ_15650_N과M2;

import java.util.Scanner;

public class Main {
	static int[] arr,sel;
	static boolean[] visited;
	static int N, M;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		arr = new int[N];
		sel = new int[M];
		visited = new boolean[N];
		
		for(int i=0, num=1; i<N; i++) {
			arr[i] = num++;
		}
		
		dfs(0, 0);
		System.out.println(sb);
	}
	static void dfs(int sidx, int idx) {
		//M개를 뽑았으면 return
		if(sidx == M) {
			for(int i=0; i<M; i++)
				sb.append(sel[i]+" ");
			sb.append("\n");
			return;
		}
		
		//전체 싸이클은 N만큼 돌아야 됌
		for(int i=idx; i<N; i++) {
			if(!visited[i]) {
				sel[sidx] = arr[i];
				dfs(sidx+1, idx);
				visited[i] = false;
				idx++;
			}
		}
		
	}
}
