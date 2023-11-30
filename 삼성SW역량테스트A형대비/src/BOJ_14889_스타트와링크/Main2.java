package BOJ_14889_스타트와링크;

import java.util.Scanner;

public class Main2 {
	static int N, min;
	static int[][] map;
	static boolean[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//N(4 ≤ N ≤ 20, N은 짝수)
		N = sc.nextInt();
		
		//1 <= S <=100 (능력치 값)
		//다 합쳐도 int 자료형 범위내에 있음
		map = new int[N][N];
		
		//map 정보 입력
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) map[i][j] = sc.nextInt();
		}

		visited = new boolean[N];
		
		min = Integer.MAX_VALUE;
		
		combination(0, 0);
		
		System.out.println(min);
		sc.close();

	
	}
	static void combination(int idx, int cnt) {
		//기저 조건: 다 뽑았음면 뽑은 숫자 담고 리턴
		if(cnt == N/2) {
			check();
			return;
		}
		// 재귀 파트
		for(int i=idx; i<N; i++) {
			//선택 확인
			if(!visited[i]) {
				visited[i] = true;//선택 체크
				combination(i+1, cnt+1);//재귀 호출
				visited[i] = false;//선택 해제
			}
		}
	}
	static void check() {

		int sum1 = 0;
		int sum2 = 0;
		//완전탐색으로 해당 팀의 시너지 구하기
		for(int i=0; i<N; i++) {
			for(int j=i+1; j<N; j++) {
				//1번팀과 2번팀 각각 시너지 합 구하기
				if(visited[i] && visited[j]) sum1 += map[i][j] + map[j][i];
				else if(!visited[i] && !visited[j]) sum2 += map[i][j] + map[j][i];
			}
		}
		
		/**두팀의 점수 차가 0이라면 탐색할 필요 없이 0을 출력하고 메인 메소드를 종료하면 된다.*/
		int ans = Math.abs(sum2-sum1);
		if(ans == 0) {
			System.out.println(0);
			System.exit(0);
		}
		//최소값 갱신
		min = Math.min(ans, min);
		
		
	}
}
