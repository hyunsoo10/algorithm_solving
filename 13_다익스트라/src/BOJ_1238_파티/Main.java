package BOJ_1238_파티;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


//마을 노드 만들기
class Node implements Comparable<Node>{
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

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); //N : 노드의 개수
		int M = sc.nextInt(); //M개의 단방향 도로 : 간선 개수
		int X = sc.nextInt(); //파티 장소 
		
		
		//1부터 N까지의 노드를 만들고, 각 노드에서 갈 수 있는 노드와 그 가중치를 저장
		List<Node>[] arr1 = new ArrayList[N+1];
		List<Node>[] arr2 = new ArrayList[N+1];
		
		//리스트 초기화
		for(int i=0; i<=N; i++) {
			arr1[i] = new ArrayList<>();
			arr2[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			int start = sc.nextInt(); //시작 노드
			int end = sc.nextInt();   //도착 노드
			int weight = sc.nextInt();//가중치
			
			arr1[end].add(new Node(start, weight)); //각 노드에서 목적지 X까지의 거리를 구하기 위해 가중치의 방향을 반대로 입력
			arr2[start].add(new Node(end, weight)); //주어진 그대로 -> 목적지에서 각 노드까지의 거리
		}
		
	}
}
