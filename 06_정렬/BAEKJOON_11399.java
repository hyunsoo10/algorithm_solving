import java.util.Scanner;

public class BAEKJOON_11399 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		//arr를 오름차순으로 정렬
		//insertion 정렬을 써보자
		
		for(int i = 1; i<arr.length; i++) {
			//현재 비교값과 그 인전의 값들을 모두 비교해서 위치 선정
			for(int j = i; j>0; j--) {
				//자신 보다 작은 값이 있다면 계속 교환
				if(arr[j-1] > arr[j]) {
					int tmp = arr[j-1];
					arr[j-1] = arr[j];
					arr[j] = tmp;
				}
			}
		}

		for(int i = 1; i<N; i++) {
			arr[i] += arr[i-1];
		}
		int sum = 0;
		for(int a : arr) {
			sum += a;
		}
		System.out.println(sum);
		sc.close();
	}
}
