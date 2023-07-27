import java.util.Scanner;

public class BAEKJOON_2798 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // N장의 카드
		int M = sc.nextInt(); // winning number

		int[] nums = new int[N];

		for(int i = 0; i < N; i++){
			nums[i] = sc.nextInt();
		}
		int max = 0;
		for(int i = 0; i < N-2; i++) {
			for(int j = i+1; j<N-1; j++) {
				for(int k = j+1; k<N; k++) {
					if(nums[i] + nums[j] + nums[k] <= M) {
						if(nums[i] + nums[j] + nums[k] > max) {
							max = nums[i] + nums[j] + nums[k] ;
						}
					}
				}
			}
		}
		System.out.println(max);
	}
}
