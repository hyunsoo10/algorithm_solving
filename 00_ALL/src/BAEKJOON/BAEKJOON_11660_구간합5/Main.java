package BAEKJOON.BAEKJOON_11660_구간합5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); //N*N행렬
		int M = Integer.parseInt(st.nextToken()); ///M번 구간합
		
		//인덱스번호 1부터 사용하기 위해 N+1크기로 생성
		int[][] matrix = new int[N+1][N+1];
		
		//N*N행렬 입력값 받기
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				matrix[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		//구간합 배열 생성
		int[][] sumMatrix = new int[N+1][N+1];
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				sumMatrix[i][j] = sumMatrix[i-1][j] + sumMatrix[i][j-1] + matrix[i][j] - sumMatrix[i-1][j-1];
			}
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			System.out.println(sumMatrix[x2][y2]-sumMatrix[x1-1][y2]-sumMatrix[x2][y1-1]+sumMatrix[x1-1][y1-1]);
		}
	}
}
