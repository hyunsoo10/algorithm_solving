package SWEA_1251_하나로;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;


class Node implements Comparable<Node>{
	int x; //정점
	double w; //두 정점 사이의 가중치
	
	Node(int x, double w){
		this.x = x;
		this.w = w;
	}
	//가중치를 기준으로 정렬
	public int compareTo(Node o) {
		return Double.compare(this.w, o.w);
	}
}

public class Solution {
	static int N;
	static int[][] island;
	static double[][] tunel;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();// 테스트 케이스
		for(int tc=1; tc<=T; tc++) {
			N = sc.nextInt(); //N: 섬의 개수
			island = new int[N][2]; //섬의 좌표
			
			//두 연결 섬의 번호와 터널 환경 부담금 가중치 저장
			//정점의 수가 N 이면 모든 간선의 경우의 수는 N(N-1)/2 => nC2
			int V = N*(N-1)/2;
			tunel = new double[V][3]; 
			List<Node>[] graph = new ArrayList[N]; //노드 정보 담을 그래프
			for(int i=0; i<N; i++) graph[i] = new ArrayList<>();
			
			//섬 좌표 입력
			for(int i=0; i<N; i++) island[i][0] = sc.nextInt();
			for(int i=0; i<N; i++) island[i][1] = sc.nextInt();
			
			
			double E = sc.nextDouble(); //세율
			
			int idx = 0;//tnuel에 넣을 인덱스 갱신시킬 번호
			//N개 중에서 2개의 섬 조합 뽑기
			for(int i=0; i<N; i++) {
				for(int j=i+1; j<N; j++) {
					//0인덱스: 섬의 번호, 1인덱스: 섬의 번호(순서 상관 x)
					tunel[idx][0] = i;
					tunel[idx][1] = j;
					//2인덱스: 가중치
					double tmp = E*(Math.pow(island[i][0] - island[j][0], 2) +Math.pow(island[i][1] - island[j][1], 2));
					tunel[idx][2] = E*(Math.pow(island[i][0] - island[j][0], 2) +Math.pow(island[i][1] - island[j][1], 2));
					
					
					//정점 정보와 가중치 추가
					graph[i].add(new Node(j, tmp));
					graph[j].add(new Node(i, tmp));
					idx++;
				}
			}// 조합 뽑기 끝


			boolean[] visited = new boolean[N];
			//방문체크할 배열
			//프림 알고리즘을 위한 우선순위 큐
			PriorityQueue<Node> pq = new PriorityQueue<>();
			pq.offer(new Node(0, 0));
			
			double ans = 0;
			
			//큐가 빌 떄 까지
			while(!pq.isEmpty()) {
				Node node = pq.poll();//큐에서 꺼내기
				int x = node.x; //정점의 좌표
				double w = node.w; //두 정점 사이의 가중치
				
				if(visited[x]) continue; //방문한 정점이라면 스킵
				
				visited[x] =  true; //방문 처리
				ans += w; //가중치 더해주기

				
				for(Node n : graph[x]) {
					//해당 정점과 연결된 정점들 중 방문하지 않은 정점들 큐에 추가
					if(!visited[n.x]) pq.add(n);	
				}
			}
			System.out.printf("#%d %d\n", tc, Math.round(ans));
		}
	}
}
