package BOJ_17179_케이크자르기;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int[] arr;
	static int N, L;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		N = sc.nextInt();
		L = sc.nextInt();
		
		arr = new int[N+2];
		arr[N+1] = L;
		Arrays.sort(arr);
		
		for(int i=1; i<=N; i++) arr[i] = sc.nextInt();
		
		for(int t=0; t<T; t++) {
			int piece = sc.nextInt();
			int left = 0;
			int right = L;
			int ans = 0;

			while(left <= right) {
				int mid = (left+right)/2;
				if(check(mid) > piece) {
					left = mid+1;
//					ans = Math.max(ans, mid);
					ans = mid;
				}else {
					right = mid-1;
				}
			}
			System.out.println(ans);
		}
	}
	
	public static int check(int target) {
		int cnt = 0;
		int idx = 0;
		for(int i=1; i<N+2; i++) {
			if(arr[i] - arr[idx] >= target) {
				idx = i; //케익 자른 지점 표시
				cnt++; // 개수 추가
			}
		}
		return cnt;
	}
}
