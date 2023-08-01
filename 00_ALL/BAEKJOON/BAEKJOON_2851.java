import java.util.Scanner;

public class BAEKJOON_2851 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[10];
		int sum = 0;
		int answer = 0;
		
		for (int i = 0; i < 10; i++) {
			arr[i] = sc.nextInt();
		}
		
		for (int i = 0; i < 10; i++) {
			int temp = arr[i];
			sum += temp;
			// 100이 되면 정답
			if (sum == 100) {
				answer = sum;
				break;
			} 
			else if (sum > 100) {
				// 100을 넘은 순간 그 전까지의 합과 비교해서 차이가 작은 수 출력
				int pre = 100 - (sum - temp);
				
				int next = sum - 100;
				
				if (pre > next) {
					answer = sum;
					break;
				} else if (pre < next) {
					answer = sum-temp;
					break;
				} else {
					answer = Math.max(sum - temp, sum);
					break;
				}

			}
			else {
				answer = sum;
			}
		}

		System.out.println(answer);
	}
}
