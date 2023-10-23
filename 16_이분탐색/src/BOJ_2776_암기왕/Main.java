package BOJ_2776_암기왕;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t<T; t++) {
			StringBuilder sb = new StringBuilder();
            int N = Integer.parseInt(br.readLine());
            
			int[] arr = new int[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
		      for(int i=0; i<N; i++)
	               arr[i] = Integer.parseInt(st.nextToken());
			
			
			//이진 탐색을 위한 정렬
			Arrays.sort(arr);
			
			int M = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine(), " ");
			
			for(int i=0; i<M; i++) {
				
				int left = 0;
				int right = N-1;
				int target = Integer.parseInt(st.nextToken());
				
				boolean flag = false;
				
				while(left <= right) {
					int mid = (left+right)/2;
					
					if(target == arr[mid]) {
						flag = true;
						break;
					}
					else if(target > arr[mid]) {
						left = mid+1;
					}else 
						right = mid-1;
					
				}
			     sb.append(flag? 1 : 0).append("\n");
            }
            System.out.print(sb);
		}
	}
}
