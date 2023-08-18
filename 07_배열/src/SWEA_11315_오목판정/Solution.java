package SWEA_11315_오목판정;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();// 테스트 케이스

		for (int tc = 1; tc <= T; tc++) {
			String answer = "NO";// 정답 NO로 초기화
			int N = sc.nextInt(); // 오목판 크기

			char[][] omok = new char[N][N];

			for (int i = 0; i < N; i++) {
				omok[i] = sc.next().toCharArray();
			}
			
			firstloop:
			for (int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					//오목돌 발견하면 check 메소드 실행
					if(omok[i][j] == 'o') {
						
						//만약 check가 true라면 answer에 YES대입 후 전체 반복문 종료
						if(check(omok, N, i, j)) {
							answer = "YES";
							break firstloop;
						}
							
						
					}
				}
			}

			System.out.printf("#%d %s\n", tc, answer);
		}
	}
	public static boolean check(char[][] omok, int N, int row, int col) {
		
		//오른쪽, 오른쪽 대각선 아래, 아래, 왼쪽 대각선 아래
		int[] dr = {0, 1, 1, 1 };
		int[] dc = {1, 1, 0, -1};
	
		//델타 탐색
		for(int k = 0; k < 4; k++) {
			int nr = row;
			int nc = col;
			int cnt = 0;
			//본인 제외한 4칸이 모두 'o'가 채워져 있으면 TRUE 리턴
			for(int i = 0; i<4; i++) {
				nr += dr[k];
				nc += dc[k];
				//배열 범위 안에 있으면
				if(nr<N && nr>=0 && nc<N && nc>=0) {
					if(omok[nr][nc] == 'o')
						cnt ++; //돌 갯수 추가
				}
			}
			if(cnt == 4)
				return true;
		}
		return false;
	}
}
