package BOJ_1240_노드사이의거리;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N, M, dis;
	static int[][] adjArr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		adjArr= new int[N+1][N+1];
		
		for(int i=0; i<N-1; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int w = sc.nextInt();
			
			//가중치 저장
			adjArr[x][y] = w;
			adjArr[y][x] = w;
		}
		for(int i=0; i<M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			dis = 0;
			dfs(a, b,  0, 0);
			System.out.println(dis);
		}
		
	}
	private static void dfs(int curr, int end, int distance, int prev) {
		if(curr == end) {
			dis = distance;
			return;
		}
		for(int i=1; i<=N; i++) {
			if(adjArr[curr][i] > 0 && i!=prev) {
				dfs(i, end, distance+adjArr[curr][i], curr);
				
			}
		}
	}
}
