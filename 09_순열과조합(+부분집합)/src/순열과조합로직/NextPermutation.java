package 순열과조합로직;

import java.util.Arrays;
import java.util.Scanner;

public class NextPermutation {
	static int[] nums;
	static int N;
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
		nums = new int[] {0, 1, 2, 2, 3, 4, 5};
		
		N = nums.length;
		
		while(true) {
			System.out.println(Arrays.toString(nums));
			if(!nextPermutation()) break;
		}
	}
	
	
	static boolean nextPermutation() {
		//주어진 수열의 맨 뒤부터 탐색하여서, 증가하는 부분을 찾는다
		int idx = N - 1; 
		int j = idx;
		int k = idx;
		//1. 뒤에서 부터 증가하는 부분 찾기
		while(idx > 0 && nums[idx-1] >= nums[idx]) idx--;
		
		//증가하는 부분이 없으면 끝
		if(idx == 0) return false;
		
		//2. 오른쪽에서부터 idx-1의 값 보다 큰 값 찾기
		while(nums[idx-1] >= nums[j]) j--;
		swap(nums, idx-1, j);
		
		
		//3. 뒷부분 정렬
		while(idx < k)
			swap(nums, idx++, k--);
//		Arrays.sort(nums, idx, nums.length);
		return true;
	}
	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
