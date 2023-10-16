package BOJ_1654_랜선자르기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		long min = 1;
		long max = 0;
		arr = new int[K];
		
		for(int i=0; i<K; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if(arr[i] > max) max = arr[i];
		}
		max+=1;
		while(min < max) {
			long mid = (min+max)/2;
			//mid길이로 잘랐을 때 개수가 N개보다 적다면
			if(count((int)mid) < N ) {
				max = mid;
			}else {
				min = mid+1;
			}
		}
		System.out.println(min-1);
		
	}
	private static int count(int len) {
		int cnt = 0;
		for(int i=0; i<arr.length; i++) {
			cnt += arr[i]/len;
		}
		return cnt;
	}
}
