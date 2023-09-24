package 다익스트라개념;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
	
	static class Node{
		int v,w; //v: 정점, w: 가중치

		public Node(int v, int w) {
			super();
			this.v = v;
			this.w = w;
		}
		
	}
	
	
	static final int INF = Integer.MAX_VALUE;//다른 정점까지의 거리를 최대값으로 초기화 하기위한 변수
	static int V, E; //V:정점의 수, E: 간선의 수
	static List<Node>[] adjList; // 정점 사이의 가중치 정보를 담을 인접 리스트
	static int[] dist; //최단 거리 정보를 저장할 배열
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(input);
		
		V = sc.nextInt(); //정점의 수 (4개)
		E = sc.nextInt(); //간선의 수 (8개)
		adjList = new ArrayList[V+1]; //V: 정점은 1부터 시작이므로 V+1 크기로 만든다.
		for(int i=1; i<=V; i++) adjList[i] = new ArrayList<>();
		
		
		
		//입력 시작
		
		for(int i=0; i<E; i++) {
			int start = sc.nextInt();// 시작 정점
			int end = sc.nextInt();  // 도착 정점
			int w = sc.nextInt();    // 가중치
			
			adjList[start].add(new Node(end, w));
		}
		
		//1번 정점에서의 최소 거리 구하기
		dijkstra(1);
		System.out.println(Arrays.toString(dist));
		dijkstra(2);
		System.out.println(Arrays.toString(dist));
		dijkstra(3);
		System.out.println(Arrays.toString(dist));
		dijkstra(4);
		System.out.println(Arrays.toString(dist));
	
		
	}
	
	static void dijkstra(int start) {
		boolean[] visited = new boolean[V+1]; //정점 방문 여부 체크
		dist = new int[V+1]; //0번 인덱스 사용하지 않기 때문에 마찬가지로 V+1크기
		Arrays.fill(dist, INF); //초기 거리 정보에 최대값 채워 두기
		dist[start] = 0; //시작정점과 시작정점사이의 거리는 0
		
		for(int i=1; i<V; i++) {
			int min = INF; //최소값 세팅
			int idx = -1;  //인덱스 -1로 세팅
			
			//전체 정점 탐색
			for(int j=1; j<=V; j++) {
				//방문하지 않았고, dist가 가장 작은 값
				if(!visited[j] && min > dist[j]) {
					min = dist[j];
					idx = j;
				}
			}
			
			visited[idx] = true; //해당 정점 방문
			
			for(Node curr : adjList[idx]) {
				if(!visited[curr.v] && dist[curr.v] > dist[idx]+curr.w) {
					dist[curr.v] = dist[idx] + curr.w;
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
