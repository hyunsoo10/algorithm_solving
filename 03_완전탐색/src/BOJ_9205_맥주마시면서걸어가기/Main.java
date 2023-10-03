package BOJ_9205_맥주마시면서걸어가기;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			
			//맥주를 파는 편의점의 개수
			int n = sc.nextInt();
			
			int[] home = new int[2];
			int[][] place = new int[n+1][2];
			//방문 체크할 배열
			boolean[] visited = new boolean[n+1];
			
			//각 좌표 입력 받기
			home[0] = sc.nextInt();			
			home[1] = sc.nextInt();		
			//place의 마지막행에는 페스티벌의 좌표가 담긴다
			for(int i=0; i<n+1; i++) {
				place[i][0] = sc.nextInt();
				place[i][1] = sc.nextInt();
			}
			
			//정답은 sad로 초기화
			String answer = "sad";
			
			Queue<int[]> queue = new LinkedList<>();
			//처음 집에서 갈 수 있는 위치의 좌표 넣기
			for(int i=0; i<n+1; i++) {
				//집에서 거리가 1000미터 이하인 편의점들 찾기
				if(Math.abs(home[0] - place[i][0]) + Math.abs(home[1] - place[i][1]) <= 1000) {
					queue.add(new int[] {place[i][0], place[i][1]});
					visited[i] = true;//방문처리
				}
			}
			while(!queue.isEmpty()) {
				//좌표 한개 뽑고
				int[] pos = queue.poll();
				//만약 그 좌표가 페스티벌이라면 정답에 happy대입하고 반복문 탈출
				if (pos[0] == place[n][0] && pos[1] == place[n][1]) {
					answer = "happy";
					break;
				}
				
				//해당 위치에서 갈 수 있는 좌표 queue에 넣기
				for(int i=0; i<n+1; i++) {
					//거리가 1000이하 && 방문쳌
					if(Math.abs(pos[0] - place[i][0]) + Math.abs(pos[1] - place[i][1]) <= 1000 && !visited[i]) {
						queue.add(new int[] {place[i][0], place[i][1]});
						visited[i] = true;
					}
				}
			}
			System.out.println(answer);

			
			
		}// end testCase
	}
}
