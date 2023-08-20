package SWEA_7087_문제_제목붙이기;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();//문제 제목 갯수
			
			char[] str = new char[N];
			for(int i = 0; i<N; i++) {
				str[i] = sc.next().charAt(0);
			}
			
			//'A'-'Z'까지 아스키 코드로 갯수 세기
			int[] count = new int[26];
			for(int i=0; i<N; i++) {
				count[str[i]-'A']++;
			}
			//정답 담을 변수
			int ans = 0; 
			for(int i=0; i<26; i++) {
				if(count[i]==0)
					break;
				ans++;
			}
			System.out.printf("#%d %d\n", tc, ans);
		}
	}
}
