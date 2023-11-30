package BOJ_2206_벽부수고이동하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
	//4방향 상하좌우
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0 , -1, 1};
	//N, M, min,  map 변수
	static int N , M;
	static int min = Integer.MAX_VALUE;
	static int[][] map, cost, visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//N(1 ≤ N ≤ 1,000), M(1 ≤ M ≤ 1,000)
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		cost = new int[N][M];
		visited = new int[N][M];
		
		//map 정보 입력 받기 
		for(int i=0; i<N; i++) {
			char[] temp = br.readLine().toCharArray();
			for(int j=0; j<M; j++) {
				map[i][j] = temp[j] - '0';
				cost[i][j] = Integer.MAX_VALUE;
			}
		}
		cost[0][0] = 1; //시작 좌표는 비용이1
		visited[0][0] = 1; // 시작 좌표 방문 처리
		//벽을 1개까지 부실 수 있다.
		dfs(0, 0, 1, 0);
		if(cost[N-1][M-1] == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(cost[N-1][M-1]);
		
		
	}
	//벽 부수고 이동할 dfs
	//시간초과
	private static void dfs(int row, int col, int distance, int breakCount) {
		//벽 한번이라도 부순 경로는 바로 return
		if(breakCount > 1) return;
		
		//최소값보다 큰 distance들도 바로 return
		if(min <= distance) return;
		
		if(row == N-1 && col == M-1) {
			min = Math.min(min, distance);
		}
		
		//4방향 탐색
		for(int d = 0; d<4; d++) {
			int nr = row + dr[d];
			int nc = col + dc[d];
			
			//인덱스 범위 조건
			if(nr >=0 && nr<N && nc>=0 && nc<M && visited[nr][nc] == 0) {
				//뚫려 있는 공간이면
				if(map[nr][nc] == 0) {
					//cost체크
					if(cost[nr][nc] > distance+1) {
						cost[nr][nc] = distance+1;
						visited[nr][nc] = 1;
						dfs(nr, nc, distance+1, breakCount);
						visited[nr][nc] = 0;
					}
				}
				//막혀 있는 공간이면
				else {
					//cost체크
					if(cost[nr][nc] > distance+1) {
						cost[nr][nc] = distance+1;
						visited[nr][nc] = 1;
						dfs(nr, nc, distance+1, breakCount+1);
						visited[nr][nc] = 0;
					}
				}
			}
		}
	}
}
