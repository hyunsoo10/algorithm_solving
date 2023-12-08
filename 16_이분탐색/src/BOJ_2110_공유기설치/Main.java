package BOJ_2110_공유기설치;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, C;
	static int[] arr; 
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		//N: 집의 개수  C: 공유기 개수
		N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		
		//이분탐색을 위해 배열로 입력 받고 오름차순 정렬
		for(int i=0; i<N; i++) arr[i] = Integer.parseInt(br.readLine());
		Arrays.sort(arr);
		
		//최소 거리가 가질 수 있는 최소값과 최대 값
		int min = 1; //집들의 거리는 1이기 때문에 최소값은 1
		int max = arr[N-1] - arr[0] + 1; //최대값은 양 끝의 집간 거리 +1로 설정
		
		int ans = 0;
		while(min <= max) {
			int mid = (min + max) / 2;
			
			//거리가 mid일 때 설치할 수 있는 공유기의 개수가 C보다 적다면 mid를 늘려야 함
			if(install(mid) < C) {
				max = mid-1;
			}else {
				ans = mid;
				min = mid+1;
			}
		}
		System.out.println(ans);
//		while(min < max) {
//			int mid = (min + max) / 2;
//			
//			//거리가 mid일 때 설치할 수 있는 공유기의 개수가 C보다 적다면 mid를 늘려야 함
//			if(install(mid) < C) {
//				max = mid;
//			}else {
//				min = mid+1;
//			}
//		}
//		System.out.println(min-1);
		
		
	}
	private static int install(int distance) {
		
		
		//공유기 설치한 개수
		int cnt = 1;
		//가장 마지막에 공유기를 설치한 인덱스
		int idx = 0;
		
		for(int i=1; i<N; i++) {
			//공유기를 설치할 수 있으면
			if(arr[i] - arr[idx] >= distance) {
				cnt++;
				idx = i;
			}
		}
		return cnt;
	}
}
