import java.util.Scanner;

public class BAEKJOON_1592 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 인원 수
		int M = sc.nextInt(); // 게임 종료 조건
		int L = sc.nextInt(); // 탐색 조건

		int[] arr = new int[N]; // 받은 횟수를 담을 배열 생성

		arr[0] = 1; // 1번째 사람부터 시작이기 떄문에 a[0]은 1로 초기화

		int idx = 0; // 공 받는 사람 인덱스 초기화

		while (arr[idx] != M) {
			// 홀수일 경우
			if (arr[idx] % 2 == 1) {
				// 인덱스가 범위를 초과하면 다시 0부터 시작할수 있도록
				if (idx + L >= N) {
					idx = idx + L - N;
				} else {
					idx = idx + L;
				}
				arr[idx] += 1; // 받은 횟수 추가
			}
			// 짝수일 경우
			else {
				// 인덱스가 범위를 초과하면 뒤에 인덱스 부터 시작할수 있도록
				if (idx - L < 0) {
					idx = idx - L + N;
				} else {
					idx = idx - L;
				}
				arr[idx] += 1; // 받은 횟수 추가
			}
		}
		
		int sum = 0; //받은 횟수 총합을 담을 변수
		for(int a : arr) {
			sum+=a;
		}
		int answer = sum - 1; //처음 1번이 받았던 횟수는 던진 횟수에 포함되지 않으므로 마이너스1
		
		System.out.println(answer);

		sc.close();
	}
}
