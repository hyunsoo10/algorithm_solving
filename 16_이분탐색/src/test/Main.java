package test;

public class Main {
	static int[] arr = {1, 5, 6, 7, 12, 12, 12, 15, 29, 40};
	static int left = 0;
	static int right = arr.length;
	static int answer;
	static int n = 13;
	public static void main(String[] args) {
	
		binarySearch();
		
		System.out.println(answer);
		left = 0;
		right = arr.length;
		System.out.println(lowerbound());
		left = 0;
		right = arr.length;
		System.out.println(upperbound());
		
	}
	
	
	public static void binarySearch() {
	     //일반 이분탐색
	     while(left <= right){
	         int mid = (left+right) / 2;
	         //시간이 남음 -> right를 땡겨야함
	         if(arr[mid] >= n){
	             answer = mid;
	             right = mid-1;
	         }else{
	             left = mid+1;
	         }
	     }
	}
	
	
	public static int lowerbound() {
		while(left < right) {
			int mid = (left + right)/2;
			if(arr[mid] >= n) {
	          right = mid;
			}
			else{
	          left = mid+1;
			}
		}
		return left;
	}

	public static int upperbound() {
		while(left < right) {
			int mid = (left + right)/2;
			if(arr[mid] > n) {
	          right = mid;
			}
			else{
	          left = mid+1;
			}
		}
		return left;
	}
}
