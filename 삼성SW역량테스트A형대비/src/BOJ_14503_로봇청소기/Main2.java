package BOJ_14503_로봇청소기;

import java.util.Scanner;

public class Main2 {
	
	static int N, M, cnt;
	//북동남서
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int[][] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//3<=N, M <=50
		N = sc.nextInt();
		M = sc.nextInt();
		
		//처음 로봇 청소기의 좌표
		int r = sc.nextInt();
		int c = sc.nextInt();
		//초기 방향
		int d = sc.nextInt();
		
		//맵 정보
		map = new int[N][M];
		
		// 0: 청소하지 않은 칸, 1:벽
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) map[i][j] = sc.nextInt();
		}//맵 정보 입력 끝
		cnt = 1; //첫 좌표는 항상 0이므로 cnt1로 초기화
		clean(r, c, d);
		System.out.println(cnt);
	}
	/**row:행, col: 열, dir: 현재 청소기 방향*/
	static void clean(int row, int col, int dir) {
		
		//청소 완료 표시
		map[row][col] = -1;
		
		//반시계 방향 탐색
		for(int j=0; j<4; j++) {
			//반시계 방향으로 회전
			dir = (dir+3)%4;
			int nr = row + dr[dir];
			int nc = col + dc[dir];
			
			//인덱스 범위 내에 있으면서 탐색 시도
			if(nr>=0 && nr<N && nc>=0 && nc<M) {
				//만약에 아직 청소하지 않은 칸이라면
				if(map[nr][nc]==0) {
					//횟수 증가하고 이동
					cnt++;
					clean(nr, nc, dir);
					return;
				}
			}
	
		}
		
		//해당 반시계방향 탐색에서 빈칸을 못찾은 경우
		//현재 방향과 반대방향으로 후진
		int opposite = (dir+2)%4;
		//후진 방향 좌표
		int or = row + dr[opposite];
		int oc = col + dc[opposite];
		
		//인덱스 범위 내에 있으면서 && 벽이 아닐경우 후진
		if(or>=0 && or<N && oc>=0 && oc<M && map[or][oc]!=1)
			clean(or, oc, dir);//후진이므로 방향은 유지
	}
}
