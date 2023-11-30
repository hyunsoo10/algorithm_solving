package BOJ_15686_치킨배달;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int N, M, chicken, house, min;
	static int[][] map, pos1, pos2;
	static boolean[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//N(2 ≤ N ≤ 50) M(1 ≤ M ≤ 13)
		//N*N 도시
		N = sc.nextInt();
		//M개의 치킨집 뽑기
		M = sc.nextInt();
		
		//치킨 집 개수
		chicken = 0;
		//집의 개수
		house = 0;
		
		map = new int[N+1][N+1];
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				int tmp = sc.nextInt();
				map[i][j] = tmp;
				if(tmp == 1) house ++;
				if(tmp == 2) chicken ++;
			}
		}//도시 정보 입력 끝
		
		//집 좌표 담을 배열
		pos1 = new int[house][2];
		//치킨 집 좌표 담을 배열
		pos2 = new int[chicken][2];
		//치킨집 좌표 뽑을 때 활용할 방문 배열
		visited = new boolean[chicken];
		//치킨 집 좌표와 집 좌표 배열에 넣기
		int idx1=0;
		int idx2=0;
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(map[i][j]==1) {
					//집 좌표 넣어주기
					pos1[idx1][0] = i;
					pos1[idx1++][1] = j;
				} 
				if(map[i][j]==2) {
					//치킨 집 좌표 넣어주기
					pos2[idx2][0] = i;
					pos2[idx2++][1] = j;
				}
			}
		}
		
		min = Integer.MAX_VALUE;
		
		combination(0, 0);
		System.out.println(min);

	}
	//조합
	static void combination(int idx, int sidx) {
		//기저 조건 M개 뽑았을 때
		if(sidx == M) {
			check();
			return;
		}
		//재귀
		for(int i = idx; i<chicken; i++) {
			if(!visited[i]) {
				visited[i] = true;
				combination(i+1, sidx+1);
				visited[i] = false;
			}
		}
	}
	//치킨집 뽑았을 떄 각 집들과의 최소 거리 계산하는 메서드
	static void check() {
		int tmpSum = 0;
		for(int i=0; i<house; i++) {
			int tmpMin = Integer.MAX_VALUE;
			for(int j=0; j<chicken; j++) {
				if(visited[j]) {
					tmpMin = Math.min(Math.abs(pos1[i][0] - pos2[j][0]) + Math.abs(pos1[i][1] - pos2[j][1]), tmpMin);
				}
			}
			//최소값들 계속 더해주기
			tmpSum += tmpMin;
		}
		min = Math.min(min, tmpSum);
	}
}
