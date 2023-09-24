package BOJ_2178_미로탐색;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N, M;
	static char[][] map;
	static int[][] visited;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new char[N][M];
		visited = new int[N][M];
		for(int i=0; i<N; i++) {
			map[i] = sc.next().toCharArray();
		}//미로 정보 입력 끝

		bfs(0, 0);
//		for(int[] v: visited) {
//			System.out.println(Arrays.toString(v));
//		}
		System.out.println(visited[N-1][M-1]);
		
	}
	//bfs
	static void bfs(int row, int col) {
		Queue<int[]> queue = new LinkedList<>();
		//시작 좌표 넣어주고
		queue.add(new int[] {0, 0});

		//방문쳌
		visited[0][0] = 1;
		
		while(!queue.isEmpty()) {

			//queue에서 꺼내고
			int[] tmp = queue.poll();
			if(tmp[0]==N-1 &&  tmp[1]==M-1) {
				break;
			}
			//해당 좌표의 델타 탐색
			for(int i=0; i<4; i++) {
				int nr = tmp[0] + dr[i];
				int nc = tmp[1] + dc[i];
				//이동하려는 위치의 인덱스 쳌, 방문 쳌, 뚫려있는 지 쳌
				if(nr>=0 && nr<N && nc>=0 && nc<M && visited[nr][nc]==0 && map[nr][nc]=='1') {
					//방문쳌 (값을 깊이로 넣어주기)
					visited[nr][nc] = visited[tmp[0]][tmp[1]] + 1;
					queue.add(new int[] {nr, nc});
				}
			}
		}
		
	}
}
