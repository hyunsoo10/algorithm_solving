package SWEA_5644_무선충전;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[][] mdr = {	{ 0},
							{-1, 0, 1, 0}, // 12시 부터 시계방향, 1
							{-2,-1, 0, 1, 2, 1, 0,-1}, // 2
							{-3,-2,-1, 0, 1, 2, 3, 2, 1, 0,-1,-2}, // 3
							{-4,-3,-2,-1, 0, 1, 2, 3, 4, 3, 2, 1, 0,-1,-2,-3}, // 4
						};
	static int[][] mdc = {	{ 0},
							{ 0, 1, 0,-1}, // 12시 부터 시계방향, 1
							{ 0, 1, 2, 1, 0,-1,-2,-1}, // 2
							{ 0, 1, 2, 3, 2, 1, 0,-1,-2,-3,-2,-1}, // 3
							{ 0, 1, 2, 3, 4, 3, 2, 1, 0,-1,-2,-3,-4,-3,-2,-1}, // 4
						};
	static int[] dr = { 0,-1, 0, 1, 0}; // 0 이동하지 않음, 1 상, 2 우, 3 하, 4 좌
	static int[] dc = { 0, 0, 1, 0,-1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine()); // 50개 테스트케이스
		for (int testCase = 1; testCase <= TC; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int M = Integer.parseInt(st.nextToken()); // 총 이동 시간 M, (20 ≤ M ≤ 100) 
			int A = Integer.parseInt(st.nextToken()); // BC의 개수 A, (1 ≤ A ≤ 8)
			
//			0 이동하지 않음, 1 상, 2 우, 3 하, 4 좌
			int[] userA = new int[M+1]; // 사용자A의 이동 정보
			String s = br.readLine();
			for (int i = 0, index = 0; i < M; i++, index += 2) { // 0:이동하지 않음, 1:상 (UP), 2:우 (RIGHT), 3:하 (DOWN), 4:좌 (LEFT)
				userA[i] = s.charAt(index) - '0';
			}
			int[] userB = new int[M+1]; // 사용자B의 이동 정보
			s = br.readLine();
			for (int i = 0, index = 0; i < M; i++, index += 2) {
				userB[i] = s.charAt(index) - '0';
			}
		
			int[][][] map = new int[A+1][11][11]; // BC마다 맵을 사용 1~10, 0 안씀, [BC][행][열]
//			맵을 한칸 더 만들어서 최대값 저장함	 [A][행][열] 칸에 각 행열 위치에서 포함될수 있는 BC의 충전처리량의 합을 누적
			
			for (int i = 0; i < A; i++) { // A개의 BC 정보 입력
				st = new StringTokenizer(br.readLine(), " ");
				int c = Integer.parseInt(st.nextToken()); // 열
				int r = Integer.parseInt(st.nextToken()); // 행
				int C = Integer.parseInt(st.nextToken()); // 충전범위 C, (1 ≤ C ≤ 4)
				int P = Integer.parseInt(st.nextToken()); // 처리량, BC의 성능 P, (10 ≤ P ≤ 500) 짝수
				
				for (int j = 0; j <= C; j++) { // 충전범위 만큼 반복, BC자리도 체크해야하니까 C이하까지
					for (int k = 0; k < mdr[j].length; k++) {
						int nr = r + mdr[j][k];
						int nc = c + mdc[j][k];
						if (1<=nr && nr<11 && 1<=nc && nc<11) { // 범위체크
							map[i][nr][nc] = P; // [해당BC번호][행][열] = 처리량을 저장
							if (map[A][nr][nc] < P) { // [A][행][열] 칸에 각 행열 위치에서 포함될수 있는 BC의 충전처리량의 합을 누적
								map[A][nr][nc] = P;
							}
						}
					}
				}
			}
			
//			시뮬레이션 시작
			int total = 0; // 전체 충전량 합
			int rA =  1, cA =  1; // 사용자A 좌표, 2. 사용자는 총 2명이며, 사용자A는 지도의 (1, 1) 지점에서, 사용자B는 지도의 (10, 10) 지점에서 출발한다.
			int rB = 10, cB = 10; // 사용자B 좌표
			for (int i = 0; i <= M; i++) { // 이동시간만큼 반복, 0시점에도 충전가능하기에 0부터 M까지 진행
				int maxSum = 0;
				if (map[A][rA][cA] > 0 && map[A][rB][cB] > 0) { // 둘다 BC 영역에 포함된경우
					for (int j = 0; j < A; j++) { // 사용자A의 해당 BC 찾기
						if (map[j][rA][cA] == 0) continue; // BC 없는 것은 통과
						int sum = map[j][rA][cA];
						for (int k = 0; k < A; k++) { // 사용자B의 해당 BC 찾기
							if (map[k][rB][cB] == 0) continue; // BC 없는 것은 통과
							if (j != k) { // 다른 BC 이면
								if (maxSum < sum + map[k][rB][cB])
									maxSum = sum + map[k][rB][cB];
							} else { // 같은 BC 이면
								if (maxSum < sum)
									maxSum = sum;
							}
						}
					}
				} else { // 둘다 BC 영역에 포함되지 않은 경우
					maxSum = map[A][rA][cA] + map[A][rB][cB];
				}
				total += maxSum; // 전체 충전량 누적
				
//				다음칸으로 좌표이동
				rA += dr[userA[i]];
				cA += dc[userA[i]];
				rB += dr[userB[i]];
				cB += dc[userB[i]];
			}
			sb.append("#").append(testCase).append(" ").append(total).append("\n");
		} // end of for testCase
		System.out.print(sb);
	} // end of main
} // end of class
