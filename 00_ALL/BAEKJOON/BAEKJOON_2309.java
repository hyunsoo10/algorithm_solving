import java.util.Scanner;

public class BAEKJOON_2309 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] people = new int[9];
		int sum = 0;
		for (int i = 0; i < people.length; i++) {
			people[i] = sc.nextInt();
			sum += people[i]; // 전체 키 합 구하기
		}

		// 전체 키 합에서 100 만큼 뺸 숫자의 합을 구하면 된다
		int target = sum - 100;
		int a = 0;
		int b = 0;
		for (int i = 0; i < people.length - 1; i++) {
			for (int j = i + 1; j < people.length; j++) {
				if (people[i] + people[j] == target) {
					// target 의 합이 나오면 그 인덱스에 0을 집어 넣고 반복문 탈출
					a = people[i];
					b = people[j];
				}

			}

		}

		// 오름차순 정렬
		for (int i = 0; i < people.length - 1; i++) {
			for (int j = i + 1; j < people.length; j++) {
				if (people[i] > people[j]) {
					int temp = people[i];
					people[i] = people[j];
					people[j] = temp;
				}
			}
		}

		// 출력
		for (int i = 0; i < people.length; i++) {
			if (people[i] != a && people[i] != b) {
				System.out.println(people[i]);
			}
		}

	}
}
