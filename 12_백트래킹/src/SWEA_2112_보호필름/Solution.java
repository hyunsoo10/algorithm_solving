package SWEA_2112_보호필름;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int D, W, K, ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt(); //총 테스트 케이스
		for(int tc=1; tc<=T; tc++) {
			D = sc.nextInt(); // D:두께
			W = sc.nextInt(); // W:가로크기
			K = sc.nextInt(); // K:합격기준
			
			int[][] film = new int[D][W];
			for(int i=0; i<D; i++) {
				for(int j=0; j<W; j++)
					film[i][j] = sc.nextInt();
			}
			
			//합격 기준이 1일 경우에는 검사할 필요 없이 정답 0
			if(K==1) {
				ans = 0;
			}else {
				//성능 검사
				for(int j=0; j<W-1; j++) {
					//연속 숫자 셀 임시 카운트 변수
					int cnt=1;
					boolean flag = false;
					for(int i=0; i<D; i++) {
						if(cnt == K) flag = true;
						//다음 열과 동일할 경우 cnt 증가
						if(film[i][j] == film[i][j+1]) {
							cnt++;
						}else cnt=1;						
					}//열 성능 검사 끝
					
				}				
			}
		
			System.out.println('B'-'A');
			System.out.println(Arrays.deepToString(film));
		}
	}
	static void check() {
		
	}
}
