package BOJ_14658_하늘에서별똥별이빗발친다;

import java.util.Scanner;

public class Main {
	static int N, M, L, K;
	static int[][] stars;
	static int max = 0;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//N : 별똥별이 떨어지는 구역의 가로 길이
		//M : 별똥별이 떨어지는 구역의 세로 길이
		N = sc.nextInt();
		M = sc.nextInt();
		
		//트램펄린의 한 변의 길이
		L = sc.nextInt();
		
		//별똥별의 수
		K = sc.nextInt();
		
		
		stars = new int[K][2];
		
		for(int i=0; i<K; i++) {
			//별똥별의  x,y좌표
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			stars[i][0]=x;
			stars[i][1]=y;
		}

		for(int i=0; i<K; i++) {
			for(int j=0; j<K; j++) {
				int startX = Math.min(stars[i][0], stars[j][0]);
				int startY = Math.min(stars[i][1], stars[j][1]);
				count(startX, startY);
			}
		}
		
		
		System.out.println(K-max);
		
		
	}
	//트램펄린 구역내의 별똥별 개수 세기
	private static void count(int x, int y) {
		
		int cnt = 0;
		for(int i=0; i<K; i++) {
			if(stars[i][0] >=x && stars[i][0] <= x+L && stars[i][1] >=y && stars[i][1] <= y+L)
				cnt++;
		}
		
	
		max = Math.max(max, cnt);
	}
}
