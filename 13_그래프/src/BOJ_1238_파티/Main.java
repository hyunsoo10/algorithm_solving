package BOJ_1238_파티;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;




public class Main {
	//마을 노드 만들기
	static class Node implements Comparable<Node>{
		int x;
		int w;
		public Node(int x, int w) {
			this.x = x; //도착지 
			this.w = w; //가중치
		}
		public int compareTo(Node node) {
			return this.w - node.w;
		}
	}
	static int N, M, X, max;
	static int[] dist;
	static final int INF = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt(); //N : 노드의 개수
		M = sc.nextInt(); //M개의 단방향 도로 : 간선 개수
		X = sc.nextInt(); //파티 장소 
		
		
		//1부터 N까지의 노드를 만들고, 각 노드에서 갈 수 있는 노드와 그 가중치를 저장
		List<Node>[] arr1 = new ArrayList[N+1];
		List<Node>[] arr2 = new ArrayList[N+1];
		
		//리스트 초기화
		for(int i=1; i<=N; i++) {
			arr1[i] = new ArrayList<>();
			arr2[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			int start = sc.nextInt(); //시작 노드
			int end = sc.nextInt();   //도착 노드
			int weight = sc.nextInt();//가중치
			
			arr1[start].add(new Node(end, weight)); //주어진 그대로 -> 목적지에서 각 노드까지의 거리
			arr2[end].add(new Node(start, weight)); //각 노드에서 목적지 X까지의 거리를 구하기 위해 가중치의 방향을 반대로 입력
			
			//0번 부터 N까지 시작정점 반복문
		}
		max = Integer.MIN_VALUE;
		for(int n=1; n<=N; n++) {
			int sum = 0;
			dijkstra(n, arr1); //n을 시작점으로 하는 거리 최소 값들 구하기
			sum += dist[X];
//			System.out.println("n" +n);
//			System.out.println(Arrays.toString(dist));
			dijkstra(n, arr2); //X를  도착점으로 하는 거리의 최소 값
//			System.out.println(Arrays.toString(dist));
			sum += dist[X];
			max = Math.max(max, sum);

		}
		System.out.println(max);
		
	}
	static void dijkstra(int start, List<Node>[] arr) {
		boolean[] visited = new boolean[N+1]; //방문 처리
		dist = new int[N+1]; //방문 거리 담을 배열
		Arrays.fill(dist, INF);
		dist[start] = 0; //시작 정점 까지의 거리는 0으로 초기화
		
		//모든 마을 순회
		for(int i=1; i<N; i++) {
			int min = INF;
			int idx = -1;
			
			//방문하지 않은 마을 중 최소의 dist값을 가진 마을 선택
			for(int j=1; j<=N; j++) {
				if(!visited[j] && min > dist[j]) {
					min = dist[j];
					idx = j;
				}
			}
			if(idx == -1) break;
			visited[idx] = true; //방문 처리
			
			
			for(Node curr : arr[idx]) {
				if(!visited[curr.x] && dist[curr.x] > dist[idx] + curr.w) {
					dist[curr.x] = dist[idx] + curr.w;
				}
			}
		}
		
	}
}
