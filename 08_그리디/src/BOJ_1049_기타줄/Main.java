package BOJ_1049_기타줄;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//끊어진 기타줄의 개수 
		int N = sc.nextInt();
		
		//기타줄 브랜드
		int M = sc.nextInt();

		int minOfPack = Integer.MAX_VALUE;
		int minOfEach = Integer.MAX_VALUE;
		for(int i=0; i<M; i++) {
			int tmp1 = sc.nextInt();
			int tmp2 = sc.nextInt();
			if(tmp1 < minOfPack) minOfPack = tmp1;
			if(tmp2 < minOfEach) minOfEach = tmp2;
		}

		int cost = 0;
		//필요한 기타줄 모두 살 때까지 반복
		while(N > 0) {
			if(N>=6) {
				int option1 = minOfPack;
				int option2 = minOfEach*6;
				if(option1 <= option2) {
					cost += option1;
				}
				else {
					cost+=option2;
				}
				N-=6;
			}else {
				int option1 = minOfPack;
				int option2 = minOfEach*N;
				if(option1 <= option2) cost += option1;
				else cost+=option2;
				break;
			}
		}
		System.out.println(cost);
	}
}
