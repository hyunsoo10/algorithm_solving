package SWEA_2115_벌꿀채취;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution2 {
	private static int N;
	private static int M;
	private static int C;
	private static int[][] map;
	private static int[][] memo;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= TC; testCase++) { // 최대 50개 테스트 케이스
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken()); // 벌통들의 크기 N, 3 ≤ N ≤ 10
			M = Integer.parseInt(st.nextToken()); // 연속으로 채취해야하는 벌통의 개수 M, 1 ≤ M ≤ 5, M <= N
			C = Integer.parseInt(st.nextToken()); // 꿀을 채취할 수 있는 최대 양 C, 10 ≤ C ≤ 30
			map = new int[N][N]; // 벌통에 담긴 꿀의 양
			for (int i = 0; i < N; i++) {
				String s = br.readLine();
				for (int j = 0, index = 0; j < N; j++, index += 2) {
					map[i][j] = s.charAt(index) - '0'; // 1 <= 꿀의 양 <= 9, 안쪼갤수 있으면 쪼개지 말자
				}
			}
			memo = new int[N][N-M+1]; // 모든 위치에서 M영역을 지정하여, 부분집합으로 얻을 수 있는 최대 수익을 구해서 저장
			for (int r = 0; r < N; r++) {
				for (int c = 0; c <= N-M; c++) {
					getHoney(r, c, 0, 0, 0);
				}
			}
			
			int max1 = 0;
			int r1=-1, c1=-1;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c <= N-M; c++) {
					if (max1 < memo[r][c]) {
						max1 = memo[r][c];
						r1 = r;
						c1 = c;
					}
				}
			}
			int max2 = 0;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c <= N-M; c++) {
					if (r==r1 && ((c<=c1 && c1<=c+M-1) || (c<=c1+M-1 && c1+M-1<=C+M-1))) continue; // 최대이익과 영역이 겹치면 제외
					if (max2 < memo[r][c]) max2 = memo[r][c];
				}
			}
			sb.append("#").append(testCase).append(" ").append(max1+max2).append("\n");
		} // end of for testCase
		System.out.print(sb.toString());
	} // end of main
	
	/**
	 * r,c 위치에서 시작해서 연속된 M칸의 영역에서 얻을 수 있는 꿀의 최대 이익을 memo[r][c]칸에 업데이트 하는 메서드
	 * r,c는 좌표
	 * index : M 칸 영역에서 부분집합을 구할 때 고려할 원소 순서
	 * sum : 지금까지 선택한 꿀의 합 -  꿀의 양의 합을 C를 넘으면 안되기 때문에 C가 넘을 때 return 해서 시간 절약 가능
	 * val:  지금까지 선택한 꿀의 수익의 합
	 * */
	//index : 현재 선택한 원소 sum: 채취한 꿀의 양, val : 채취한 꿀의 수익
	public static void getHoney(int r, int c, int index, int sum, int val) {
		if (sum > C) return;
		if (index == M) {
			if (memo[r][c] < val) memo[r][c] = val; // 추후 C 제한을 여기서 체크해야하는지 확인
			return;
		}
		int temp = map[r][c+index];
		getHoney(r, c, index+1, sum + temp, val + temp*temp); //index원소 선택
		getHoney(r, c, index+1, sum, val); //index원소 선택X
	}
}
