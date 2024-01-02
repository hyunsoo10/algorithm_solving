package PGM_리코쳇로봇;

public class Main2 {
	public static void main(String[] args) {
		String[] board = {"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."};
//		String[] board = {".D.R", "....", ".G..", "...D"};
		int result = solution(board);
		System.out.println(result);
	}
	
//    static int[] dr = {0, 0, -1, 1};
//    static int[] dc = {-1, 1, 0, 0};
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static char[][] map;
    static int n, m, min;
    static int[] start, end;
    static boolean[][] visited;
    public static int solution(String[] board) {
        int answer = 0;
        n = board.length;
        m = board[0].length();
        
        visited = new boolean[n][m];
        map = new char[n][m];
        start = new int[2];
        end = new int[2];
        
        for(int i=0; i<n; i++){
            map[i] = board[i].toCharArray();
        }
        
        //시작좌표와 목표지점 좌표 입력
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j]=='R') start = new int[]{i, j};
                if(map[i][j]=='G') end = new int[] {i, j};
            }
        }
    
       
        min = Integer.MAX_VALUE;
        
        dfs(start[0], start[1], 0, -1);
        
        answer = min;
        return answer;
    }
    //cnt: 이동 횟수(dfs 깊이), dir: 이전 진행 방향
    public static void dfs(int row, int col, int cnt, int dir){
        
        if(row == end[0] && col == end[1]){
        	System.out.println("goal row: "+ row);
        	System.out.println("goal col: "+ col);
            min = Math.min(min, cnt);
            return;
        }
        for(int d=0; d<4; d++){
            int nr = row + dr[d];
            int nc = col + dc[d];
            
            if(nr>=0 && nr<n && nc>=0 && nc<m && map[nr][nc]!='D' && d!=reverseDir(dir)){
                goStraight(nr, nc, cnt+1, d);
            }
                
        }
        
    }
    public static void goStraight(int row, int col, int cnt, int dir){
//    	if(cnt >=min) return;
        int nr = row+dr[dir];
        int nc = col+dc[dir];
        
        if(nr < 0 || nr >=n || nc<0 || nc>=m || map[nr][nc]=='D'){
        	
            if(!visited[row][col]){
                visited[row][col] = true; 
                System.out.print("row: "+ row);
                System.out.print(" col: "+ col);
                System.out.println(" cnt: "+ cnt);
                dfs(row, col, cnt, dir);
            }
            return;
        }
        else goStraight(nr, nc, cnt, dir);

    }
    
    public static int reverseDir(int dir){
        if(dir==0) return 1;
        else if(dir==1) return 0;
        else if (dir==2) return 3;
        else if(dir ==3 )return 2;
        else return -1;
    }
}
