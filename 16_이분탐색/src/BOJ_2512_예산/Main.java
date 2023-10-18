package BOJ_2512_예산;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int min = 0;
		int max = arr[N-1];
		
		int M = Integer.parseInt(br.readLine());
		int ans = 0;
		int mid = (min+max)/2;
		while(mid != max && mid != min) {
			
			if(amount(mid) < M) {
				min = mid;
			}else {
				max = mid;
			}
			mid = (min+max)/2;
		}
		
		ans = min;
		
		if(amount(max) <= M) ans = max;
		
		System.out.println(ans);
		
	}

	private static int amount(int mid) {
		int sum = 0;
		for(int i=0; i<N; i++) {
			if(arr[i] >= mid) sum += mid;
			else sum += arr[i];
		}
		return sum;
	}
}
