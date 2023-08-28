package BOJ_21610_마법사_상어와_비바라기;

import java.util.Scanner;
import java.util.Stack;

public class Main {
	static int N, M;
	static int[][] map;
	static Stack<int[]> stack;
	static boolean[][] visited;
	//비바라기 진행 방향 
	static int[] dr = {0, 0, -1, -1, -1, 0, 1, 1, 1};
	static int[] dc = {0, -1, -1, 0, 1, 1, 1, 0, -1 };
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
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
		//최종 맵에 남아있는 물의 양 answer에 모두 더해주면 정답
		int answer = 0;
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				answer += map[i][j];
			}
		}
		System.out.println(answer);
	
	}
	
	static void moveCloud(int dir, int s) {
		//s번 이동
		Stack <int[]> newCloud = new Stack<>();
		//새로운 구름의 위치 저장할 배열
		visited = new boolean[N+1][N+1];
		while(!stack.isEmpty()) {
			//구름 하나씩 꺼내서 이동 시작
			int[] tmp = stack.pop();
			//s거리로 이동
			for(int i=0; i<s; i++) {
				tmp[0] = tmp[0] + dr[dir];
				tmp[1] = tmp[1] + dc[dir];
				for(int j=0; j<2; j++) {
					if(tmp[j]==0)
						tmp[j] = N;
					if(tmp[j]>N)
						tmp[j] = 1;
				}				
			}
			//이동이 끝나면 비 1씩 증가
			map[tmp[0]][tmp[1]]++;
			//구름이 생긴 위치 저장
			visited[tmp[0]][tmp[1]] = true;
			//그리고 새로운 구름의 위치 스택에 담기
			newCloud.add(tmp);
		}
		while(!newCloud.isEmpty()) {
			int[] tmp = newCloud.pop();
			check(tmp[0], tmp[1]);
		}

		
		//구름이 있었던 칸을 제외한 나머지 칸 중에 물의 양이 2 이상인 칸에 구름이 생긴다.
		//현재 위치 제외한 다른 칸 중 값이 2 이상인 곳에 값 2씩 감소
		makeCloud();
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
	
	static void makeCloud() {
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				//구름이 생겼던 위치가 아니면서 물의 양이 2이 상일 경우에 구름이 생긴다
				if(visited[i][j] == false && map[i][j] >=2) {
					map[i][j] -= 2;
					int[] tmp = {i, j};
					stack.add(tmp);
				}

			}
		}
	}
}
