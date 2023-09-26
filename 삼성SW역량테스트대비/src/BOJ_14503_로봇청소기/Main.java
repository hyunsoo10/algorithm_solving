package BOJ_14503_로봇청소기;

import java.util.Scanner;

public class Main {
	
	static int N, M, cnt;
	//상좌하우
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, -1, 0, 1};
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
		
		clean(r, c, d);
	}
	/**row:행, col: 열, dir: 현재 청소기 방향*/
	static void clean(int row, int col, int dir) {
		
		//1. 현재 칸이 청소되지 않았다면 현재 칸 청소
		if(map[row][col] == 0) {
			map[row][col] = -1; //청소 완료 : -1로 표현
			cnt++; //청소횟수 증가
		}
		
		//2. 주변 4칸 탐색
		for(int i=0; i<4; i++) {
			int nr = row + dr[i];
			int nc = col + dc[i];
			int tmp = 0; //청소되지 않은 빈칸 횟수 저장할 임시 변수
			//인덱스 범위 쳌
			if(nr>=0 && nr<N && nc>=0 && nc<N) {
				if(map[nr][nc] == 0) tmp++;
			}
			//주변 4칸에 청소되지 않은 빈칸이 없는 경우
			if(tmp == 0) {
				
			}
		}
		
	}
}
