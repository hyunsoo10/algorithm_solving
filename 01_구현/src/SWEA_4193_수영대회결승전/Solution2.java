package SWEA_4193_수영대회결승전;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 시물레이션
 * BFS
 * 소용돌이는 3초마다 주기 반복, 0초 1초는 소용돌이라서 통과 못함, 2초는 통과함, 3초4초는 통과 못함, 5초는 통과
 * => 나머지 연산을 통해 나머지가 2이면 통과
 *
 */
public class Solution2 {
	
	//상하좌우
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for(int testCase = 1; testCase <= TC; testCase++) {
			int N = Integer.parseInt(br.readLine());
			
			int[][] m = new int[N][N];
			boolean[][] visited = new boolean[N][N]; //방문 체크
			
			
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<N; j++) {
					m[i][j] = Integer.parseInt(st.nextToken());
					
				}
			}
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int sr = Integer.parseInt(st.nextToken());
			int sc = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine(), " ");
			int er = Integer.parseInt(st.nextToken());
			int ec = Integer.parseInt(st.nextToken());
			
			Queue<int[]> q = new LinkedList<>();
			//시작 좌표 넣기
			q.offer(new int[] {sr, sc});
			visited[sr][sc] = true; //방문 체크
			int result = -1; //도착까지 몇초 인지, 도착을 못하면 초기값 -1로 나오니까 -1로 초기화
			int time = 0; //시간 진행 사항 나타낼 변수
			
			//!q.isEmpty()도 가능
			
ex:			while(q.size() > 0) {
				int size  = q.size();//지금 현재 큐의 사이즈 만큼 반복믈 해야 된다.
				for (int i = 0; i < size; i++) {
					int[] pos = q.poll();
					//큐에서 하나 꺼냈으면 상하좌우 인접한 칸 탐색
					for (int j = 0; j < dr.length; j++) {
						int nr = pos[0] + dr[j];
						int nc = pos[1] + dc[j];
						//배열 범위내인지, 장애물 아닌지, 방문 안했는지
						if(nr>=0 && nr<N && nc >=0 && nc<N && m[nr][nc] !=1 && !visited[nr][nc]) {
							//만약 도착 지점이라면
							if(nr == er && nc == ec) {
								result = time+1;
								break ex;
							}
							//소용돌이면 대기해야함 -> 현재 좌표를 다시 큐에 넣기(nr,nc가 아님) 
							if(m[nr][nc] == 2 && time%3 != 2) {
								q.offer(pos); //소용돌이면 다시 큐에 넣어라
							}else {
								//소용돌이가 아니면 진행하면 됨
								q.offer(new int[] {nr, nc});
								visited[nr][nc] = true;
							}
											
						}
					}
					
				} // 시간이 증가하기 전에 해줘야 하는 작업들
				
				time ++;
			}
			sb.append("#").append(testCase).append(" ").append(result).append("\n");
		}
		System.out.println(sb.toString());
	}//end of main
} //end of class
