package SWEA_4193_수영대회결승전;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	static int N;
	static int[][]map;
	//우 하 좌 상 방향
	static int d[][] = {{0,1}, {1,0},{0,-1},{-1,0}};
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			N = sc.nextInt(); //N*N 맵
			map = new int[N][N];
			boolean[][] visited = new boolean[N][N];
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			int startX = sc.nextInt();
			int startY = sc.nextInt();
			int endX = sc.nextInt();
			int endY = sc.nextInt();

			//큐 생성
			Queue<int[]> queue = new LinkedList<>();
			//첫 출발점 큐에 집어 넣기
			queue.offer(new int[] {startX, startY});
			visited[startX][startY] = true;//방문 체크
			int result = -1; //도착까지 몇초 걸리는지 담을 변수
			int time = 0; //현재 시간 담을 변수
			
			//queue가 빌 때 까지
out:		while(!queue.isEmpty()) {
				int size = queue.size();
				for(int i=0; i<size; i++) {
					int[] currPos = queue.poll(); //큐에서 값 꺼내기
					//4방향 탐색
					for(int x=0; x<4; x++) {
						int nr = currPos[0] + d[x][0];
						int nc = currPos[1] + d[x][1];
						//범위 내에 있고, 방문하지 않았고, 장애물이 아니라면
						if(nr>=0&&nr<N&&nc>=0&&nc<N && !visited[nr][nc] && map[nr][nc] != 1) {
							//만약 도착지점이라면
							if(nr == endX && nc == endY) {
								result = time + 1;//정답에 시간 담기
								break out;//전체 반복문 탈출								
							}
							
							//소용돌이가 있는 지점이고, 사라지지 않는 시간대라면
							if(map[nr][nc] == 2 && time%3 != 2) {
								//현재 좌표를 다시 큐에 넣는다.
								queue.offer(currPos);
							}else {
								//소용돌이가 사라진 경우라면
								//큐에 이동 좌표 넣어주기
								queue.offer(new int[] {nr, nc});
								visited[nr][nc] = true;
							}
						}
					}
				}//해당 시간에 한 작업 싸이클
				//시간 증가
				time++;
				
			}
			
			System.out.printf("#%d %d\n", tc, result);
		}
	}

}
