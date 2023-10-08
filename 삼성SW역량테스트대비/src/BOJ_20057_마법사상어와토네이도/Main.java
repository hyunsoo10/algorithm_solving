package BOJ_20057_마법사상어와토네이도;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N;
	static int cnt=1;
	static int ans;
	static int [][]map, visited;
	//좌하우상
	static int[] dr = {0, 1, 0, -1 };
	static int[] dc = {-1, 0, 1, 0};
	
	//토네이도 마법 모래 위치
	static int[] rate = {1, 1, 2, 2, 5, 7, 7, 10, 10};
	static int[][] dx = {
			{-1, 1, -2, 2, 0, -1, 1, -1, 1},
			{0, 0, 1, 1, 3, 1, 1, 2, 2},
			{-1, 1, -2, 2, 0, -1, 1, -1, 1},
			{0, 0, -1, -1, -3, -1, -1, -2, -2},			
		};
	static int[][] dy = {
			{0, 0, -1, -1, -3, -1, -1, -2, -2},
			{-1, 1, -2, 2, 0, -1, 1, -1, 1},
			{0, 0, 1, 1, 3, 1, 1, 2, 2},
			{-1, 1, -2, 2, 0, -1, 1, -1, 1},
		};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		map = new int[N][N];
		visited = new int[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) map[i][j] = sc.nextInt();
		}
		
		//토네이도의 시작 위치
		int start = (N/2);
		
		dfs(start, start, 0);
		System.out.println(ans);
	}
	//중앙에서부터 바깥으로 달팽이 순회
	private static void dfs(int row, int col, int dir) {
		visited[row][col]=cnt++;
		//0,0 도착하면 토네이도 소멸
		if(row==0 && col==0) return;
		
		int nr = row + dr[dir];
		int nc = col + dc[dir];
		
		if(nr>=0 && nr<N && nc>=0 && nc<N && visited[nr][nc]==0) {
		magic(row, col, dir);
			dfs(nr, nc, (dir+1)%4);
		}else {
			//위의 if문에서 걸리지 못했으면
			//현재 내가 입력받은 방향의 이전 방향으로 가야된다.
			dir = (dir+3)%4;
		magic(row, col, dir);
			nr = row + dr[dir];
			nc = col + dc[dir];
			dfs(nr, nc, (dir+1)%4);
		}
		
	}
	//토네이도 마법 메서드
	private static void magic(int row, int col, int dir) {
		int nr = row + dr[dir];
		int nc = col + dc[dir];
		
		int sand = map[nr][nc];
		int total = sand;
		map[nr][nc] = 0;
		
		for(int k=0; k<9; k++) {
			//1%부터 10%까지 순차 탐색
			int tmp = (int)(total* (rate[k] * 0.01));
			//해당 모래가 뿌려질 좌표
			int nx = row + dx[dir][k];
			int ny = col + dy[dir][k];
			//범위 안에 있으면
			if(nx>=0 && nx<N && ny>=0 && ny<N) {
				//맵에 모래 추가
				map[nx][ny] += tmp;
				sand -= tmp;
			}else {
				//범위 벗어나면 정답에서 구할 모래양에 추가
				ans += tmp;
				sand -= tmp;
			}
		}
		//마지막으로 a위치 확인
		nr += dr[dir];
		nc += dc[dir];
		//a위치 안에 있는지 밖에 있는지에 따라 값 저장해주기
		if(nr>=0&&nr<N&&nc>=0&&nc<N) {
			map[nr][nc] += sand;			
		}else ans += sand;
		
		
	}
}
