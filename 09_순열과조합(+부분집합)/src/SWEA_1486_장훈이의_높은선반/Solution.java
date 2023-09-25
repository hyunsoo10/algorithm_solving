package SWEA_1486_장훈이의_높은선반;

import java.util.Scanner;

public class Solution {
	static int N, B, min;
	static int[] height;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			N = sc.nextInt(); //N: 점원의 수
			B = sc.nextInt(); //B: 선반의 높이
			height = new int[N];
			min = Integer.MAX_VALUE;

			for(int i=0; i<N; i++) height[i]=sc.nextInt();

			for(int i=1; i<(1<<N); i++) {
				int sum=0;
				for(int j=0; j<N; j++) {
					if((i & (1<<j)) > 0) {
						sum += height[j];
					}
				}
				if(sum >=B ) min = Math.min(min, sum-B);
			}
			System.out.printf("#%d %d\n", tc, min);
		}
	}

}
