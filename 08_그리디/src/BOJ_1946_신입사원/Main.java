package BAEKJOON_1946_신입사원;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();
			
			/* 시간초과 
			int[][] ranks = new int[N][2];//서류, 면접 순위 담을 배열
			
			for(int i=0 ; i<N; i++) {
				//0번인덱스에 서류순위, 1번 인덱스에 면접순위
				ranks[i][0]=sc.nextInt();
				ranks[i][1]=sc.nextInt();
			}
			
			//0번 인덱스 기준으로 오름차순 정렬
			Arrays.sort(ranks, (o1, o2) -> {
				return(o1[0]-o2[0]);
			});
			
			int cutline = ranks[0][1]; //서류1등의 면접 순위가 첫번째 커트라인
			int cnt = 1; //서류1등은 일단 통과
			for(int i = 1; i<N; i++) {
				//커트라인 보다 순위가 높으면
				if(ranks[i][1] < cutline) {
					cnt++;
					cutline = ranks[i][1]; // cutline 갱신
				}
			}
			*/
			//1번인덱스부터 활용해야 하므로 N+1크기
			int[] ranks = new int[N+1];
			for(int i = 0; i<N; i++) {
				//서류 순위를 인덱스로, 면접 순위를 값으로
				ranks[sc.nextInt()] = sc.nextInt();
			}
			int cnt = 1;//서류1등은 일단 합격
			int cutline = ranks[1];//서류1등의 면접순위가 첫번째 커트라인 순위
			for(int i = 2; i<=N; i++) {
				// 면접순위 커트라인보다 높은 순위면 합격
				if(ranks[i] < cutline) {
					cnt++;
					cutline = ranks[i];//커트라인 갱신
				}
			}
			System.out.println(cnt);
			
		}
	}
}
