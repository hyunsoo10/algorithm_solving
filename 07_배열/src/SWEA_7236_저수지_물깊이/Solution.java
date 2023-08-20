package SWEA_7236_저수지_물깊이;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); //N*N저수지
			sc.nextLine();
			
			char[][] map = new char[N][N];
			
			for(int i=0; i<N; i++) {
				map[i]= sc.nextLine().replace(" ", "").toCharArray();
			}
			//물의 깊이 담을 배열
			int[][] deep = new int[N][N];
			//물의 깊이에 가중치가 없으므로 끝 라인들은 검사 할 필요 없음
			for(int i=1; i<N-1; i++) {
				for(int j = 1; j<N-1; j++) {
					deep[i][j] = howDeep(map, i, j);
				}
			}
			
			int max = 0;
			for (int i=1; i<N-1; i++) {
				for(int j=1; j<N-1; j++) {
					if(deep[i][j]>max)
						max = deep[i][j];
				}
			}
			
			System.out.printf("#%d %d\n", tc, max);
		}
	}
	public static int howDeep(char[][]map, int row, int col){
		
		//델타 탐색 12시방향부터 시계방향으로  8 방향 탐색
		int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
		int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
		
		int cnt = 0;//W의 개수
		for(int i=0; i<8; i++) {
			if(map[row+dr[i]][col+dc[i]]=='W')
				cnt++;
		}
		//주변 8방향에 W가 없으면 깊이는 1로 고정
		if(cnt==0)
			return 1;
		return cnt;
	}
}
