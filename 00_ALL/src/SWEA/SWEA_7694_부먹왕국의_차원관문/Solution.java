package SWEA.SWEA_7694_부먹왕국의_차원관문;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();// 부먹왕국의 도시 수
			int D = sc.nextInt();// 제한 거리
			int ans = 0; // 차원관문 필요 갯수
			sc.nextLine();
			char[] city = new char[N];
			String input = sc.nextLine().replace(" ", "");
			city = input.toCharArray();

			int idx = 0;// 이동 거리
			for (int i = 0; i < N; i++) {
				//한칸씩 이동하면서 확인
				idx++;
				//차원관문이 있는 곳이거나 거리가 최대 거리에 도달 했을 경우
				if(city[i]=='1'|| idx >=D) {
					//최대거리에 도달 했는데도 관문이 없으면 설치
					if(idx>=D && city[i]!='1') {
						city[i] = '2';//그냥 구분하기 위해 2찍기
						ans++;
					}
					idx=0;
					continue;
				}
				
			} // 도시 한 개 클리어
			System.out.printf("#%d %d\n", tc, ans);
		}
	}
}
