package BOJ_6603_로또;

import java.util.Scanner;

public class Main {
	static int k;
	static int[] nums, sel;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//k (6 < k < 13)
		do{
			k = sc.nextInt();
			if(k==0) break;
			
			nums = new int[k];
			sel = new int[6];
			for(int i=0; i<k; i++) nums[i] = sc.nextInt();
			comb(0, 0);
			System.out.println();
			
		}while(k>0);
	}
	
	static void comb(int idx, int sidx) {
		//기저 조건
		if(sidx==6) {
			for(int a : sel) System.out.print(a+ " ");
			System.out.println();
			return;
		}
		if(idx == k) return;
		
		//재귀 파트
		//해당 인덱스를 뽑아라
		sel[sidx] = nums[idx];
		comb(idx+1, sidx+1);
		//해당 인덱스를 뽑지마라
		comb(idx+1, sidx);
		
	}
}
