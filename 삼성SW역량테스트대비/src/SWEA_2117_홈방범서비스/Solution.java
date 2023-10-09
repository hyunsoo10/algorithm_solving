package SWEA_2117_홈방범서비스;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	static int N, M, cnt, ans;
	static int[][] map, visited;
	static int[] cost;
	//상 하 좌 우 4방향 델타 탐색
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//운영 비용 = K * K + (K - 1) * (K - 1)

		//도시의 크기 N (5 ≤ N ≤ 20)
		//하나의 집이 지불할 수 있는 비용 M (1 ≤ M ≤ 10)
		
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			ans = 0;
			map = new int[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					map[i][j] = sc.nextInt();
				}
			}// map 정보
			//k 영역에 대한 비용 정보
			//N이 최대 20이므로 21까지만 구해놓으면 된다.(N이 짝수일 때는 N+1크기만큼 확인해봐야 전체 영역 확인 가능)
			cost = new int[22];
			for(int k=1; k<=21; k++) {
				cost[k] = k*k + (k-1)*(k-1);
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					check(i, j, 1);
				}
			}
			System.out.printf("#%d %d\n",tc, ans);
		}// end tc
	}// end main
	//row: 행, col: 열  k:영역 범위(1부터 ~ N까지 체크)
	private static void check(int row, int col, int k) {
		//N+1영역을 넘어서면 더 이상 체크할 필요 없음
		if(k == N+2) return;
		//해당 영역에서 bfs로 방범 상태 체크
		bfs(row, col, k);
		//그리고 k영역 넓혀서 check 메소드 다시 호출
		check(row, col, k+1);
	}
	//row: 행, col: 열, k: depth의 max 범위, depth : 현재 영역 깊이
	private static void bfs(int row, int col, int k) {
		//bfs에서 사용할 변수 초기화
		visited = new int[N][N];
		cnt=0;
		Queue<int[]> queue = new LinkedList<>();
		//행, 열, depth 정보까지 같이 저장
		queue.add(new int[] {row, col, 1});
		//집 숫자 체크
		if(map[row][col]==1) cnt++;
		visited[row][col] = 1;//방문 처리
		while(!queue.isEmpty()) {
			//depth가 k가 넘어가면 리턴
			int[] pos = queue.poll(); //좌표 한개 뽑기
			int x = pos[0];
			int y = pos[1];
			int depth = pos[2];
			
			for(int i=0; i<4; i++) {
				int nr = pos[0] + dr[i];
				int nc = pos[1] + dc[i];
				if(nr>=0 && nr<N && nc>=0 && nc<N && visited[nr][nc]==0 && depth<k) {
					//집 숫자 체크
					if(map[nr][nc] == 1) cnt++;
					queue.add(new int[] {nr, nc, depth+1});
					visited[nr][nc] = 1;
				}
			}
		}
		if(cost[k] <= cnt*M) {
			ans = Math.max(cnt, ans);
		}
	}
}
