package SWEA_3499_퍼펙트셔플;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			
			//중간 인덱스 구하기
			int mid;
			//N이 짝수일 경우와 홀수일 경우 나눠서
			if(N%2==0)
				mid = N/2;
			else
				mid = N/2+1;
		
			String[] firstDeck = new String[mid];
			String[] secondDeck = new String[N-mid];
			
			for(int i=0; i<mid; i++) {
				firstDeck[i] = sc.next();
			}
			for(int i=0; i<N-mid; i++) {
				secondDeck[i] = sc.next();
			}
			System.out.printf("#%d ", tc);
			int idx = 0;
			while(idx <= mid) {
				//인덱스가 firstDeck의 최대 길이 보다 작을 때만
				if(idx < mid)
					System.out.print(firstDeck[idx]+" ");
				//인덱스가 secondDeck의 최대 길이 보다 작을 때만
				if(idx < N-mid)
					System.out.print(secondDeck[idx]+" ");
				idx++;
			}
			System.out.println();
		}
	}
}
