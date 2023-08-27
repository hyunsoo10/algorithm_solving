package BAEKJOON_21610_마법사_상어와_비바라기;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Main3 {
	static int N, M;
	static int[][] map;
	static Stack<int[]> stack;
	static boolean[][] visited;
	//비바라기 진행 방향 
	static int[] dr = {0, 0, -1, -1, -1, 0, 1, 1, 1};
	static int[] dc = {0, -1, -1, 0, 1, 1, 1, 0, -1 };
	public static void main(String[] args) {
		Scanner sc = new Scanner(input);
		
		N = sc.nextInt(); // N*N맵 크기
		M = sc.nextInt(); // M번 이동
		
		map = new int[N+1][N+1];
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				map[i][j] = sc.nextInt();
			}
		}//마법사 맵 정보 입력 끝
		
		
		//초기 구름 위치 생성 후 스택에 쌓기
		stack = new Stack<>();
		int[] one = {N-1, 1}; 
		int[] two = {N-1, 2};
		int[] three = {N, 1};
		int[] four = {N, 2};
		stack.add(one);
		stack.add(two);
		stack.add(three);
		stack.add(four);
		
		//비바라기 마법 실행
		for(int i=0; i<M; i++) {
			int dir = sc.nextInt(); // 진행 방향
			int s = sc.nextInt(); // 진행 거리
			
			moveCloud(dir, s);
			
		}

		System.out.println(Arrays.deepToString(map));
		
	}
	
	static void moveCloud(int dir, int s) {
		int[] one = {N-1, 1}; 
		int[] two = {N-1, 2};
		int[] three = {N, 1};
		int[] four = {N, 2};
		//s번 이동
		for(int i=0; i<s; i++) {
			one[0] = one[0] + dr[dir];
			one[1] = one[1] + dc[dir];
			two[0] = two[0] + dr[dir];
			two[1] = two[1] + dc[dir];
			three[0] = three[0] + dr[dir];
			three[1] = three[1] + dc[dir];
			four[0] = four[0] + dr[dir];
			four[1] = four[1] + dc[dir];

			for(int j=0; j<2; j++) {
				if(one[j]==0)
					one[j] = N;
				if(one[j]>N)
					one[j] = 1;
			}
			for(int j=0; j<2; j++) {
				if(two[j]==0)
					two[j] = N;
				if(two[j]>N)
					two[j] = 1;
			}
			for(int j=0; j<2; j++) {
				if(three[j]==0)
					three[j] = N;
				if(three[j]>N)
					three[j] = 1;
			}
			for(int j=0; j<2; j++) {
				if(four[j]==0)
					four[j] = N;
				if(four[j]>N)
					four[j] = 1;
			}
		
		}
		//이동이 끝 났으면 비 1씩 내리기
		map[one[0]][one[1]]++;
		map[two[0]][two[1]]++;
		map[three[0]][three[1]]++;
		map[four[0]][four[1]]++;
//		System.out.println(Arrays.deepToString(map));
		
		
		//대각선 물의 양 체크 후에 값 증가
		check(one[0], one[1]);
		check(two[0], two[1]);
		check(three[0], three[1]);
		check(four[0], four[1]);
//		System.out.println(Arrays.deepToString(map));
		
		//구름이 있었던 칸을 제외한 나머지 칸 중에 물의 양이 2 이상인 칸에 구름이 생긴다.
		//현재 위치 제외한 다른 칸 중 값이 2 이상인 곳에 값 2씩 감소
		makeCloud(one, two, three, four);
		System.out.println(Arrays.deepToString(map));
	}
	
	static void check(int i, int j) {
		//왼쪽 위 대각선 검사
		if(i-1>0 && j-1>0 && map[i-1][j-1]!=0)
			map[i][j] ++;
		//오른쪽 위 대각선검사
		if(i-1>0 && j+1<=N && map[i-1][j+1]!=0)
			map[i][j] ++;
		//왼쪽 아래 대각선 검사
		if(i+1<=N && j-1>0 && map[i+1][j-1]!=0)
			map[i][j] ++;
		//오른쪽 아래 대각선 검사
		if(i+1<=N && j+1<=N && map[i+1][j+1]!=0)
			map[i][j] ++;
	}
	
	static void makeCloud(int[]one, int[] two, int[] three, int[] four) {
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				//구름이 생겼던 위치가 아니면서 물의 양이 2이 상일 경우에 구름이 생긴다
				if(i==one[0] && j==one[1])
					continue;
				if(i==two[0] && j==two[1])
					continue;
				if(i==three[0] && j==three[1])
					continue;
				if(i==four[0] && j==four[1])
					continue;
				if(map[i][j] >= 2)
					map[i][j] -= 2;
			}
		}
	}
	
	static String input = "5 4\r\n" + 
			"0 0 1 0 2\r\n" + 
			"2 3 2 1 0\r\n" + 
			"4 3 2 9 0\r\n" + 
			"1 0 2 9 0\r\n" + 
			"8 8 2 1 0\r\n" + 
			"1 3\r\n" + 
			"3 4\r\n" + 
			"8 1\r\n" + 
			"4 8";
}
