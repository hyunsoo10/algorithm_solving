package BOJ_1753_최단경로;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main3 {
	static int V,E;
	static List<int[]>[] adjList;
	static int[] dist;
	static final int INF = Integer.MAX_VALUE;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		V = sc.nextInt();
		E = sc.nextInt();
		
		int start = sc.nextInt();
		adjList = new ArrayList[V+1];
		
		//초기화
		for(int i=1; i<=V; i++) adjList[i] = new ArrayList<>();
		
		//간선 정보 입력
		for(int i=0; i<E; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int W = sc.nextInt();
			adjList[A].add(new int[]{B, W});
		}
		
		//거리 저장할 배열
		dist = new int[V+1];
		//큰 값으로 모두 초기화
		Arrays.fill(dist, INF);
		
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[1]- o2[1];
			}
		});
		
		//시작 좌표 넣기
		pq.offer(new int[] {start, 0});
		dist[start] = 0;//자기 자신으로 가는 거리는 0이다
		
		while(!pq.isEmpty()) {
			int[] pos = pq.poll();
			int v = pos[0];
			int w = pos[1];
			
			//해당 정점과 연결되어 있는 정점 탐색
			for(int[] next : adjList[v]) {
				//연결할 정점의 가중치와 내 정점의 가중치를 합해서 tmp로 저장
				int tmp = next[1] + w;
				if(tmp < dist[next[0]]) {
					dist[next[0]] = tmp;
					pq.add(new int[]{next[0], tmp});
				}
			}
		}
		
//		System.out.println(Arrays.toString(dist));
		for(int i=1; i<=V; i++) {
			if(dist[i] == INF) System.out.println("INF");
			else System.out.println(dist[i]);
		}

	}
}
