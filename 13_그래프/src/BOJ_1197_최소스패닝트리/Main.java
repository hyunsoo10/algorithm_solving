package BOJ_1197_최소스패닝트리;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	static int V, E;
	static int[] p;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		V = sc.nextInt();
		E = sc.nextInt();
		
		//대표자 배열 생성
		p = new int[V+1];
		for(int i=1; i<=V; i++) p[i] = i;
		
		
		int[][] edges = new int[E][3];
		
		//간선 배열 입력 받기
		for(int i=0; i<E; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int W = sc.nextInt();
			edges[i][0] = A;
			edges[i][1] = B;
			edges[i][2] = W;
		}
		
		//1. 가중치 기준으로 오름차순 정렬
		Arrays.sort(edges, new Comparator<int[]>() {
			public int compare(int[]o1, int[]o2) {
				return o1[2] - o2[2];
			}
		});
		
		int ans = 0;//정답 담을 변수
		int pick = 0; //간선 뽑은 횟수 담을 변수
		
		//2. 간선 정보 완전 탐색
		for(int i=0; i<E; i++) {
			//(1)각 정점의 대표자들 정보 불러와
			int px = findset(edges[i][0]);
			int py = findset(edges[i][1]);
			
			//(2)싸이클 확인해
			if(px != py) {
				//싸이클이 없다면 그 간선 뽑아
				union(px, py);
				//가중치 더해
				ans += edges[i][2];
				
			}
			//(3)간선 다 뽑았으면 끝내
			if(pick == V-1) break;
		}
		System.out.println(ans);
		
	}
	//대표자 찾기
	static int findset(int x) {
		if(p[x] != x) return p[x] = findset(p[x]);
		return p[x];
	}
	//합치기
	static void union(int px, int py) {
		p[py] = px;
	}
}
