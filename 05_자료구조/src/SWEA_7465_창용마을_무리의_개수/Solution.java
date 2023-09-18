package SWEA_7465_창용마을_무리의_개수;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	static int N, M, ans;
	static Map<Integer, List<Integer>> map;
	static boolean[] checked;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt(); //테스트 케이스
		
		for(int tc=1; tc<=T; tc++) {
			N = sc.nextInt(); // N: 마을 사람의 수
			M = sc.nextInt(); // M: 서로 알고 있는 관계의 수
			
			//관계 정보 담을 맵
			map = new HashMap<>();
			checked = new boolean[N+1];
			//맵 키와 밸류 초기화
			for(int i=1; i<=N; i++) {
				map.put(i, new ArrayList<>());
			}
			
			//관계 입력
			for(int i=0; i<M; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				map.get(x).add(y);
				map.get(y).add(x);
			}

			//정답 초기화
			ans = 0;
			
			for(int i=1; i<=N; i++) {
				if(!checked[i])
					bfs(i);
			}
			
			System.out.printf("#%d %d\n", tc, ans);
		}
		
	}
	//bfs 탐색
	static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		List<Integer> result = new ArrayList<>();
		boolean[] visited = new boolean[N+1];
		
		//첫번째 루트 노드 큐에 추가
		queue.add(start);
		
		//큐가 모두 빌 때 까지
		while(!queue.isEmpty()) {
			//큐에서 값 꺼내기
			int tmp = queue.poll();
			//방문을 안했으면
			if(!visited[tmp]) {
				visited[tmp] = true; //방문처리
				for(int a : map.get(tmp)) {
					//연결 요소 중에 아직 방문 하지 않은 것들만 queue에 추가
					if(!visited[a]) queue.add(a);
				}
				result.add(tmp);
				checked[tmp] = true;
			}
		}
		//bfs한번 돌 때 마다 정답 추가
		ans++;
	}
}
