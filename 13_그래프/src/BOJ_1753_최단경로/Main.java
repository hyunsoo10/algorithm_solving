package BOJ_1753_최단경로;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	
	static class Node implements Comparable<Node>{
		int ed,w;

		public Node(int ed, int w) {
		
			this.ed = ed;
			this.w = w;
		}

		public int compareTo(Node o) {
			return this.w - o.w;
		}
	}
	
	static int V, E;
	static List<Node>[] adjList;
	static boolean[] visited;
	static int[] dist;
	static final int INF = Integer.MAX_VALUE;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		V = sc.nextInt();
		E = sc.nextInt();
		
		int start = sc.nextInt();
		
		adjList = new ArrayList[V+1];
		for(int i=1; i<=V; i++) adjList[i] = new ArrayList<>();
		
		for(int i=0; i<E; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int W = sc.nextInt();
			
			adjList[A].add(new Node(B, W));

		}//그래프 정보 입력 끝

		dijkstra(start);
		
	}

	//다익스트라 알고리즘
	static void dijkstra(int start){
		visited = new boolean[V+1];
		PriorityQueue<Node> pq = new PriorityQueue<>();
		visited[start] = true;//첫 시작 정점 방문
		//다익스트라할 때 추가되는 작업
		dist = new int[V+1];
		Arrays.fill(dist, INF);
		//시작 노드에서 시작노드로 가는 값은 0
		//비용이 0인 정점를 가장 먼저 선택
		pq.offer(new Node(start, 0));
		dist[start] = 0;		
		
		while(!pq.isEmpty()) {
			Node curr = pq.poll();
			
			if(dist[curr.ed] < curr.w) continue;
			
			for(int i=0; i<adjList[curr.ed].size(); i++) {
				Node next = adjList[curr.ed].get(i);
				
				if(dist[next.ed] > curr.w + next.w) {
					dist[next.ed] = curr.w + next.w;
					visited[next.ed] = true;
					pq.offer(new Node(next.ed, dist[next.ed]));
				}
			}
		
		}
		for(int i=1; i<=V; i++){
			if(visited[i]) System.out.println(dist[i]);
			else System.out.println("INF");
		}
//		System.out.println(Arrays.toString(dist));
		
	}
	static String input =
			"7 11\r\n" + 
			"1 2 32\r\n" + 
			"1 3 31\r\n" + 
			"1 6 60\r\n" + 
			"1 7 51\r\n" + 
			"2 3 21\r\n" + 
			"3 5 46\r\n" + 
			"3 7 25\r\n" + 
			"4 5 34\r\n" + 
			"4 6 18\r\n" + 
			"5 6 40\r\n" + 
			"5 7 51";
}
