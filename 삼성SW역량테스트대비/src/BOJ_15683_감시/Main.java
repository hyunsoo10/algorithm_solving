package BOJ_15683_감시;

import java.util.Scanner;

public class Main {
	static int N, M, cctv, min, walls;
	static int[][] location; 
	static int[][][] map;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	//search[idx][dir][true/false여부]
	static int[][][] search = {
			{},
			//1번 CCTV
			{
				{0, 0, 0, 1},
				{0, 1, 0, 0},
				{0, 0, 1, 0},
				{1, 0, 0, 0}
			},
			//2번 CCTV
			{
				{0, 0, 1, 1},
				{1, 1, 0, 0},
			},
			//3번 CCTV
			{
				{1, 0, 0, 1},
				{0, 1, 0, 1},
				{0, 1, 1, 0},
				{1, 0, 1, 0}
			},
			//4번 CCTV
			{
				{1, 0, 1, 1},
				{1, 1, 0, 1},
				{0, 1, 1, 1},
				{1, 1, 1, 0}
			},
			//5번 CCTV
			{
				{1, 1, 1, 1}
			}
	};
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M][2];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				map[i][j][0] = sc.nextInt();
				//cctv 개수 카운팅
				if(map[i][j][0] != 0 && map[i][j][0] != 6) cctv++;
				//벽 개수 카운팅
				if(map[i][j][0] == 6) walls++;
			}
		}
		
		//cctv 좌표 저장할 큐
		location = new int[cctv][3];
		int idx=0;
		//CCTV탐색
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				//CCTV를 좌표와 해당 유형에 대한 정보를 배열로 저장
				if(map[i][j][0] != 0 && map[i][j][0] != 6) {
					location[idx][0] = i;
					location[idx][1] = j;
					location[idx++][2] = map[i][j][0];
				}
			}
		}
		min = Integer.MAX_VALUE;
		dfs(0);
		System.out.println(min-walls);
	}
	
	/**CCTV 회전 시키는 dfs
	 * idx: cctv 인덱스
	 * */
	static void dfs(int idx) {
		//기저조건 파트
		//모든 cctv를 다 체크하면 리턴
		if(idx == cctv) {
			scan();
			return;
		}

		//해당 idx의 CCTV 유형
		int type = location[idx][2];
		//재귀 파트
		//2. 다음 CCTV 탐색 
		//유형에 따라 다른 조건문으로 재귀 호출
		if(type==1 || type==3 || type==4) {
			map[location[idx][0]][location[idx][1]][1] = 0;
			dfs(idx+1);
			
			map[location[idx][0]][location[idx][1]][1] = 1;
			dfs(idx+1);
			
			map[location[idx][0]][location[idx][1]][1] = 2;
			dfs(idx+1);
			
			map[location[idx][0]][location[idx][1]][1] = 3;
			dfs(idx+1);
			
		}else if(type == 2) {
			map[location[idx][0]][location[idx][1]][1] = 0;
			dfs(idx+1);
			
			map[location[idx][0]][location[idx][1]][1] = 1;
			dfs(idx+1);
		}else {
			dfs(idx+1);
		}
		
		
	}
	//안전 영역 개수 카운팅 하는 메서드
	static void scan() {
		boolean[][] visited = new boolean[N][M];
		for(int i=0; i<cctv; i++) {
			int[] info = location[i];
			
			
			int row = info[0];//cctv행
			int col = info[1];//cctv열
			int type = info[2];//cctv유형
			visited[row][col] = true;
			//주변 4방향 중 감시 가능한 방향 체크
			for(int d=0; d<4; d++) {
				//1이라면 그 방향으로 감시가 가능함
				if(search[type][map[row][col][1]][d]==1) {
					int nr = row + dr[d];
					int nc = col + dc[d];
					//인덱스 범위 && 벽 아님
					while(nr>=0 && nr<N && nc>=0 && nc<M && map[nr][nc][0]!=6) {
						visited[nr][nc] = true;
						nr += dr[d];
						nc += dc[d];
					}
				}			
			}//i번째 cctv 4방향 감시 체크 후 감시 종료

		}//전체 for문
		//안전 영역 체크
		int safe = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(!visited[i][j]) safe++; 
			}
		}
		min = Math.min(safe, min);
		
	}
}
