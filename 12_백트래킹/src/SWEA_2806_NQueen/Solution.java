package SWEA_2806_NQueen;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	static int N, ans;
	static List<Integer> col, row, pDiagonal, nDiagonal;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();// N*N 행렬에서 N개의 queen 두기
			
			col = new ArrayList<>();// 퀸이 있는 열 정보
			pDiagonal = new ArrayList<>(); //퀸이 있는 대각선 정보 - positive diagonal
			nDiagonal = new ArrayList<>();//퀸이 있는 대각선 정보 - negative diagonal
			// 정답 개수
			ans = 0;

			queen(0);// 퀸 두기

			System.out.printf("#%d %d\n",tc, ans);

		}
	}

	static void queen(int row) {
		//마지막 열까지 퀸을 두었다면 row는 N에 도달하므로 정답 카운팅 해주고 return
		if (row == N) {
			ans++;
			return;
		}
		//0 ~ N-1열 탐색
		for(int j=0; j<N; j++) {
			//해당 위치에 퀸을 두어도 되는지 검사
			if(isPossible(row, j)) {
				//두어도 된다면 해당 위치의 열, 대각선 정보 추가
				col.add(j);
				pDiagonal.add(row+j);
				nDiagonal.add(row-j);
				//다음 행으로 고고
				queen(row+1);
				//queen재귀가 끝났으면 해당 위치 정보 삭제 후 다음 열로 넘어가야 함
				col.remove(col.size()-1);
				pDiagonal.remove(pDiagonal.size()-1);
				nDiagonal.remove(nDiagonal.size()-1);
			}
		}
	
	}
	//해당 위치에 퀸을 두어도 되는지 검사
	static boolean isPossible(int i, int j) {	
		if(col.contains(j) || pDiagonal.contains(i+j) || nDiagonal.contains(i-j))
			return false;
		return true;
	}

}
