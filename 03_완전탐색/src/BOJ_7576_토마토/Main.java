package BOJ_7576_토마토;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	//상하좌우
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	//변수 static선언
	static int M, N, ans;
	static int[][] map, visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//N*M의 상자 크기 2 ≤ M,N ≤ 1,000
		M = sc.nextInt();
		N = sc.nextInt();
		int H = sc.nextInt();
		
		//map과 방문 배열 초기화
		map = new int[N][M];
		visited = new int[N][M];
		
		//토마토 정보 입력
		//-1: 토마토 없음 0: 익지 않은 토마토  1: 익은 토마토
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				map[i][j] = sc.nextInt();
				
				//방문 배열 초기화
				//벽은 -2로, 나머지는 -1로 초기화
				if(map[i][j]==-1) visited[i][j] = -2;
				else visited[i][j] = -1;
			}
		}
	
		bfs();
		System.out.println(ans); 
		
	}
	
	static void bfs() {
		Queue<int[]> queue = new LinkedList<>();
		//초기 상태에서 익은 토마토의 위치 queue에 넣기
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == 1) {
					queue.add(new int[] {i, j});
					//방문쳌
					visited[i][j] = visited[i][j]+1;
				}
			}
		}//초기 익은 토마토 위치 입력 끝
		
		//큐가 빌 때 까지 진행
		while(!queue.isEmpty()) {
			//큐 값 하나 꺼내기
			int[] pos = queue.poll();
			
			//해당 위치의 4방향 델타 탐색
			for(int i=0; i<4; i++) {
				int nr = pos[0] + dr[i];
				int nc = pos[1] + dc[i];
				//인덱스 범위 내 && 토마토가 있는 경우 && 방문을 아직 하지 않은 경우
				if(nr>=0 && nr<N && nc>=0 && nc<M && map[nr][nc] != -1 && visited[nr][nc]==-1) {
					//visited 배열에는 해당 토마토가 며칠이 지난 후에 익는지에 대한 정보를 저장한다.
					visited[nr][nc] = visited[pos[0]][pos[1]] + 1;
					//그리고 위치 정보를 다시 큐에 넣는다.
					queue.add(new int[] {nr, nc});
				}
			}
			
		}

		//최대값 비교할 변수
		int max = Integer.MIN_VALUE;
		for(int[] v : visited) {
			for(int x : v) {
				//최대값 갱신
				if(x > max)  max = x;
				//익지 않은 토마토 있으면 정답에 -1 대입하고 바로 bfs 리턴
				if(x == -1) {
					ans = -1;
					return;
				}
			}
		}//visited 완전 탐색 끝
		
		//최대값이 0 이라면, 모든 토마토가 익은 상태였던 것임
		if(max == 0) ans = 0;
		else ans = max;
	}
}
