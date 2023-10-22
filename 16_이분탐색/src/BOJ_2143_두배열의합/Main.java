package BOJ_2143_두배열의합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//T(-1,000,000,000 ≤ T ≤ 1,000,000,000)
		int T = Integer.parseInt(br.readLine()); 

		// n(1 ≤ n ≤ 1,000)
		//A배열 입력받기
		int n= Integer.parseInt(br.readLine()); 
		int[] arr1 = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<n; i++) {
			arr1[i] = Integer.parseInt(st.nextToken());
		}
		
		//B배열 입력받기
		int m= Integer.parseInt(br.readLine()); 
		int[] arr2 = new int[m];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<m; i++) {
			arr2[i] = Integer.parseInt(st.nextToken());
		}
		
		//A배열의 부분합의 배열 만들기
		int sizeA = n*(n+1)/2;
		int sizeB = m*(m+1)/2;
		long[] sumArr1 = new long[sizeA];
		for(int i=0, idx=0; i<n; i++) {
			int tmp = 0;
			for(int j=i; j<n; j++) {
				tmp += arr1[j];
				sumArr1[idx++] = tmp;
			}
		}
		//B배열의 부분합 배열 만들기
		long[] sumArr2 = new long[sizeB];
		for(int i=0, idx=0; i<m; i++) {
			int tmp = 0;
			for(int j=i; j<m; j++) {
				tmp += arr2[j];
				sumArr2[idx++] = tmp;
			}
		}
		
		//부분합 배열 정렬해주기
		Arrays.sort(sumArr1);
		Arrays.sort(sumArr2);
		
		long ans = 0;
		int index = 0;
		while(index < sizeA) {
			//sumArr1의 부분집합 탐색
			long aSum = sumArr1[index];
			//aSum의 개수 구하기
			long aCount = upperBound(sumArr1, aSum) - lowerBound(sumArr1, aSum);
			//T를 만들 수 있는 bSum의 개수 구하기
			long bCount = upperBound(sumArr2, T-aSum) - lowerBound(sumArr2, T-aSum);
			ans += aCount*bCount;//정답 카운팅 해주고
			index += aCount;//index는 aCount만큼 증가시키면됌
		}
		System.out.println(ans);
	}

	private static int lowerBound(long[] arr, long target) {
		int left = 0;
		int right = arr.length;
		while(left < right) {
			int mid = (left+right)/2;
			//찾고자 하는 값이 더 작으면
			if(target <= arr[mid]) {
				right = mid;
			}else {
				left = mid+1;
			}
		}
		return left;
	}

	private static int upperBound(long[] arr, long target) {
		int left = 0;
		int right = arr.length;
		while(left < right) {
			int mid = (left+right)/2;
			//찾고자 하는 값이 더 작거나 같으면
			if(target < arr[mid]) {
				right = mid;
			}else {
				left = mid+1;
			}
		}
		return left;
	}
}
