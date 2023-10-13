package BOJ_10816_숫자카드2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;
	static int N;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//상근이가 가지고 있는 숫자 카드의 개수
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		StringBuilder sb = new StringBuilder();
		
		//카운팅할 숫자 개수
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<M; i++) {
			//찾아야 될 숫자
			int target = Integer.parseInt(st.nextToken());
			sb.append(upperBound(target) - lowerBound(target) + " ");
		}
		System.out.println(sb.toString());
	}

	private static int lowerBound(int target) {
		int min = 0;
		int max = N;
		
		while(min < max) {
			int mid = (min + max)/2;
			
			if(target <= arr[mid]) {
				max = mid;
			}
			else {
				min = mid +1;
			}
		}
		return min;
	}

	private static int upperBound(int target) {
		int min = 0;
		int max = N;
		
		while(min < max) {
			int mid = (min + max)/2;
			
			if(target < arr[mid]) {
				max = mid;
			}
			else {
				min = mid +1;
			}
		}
		return min;
	}

//	//이분 탐색으로 target 숫자 찾아서 개수 리턴 해주는 메서드
//	private static void binarySearch(int min, int max, int target) {
//		if(min > max) return;
//		int mid = (min+max)/2;
//		//target이 중간값 보다 큰 경우엔 
//		if(target>arr[mid]) {
//			//최소값을 중간값으로
//			binarySearch(mid+1, max, target);
//		}
//		//target이 중간값보다 작으면
//		else if(target < arr[mid]) {
//			binarySearch(min, mid-1, target);
//		}else {
//			//target == mid이면
//			cnt++;
//			int left = mid-1;
//			int right = mid+1;
//			while(left>=0 && left<N && arr[left] == target) {
//				cnt++;
//				left--;
//			}
//			while(right >=0 && right<N && arr[right] == target) {
//				cnt++;
//				right++;
//			}
//		}
//		
//		return;
//	}
}
