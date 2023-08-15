package BAEKJOON_14696_딱지놀이;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		String[] result = new String[N];

		for (int i = 0; i < N; i++) {
			int aNum = sc.nextInt();
			int[] a = new int[aNum];
			for (int j = 0; j < aNum; j++) {
				a[j] = sc.nextInt();
			}
			int bNum = sc.nextInt();
			int[] b = new int[bNum];
			for (int j = 0; j < bNum; j++) {
				b[j] = sc.nextInt();
			}

			// 새로운 배열에 각 숫자 빈도수 담은 후에 빈도수 끼리 비교
			int[] resultA = new int[5];
			int[] resultB = new int[5];

			for (int j = 0; j < aNum; j++) {
				resultA[a[j]]++;
			}
			for (int j = 0; j < bNum; j++) {
				resultB[b[j]]++;
			}
			boolean draw = true;
			for (int k = 4; k > 0; k--) {
				// A가 더 많을시
				if (resultA[k] > resultB[k]) {
					result[i] = "A";
					draw = false;
					break;
				} else if (resultA[k] < resultB[k]) {
					result[i] = "B";
					draw = false;
					break;
				} else {
					continue;
				}
			}
			if(draw)
				result[i] = "D";

		}
		for(String a : result) {
			System.out.println(a);
		}
	}
}
