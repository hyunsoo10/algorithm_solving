package BOJ_2206_벽부수고이동하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	//4방향 상하좌우
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0 , -1, 1};
	//N, M, min,  map 변수
	static int N , M;
	static int min = Integer.MAX_VALUE;
	static int[][] map;
	static boolean[][][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//N(1 ≤ N ≤ 1,000), M(1 ≤ M ≤ 1,000)
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M][2];
		
		//map 정보 입력 받기 
		for(int i=0; i<N; i++) {
			char[] temp = br.readLine().toCharArray();
			for(int j=0; j<M; j++) {
				map[i][j] = temp[j] - '0';
			}
		}
		Queue<int[]> queue = new LinkedList<>();
		int start[] = new int[] {0, 0, 1, 0}; // 첫 좌표 정보 큐에 추가
		visited[0][0][0] = true; // 시작 좌표 방문 처리
		queue.add(start);
		int ans = -1;
		while(!queue.isEmpty()) {
			int[] pos = queue.poll();
			
			int row = pos[0];
			int col = pos[1];
			int dis = pos[2];
			int flag = pos[3];
			
			if(row == N-1 && col == M-1) {
				ans = dis;
				break;
			}
			
			for(int d=0; d<4; d++) {
				int nr = row + dr[d];
				int nc = col + dc[d];
				
				//인덱스 범위 체크
				if(nr >=0 && nr<N && nc>=0 && nc<M) {
				
					//벽이 아닐 경우
					if(map[nr][nc] == 0 && !visited[nr][nc][flag]) {
						visited[nr][nc][flag] = true;
						queue.add(new int[] {nr, nc, dis+1, flag});
					}
					//벽일 경우
					else {
						//벽을 부수지 않았던 경우에만 부신다
						if(pos[3] == 0 && !visited[nr][nc][1]) {
							visited[nr][nc][1] = true;
							queue.add(new int[] {nr, nc, dis+1, 1});
							//벽 뚫고간 방문 처리 
						}
					}
				}
				
			} //4방향 탐색
		}
	
		System.out.println(ans);
		
	}

}
