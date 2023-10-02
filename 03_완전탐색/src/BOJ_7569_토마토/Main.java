package BOJ_7569_토마토;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	//상하좌우
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	//변수 static선언
	static int M, N, H, ans;
	static int[][][] map, visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//N*M의 상자 크기 2 ≤ M,N ≤ 100
		M = sc.nextInt();
		N = sc.nextInt();
		//H: 쌓아올려지는 상자의 수
		H = sc.nextInt();
		
		//map과 방문 배열 초기화
		map = new int[H][N][M];
		visited = new int[H][N][M];
		
		//토마토 정보 입력
		//-1: 토마토 없음 0: 익지 않은 토마토  1: 익은 토마토
		for(int h = 0; h<H; h++) {
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					map[h][i][j] = sc.nextInt();
					
					//방문 배열 초기화
					//벽은 -2로, 나머지는 -1로 초기화
					if(map[h][i][j]==-1) visited[h][i][j] = -2;
					else visited[h][i][j] = -1;
				}//M(가로)
			}//N(세로)	
		}//H(높이)
		
		Queue<int[]> queue = new LinkedList<>();
		//초기에 익은 토마토 queue에 넣기
		for(int h = 0; h<H; h++) {
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					//익은 토마토
					if(map[h][i][j] == 1) {
						queue.add(new int[]{h, i, j});
						visited[h][i][j] ++;
					}
				}
			}
		}
		
		//큐가 빌때 까지
		while(!queue.isEmpty()) {
			int[] pos = queue.poll();
			int currH = pos[0];
			//1. 해당 높이 상자 탐색
			for(int i=0; i<4; i++) {
				int nr = pos[1] + dr[i];
				int nc = pos[2] + dc[i];
				//인덱스 범위 내 && 토마토가 있는 경우 && 방문을 아직 하지 않은 경우
				if(nr>=0 && nr<N && nc>=0 && nc<M && map[currH][nr][nc] != -1 && visited[currH][nr][nc]==-1) {
					//visited 배열에는 해당 토마토가 며칠이 지난 후에 익는지에 대한 정보를 저장한다.
					visited[currH][nr][nc] = visited[currH][pos[1]][pos[2]] + 1;
					//그리고 위치 정보를 다시 큐에 넣는다.
					queue.add(new int[] {currH, nr, nc});
				}
			}
			
			//2. 해당 높이 아래 위치 쳌
			if(currH-1 >= 0) {
				//해당 위치에 익지 않은 토마토 가 있으면서 방문하지 않은 경우
				if(map[currH-1][pos[1]][pos[2]] == 0 && visited[currH-1][pos[1]][pos[2]]==-1) {
					//방문 쳌
					visited[currH-1][pos[1]][pos[2]] = visited[currH][pos[1]][pos[2]] + 1;
					queue.add(new int[] {currH-1, pos[1], pos[2]});
				}
			}
			//3. 해당 높이 위에 위치 쳌
			if(currH+1 < H) {
				//해당 위치에 익지 않은 토마토 가 있으면서 방문하지 않은 경우
				if(map[currH+1][pos[1]][pos[2]] == 0 && visited[currH+1][pos[1]][pos[2]]==-1) {
					//방문 쳌
					visited[currH+1][pos[1]][pos[2]] = visited[currH][pos[1]][pos[2]] + 1;
					queue.add(new int[] {currH+1, pos[1], pos[2]});
				}
			}
			
			
		}//end while
		
		//최대값 비교할 함수
		int max = Integer.MIN_VALUE;
out:	for(int [][] a : visited) {
			for(int [] b : a) {
				for(int c : b) {
					if(c > max) max = c;
					//아직 익지 않은 토마토 가 있다면 max에 -1 대입하고 전체 for문 종
					if(c == -1) {
						max = -1;
						break out;
					}
				}
			}
		}
		
		//max가 -1이면 ans는 -1
		if(max == -1) ans = -1;
		//최대 값이 0 이라면 ans는 0
		else if(max == 0) ans = 0;
		//그 외의 경우는  max가 곧 ans
		else ans = max;

		System.out.println(ans);

		
	}
}
