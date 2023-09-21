package 순열과조합로직;

import java.util.Scanner;

public class NextPermutation {
	static int[] nums;
	static int N;
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
		nums = new int[] {0, 1, 2, 3, 4, 5};
		
		N = nums.length;
		
		nextPermutation();
	}
	
	
	static void nextPermutation() {
		//주어진 수열의 맨 뒤부터 탐색하여서, 증가하는 부분을 찾는다
		int idx = N - 1; 
		for(int i=N-1; i>0; i--) {
			//증가하는 부분
			if(nums[i] > nums[i-1]) {
				idx = i; //해당 인덱스를 저장
				break;
			}
		}
		
		//만약 idx가 0이라면 끝난 것임
		if(idx == 0) return;
		
		//해당 인덱스를 기준으로 좌/우로 나눈다
		//좌측의 제일 오른쪽 숫자에 대하여, 우측의 제일 오른쪽 지점부터 탐색에서 가장 큰 수를 찾는다.
	}
}
