package SWEA_11446_사탕가방;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			long M = Long.parseLong(st.nextToken());
			//사탕 종류 개수 저장
			long[] candies = new long[N+1];
			long max = 0;
			
			st = new StringTokenizer(br.readLine(), " ");
			for(int i=0; i<N; i++) {
				candies[i] = Long.parseLong(st.nextToken());
				if(max < candies[i]) max = candies[i];
			}
			
			long low = 1;
			long high = max;
			long ans = 0;
			
			while(low <= high) {
				long mid = (low + high) / 2;
				
				//가방을 mid개 만큼 만든다고 가정
				long sum = 0;
				for(int i=0; i<N; i++) sum += (candies[i]/mid);
				
				//sum이 M보다 더 적은 경우는 가방을 줄여야 한다
				if(sum < M) {
					high = mid-1;
				}else {
					//sum이 M 이상인 경우 가방 늘려본다.
					ans = mid;//최적 값을 저장하고
					low = mid+1;
				}
			}

			
			System.out.printf("#%d %d\n",tc, ans);
		}
	}
}
