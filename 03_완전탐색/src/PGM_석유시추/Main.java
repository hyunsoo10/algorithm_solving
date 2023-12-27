package PGM_석유시추;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) {
		int[][] case1 = new int[][] {
			{0, 0, 0, 1, 1, 1, 0, 0},
			{0, 0, 0, 0, 1, 1, 0, 0},
			{1, 1, 0, 0, 0, 1, 1, 0},
			{1, 1, 1, 0, 0, 0, 0, 0},
			{1, 1, 1, 0, 0, 0, 1, 1}
		};
		int ans = solution(case1);
		System.out.println(ans);
	}
	
    public static int solution(int[][] land) {
        int answer = 0;
        
        // 땅의 세로 길이 n (1 <= n <= 500)
        int n = land.length;
        
        // 땅의 가로 길이 m (1 <= m <= 500)
        int m = land[0].length;
        //0: 빈땅, 1: 석유가 있는 땅
        //석유 체크 배열
        int[][] visited = new int[n][m];
        
        //4방향 델타 탐색
        int[] dr = {-1, 1, 0 , 0};
        int[] dc = {0, 0, -1 ,1};
        
        //석유 종류와 개수 저장할 배열
        int tmp = n*m/2;
        int[] count = new int[tmp+1];
        
        //석유 종류 변수
        int kind = 1;
        //완전 탐색
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                //석유가 있고, 아직 확인하지 않은 석유 덩어리인 경우
                if(land[i][j] == 1 && visited[i][j] == 0){
                    //bfs
                    int cnt = 1;
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{i, j});
                    visited[i][j] = kind;
                    while(!queue.isEmpty()){
                        int[] pos = queue.poll();
                        
                        //4방향 탐색
                        for(int d=0; d<4; d++){
                            int nr = pos[0] + dr[d];
                            int nc = pos[1] + dc[d];
                            if(nr >=0 && nr <n && nc>=0 && nc<m && land[nr][nc]==1 && visited[nr][nc]==0){
                                queue.add(new int[]{nr, nc});
                                visited[nr][nc] = kind;
                                cnt++;
                            }
                        }
                    }//end while
                    count[kind] = cnt;
                    kind++;
                }
                
            }// end for j
        }// end for i
        
        int max = 0;
        for(int j=0; j<m; j++){
            boolean[] check = new boolean[kind];
            for(int i=0; i<n; i++){
                check[visited[i][j]] = true;
            } 
            
            int sum = 0; 
            for(int k=1; k<kind; k++){
                if(check[k]) sum += count[k];
            }
            max = Math.max(max, sum);
        }
  
        answer = max;
        return answer;
    }
}