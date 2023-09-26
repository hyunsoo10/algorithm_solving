package BOJ_14503_로봇청소기;

import java.util.Scanner;

public class Main {
	
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
		
		cnt = 0;
		clean(r, c, d);
		System.out.println(cnt);
	}
	/**row:행, col: 열, dir: 현재 청소기 방향*/
	static void clean(int row, int col, int dir) {
		
		//1. 현재 칸이 청소되지 않았다면 현재 칸 청소
		if(map[row][col] == 0) {
			map[row][col] = -1; //청소 완료 : -1로 표현
			cnt++; //청소 횟수 추가	
		}
		
		//청소되지 않은 빈칸 횟수 저장할 임시 변수
		int tmp =0;
		//주변 4칸 탐색
		for(int i=0; i<4; i++) {
			int nr = row + dr[i];
			int nc = col + dc[i];
			//인덱스 범위 쳌
			if(nr>=0 && nr<N && nc>=0 && nc<M) {
				if(map[nr][nc] == 0) tmp++;
			}
		}
		//2. 주변 4칸에 청소되지 않은 빈칸이 없는 경우
		if(tmp == 0) {
			//현재 바라보고 있는 방향과 반대방향으로 후진 시도
			int nr = row+dr[(dir+2)%4];
			int nc = col+dc[(dir+2)%4];
			//후진하려는 방향 쳌
			if(nr>=0 && nr<N && nc>=0 && nc<M) {
				//벽이라면 작동 멈춘다.
				if(map[nr][nc] == 1) {
					return;
				}
				//벽이 아니라면
				else clean(nr, nc, dir); //방향 유지한채로 다시 clean 메서드 호출
			}
		}//end if
		//3. 주변 4칸 중에 청소되지 않은 칸이 있는 경우
		else {
			
			//반시계 방향 탐색
			for(int j=0; j<4; j++) {
				//반시계 방향으로 회전한 방향
				int newDir = (dir+3)%4;
				int nr = row + dr[newDir];
				int nc = col + dc[newDir];
				
				//인덱스 범위 내에 있으면서 청소되지 않은 빈칸일 경우 한칸 전진
				if(nr>=0 && nr<N && nc>=0 && nc<M && map[nr][nc]==0) {
					clean(nr, nc, newDir);
					break;
				}
				dir = newDir;
			}

		}//end else

	}
}
