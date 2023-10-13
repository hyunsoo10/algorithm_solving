package SWEA_5656_벽돌깨기;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
	static int N, H, W, cnt, min;
	static int[][] map, copyMap;
	static int[] nums, sel;
	static boolean[][] visited;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//구슬은 좌, 우로만 움직일 수 있어서 항상 맨 위에 있는 벽돌만 깨트릴 수 있다.
		//벽돌은 숫자 1 ~ 9 로 표현되며 구술이 명중한 벽돌은 상하좌우로 (벽돌에 적힌 숫자 - 1) 칸 만큼 같이 제거된다.
		
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			N = sc.nextInt();
			W = sc.nextInt();
			H = sc.nextInt();
			
			map = new int[H][W];
			for(int i=0; i<H; i++) {
				for(int j=0; j<W; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			//뽑을 숫자
			nums = new int[W];
			sel = new int[N];
			for(int i=0; i<W; i++) nums[i] = i;
			min = Integer.MAX_VALUE;
			//순열 돌리기
			perm(0, 0);
			
			System.out.printf("#%d %d\n",tc,min);
		}//end testCase
	
		
	}
	//W중에서 중복으로 3개 정하는 순열
	private static void perm(int idx, int sidx) {
		//sidx가 N이되면 return
		if(sidx == N) {
			
			copyMap = new int[H][W];
			//깊은 복사 후에 진행
			for(int i=0; i<H; i++) {
				for(int j=0; j<W; j++) {
					copyMap[i][j] = map[i][j];
				}
			}
			visited = new boolean[H][W];
			//해당 행 위치 정보를 갖고 벽돌 부시기
			for(int i=0; i<sel.length; i++) {
				play(sel[i]);
			}
			
			cnt = 0; //남은 벽의 수
			for(int i=0; i<H; i++) {
				for(int j=0; j<W; j++) {
					if(copyMap[i][j]!=0) cnt++;
				}
			}
			min = Math.min(cnt, min);
			if(min==0) return;
			return;
		}
		
		if(idx == W)  return;
		
		for(int i=0; i<W; i++) {
			//idx를 뽑고 담에 또 뽑아
			sel[sidx] = nums[i];
			perm(i, sidx+1);

		}
	}
	//벽돌 부수기
	private static void play(int startCol) {
		
		for(int i=0; i<H; i++) {
			//벽 만날 때 까지 내려가기
			if(copyMap[i][startCol] != 0) {
				//해당 칸의 폭발 범위
				//부쉈음
				
				bfs(i, startCol);
				organize();
				break;
			}
		}
	}
	
	private static void bfs(int row, int col) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {row, col, copyMap[row][col]});
		visited[row][col] = true;
		while(!queue.isEmpty()) {
			int[] curr = queue.poll();
			int x = curr[0];
			int y = curr[1];
			int range = curr[2];
			
			copyMap[x][y] = 0;
			for(int d=0; d<4; d++) {
				int nr = x;
				int nc = y;
				for(int r=0; r<range-1; r++) {
					nr += dr[d];
					nc += dc[d];
					//범위 내에 있다면
					if(nr>=0 && nr<H && nc>=0 && nc<W){
						if(!visited[nr][nc]) {
							queue.add(new int[] {nr, nc, copyMap[nr][nc]});
							visited[nr][nc]=true;
						}
					}
				}
			}
//			System.out.println("h");
		}
	}
	//벽돌 다 아래로 쌓기
	private static void organize() {
		for(int j=0; j<W; j++) {
			Stack<Integer> stack = new Stack<>();
			for(int i=0; i<H; i++) {
				if(copyMap[i][j] != 0) {
					stack.push(copyMap[i][j]);
					copyMap[i][j] = 0;
				}
			}
			int idx = H-1;
			while(!stack.isEmpty()) {
				copyMap[idx--][j] = stack.pop();
			}
		}
	}


}
