import java.util.Scanner;

public class SWEA_2001 {
	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();

			int answer = 0;// 정답 담을 변수

			// 파리 정보 담을 변수
			int[][] flyMap = new int[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					flyMap[i][j] = sc.nextInt();
				}
			}

			// 행 우선 탐색으로 전체 배열 하나하나씩 탐색해야됌
			// 크기가 M인 파리채면 행이든 열이든 N-M까지만 탐색하면 됨
			for (int i = 0; i <= N - M; i++) {
				for (int j = 0; j <= N - M; j++) {

					// 탐색할 인덱스에서 M*M크기만큼 또 탐색 해야됌
					int tmpSum = 0; // M*M의 합을 담을 변수
					for (int r = i; r < i + M; r++) {
						for (int c = j; c < j + M; c++) {
							tmpSum += flyMap[r][c];
						}
					}
					// M*M탐색이 끝날 때 마다 최대값 갱신
					if (answer < tmpSum)
						answer = tmpSum;

				}
			}
			
			System.out.printf("#%d %d\n", tc, answer);
		}
		sc.close();
	}

}
