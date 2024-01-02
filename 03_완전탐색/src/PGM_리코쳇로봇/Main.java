package PGM_리코쳇로봇;

import java.util.LinkedList;
import java.util.Queue;

//dfs 풀이 - 실패
public class Main {
	public static void main(String[] args) {
		String[] board = {"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."};
		int result = solution(board);
		System.out.println(result);
	}
	
    //4방향 델타 탐색
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    //static 변수
    static char[][] map;
    static int n, m, min;
    static int[] start, end;
    static boolean[][] visited;
    public static int solution(String[] board) {
        int answer = 0;
        
        //n:가로, m: 세로
        n = board.length;
        m = board[0].length();
        
        //char배열로 map 만들기
        map = new char[n][m];
        for(int i=0; i<n; i++) map[i] = board[i].toCharArray();
        
        //시작좌표와 목표지점 좌표 입력
        start = new int[2];
        end = new int[2];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j]=='R') start = new int[]{i, j};
                if(map[i][j]=='G') end = new int[] {i, j};
            }
        }
        min = Integer.MAX_VALUE;
        visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start[0], start[1], 1});
        visited[start[0]][start[1]] = true;
        //bfs 로직
        while(!queue.isEmpty()){
            int[] pos = queue.poll();
            for(int d = 0; d<4; d++){
                int nr = pos[0];
                int nc = pos[1];
                int cnt = pos[2];
                
                if(nr >=0 && nr<n && nc>=0 && nc<m){
                    while(nr>=0 && nr<n && nc>=0 && nc<m && map[nr][nc]!='D'){
                        // System.out.print("nr1: " + nr);
                        // System.out.println(" nc1: " + nc);
                        nr += dr[d];
                        nc += dc[d];
                    }
                    nr -= dr[d];
                    nc -= dc[d];

                    
                    // System.out.print("nr: " + nr);
                    // System.out.print(" nc: " + nc);
                    // System.out.println(" cnt: " + cnt);
                    //목표 지점이면
                    if(map[nr][nc] == 'G'){
                        min = Math.min(min, cnt);
                    }
                    // 목표 지점이 아니면서 && 방문하지 않은 곳이면
                    else if(!visited[nr][nc]){
                        visited[nr][nc] = true;//방문쳌
                        queue.add(new int[]{nr, nc, cnt+1});//큐에 넣기
                    }
                }
        
            }

        }
        if(min == Integer.MAX_VALUE) min = -1;
        answer = min;
        return answer;
    }
}
