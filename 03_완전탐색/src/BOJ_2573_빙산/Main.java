package BOJ_2573_빙산;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N, M, count, year;
	static int[][] map, ocean, visited;
	//상하좌우 델타탐색
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//변수 초기화
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) map[i][j] = sc.nextInt();
		}
		
		while(true) {
			
			//1. 해당 빙산 주변에 위치하는 바다의 개수 세기
			ocean = new int[N][M];
			for(int i=1; i<N-1; i++) {
				for(int j=1; j<M-1; j++) {
					//해당 위치에 빙산이 있을 때 count 메서드로  주변 바다 개수 카운팅
					if(map[i][j] != 0)
						count(i, j);
				}
			}
			//2. ocean 배열을 활용해서 빙산 녹이기
			melting();
			year++;//1년 증가
			//3. 빙산 개수 카운팅
			count = 0;
			visited = new int[N][M];
			int zero = 0;//남아 있는 빙산 개수 셀 변수
			for(int i=1; i<N-1; i++) {
				for(int j=1; j<M-1; j++) {
					//빙산 덩어리 개수 세기 위한 bfs진입 조건
					if(map[i][j] !=0 && visited[i][j] == 0) {
						visited[i][j] = 1;//방문 처리
						//빙산 덩어리 체크
						bfs(i, j);
						count++;
					}
					//빙산 개수 세기
					if(map[i][j] != 0) zero++;
				}
			}
			//종료 조건
			//1. count가 2개 이상이되면 반복문 종료
			if(count>=2) break;
			//2. count가 2가 되기전에 빙산이 전체가 녹으면 year에 0대입하고 반복문 종료
			if(zero==0) {
				year = 0;
				break;
			}
		}
		//정답 출력
		System.out.println(year);
		
	}//main method
	
	//빙산 녹이기 메서드
	static void melting() {
		for(int i=1; i<N-1; i++) {
			for(int j=1; j<M-1; j++) {
				if(map[i][j] != 0) {
					int tmp = map[i][j] - ocean[i][j];
					//만약 음수라면 그냥 0으로 
					if(tmp < 0) map[i][j] = 0;
					else map[i][j] = tmp;
				}
			}
		}
	}
	//빙산 덩어리 체크 메서드
	static void bfs(int row, int col) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {row, col});
		
		while(!queue.isEmpty()) {
			int[] pos = queue.poll();
			for(int d=0; d<4; d++) {
				int nr = pos[0] + dr[d];
				int nc = pos[1] + dc[d];
				
				//인덱스 범위 && 방문 && 빙산인지
				if(nr>=0 && nr<N && nc>=0 && nc<M && visited[nr][nc]==0 && map[nr][nc] != 0) {
					queue.add(new int[] {nr, nc});
					visited[nr][nc] = 1;//방문처리
				}
			}//4방향 탐색 끝
		}//while문 종료
	}
	//주변 바다 개수 세기 메서드
	static void count(int i, int j) {
		int tmp = 0;
		for(int d=0; d<4; d++) {
			int nr = i + dr[d];
			int nc = j + dc[d];
			//바다 개수 카운팅
			if(map[nr][nc]==0) tmp++;
		}
		//바다 개수 저장
		ocean[i][j] = tmp;
	}
}
