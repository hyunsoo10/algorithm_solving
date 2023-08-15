package BAEKJOON_2292_벌집;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int level_max = 1;
		
		if (N == 1)
			System.out.println(1);
		else {
			for (int i = 1;; i++) {
				level_max += 6 * i;
				if(N <= level_max) {
					System.out.println(i+1);
					break;
				}
			}
		}
		sc.close();
	}
}
