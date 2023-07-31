import java.util.Scanner;

public class BAEKJOON_2563 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 색종이 수

		// 100*100 도화지 만들기
		int[][] paper = new int[101][101];

		for (int i = 0; i < N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();

			for (int a = x; a < x + 10; a++) {
				for (int b = y; b < y + 10; b++) {
					paper[a][b]++;
				}
			}
		}

		int answer = 0;
		for (int i = 1; i < 101; i++) {
			for (int j = 1; j < 101; j++) {
				if(paper[i][j] > 0)
					answer++;
			}
		}
		sc.close();

		// 정답 출력
		System.out.println(answer);
	}
}
