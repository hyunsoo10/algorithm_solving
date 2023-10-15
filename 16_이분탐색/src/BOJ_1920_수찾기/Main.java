package BOJ_1920_수찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		//자연수 N
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] arr = new int[N];
		for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());
		//이분탐색을 하기 위한 정렬
		Arrays.sort(arr);
		
		//찾을 수 개수
		int M = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine(), " ");
		
		for(int i=0; i<M; i++) {
			int min = 0;
			int max = N-1;
		
			int X = Integer.parseInt(st.nextToken());
			boolean flag = false;
			while(min <= max) {
				int mid = (min+max)/2;
				
				if(X < arr[mid]) {
					max = mid-1;
				}else if (X > arr[mid]) {
					min = mid+1;
				}else {
					flag = true;
					break;
				}
			}
			if(flag) sb.append("1\n");
			else sb.append("0\n");
		}
		System.out.println(sb);
			
	}
}
