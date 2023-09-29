package BOJ_1149_RGB거리;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//N개의 집
		int N = sc.nextInt();
		
		int[][] map = new int[N][3];
		
		//map 정보 입력
		for(int i=0; i<N; i++) {
			for(int j=0; j<3; j++) map[i][j] = sc.nextInt();
		}
		
		int[] dpRed = new int[N];
		int[] dpGreen = new int[N];
		int[] dpBlue = new int[N];
		
		//각 페인트 색에 대한 dp 배열 첫번째 값 초기화
		dpRed[0] = map[0][0];
		dpGreen[0] = map[0][1];
		dpBlue[0] = map[0][2];
		
		//각 집 마다 페인트 색에 따라 최소값 을 갱신시켜가며 dp배열에 값 저장
		for(int i=1; i<N; i++) {
			dpRed[i] = Math.min(dpGreen[i-1], dpBlue[i-1]) + map[i][0];
			dpGreen[i] = Math.min(dpRed[i-1], dpBlue[i-1]) + map[i][1];
			dpBlue[i] = Math.min(dpRed[i-1], dpGreen[i-1]) + map[i][2];
		}
		//최종 red, green, blue dp 배열에 담긴 최소값 찾기
		int min = Math.min(dpRed[N-1], dpGreen[N-1]);
		min = Math.min(min, dpBlue[N-1]);
		
		//최종 최소값 출력
		System.out.println(min);
		
	}//end main
}
