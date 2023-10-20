package BOJ_1072_게임;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		int X = sc.nextInt();
		int Y = sc.nextInt();
		
		int Z = getRate(X, Y);
		
		int ans = -1;
		int min = 0;
		int max = 1000000000;
		
		while(min <= max) {
			int mid = (min + max)/2;
			
			if(getRate(X+mid, Y+mid) != Z) {
				ans = mid;
				max = mid-1;
			}else min = mid+1;
		}
		System.out.println(ans);
	}
	static int getRate(int x, int y) {
		return (int)((long) y * 100/x);
	}
}
