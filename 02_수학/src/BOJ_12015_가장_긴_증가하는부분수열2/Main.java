package BOJ_12015_가장_긴_증가하는부분수열2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] arr = new int [N];
 
 		List<Integer> list = new ArrayList<>();
 		for(int i=0; i<N; i++) {
 			arr[i] = sc.nextInt();
 		}
 		
 		//첫번째 값은 그냥 입력
 		list.add(arr[0]);
 		
 		for(int i=1; i<arr.length; i++) {
 			int key = arr[i];
 			
 			//마지막에 넣은 값보다 크면 그냥 바로 이어서 add
 			if(key > list.get(list.size()-1))
 				list.add(key);
 			else {
 				list.set(binarySearch(list, key), key);
 			}
 			
 		}
 		System.out.println(list.size());
		
	}
	public static int binarySearch(List<Integer> list, int key) {
		int left = 0;
		int right = list.size()-1;
		
		//left가 right과 같아지는 순간 종료
		while(left < right) {
			int mid = (left + right) / 2;//중간값
			if(key > list.get(mid))
				left = mid+1;
			else
				right = mid;
		}
		return (left+right)/2;

		
	}
}
