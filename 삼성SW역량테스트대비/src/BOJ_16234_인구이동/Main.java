package BOJ_16234_인구이동;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N, L, R;
	static int[][] map, visited, visited2;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//1. 두 나라의 인구 차이가 L명 이상, R명 이하라면, 두 나라가 공유하는 국경선을 오늘 하루 동안 연다.
		//2. 국경선이 모두 열렸으면 인구이동 시작
		//3. (연합의 인구수) / (연합을 이루고 있는 칸의 개수)
		//4. 연합을 해체하고 모든 국경선 닫음
		//(1 ≤ N ≤ 50, 1 ≤ L ≤ R ≤ 100)
		N = sc.nextInt(); // N*N 크기 땅
		L = sc.nextInt(); 
		R = sc.nextInt();
		
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) map[i][j] = sc.nextInt();
		}
		int ans = 0;
		while(true) {
			int x = 0;
			visited = new int[N][N];
			//전체 for문 시작
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(visited[i][j] == 0)
						visited[i][j]=1;
						//인구 이동 일어난 개수 증가
						if(bfs(i, j)) x ++;
		
				}
			}
//			for(int[] m: visited) System.out.println(Arrays.toString(m));
//			for(int[] m: map) System.out.println(Arrays.toString(m));
			if(x>0)
				ans++;
			if(x==0) break;
		}	
		System.out.println(ans);
		
	}
	private static boolean bfs(int row, int col) {
		visited2 = new int[N][N];
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {row, col});
		int cnt = 1;
		int sum = map[row][col];
		visited2[row][col] = 1;
		while(!queue.isEmpty()) {
			int[] pos = queue.poll();
			int x = pos[0];
			int y = pos[1];
			
			//4방향 탐색
			for(int d=0; d<4; d++) {
				int nr = x + dr[d];
				int nc = y + dc[d];
				//인덱스 범위 내에 있을 때 && 방문 안했을 떄
				if(nr>=0 && nr<N && nc>=0 && nc<N && visited[nr][nc]==0) {
					int tmp = Math.abs(map[nr][nc] - map[x][y]);
//					System.out.println(tmp);
//					System.out.println(tmp);
					//인구 차이가 범위 안에 있으면 큐에 추가
					if(tmp >= L && tmp <=R) {
//						System.out.println("nr:" + nr);
						queue.add(new int[] {nr, nc});
						visited[nr][nc]=1;//방문처리
						visited2[nr][nc]=1;//방문처리
						cnt++;
						sum += map[nr][nc];
					}
				}
			}//4방향 탐색 종료
		}//while문 종료
//		for(int[] m: map) System.out.println(Arrays.toString(m));
//		System.out.println(cnt);
		//국경선이 열렸다면 해당 위치에서 갈 수 있는 모든 곳에 인구 이동 해주기
//		for(int[] m: map) System.out.println(Arrays.toString(m));
//		for(int[] m: visited) System.out.println(Arrays.toString(m));
		if(cnt > 1) {
			int num = sum/cnt;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(visited2[i][j]==1) {
						map[i][j] =  num;
					}
				}
			}// end for
//			for(int[] m: map) System.out.println(Arrays.toString(m));
//			for(int[] m: visited) System.out.println(Arrays.toString(m));
//			System.out.println("---------------");
			//인구 이동 가능
			return true;
		}//인구 이동 종료
		//인구 이동 불가능
		return false;
	}
}
