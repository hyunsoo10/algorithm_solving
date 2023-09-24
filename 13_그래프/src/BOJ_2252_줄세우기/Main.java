package BOJ_2252_줄세우기;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N, M;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//N명의 학생
		N = sc.nextInt();
		//M번 비교
		M = sc.nextInt();
		
		//관계 정보 저장할 배열
//		int[][] adjArr = new int[N+1][N+1];
		List<Integer>[] adjList = new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		//진입차수 저장할 배열
		int[] degree = new int[N+1];
		
		for(int i=0; i<M; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
//			adjArr[A][B] = 1;
			adjList[A].add(B);
			degree[B]++;//차수 증가
		}
		
		Queue<Integer> queue = new LinkedList<>();
		//차수 0인 정점 큐에 넣기
		for(int i=1; i<=N; i++) {
			if(degree[i]==0)queue.offer(i);
		}
		
		while(!queue.isEmpty()) {
			int curr = queue.poll();
			System.out.print(curr+" ");
			//현재 정점과 관계가 있는 정점 차수 감소
//			for(int i=1; i<=N; i++) {
//				if(adjArr[curr][i]==1) {
//					//차수 감소
//					degree[i]--;
//					//차수가 0이면  queue에 추가
//					if(degree[i]==0) queue.offer(i);
//				}
//			}
			//메모리 초과 되면 인접리스트 활용
			for(int i=0; i<adjList[curr].size(); i++) {
				degree[adjList[curr].get(i)]--;
				if(degree[adjList[curr].get(i)]==0) queue.offer(adjList[curr].get(i));
			}
			
		}
	}
}
