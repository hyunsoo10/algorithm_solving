package SWEA_1952_탈주범검거;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	
	static int N, M, startR, startC, L; 
	static int[][] map, visited;
	//상하좌우 순서로 
	static int[][] dir = {
			{},
			{1, 1, 1, 1},
			{1, 1, 0, 0},
			{0, 0, 1, 1},
			{1, 0, 0, 1},
			{0, 1, 0, 1},
			{0, 1, 1, 0},
			{1, 0, 1, 0}
	};
	//상하좌우 4방향 델타 탐색
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(input);
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			//N*M맵
			N = sc.nextInt();
			M = sc.nextInt();
			//시작 좌표
			startR = sc.nextInt();
			startC = sc.nextInt();
			//경과 시간
			L = sc.nextInt();
			
			map = new int[N][M];
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) map[i][j] = sc.nextInt();
			}
			
//			for(int[] a : map) System.out.println(Arrays.toString(a));
			
			//방문 배열 초기화
			visited = new int[N][M];
			visited[startR][startC] = 1;
			bfs(startR, startC);
			
//			for(int[] v : visited)System.out.println(Arrays.toString(v));
			int cnt = 0;
			for(int[]v : visited) {
				for(int a : v) if(a>0 && a<=L) cnt ++;
			}
			System.out.printf("#%d %d\n", tc, cnt);
		}//end testCase
	}
	
	//row: 행, col: 열, dir: 이전 터널의 유형
	static void bfs(int row, int col) {
		
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {row, col});
		
		while(!queue.isEmpty()) {
			int[] pos = queue.poll();
			//내 위치의 터널 정보
			int type = map[pos[0]][pos[1]];
			//4방향 탐색
			for(int i=0; i<4; i++) {
				//1. 내가 갈 수 있는 방향으로만 시도
				if(dir[type][i] == 1) {
					int nr = pos[0] + dr[i];
					int nc = pos[1] + dc[i];
					//범위 쳌 && 방문 쳌
					if(nr>=0 && nr<N && nc>=0 && nc<M && visited[nr][nc] == 0 && map[nr][nc]!=0) {
						//다음 터널의 타입이 내 방향과 연결되어 있는지 확인
						if(dir[map[nr][nc]][changeDir(i)] == 1) {
							visited[nr][nc] = visited[pos[0]][pos[1]] + 1;
							queue.offer(new int[] {nr, nc});
						}
					}
				}
			}//4방향 탐색 끝
			
		}//end of while
		
	}

	//다음 터널에서는 내 터널 정보의 반대 방향과 연결되어있어야 하므로
	//방향을 바꿔서 다음 터널에 정보를 보내주기 위한 메소드
	static int changeDir(int x) {
		if(x==0) return 1;
		else if(x==1) return 0;
		else if(x==2) return 3;
		else return 2;
	}
	static String input =
			"1\r\n" + 
			"5 6 2 1 3\r\n" + 
			"0 0 5 3 6 0\r\n" + 
			"0 0 2 0 2 0\r\n" + 
			"3 3 1 3 7 0\r\n" + 
			"0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0"
			+ "";
}
