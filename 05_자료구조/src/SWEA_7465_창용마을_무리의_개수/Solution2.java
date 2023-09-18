package SWEA_7465_창용마을_무리의_개수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * 시뮬레이션, 그룹핑(DFS/BFS, HashSet, Disjoint-set)
 * Disjoint-set이 제일 빠름
 *
 */

public class Solution2 {
	public static int[] p, rank;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		for(int testCase = 1; testCase<=TC; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken()); //N, M(1 ≤ N ≤ 100, 0 ≤ M ≤ N(N-1)/2)
			int M = Integer.parseInt(st.nextToken());
			
			makeSet(N+1); //0번은 안씀, 1번 부터 N번 사용
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				union(findSet(a), findSet(b));
			}
			
			int cnt = 0; //대표자의 개수 세기
			
			for (int i = 1; i < p.length; i++) {
				if(p[i] == i) cnt++;
			}
			
			
			sb.append("#").append(testCase).append(" ").append(cnt).append("\n");
			
		}// end of for testCase
		System.out.println(sb.toString());
	} //end of main
	
//	/** 각 원소를 하나짜리 집합으로 만들기*/
//	public static void makeSet(int N) {
//		p = new int[N];
//		for(int i=1; i<p.length; i++) {
//			p[i] = i; //하나짜리 집합 만들기 i대신 0을 넣어도 됨. 대표자의 경우는 0을 넣는다
//		}
//	}
	/** 각 원소를 하나짜리 집합으로 만들기*/
	//랭크 사용
	public static void makeSet(int N) {
		rank = new int[N]; // 깊이 관리
		p = new int[N];
		for(int i=1; i<p.length; i++) {
			p[i] = i; //하나짜리 집합 만들기 i대신 0을 넣어도 됨. 대표자의 경우는 0을 넣는다
		}
	}
	/** a 원소의 집합의 대표자 찾기 리턴*/
	public static int findSet(int a) {
		//내가 대표자가 아닌 경우
		if(p[a] != a) return p[a] = findSet(p[a]); //나의 부모의 대표자로 쭉쭉 올라가라 //Path Compression
		return p[a];
	}
	/** union : 두 대표자 pa, pb 집합을 합침*/
	public static void union(int pa, int pb) {
//		p[pa] = pb; //두개가 합쳐진다.
		if(pa == pb) return; // 같은 그룹이면 합칠 필요 없음.
		link(pa, pb);
	}
	/** 깊이를 확인해서 합치기 */
	public static void link(int pa, int pb) {
		//깊이가 낮은 쪽은 큰쪽에다 합친다.
		if(rank[pa] > rank[pb]) {
			p[pb] = pa;
		}else {
			p[pa] = pb;
			if(rank[pa] == rank[pb]) rank[pb]++; //깊이가 같은 경우 깊이 한개 증가
		}
	}
	
} // end of class







