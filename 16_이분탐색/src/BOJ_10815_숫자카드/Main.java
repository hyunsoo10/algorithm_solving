package BOJ_10815_숫자카드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int nums[] = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(nums);
		
		StringBuilder sb = new StringBuilder();
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		
		for(int i=0; i<M; i++) {
			int min = 0;
			int max = nums.length-1;
			boolean flag = false;
			
			int key = Integer.parseInt(st.nextToken());
			
			while(min <= max) {
				int mid = (min+max)/2;
				
				//key가 mid보다 크다면
				if(key > nums[mid]) {
					min = mid+1;
				}else if(key < nums[mid]) {
					max = mid-1;
				}else {
					flag = true;
					break;
				}
			}
			if(flag) sb.append("1 ");
			else sb.append("0 ");
			
		}
		
		System.out.println(sb);
	}
}
