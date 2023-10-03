package BOJ_16236_아기상어;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	//상좌우하 순서로 델타 탐색
	static int[] dr = {-1, 0, 0, 1};
	static int[] dc = {0, -1, 1, 0};
	//아기 상어의 초기 크기 2 초기화
	static int size = 2;
	static int N, eatable, eaten, time;
	static int[] shark;
	static int[][] map, visited, fish;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//문제 설명
		//아기 상어의 크기는 2이고, 아기 상어는 1초에 상하좌우로 인접한 한 칸씩 이동
		//아기상어는 자신보다 큰 물고기가 있는 칸은 지나가지 못함
		//아기상어는 자신보다 작은 물고기만 먹을수 있음
		//즉 크기가 같은 물고기가 있는 칸은 지나갈 수는 있지만 먹지는 못함
		
		//아기상어의 이동
		//1. 더 이상 먹을 수 있는 물고기가 공간에 없으면 엄마상어에게 도움 요청 - return 조건
		//2. 먹을 수 있는 물고기가 1마리라면 그 물고기를 먹으러 간다
		//3. 먹을 수 있는 물고기가 1마리보다 많다면 가장 가까운 물고기를 먹으러 감
		
		N = sc.nextInt();
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		eatable=1;
		while(true) {
			//bfs를 빠져나왔는데 eatable이 0이면 먹을수 있는 물고기가 없는 것임
			if(eatable == 0) break;
			//물고기 개수 다시 파악
			eatable = 0;
			//상어위치와 물고기 개수 파악
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					//아기 상어의  위치 저장
					if(map[i][j]==9) shark = new int[]{i, j};
					//초기에 먹을 수 있는 물고기의 개수 파악
					if(map[i][j] > 0 && map[i][j] < size  && map[i][j] != 9) eatable++;
				}
			}

			//먹을 수 있는 물고기가 없다면 반복문 탈출
			if(eatable == 0) break;
			//먹을 수 있는 물고기의 위치
			fish = new int[eatable][2];
			for(int i=0, idx=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					//먹을 수 있는 물고기의 위치
					if(map[i][j] > 0 && map[i][j] < size && map[i][j] != 9) fish[idx++] = new int[]{i, j};
				}
			}//상어 위치, 먹을 수 있는 물고기 위치 파악 끝
			
			//물고기 먹기
			bfs();
		}
		
		System.out.println(time);

	}
	//현재 아기 상어의 현재 위치에서 갈수 있는 칸 찾아서 먹기 위한 bfs
	static void bfs() {
		visited = new int[N][N];
		//방문 배열 -1로 초기화
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) visited[i][j] = -1;
		}
		
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {shark[0], shark[1]});
		visited[shark[0]][shark[1]] = 0;//방문 처리
		
		while(!queue.isEmpty()) {
			int[] pos = queue.poll();
			
			//4방향 델타 탐색
			for(int i=0; i<4; i++) {
				int nr = pos[0] + dr[i];
				int nc = pos[1] + dc[i];
				
				//인덱스 범위 && 방문 체크 && 아기상어의 크기보다 작거나 같은지
				if(nr>=0 && nr<N && nc>=0 && nc<N && visited[nr][nc]==-1 && map[nr][nc] <= size) {
					queue.add(new int[] {nr, nc});
					visited[nr][nc] = visited[pos[0]][pos[1]] + 1;
				}
			}
		}// end while
		
		int min = Integer.MAX_VALUE;
		//최소값 찾기
		for(int i=0; i<eatable; i++) {
			if(visited[fish[i][0]][fish[i][1]] != -1&& min > visited[fish[i][0]][fish[i][1]]) {
				min = visited[fish[i][0]][fish[i][1]];
			}
		}
		//먹으러 갈 수 있는 물고기가 없을경우엔 return
		if(min == Integer.MAX_VALUE) {
			eatable = 0;
			return;
		}

		int[] target = new int[2];
		//행 우선 탐색으로 1부터 시작해서 값을 찾으면 그 위치가 아기상어가 물고기를 먹어야 하는 위치이다
		for(int i=0; i<eatable; i++) {
			if(visited[fish[i][0]][fish[i][1]] != -1 &&visited[fish[i][0]][fish[i][1]] == min) {
				target[0] = fish[i][0];
				target[1] = fish[i][1];
				break;
			}
		}

		//타겟 물고기를 찾았으므로 상어 이동 작업 실시
		//1. 원래 상어가 있던 위치는 0으로 변경
		map[shark[0]][shark[1]] = 0;
		//2. 상어 위치 이동
		map[target[0]][target[1]] = 9;
		//3. 시간 증가
		time += min;
		//4. 상어가 현재 먹은 물고기 수 누적 후 크기 커질 수 있는 지 판단
		eaten ++;
		//사이즈만큼 먹으면 크기 증가
		if(size == eaten) {
			size++;
			eaten = 0;
		}


	}

}
