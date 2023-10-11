package BOJ_15685_드래곤커브;

import java.util.Scanner;
import java.util.Stack;

public class Main {
	static int N, cnt;
	static int[][] map;
	static boolean[][] visited;
	//세대에 따른 방향 우 상 좌 하
	static int[] dr = {0, -1, 0, 1};
	static int[] dc = {1, 0, -1, 0};
	//정사각형 체크
	static int[][] mdr = {
			{-1, -1 ,0},
			{0, 1, 1},
			{1, 1, 0},
			{0, -1, -1}
		
			};
	static int[][] mdc = {
			{0, 1, 1},
			{1, 1, 0},
			{0, -1, -1},
			{-1, -1, 0}
			};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//드래곤 커브의 개수 N(1 ≤ N ≤ 20)
		N = sc.nextInt();
		
		//x, y : 드래곤 커브의 시작점
		//d    : 시작 방향
		//g    : 세대
		
		map = new int[101][101];
		
		for(int i=0; i<N; i++) {
			int col = sc.nextInt();
			int row = sc.nextInt();
			int dir = sc.nextInt();
			int depth = sc.nextInt();
			
			// 0 -> 1
			// 1 -> 2
			// 2 -> 3
			// 3- > 0
			Stack<Integer> stack = new Stack<>();
//			int[] arr = new int[(int)Math.pow(2, depth)];
			//방향을 넣어주기
			stack.push(dir);
			map[row][col] = 1;
			//끝 정점 찍기
			int nr = row + dr[dir];
			int nc = col + dc[dir];
			
			
			
			for(int j=1; j<=depth; j++) {
				
//				for(int k=(int)Math.pow(2, j-1), idx =(int)Math.pow(2, j); k>=0; k--) {
//					arr[idx++]=(arr[k] + 1)%4;
//				}
				for(int k=stack.size()-1; k>=0; k--) {
					int currDir = (stack.get(k)+1)%4;
					map[nr][nc] = 1;
					nr += dr[currDir];
					nc += dc[currDir];
					stack.push(currDir);
				}
			}
			map[nr][nc]=1;

			stack.clear();
		}
		cnt = 0;
		visited = new boolean[101][101];
		//현재 좌표 기준으로
		//1. 좌, 좌 대각선, 하
		for(int i=0; i<101; i++) {
			for(int j=0; j<101; j++) {
				if(map[i][j]==1) {
					check(i, j);
				}
			}
		}
//		for(int[] m: map) System.out.println(Arrays.toString(m));
//		for(boolean[] m: visited) System.out.println(Arrays.toString(m));
		System.out.println(cnt);
		
	}
	private static void check(int row, int col) {
		visited[row][col] = true;
		for(int i=0; i<4; i++) {
			int tmp1=0;
			int tmp2=0;
			Stack<int[]> stack = new Stack<>();
			for(int d=0; d<3; d++) {
				int nr = row + mdr[i][d];
				int nc = col + mdc[i][d];
				if(nr>=0 && nr<101 && nc>=0 &&nc<101) {
					if(map[nr][nc]==1) tmp1 ++;
					if(visited[nr][nc]) tmp2 ++;
					stack.add(new int[] {nr,nc});
				}
			}
			//아직 체크하지 않은 정사각형 존재
			if(tmp1==3 && tmp2!=3) {
				cnt++;
				while(!stack.isEmpty()) {
					int[] pos = stack.pop();
					visited[pos[0]][pos[1]]=true;
				}
				
			}
		}
		
	}
}
