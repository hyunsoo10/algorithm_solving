package BOJ_1094_막대기;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int X = sc.nextInt();
		int ans = 0;
		String binary = Integer.toBinaryString(X);
		for(int i=0; i<binary.length(); i++) {
			if(binary.charAt(i)=='1') ans++;
		}
		System.out.println(ans);
	}
}
