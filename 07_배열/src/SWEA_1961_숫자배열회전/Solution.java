package SWEA_1961_숫자배열회전;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt(); //N*N행렬
			
			String [][]map = new String[N][N];
			
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<N; j++) {
					map[i][j] = sc.next();
				}
			}
			
			//회전 시킨 배열 담을 배열
			String[][] printMap = new String[N][3];
			
			//열역 우선 탐색
			for(int j = 0; j<N; j++) {
				String tmp = "";
				for(int i = N-1; i>=0; i--) {
					tmp += map[i][j];
				}
				printMap[j][0] = tmp;
			}
			//행 열역 우선 탐색
			for(int i = N-1, idx=0; i>=0; i--) {
				String tmp = "";
				for(int j = N-1; j>=0; j--) {
					tmp += map[i][j];
				}
				printMap[idx++][1] = tmp;
			}
			//열 행역우선 탐색
			for(int j = N-1,idx=0; j>=0; j--) {
				String tmp = "";
				for(int i = 0; i<N; i++) {
					tmp += map[i][j];
				}
				printMap[idx++][2] = tmp;
			}
			
			System.out.printf("#%d\n", tc);
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<3; j++) {
					System.out.print(printMap[i][j] + " ");
				}
				System.out.println();
			}
			
		}//테스트 케이스 싸이클
	}

}
