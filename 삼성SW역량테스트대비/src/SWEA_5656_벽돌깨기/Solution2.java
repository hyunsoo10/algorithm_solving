package SWEA_5656_벽돌깨기;

import java.util.Scanner;
import java.util.Stack;

public class Solution2 {
	static int N, W, H;
	static int cnt, minCnt;
	static int[][] map, map2;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			N = sc.nextInt(); // N : 구슬 발사 횟수
			W = sc.nextInt(); // W : 구슬 맵 넓이
			H = sc.nextInt(); // H : 구슬 맵 높이
			minCnt = Integer.MAX_VALUE;
			map = new int[H][W];
			for(int i=0; i<H; i++) {
				for(int j=0; j<W; j++) {
					map[i][j] = sc.nextInt();					
				} 
			}//map 정보 입력 끝
			
			int[] arr = new int[W];
			for(int i=0; i<W; i++) {
				arr[i] = i;
			}
			int[] result = new int[N];
			
			duplicatePerm(arr,result, 0, N);
			
			System.out.printf("#%d %d\n", tc, minCnt);
		}
	}
	//0~W 까지의 숫자 중에서 N개의 숫자 뽑는 중복순열
	static void duplicatePerm(int[] arr, int[] result, int depth, int r) {
		if(depth == r) {
			//중복 순열
			cnt=0;
			//map2에 복사본 만들어서 사용
			map2 = arrayCopy(map); 
//			System.out.println(Arrays.deepToString(map2));
			for(int a : result) {
//				System.out.print(a);
				breakWall(a);
			}
//			System.out.println();
			//남은 벽돌 세주기
//			System.out.println(Arrays.deepToString(map2));
			for(int i=0; i<H; i++) {
				for(int j=0; j<W; j++) {
					if(map2[i][j] != 0)
						cnt++;
				} 
			}
//			System.out.println(cnt);
			minCnt = Math.min(cnt, minCnt);
			return;
		}
		for(int i=0; i<arr.length; i++) {
			result[depth] = arr[i];
			duplicatePerm(arr, result, depth+1, r);
		}
	}
	
	//벽돌 깨기
	static void breakWall(int j) {
		for(int i=0; i<H; i++) {
			if(map2[i][j] != 0) {
				dfs(i, j, map2[i][j]);
				break;
			}
			//벽돌 한번 깨고 나면 벽돌 다시 재배치
		}
		organize(map2);
	}
	static void dfs(int i, int j, int num) {
//		//범위를 벗어날 경우  return
//		if(i<0 || i >= H || j <0 || j >= H || num == 0)
//			return;
//		
		//해당 위치 벽돌 뿌시기
		map2[i][j] = 0;
		
		//우측 탐방
		for(int x=j+1; x<W && x<j+num; x++) {
			dfs(i, x, map2[i][x]);
		}
		//좌측 탐방
		for(int x=j-1; x>=0 && x>j-num; x--) {
			dfs(i, x, map2[i][x]);
		}
		//아래 탐방
		for(int x=i+1; x<H && x<i+num; x++) {
			dfs(x, j, map2[x][j]);
		}
		//위 탐방
		for(int x=i-1; x>=0 && x>i-num; x--) {
			dfs(x, j, map2[x][j]);
		}
	}
	
	//벽돌 부순 후에 벽돌 내리기
	static void organize(int[][] map) {
		Stack<Integer> stack = new Stack<>();
		int[][] map3 = new int[H][W];
		
		for(int j=0; j<W; j++) {
			for(int i=0; i<H; i++) {
				if(map[i][j] != 0)
					stack.add(map[i][j]);
			}
			for(int i=H-1; i>=0; i--) {
				if(!stack.isEmpty())
					map3[i][j] = stack.pop();
			}
		}
		map2 = map3;
	}
	
	static int[][] arrayCopy(int[][] map) {
		int tmp[][] = new int[H][W];
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map[i].length; j++) {
				tmp[i][j] = map[i][j];
			}
		}
		return tmp;
	}

}
