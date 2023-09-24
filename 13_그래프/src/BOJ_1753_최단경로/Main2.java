package BOJ_1753_최단경로;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//반복문 다익스트라
//시간 초과
public class Main2 {
	static class Node{
		int v,w;

		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}
	
	static int V, E;
	static List<Node>[] adjList;
	static boolean[] visited;
	static int[] dist;
	static int start;
	static final int INF = Integer.MAX_VALUE;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		V = sc.nextInt();
		E = sc.nextInt();
		
		//시작 정점
		start = sc.nextInt();
		
		//0번 인덱스 안쓴다
		adjList = new ArrayList[V+1];
		dist = new int[V+1];
		visited = new boolean[V+1];
		//리스트 초기화
		for(int i=1; i<=V; i++) adjList[i] = new ArrayList<Node>();
		
		for(int i=0; i<E; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int W = sc.nextInt();
			adjList[A].add(new Node(B, W));
		}//그래프 정보 입력 끝
		
		//거리 정보 INF로 채우기
		Arrays.fill(dist, INF);
		
		dijkstra(start);
		for(int i=1; i<=V; i++) {
			if(visited[i]) System.out.println(dist[i]);
			else System.out.println("INF");
		}
	}
	//다익스트라
	static void dijkstra(int start) {
		//시작 정점이 뽑히게 세팅
		dist[start] = 0;
		
		for(int i=1; i<=V; i++) {
			int min = INF;
			int idx = -1;
			//최소 가중치 정점 선택
			for(int j=1; j<=V; j++) {
				if(!visited[j] && min>dist[j]) {
					min = dist[j];
					idx = j;
				}
			}
			
			//선택할 친구가 없으면 break
			if(idx == -1) break;
			
			//뽑았으니까 방문 찍어 이제
			visited[idx] = true;
			
			//뽑은 친구의 연결된 정점 거리 정보 업뎃
			
			//해당 인덱스에서 갈 수 있는 노드들 모두 쳌
			for(Node curr : adjList[idx]) {
				
				//방문한 노드가 아니면서 거리 정보 업데이트 할 수 있으면 업데이트
				if(!visited[curr.v] && dist[curr.v] > dist[idx] + curr.w ) {
					dist[curr.v] = dist[idx] + curr.w;
				} 
			}
		}
		
	}
}
