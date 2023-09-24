package BOJ_2468_안전영역;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N;
	static int[][] map;
	static int max, cnt;
	static boolean[][] visited;
	//상하좌우 델타 탐색
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//N*N맵
		N = sc.nextInt();
		//map
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = sc.nextInt();
			}
		}//map 정보 입력 끝
		
//		for(int[] a : map) System.out.println(Arrays.toString(a));
		
		max = Integer.MIN_VALUE;
		//물의 높이는 1이상 100이하
		//0부터 100까지 완전탐색
		for(int i=0; i<=100; i++) {
			
			cnt = 0;//안전영역 개수 저장할 변수 초기화
			visited = new boolean[N][N];//방문 초기화
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					//방문하지 않고 limit보다 높은 높이에서만 dfs 돌린다
					if(!visited[r][c] && map[r][c] > i) {
						bfs(r, c, i);					
						cnt++;
					}
				}
			}//N*N맵 탐색 끝
			
			//최대값 업데이트
			max = Math.max(cnt, max);
		}
		System.out.println(max);
	}
	//dfs
	static void dfs(int row, int col, int limit){
		for(int i=0; i<4; i++) {
			int nr = row + dr[i];
			int nc = col + dc[i];
			
			//다음 방향으로 갈 수 있는 경우에 dfs 재귀 호출
			if(nr >=0 && nr<N && nc>=0 && nc<N && !visited[nr][nc] && map[nr][nc] > limit) {
				visited[nr][nc] = true;
				dfs(nr, nc, limit);
			}
		}
	}
	//bfs
	static void bfs(int row, int col, int limit) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {row, col});//시작 좌표 큐에 넣기
		
		//큐가 빌 때 까지
		while(!queue.isEmpty()) {
			int[] tmp = queue.poll();
			
			//꺼낸 좌표 4방향 델타 탐색
			for(int i=0; i<4; i++) {
				int nr = tmp[0]+ dr[i];
				int nc = tmp[1]+ dc[i];
				if(nr >=0 && nr<N && nc>=0 && nc<N && !visited[nr][nc]&&map[nr][nc] > limit) {
					visited[nr][nc] = true;
					queue.add(new int[] {nr, nc});
				}
			}
		}
	}
}
