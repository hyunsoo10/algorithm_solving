package 순열과조합로직;

import java.util.Arrays;


public class Test {
	static int N = 5;
	static int[] tgt = {0, 1, 1, 2, 3 };
	static int cnt;


	public static void main(String[] args) throws Exception {
		// n! = 3 x 2 x 1 = 6 가지

		Arrays.sort(tgt);
		System.out.println("tgt[]: " + Arrays.toString(tgt));

		while (true) {
			System.out.println(Arrays.toString(tgt));
			cnt++;
			if (!np()) break;
		}

		System.out.println("총 가짓 수 : " + cnt);

	} // end main


	private static boolean np() {
		int i = N - 1;
		int j = i;
		int k = i;

		while (i > 0 && tgt[i - 1] >= tgt[i]) i--;

		if (i == 0) return false;

		while (tgt[i - 1] >= tgt[j]) j--;
		swap(tgt, i - 1, j);

		while (i < k) swap(tgt, i++, k--);

		return true;

	} // end np


	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	} // end swap
}