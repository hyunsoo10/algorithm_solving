package BOJ_2343_기타레슨;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N  = sc.nextInt();
		int M  = sc.nextInt();
		
		int[] arr = new int[N];
		
		int min = 0;
		int max = 0;
		
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
			if(min < arr[i]) min = arr[i];
			max += arr[i];
			
		}
		while(min <= max) {
			int mid = (min + max)/2;
			int sum = 0;
			int cnt = 0;
			for(int i=0; i<N; i++) {
				if(sum + arr[i] > mid) {
					cnt++;
					sum = 0;
				}
				sum = sum+arr[i];
			}
			if(sum != 0) cnt++;
			if(cnt > M) min = mid + 1;
			else max = mid -1;
		}
		System.out.println(min);
	}
}
