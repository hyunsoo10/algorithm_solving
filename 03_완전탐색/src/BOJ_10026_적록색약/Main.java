package BOJ_10026_적록색약;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	static int N, cnt1, cnt2;
	static char[][] map;
	static boolean [][] visited1, visited2;
	//상하좌우 델타 탐색
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//필요한 변수 초기화
		N = sc.nextInt();
		map = new char[N][N];
		visited1 = new boolean[N][N];
		visited2 = new boolean[N][N];
		
		for(int i=0; i<N; i++) map[i] = sc.next().toCharArray();
		
		//적록색약이 아닌 사람은 bfs로 탐색, 적록색약인 사람은 dfs로 탐색(그냥 재미로)
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				//적록 색약아닌 사람
				if(!visited1[i][j]) {
					bfs(i, j);
					cnt1++;
				}
				//적록 색약인 사람
				if(!visited2[i][j]) {
					dfs(i, j);
					cnt2++;
				}
			}
		} // end for
		
		System.out.printf("%d %d", cnt1, cnt2);
	}
	
	//적록색약 아닌 경우
	static void bfs(int row, int col) {
		char color = map[row][col];
		Queue<int[]> queue = new LinkedList<>();
		//초기 시작 좌표 큐에 넣기
		queue.add(new int[] {row, col});
		//방문처리
		visited1[row][col] = true;
		
		//큐가 빌 때 까지
		while(!queue.isEmpty()) {
			int[] pos = queue.poll();
			
			for(int i=0; i<4; i++) {
				int nr = pos[0] + dr[i];
				int nc = pos[1] + dc[i];
				
				//인덱스 범위 내 && 방문 쳌 && 같은 색상
				if(nr >=0 && nr<N && nc>=0 && nc<N && !visited1[nr][nc] && map[nr][nc] == color) {
					queue.add(new int[] {nr, nc});
					visited1[nr][nc] = true;
				}
			}
		}
		
	}
	//적록색약인 경우
	static void dfs(int row, int col) {
		char color = map[row][col];
		Stack<int[]> stack = new Stack<>();
		//초기값 넣어주기
		stack.add(new int[] {row, col});
		//방문처리
		visited2[row][col] = true;
		
		//스택이 빌 때 까지
		while(!stack.isEmpty()) {
			int[] pos = stack.pop();
			
			for(int i=0; i<4; i++) {
				int nr = pos[0] + dr[i];
				int nc = pos[1] + dc[i];
				
				//인덱스 범위 내 && 방문 쳌 && (같은 색상 or 적록색약 구분 불가 색상)
				if(nr >=0 && nr<N && nc>=0 && nc<N && !visited2[nr][nc] && (map[nr][nc] == color || lens(map[nr][nc]) == color)) {
					stack.add(new int[] {nr, nc});
					visited2[nr][nc] = true;
				}
			}
			
		}
		
	}
	
	//적록색약 색상 인식 메소드
	static char lens(char color) {
		//빨간색과 초록색을 동일하게 인식
		if (color == 'R') return 'G';
		if (color == 'G') return 'R';
		else return color;
	}
}

