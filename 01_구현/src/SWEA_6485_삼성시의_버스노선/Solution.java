package SWEA_6485_삼성시의_버스노선;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			
			//N개의 버스노선
			int N = sc.nextInt();
			int[][] bus = new int[N][2];
			for(int i=0; i<N; i++) {
				bus[i][0] = sc.nextInt();
				bus[i][1] = sc.nextInt();
			}
			//정류장 정보
			int P = sc.nextInt();
			//출력 순서 
			int[] order = new int[P];
			for(int i=0; i<P; i++) {
				order[i] = sc.nextInt();
			}
			//0번 인덱스 활용 안하기 때문에 P+1크기로 선언
			int[] stop = new int[5001];
			
			for(int i = 0; i<N; i++) {
				for(int j = bus[i][0]; j<=bus[i][1]; j++) {					
					stop[j]++;
				}
			}
			System.out.printf("#%d", tc);
			for(int i=0; i<P; i++) {
				System.out.print(" "+ stop[order[i]]);
			}
			System.out.println();
			
		}
	}
}
