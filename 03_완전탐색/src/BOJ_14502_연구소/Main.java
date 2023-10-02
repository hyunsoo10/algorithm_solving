package BOJ_14502_연구소;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N, M, K, max;
	static int[][] map, copy, blank;
	static boolean[] visited;
	//4방향 델타 탐색
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		//사용할 변수 초기화
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		max = Integer.MIN_VALUE;
		//map정보 입력
		//K는 빈칸 개수 의미
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] == 0) K++;
			}
		}
		//빈칸 정보 담을 배열선언
		blank = new int[K][2];
		//map 깊은 복사
		copy = new int[N][M];
		int idx=0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == 0) {
					blank[idx][0] = i;
					blank[idx++][1] = j;
				}
				
			}
		}//빈칸 위치 정보 입력 끝
		
		//방문 처리할 배열
		visited = new boolean[K];
		//빈칸 위치 중에 3개 뽑아야 함
		combination(0, 0);
		
		System.out.println(max);

	}
	//3개 조합 뽑는 메서드
	static void combination(int idx, int sidx) {
		//3개 뽑았으면 리턴
		if(sidx == 3) {
			int[][] pos = new int[3][2];
			for(int i=0, x=0; i<K; i++) {
				//뽑은 세 위치에 벽 세우기
				if(visited[i]) pos[x++] = blank[i]; 
			}
			install(pos);
			return;
		}
		//idx 끝까지 왔으면 리턴
		if(idx == K) return;
		
		for(int i = idx; i<K; i++) {
			//i를 뽑고 다음으로
			visited[i] = true;
			combination(i+1, sidx+1);
			//원상 복귀
			visited[i] = false;
		}
	}
	
	//벽 설치
	static void install(int[][] pos) {
		//벽 설치
		for(int i=0; i<3; i++) {
			map[pos[i][0]][pos[i][1]] = 1;
		}
		
		//벽 설치 후 bfs
		bfs();
		
		//벽 철거
		for(int i=0; i<3; i++) {
			map[pos[i][0]][pos[i][1]] = 0;
		}
	}
	//바이러스 bfs로 퍼트리기
	static void bfs() {
		Queue<int[]> queue = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];
		//초기 바이러스 위치 큐에 담기
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == 2) {
					queue.add(new int[] {i, j});
					visited[i][j] = true;
				}
				//벽이 있는 위치를 그냥 방문처리 해버리기
				if(map[i][j] == 1) visited[i][j] = true;
			}
		}
		
		while(!queue.isEmpty()) {
			int[] pos = queue.poll();
			
			for(int i=0; i<4; i++) {
				int nr = pos[0] + dr[i];
				int nc = pos[1] + dc[i];
				
				//인덱스 범위 && 방문 체크(벽은 이미 방문 처리가 되있으므로 자동으로 체크 가능)
				if(nr >=0 && nr<N && nc>=0 && nc<M && !visited[nr][nc]) {
					//큐에 넣고 방문 처리
					queue.add(new int[] {nr, nc});
					visited[nr][nc] = true;
				}
			}
		}
		int cnt=0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				//방문안한 곳 개수 카운팅 -> 안전영역 크기임
				if(!visited[i][j]) cnt++;
			}
		}
		max = Math.max(max, cnt);
	}

}
