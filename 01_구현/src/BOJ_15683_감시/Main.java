package BOJ_15683_감시;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N, M, cnt, walls;
	static int[][] map;
	static int[][] check;
	
	static int max = Integer.MIN_VALUE;
	
	//상 하 좌 우 델타 탐색
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	//감시 카메라 위치
	static int[][] location;
	
	//카메라
	static int[] camera;
	//카메라 회전 담을 부분집합 배열
	static int[] rotate;
	
	//감시 카메라 방향
	static int [][][] direction = {
			{{}},
			{{0, 0, 0, 1}, {0, 0, 1, 0}, {0, 1, 0, 0}, {1, 0, 0, 0}}, //1번
			{{0, 0, 1, 1}, {1, 1, 0, 0}}, //2번은 좌우
			{{1, 0, 0, 1}, {0, 1, 0, 1}, {0, 1, 1, 0}, {1, 0, 1, 0}}, //3번은 상우
			{{1, 0, 1, 1}, {1, 1, 0, 1}, {1, 1, 1, 0},{0, 1, 1, 1}}, //4번은 상좌우
			{{1, 1, 1, 1}}  //5번은 상하좌우
	};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
	
		
		location = new int[8][2];
		camera = new int[8];
		Arrays.fill(camera, -1);
		//카메라의 개수
		cnt = 0;
		//벽의 개수
		walls = 0;
		//map 정보 입력
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				map[i][j] = sc.nextInt();
				//감시 카메라 위치 좌표 저장
				if(map[i][j] !=0 && map[i][j] !=6) {
					location[cnt][0] = i;
					location[cnt][1] = j;
					camera[cnt] = map[i][j];
					//카메라의 개수
					cnt++;
				}
				if(map[i][j] == 6) walls++;
			}
		}
		
		rotate = new int[cnt];
//		System.out.println(Arrays.toString(camera));
		powerset(0);
	
		
		sc.close();
		System.out.println(N*M - max - walls - cnt);
	}
	
	static void powerset(int idx){
		if(idx == cnt) {
//			System.out.println(Arrays.toString(rotate));
			//감시구역 표시할 map
			check = new int[N][M];
			scan();
			count();
			return;
		}
		
		//1번 카메라면 0~3 가능
		if(camera[idx] == 1) {
			rotate[idx] = 0;
			powerset(idx+1);
			rotate[idx] = 1;
			powerset(idx+1);
			rotate[idx] = 2;
			powerset(idx+1);
			rotate[idx] = 3;
			powerset(idx+1);
		} 
		//2번 카메라면 0~1 가능
		else if(camera[idx] == 2) {
			rotate[idx] = 0;
			powerset(idx+1);
			rotate[idx] = 1;
			powerset(idx+1);
		}else if(camera[idx] == 3) {
			rotate[idx] = 0;
			powerset(idx+1);
			rotate[idx] = 1;
			powerset(idx+1);
			rotate[idx] = 2;
			powerset(idx+1);
			rotate[idx] = 3;
			powerset(idx+1);
		}
		else if(camera[idx] == 4) {
			rotate[idx] = 0;
			powerset(idx+1);
			rotate[idx] = 1;
			powerset(idx+1);
			rotate[idx] = 2;
			powerset(idx+1);
			rotate[idx] = 3;
			powerset(idx+1);
		}else {
			rotate[idx] = 0;
			powerset(idx+1);
		}
	}
	
	static void scan(){
		//camera 돌면서 감시 범위 찍어주기
		for(int i=0; i<cnt; i++) {
			int row = location[i][0];
			int col = location[i][1];
			for(int d=0; d<4; d++) {
				int nr = row + dr[d];
				int nc = col + dc[d];
				if(nr>=0 && nr<N && nc>=0 && nc<M && direction[camera[i]][rotate[i]][d] == 1 &map[nr][nc] != 6) {
					dfs(i, nr, nc, d);
				}
			}
		}
	}
	static void dfs(int idx, int row, int col, int dir) {
		if(row<0|| row>=N || col<0 || col>=M) return;
	
		


		if(map[row][col] == 6)return;
		
		if(map[row][col] ==  0) {
			check[row][col] = 1;
		}
		
		dfs(idx, row+dr[dir], col+dc[dir], dir);
	

	}
	static void count() {
		int tmp = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(check[i][j] == 1) tmp++;
			}
		}
		//scan 가능 구역 최대값 갱신
		max = Math.max(max, tmp);
	}
}
