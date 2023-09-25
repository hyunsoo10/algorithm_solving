package BOJ_1939_중량제한;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static class Node{
		int v, w;

		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}
	
	static int N, M, start, end;
	static List<Node>[] adjList;
	static boolean[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//N : 섬의 개수
		//M : 다리의 개수
		N = sc.nextInt();
		M = sc.nextInt();
		
		adjList = new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		int max = 0;
		int min = Integer.MAX_VALUE;
		
		
		
		for(int i=0; i<M; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int W = sc.nextInt();
			//가중치의 최대값과 최소값 갱신
			max = Math.max(max, W);
			min = Math.min(min, W);
			adjList[A].add(new Node(B, W));
			adjList[B].add(new Node(A, W));
		}
		
		//출발점과 도착점 입력 받기
		start = sc.nextInt();
		end = sc.nextInt();
		
		//가능한 중량을 게속 업데이트해서 result에 저장한다.
		int result = 0;
		
		//이분탐색으로 중량 확인
		while(min <= max) {
			//이분탐색 중량 
			int mid = (min+max)/2;
			//방문 쳌할 배열
			visited = new boolean[N+1];
			
			//mid의 중량이 start부터 end까지 건널 수 있는지 확인
			if(bfs(mid)) {
				//건널 수 있는 경우에 min 값을 mid+1로 올려서 다시 쳌
				min = mid+1;
				//mid값은 end까지 건널수 있는 값임이 확인 됐으므로 result에 mid값 대입
				result = mid;
			}
			//건널 수 없다면
			else {
				//현재 mid 중량이 end까지 갈 수 없으므로  max를 mid-1로 낮춘다
				max = mid-1;
			}
		}
		//이분탐색이 종료되면 최대 중량이 result에 저장되어 있다.
		System.out.println(result);
		
	}
	static boolean bfs(int mid) {
		Queue<Integer> queue = new LinkedList<>();
		//시작 정점 넣어주기
		queue.add(start);
		//방문 처리
		visited[start] = true;
		
		//큐가 빌 때 까지
		while(!queue.isEmpty()) {
			//큐에서 한개 꺼내기
			int curr = queue.poll();
			
			//도착 정점이라면 return 
			if(curr == end) return true;
			//해당 정점과 연결되어 있는 노드 확인
			for(Node node : adjList[curr]) {
				//해당 노드의 중량 제한 내에 있고 방문하지 않은 노드라면
				if(node.w >= mid && !visited[node.v]) {
					visited[node.v] = true;
					queue.add(node.v);
				}
			}
			
		}
		//만약에 while문이 끝났는데 도착 정점에 도달하지 못했다면 해당 중량은 통과할 수 없는 중량이다
		return false;
		
	}
}
