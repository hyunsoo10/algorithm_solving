package SWEA_5644_무선충전;

import java.util.Scanner;

public class Solution {
	//정지 상 우 하 좌
	static int[] dr = {0, -1, 0, 1, 0};
	static int[] dc = {0, 0, 1, 0, -1};
	//충전범위 체크 : 12시 방향부터 시계방향
	static int[][] cdr = {
			{0}, // C=0
			{-1, 0, 1, 0}, //1
			{-2, -1, 0, 1, 2, 1, 0, -1}, //2
			{-3, -2, -1, 0, 1, 2, 3, 2, 1, 0, -1, -2}, //3
			{-4,-3,-2,-1, 0, 1, 2, 3, 4, 3, 2, 1, 0,-1,-2,-3} //4
	};
	static int[][] cdc = {
			{0}, // C=0
			{0, 1, 0, -1}, //1
			{0, 1, 2, 1, 0, -1, -2 ,-1}, //2
			{0, 1, 2, 3, 2, 1, 0,-1,-2,-3,-2,-1}, //3
			{0, 1, 2, 3, 4, 3, 2, 1, 0,-1,-2,-3,-4,-3,-2,-1}, //4
	};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//테스트케이스
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			
			//M : 총 이동 시간 (20 ≤ M ≤ 100)
			int M = sc.nextInt();
			//A : BC의 개수 (1 ≤ A ≤ 8)
			int A = sc.nextInt();
			
			//사용자 A와 B의 이동 정보
			int[] moveA = new int[M+1];
			int[] moveB = new int[M+1];
			for(int i=0; i<M ;i++) moveA[i] = sc.nextInt();
			for(int i=0; i<M ;i++) moveB[i] = sc.nextInt();
			
			//BC 정보 담을 map
			int[][][] map = new int[A+1][11][11];
			//BC 정보 입력
			//row: 행 / col: 열  / range: 충전범위 C / power: 성능P 
			for(int i=0; i<A; i++) {
				int col = sc.nextInt();
				int row = sc.nextInt();
				int range = sc.nextInt();
				int power = sc.nextInt();
				
				//충전 범위 체크
				for(int r = 0; r <= range; r++) {
					//해당하는 범위에 모두 BC 체크
					for(int k=0; k < cdr[r].length; k++) {
						int nr = row + cdr[r][k];
						int nc = col + cdc[r][k];
						//인덱스 범위 체크
						if(nr>=1 && nr<11 && nc>=1 && nc<11) {
							//i번째 BC가 nr, nc에서 발휘할 수 있는 power 저장
							map[i][nr][nc] = power;
							if(map[A][nr][nc] < power) map[A][nr][nc] = power;
						}
					}
				}//충전 범위에 power 저장 완료
			}// 모든 정보 입력 끝
			
			//A의 초기 위치
			int ar = 1, ac = 1;
			//B의 초기 위치
			int br = 10, bc = 10;
			int ans = 0; //전체 충전량 담을 변수
			//m초 동안 이동하면서 체크
			for(int m=0; m<=M; m++) {
				int maxSum= 0;
				
				//A와 B가 BC의 범위내에 있다면
				if(map[A][ar][ac] > 0 && map[A][br][bc] > 0) {
					
					//어떤 BC에 포함되었는지 찾기
					for(int a = 0; a<A; a++) {
						//먼저 A의 BC찾기
						if(map[a][ar][ac] == 0) continue; //해당 BC가 아닐 경우 continue
						int sum = map[a][ar][ac];
						//이제 B의 BC 찾기
						for(int b = 0; b<A; b++) {
							if(map[b][br][bc] == 0) continue; //해당 BC가 아닐 경우 continue
							//두개의 BC가 다른 BC라면
							if(a != b) {
								//maXSum 비교 후 업데이트
								if(maxSum < sum + map[b][br][bc]) {
									maxSum = sum + map[b][br][bc];
								}
							}
							//두 개가 같은 BC라면
							else {
								if(maxSum < sum) maxSum = sum;
							}
						}
					} //BC 최대값 찾기 끝
				}//end if
				//두 사람 모두 BC에 없거나 한명만 BC에 있는 경우는 그냥 그 최대값을 더해주면된다.
				else {
					maxSum = map[A][ar][ac] + map[A][br][bc];
				}
				//m초 후 이동한 좌표에서의 BC 충전량 최대값 누적
				ans += maxSum;
				
				//m초후 A와 B의 좌표
				ar += dr[moveA[m]];
				ac += dc[moveA[m]];
				br += dr[moveB[m]];
				bc += dc[moveB[m]];
			}
			System.out.printf("#%d %d\n", tc, ans);
		}// end testCase
		
	}
}
