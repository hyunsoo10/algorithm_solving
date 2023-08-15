package SWEA_5658_보물상자_비밀번호;

import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int testCase = 1; testCase <= T; testCase++) {
			int N = sc.nextInt(); // N개의 숫자(4의 배수)
			int K = sc.nextInt(); // K번째 숫자 구하기
			sc.nextLine();
			int M = N / 4; // 비밀번호 한 구역당 개수
			TreeSet<String> tree = new TreeSet<>(Collections.reverseOrder());

			// 전체 비밀번호 숫자 받기
			String str = sc.nextLine();
			// 배열로 받기
			String[] arr = str.split("");

			for (int i = 0; i < M; i++) {
				String tmp = arr[N - 1];
				for (int j = N - 1; j > 0; j--) {
					arr[j] = arr[j - 1];
				}
				arr[0] = tmp;

				for (int j = 0; j < arr.length; j+=M) {
					String word = "";
					for(int k = j; k<j+M; k++) {
						word+=arr[k];
					}
					tree.add(word);
				}
			}
			for(int i = 0; i <K-1; i++) {
				tree.pollFirst();
			}
			String answer2 = tree.pollFirst();
			int answer = toTen(answer2);
			System.out.printf("#%d %d\n", testCase, answer);

		}
	}

	public static int toTen(String hex) {
		// 13F
		int len = hex.length();
		int[] arr = new int[len];
		String[] arr2 = hex.split("");
		for (int i = 0; i < len; i++) {
			String str = arr2[len - i - 1];
			switch (str) {
			case ("A"):
				arr[i] = 10;
				break;
			case ("B"):
				arr[i] = 11;
				break;
			case ("C"):
				arr[i] = 12;
				break;
			case ("D"):
				arr[i] = 13;
				break;
			case ("E"):
				arr[i] = 14;
				break;
			case ("F"):
				arr[i] = 15;
				break;
			default:
				arr[i] = Integer.parseInt(str);
			}
		
		}
		int sum = 0;
		
		for (int i = 0; i < len; i++) {
			int tmp = 1;
			for(int k = 0; k<i; k++) {
				tmp*=16;
			}
			sum += arr[i] * tmp;
		}

		return sum;
	}

}
