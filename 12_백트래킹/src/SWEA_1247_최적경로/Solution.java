package SWEA_1247_최적경로;

import java.util.Scanner;

public class Solution {
	
	static class Pos{
		int x, y;

		public Pos(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	static int N; //고객의 수
	static Pos comp, home; //회사와 집의 좌표를 저장한 변수
	static Pos[] custPos; //고객 정보를 저장할 배열
	static int ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			N = sc.nextInt();
			comp = new Pos(sc.nextInt(), sc.nextInt());//회사 좌표
			home = new Pos(sc.nextInt(), sc.nextInt());//집 좌표
			ans = 987654321;
			
			for(int i=0; i<N; i++) {
				custPos[i] = new Pos(sc.nextInt(), sc.nextInt());
			} //입력 및 초기화 완료
			perm(0, 0, 0, comp);
			System.out.printf("#%d %d\n", tc, ans);
		}//tc
	}//main
	//idx : 몇 번째 자리인지
	//sel : 방문체크(visited boolean 배열 만들지 않고 비트 마스킹)
	//dist: 중간 결과 저장
	//curr: 현재 나의 좌표
	static void perm(int idx, int sel, int dist, Pos curr) {
		if(dist >= ans) return;
		
		//모든 고객 방문 완료
		if(idx == N) {
			//이제 집으로 귀가
			ans = Math.min(ans, dist + Math.abs(curr.x - home.x) + Math.abs(curr.y - home.y));
			return;
		}
		
		for(int i=0; i<N; i++) {
			//고객 체크
			//방문하지 않은 경우
			if((sel & (1<<i)) == 0) {
				perm(idx+1, sel|(1<<i),Math.abs(curr.x -custPos[i].x) + Math.abs(curr.y - custPos[i].y), custPos[i]);
			}
		}
	}
}
