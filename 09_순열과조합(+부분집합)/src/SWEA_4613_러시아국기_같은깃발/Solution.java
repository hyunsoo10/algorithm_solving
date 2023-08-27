package SWEA_4613_러시아국기_같은깃발;

import java.util.Scanner;

public class Solution {
	static int N, M, min;
	static char[][] map;
	static int[] arr, comb;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			N = sc.nextInt(); // N : 행의 수
			M = sc.nextInt(); // M : 열의 수
			map = new char[N][M];
			for(int i=0; i<N; i++) {
				map[i] = sc.next().toCharArray();
			}//국기 맵 정보 입력 끝
			
			//0 ~ N-2의 숫자 중에서 2개 조합 고르기
			arr = new int[N-1];
			int cnt=0;
			for(int i=0; i<arr.length; i++) {
				arr[i] = cnt++;
			}
			comb = new int[2]; // 2개씩 뽑아서 담을 배열
			min = Integer.MAX_VALUE;
			combination(0, 0, 2);
			System.out.printf("#%d %d\n", tc, min);
		}
	
	}
	
	//조합
	static void combination(int cnt, int start, int r) {
		//r개씩 뽑았을 때의 조합이 comb에 각각 담김
		if(cnt == r) {
			check(comb);
			return;
		}
		for(int i=start; i<arr.length; i++) {
			comb[cnt] = arr[i];
			combination(cnt+1, i+1, r);
		}
	}
	
	static void check(int[] arr) {
		int white = arr[0]; //첫번째 값이 white 색칠 마지막 행
		int blue = arr[1]; //두번째 값이 blue 색칠 마지막 행
		int cnt = 0; //총 색칠 해야 하는 횟수
		for(int j=0; j<M; j++) {
			for(int i=0; i<=white; i++) {
				if(map[i][j] != 'W')
					cnt++;
			}
			for(int i=white+1; i<=blue; i++) {
				if(map[i][j] != 'B')
					cnt++;
			}
			for(int i=blue+1; i<N; i++) {
				if(map[i][j] != 'R')
					cnt++;
			}
		}
		min = Math.min(min, cnt);
	}
}
