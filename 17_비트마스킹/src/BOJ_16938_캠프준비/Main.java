package BOJ_16938_캠프준비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		//필요한 값 입력 받기
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		
		//난이도 배열 입력 받기
		st = new StringTokenizer(br.readLine(), " ");
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		//문제를 고르는 방법의 수 담을 변수
		int cnt = 0;
		
		//N의 범위가 1 ≤ N ≤ 15 이므로 비트마스킹을 통한 부분집합 구하기 가능
		for(int i=1; i < (1<<N); i++) {
			//부분집합 구할 때 마다 초기화해야할 변수
			//최고 난이도, 최저 난이도, 난이도의 합
			//문제 고른 개수(2문제 이상 골라야 하므로)
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			int sum = 0 ;
			int pick = 0;
			for(int j=0; j<N; j++) {
				if((i & (1<<j) ) > 0) {
					if(max < arr[j]) max = arr[j]; //최대값 찾기
					if(min > arr[j]) min = arr[j]; //최소값 찾기
					sum += arr[j]; //난이도의 총 합 구하기
					pick++;
				}//부분집합 끝
			}
			//sum이 L보다 크거나 같고, R보다 작거나 같으면서 
			//max-min이 X보다 크거나 같고, 2문제 이상 골랐으면 cnt 증가
			if(sum>=L && sum<=R && (max-min) >= X && pick>=2) cnt++;
		}
		System.out.println(cnt);
	}
}
