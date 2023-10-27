package BOJ_1012_유기농배추;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M, K, cnt;
	static int[][] map, visited;
	static int[] dr = {-1, 1, 0, 0 };
	static int[] dc = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t< T ; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			M = Integer.parseInt(st.nextToken()); //가로 길이
			N = Integer.parseInt(st.nextToken()); //세로길이
			K = Integer.parseInt(st.nextToken()); //배추가 심어져 있는 위치의 개수
			
			map = new int[N][M];
			visited = new int[N][M];
			//배추 심기
			for(int k=0; k<K; k++) {
				st = new StringTokenizer(br.readLine()," ");
				int col = Integer.parseInt(st.nextToken());
				int row = Integer.parseInt(st.nextToken());
				map[row][col] = 1;
			}
			cnt = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					//배추가 있으면서 아직 방문하지 않았으면 카운팅
					if(map[i][j] == 1 && visited[i][j]==0) {
						dfs(i, j);
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}
	}
	//dfs
	private static void dfs(int row, int col) {
		visited[row][col] = 1;
		for(int d=0; d<4; d++) {
			int nr = row + dr[d];
			int nc = col + dc[d];
			
			//다음 재귀 호출
			if(nr>=0 && nr<N && nc>=0 && nc<M && visited[nr][nc]==0 && map[nr][nc]==1) {
				dfs(nr, nc);
			}
		}
	}
}
