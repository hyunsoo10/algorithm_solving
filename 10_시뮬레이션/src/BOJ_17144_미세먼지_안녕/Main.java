package BOJ_17144_미세먼지_안녕;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
//	static int[][] map;
	static int R, C, T;
	//상우하좌 4방향 델타 탐색
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		R = sc.nextInt(); //행
		C = sc.nextInt(); //열
		T = sc.nextInt(); //시간
		
		int [][] map = new int[R][C];

		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		//T초동안 반복
		for(int t=1; t<=T; t++) {
			//step1. 미세먼지 확산
			map = expand(map);
			map = air(map);	
		}

		int ans = 0;
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j] > 0) ans += map[i][j];
			}
		}
		System.out.println(ans);
		
	}
	
	//원본 배열 받아서 미세먼지 확산 시켜서 저장한 새로운 배열 반환
	static int[][] expand(int[][] original) {
		//새로운 배열에 확산 미세먼지 정보 담기
		int[][] newArr = new int[R][C];
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				//공기청정기 위치라면 위치만 저장해주고 스킵
				if(original[i][j] == -1) newArr[i][j] = -1;
				//미세먼지가 있다면 확산
				else if(original[i][j] > 0) {
					//인접한 네 방향중 범위 내 공기 청정기가 없는 지역의 개수 담을 변수
					int cnt = 0;
					for(int k=0; k<4; k++) {
						//범위 내에 있고 공기청정기가 없는 경우라면 먼지 확산
						if(i+dr[k]>=0 && i+dr[k]<R && j+dc[k]>=0 && j+dc[k]<C && original[i+dr[k]][j+dc[k]]!=-1) {
							newArr[i+dr[k]][j+dc[k]] += original[i][j]/5;
							cnt++;
						}
					}
					//해당 위치에는 확산 시키고 남은 만큼의 미세먼지 저장
					newArr[i][j] += original[i][j] - (original[i][j]/5)*cnt;
				}
			}
		}
		return newArr;
	}
	
	static int[][] air(int[][] original){
		int[][] newArr = new int[R][C];
		int up = 0;
		int down = 0;

		//위쪽 공기청정기 
		for(int i=2; i<R; i++) {
			if(original[i][0]==-1) {
				up = i;//위쪽 공기청정기 행 위치
				down = i+1;//아래쪽 공기청정기 행 위치
				//위쪽 공기 청정기 반시계 방향
				//step1. 오른쪽
				for(int x=1; x<C-1; x++) {
					//미세먼지 있는 경우에 밀기
					if(original[up][x] > 0) newArr[up][x+1] = original[up][x];
				}
				//step2. 위쪽
				for(int x=up; x>0; x--) {
					if(original[x][C-1] > 0) newArr[x-1][C-1] = original[x][C-1];
				}
				//step3. 왼쪽
				for(int x=C-1; x>0; x--) {
					//미세먼지 있는 경우에 밀기
					if(original[0][x] > 0) newArr[0][x-1] = original[0][x];
				}
				//step4. 아래쪽
				for(int x=0; x<up-1; x++) {
					if(original[x][0] > 0) newArr[x+1][0] = original[x][0];
				}
				
				//아래쪽 공기청정기 시계방향
				//step1. 오른쪽
				for(int x=1; x<C-1; x++) {
					//미세먼지 있는 경우에 밀기
					if(original[down][x] > 0) newArr[down][x+1] = original[down][x];
				}
				//step2. 아래쪽
				for(int x=down; x<R-1; x++) {
					if(original[x][C-1] > 0) newArr[x+1][C-1] = original[x][C-1];
				}
				//step3. 왼쪽
				for(int x=C-1; x>0; x--) {
					//미세먼지 있는 경우에 밀기
					if(original[R-1][x] > 0) newArr[R-1][x-1] = original[R-1][x];
				}
				//step4. 위쪽
				for(int x=R-1; x>down+1; x--) {
					if(original[x][0] > 0) newArr[x-1][0] = original[x][0];
				}
				break; //공기 청정기 싸이클 돌고 반복문 탈출
			}
		}
		
		//공기청정기 싸이클 행과 열 제외한 곳은 원본 배열 그대로 넣어주기
		for(int i=1; i<=up-1; i++) {
			for(int j=1; j<C-1; j++) {
				newArr[i][j] = original[i][j];
			}
		}
		for(int i=down+1; i<R-1; i++) {
			for(int j=1; j<C-1; j++) {
				newArr[i][j] = original[i][j];
			}
		}
		//공기정청기 위치 그대로 저장
		newArr[up][0] = -1;
		newArr[down][0] = -1;
		return newArr;
	}
	


}
