package 다익스트라개념;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

//우선순위 큐
public class Solution2 {
	
	static class Node {
		
		int v; //도착 정점 번호
		int w; //가중치

		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}
	
	static int V, E; //V:정점의 수, E: 간선의 수
	static final int INF = Integer.MAX_VALUE;
	static List<Node>[] adjList;
	static int[] dist;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(input);
		
		V = sc.nextInt();
		E = sc.nextInt();
		
		
		adjList = new ArrayList[V+1];
		//정점 초기화
		for(int i=1; i<=V; i++) adjList[i] = new ArrayList<>();
		
		for(int i=0; i<E; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			int w = sc.nextInt();
			
			//정점 노드 연결
			adjList[start].add(new Node(end, w));
		}
		
		//정점 1에서 시작하는 다잌스트라
		dijkstra(1);
		System.out.println(Arrays.toString(dist));
	}
	
	static void dijkstra(int start) {
		boolean[] visited = new boolean[V+1];
		dist = new int[V+1];
		Arrays.fill(dist, INF);
		
		dist[start] = 0;
		
		PriorityQueue<Node> pq = new PriorityQueue<Node>(new Comparator<Node>() {

			public int compare(Node o1, Node o2) {
				return o1.v - o2.v;
			}
		});
		
		pq.offer(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			Node current = pq.poll();
			
			if(visited[current.v]) continue;
			visited[current.v] = true;
			
			for(Node next : adjList[current.v]) {
				if(dist[next.v] > dist[current.v] + next.w) {
					dist[next.v] = dist[current.v] + next.w;
					
					pq.offer(new Node(next.v, dist[next.v]));
				}
			}
		
		}
		
	}
	
	static String input =
			"4 8\r\n" + 
			"1 2 4\r\n" + 
			"1 3 2\r\n" + 
			"1 4 7\r\n" + 
			"2 1 1\r\n" + 
			"2 3 5\r\n" + 
			"3 1 2\r\n" + 
			"3 4 4\r\n" + 
			"4 2 3";
}
