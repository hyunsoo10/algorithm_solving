import java.util.Scanner;

public class SWEA_1954 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//총 테스트 케이스
		int T = sc.nextInt();
		
		for(int tc = 1; tc<=T; tc++) {
			
			//달팽이 크기 
			int N = sc.nextInt();
			
			//달팽이 찍을 N*N이중 배열 초기화
			int[][] snail = new int[N][N];
			
			//달팽이 찍을 방향: 우,하,좌,상
			int[] dr = {0, 1, 0, -1};
			int[] dc = {1, 0, -1, 0};
	
			int dir = 0; // 방향 변수
			int r = 0; //시작 row
			int c = 0; //시작 column
			
			//N*N달팽이의 마지막 숫자는 N*N이므로 num은 1부터 N*N까지 반복
			for(int num = 1; num<=N*N; num++) {
				snail[r][c] = num;
				r = r+dr[dir];
				c = c+dc[dir];
				//인덱스 범위를 벗어 나거나 이미 입력이 된 숫자를 만나면 방향을 바꾼다
				if(r+dr[dir] >= N || c+dc[dir] >= N  || r+dr[dir]<0 || c+dc[dir]<0 || snail[r+dr[dir]][c+dc[dir]]!=0) {
					dir = (dir+1)%4;
				}
			}
			System.out.printf("#%d\n", tc);
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<N; j++) {
					System.out.print(snail[i][j] + " ");
				}
				System.out.println();
			}
		}
		sc.close();
	}
}
