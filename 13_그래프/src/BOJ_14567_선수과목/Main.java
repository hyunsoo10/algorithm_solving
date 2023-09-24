package BOJ_14567_선수과목;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//N개의 과목
		int N = sc.nextInt();
		//M: 조건의 수
		int M = sc.nextInt();
		//인접 리스트
		List<Integer>[] adjList = new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		//진입차수 저장할 배열
		int[] degree = new int[N+1];
		//해당 과목의 depth 저장할 배열 : 이게 곧 정답
		int[] depth = new int[N+1];
		
		for(int i=0; i<M; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			adjList[A].add(B);
			degree[B]++;//차수 증가
		}
		
		Queue<Integer> queue = new LinkedList<>();
		int level = 1;
		for(int i=1; i<=N; i++) {
			//선수과목 0인 과목들 모조리 큐에 넣기
			if(degree[i]==0) {
				queue.add(i);
				//해당 과목 depth 저장
				depth[i] = level;				
			}
		}
		while(!queue.isEmpty()) {
			int curr = queue.poll();
			//해당 과목을 선수과목으로 갖고 있는 과목들 차수 하나씩 제거
			for(int a : adjList[curr]) {
				degree[a]--;
				
				if(degree[a]==0) {
					queue.add(a);
					depth[a] = depth[curr]+1;
				} 
			}
		}
		
		
		for(int i=1; i<=N; i++) System.out.print(depth[i]+ " ");

	}
}
