package SWEA_2005_파스칼의삼각형;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();//크기가 N인 삼각형
			
			int[][] pascal = new int[N][N];
			//첫 번째 값에 모두 1 추가
			for(int i=0; i<N; i++) {
				pascal[i][0] = 1;				
			}
			
			//파스칼 삼각형 찍기
			for(int i = 1; i<N; i++) {
				for(int j=1; j<N; j++) {
					pascal[i][j] = pascal[i-1][j-1] + pascal[i-1][j];
				}
			}
			
			
			System.out.printf("#%d\n", tc);
			for(int i=0; i<N; i++) {
				for(int j = 0; j<=i; j++) {
					System.out.print(pascal[i][j]+" ");
				}
				System.out.println();
			}
			
		}
	}
}
