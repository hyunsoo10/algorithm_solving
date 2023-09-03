package BOJ_2805_나무자르기;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int[] tree;
	static int N, M, ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt(); //N: 나무의 수
		M = sc.nextInt(); //M : 가져가야 하는 나무 길이
		
		tree = new int[N];
		
		for(int i=0; i<N; i++) tree[i] = sc.nextInt();
		
		//가장 큰 나무의 높이
		int max = Arrays.stream(tree).max().getAsInt();
		//바닥 0부터 시작
		int min = 0;
	
		//이분 탐색
		binarySearch(max, min);

		
		System.out.println(ans);
	}
	//max: 나무 높이 상한선, min: 나무 높이 하한선
	static void binarySearch(int max, int min) {
		if(min >= max) {
			ans = min-1;
			return;
		}
		int mid = (max+min)/2; //중간 값 -> 자르는 위치
		long sum = 0;
		//자르는 위치보다 높은 나무들 합에 담아주기
		for(int i=0; i<N; i++) {
			if(tree[i] > mid) {
				sum += (tree[i]-mid);
			}
		}
		//잘랐을 때 나무의 길이의 합이 M보다 크거나 같으면 하한선을 올려줌
		if(sum >= M) {
			min = mid+1;
			binarySearch(max, min);
		}
		//잘랐을 때 나무의 길이의 합이 M보다 작으면 상한선을 내려준다.
		else {
			max = mid;
			binarySearch(max, min);
		}
	}
}
