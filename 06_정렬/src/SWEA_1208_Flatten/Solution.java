package SWEA_1208_Flatten;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = 10; //10개 테스트 케이스 고정
		
		for(int tc = 1; tc<=T; tc++) {
			
			int N = sc.nextInt(); //덤프 횟수
			int answer = 0;//정답 담을 변수
			
			int[] arr = new int [100];//상자 정보 담을 배열
			
			//상자 정보 받는 배열
			for(int i = 0; i<100; i++) {
				arr[i] = sc.nextInt();
			}
			//배열 먼저 오름차순으로 정렬
			arr = countSort(arr);
			//덤프 횟수를 다 소진할 때 까지 반복
			while(N > 0) {
				N--;//덤프 횟수 차감
				//최소값 증가
				arr[0] = ++arr[0];
				//최대값 차감
				arr[99] = --arr[99];
				//배열 다시 정렬
				arr = countSort(arr);
				//최대값이랑 최소값의 차이가 0또는 1이라면 평탄화 작업 완료
				if(arr[99] - arr[0] == 0 || arr[99] - arr[0] == 1 ) {
					answer = arr[99] - arr[0];
					break;
				}
			}
			answer = arr[99] - arr[0];
			
			System.out.printf("#%d %d\n", tc, answer);
		}
		sc.close();
	}
	
	public static int[] countSort(int[] arr) {
		int max = max(arr);//주어진 배열 최대값 구하기
		
		//카운팅 횟수 담을 배열
		int[] countArr = new int[max+1];
		
		for(int i = 0; i < arr.length; i++) {
			countArr[arr[i]]++;
		}
		
		//countArr에 누적합으로 담기
		for(int i = 0; i<countArr.length-1; i++) {
			countArr[i+1] += countArr[i];
		}
		
		//정렬된 값 담을 배열
		int[] sortArr = new int[arr.length];
		
		for(int i = arr.length-1; i>=0; i--) {
			sortArr[--countArr[arr[i]]] = arr[i];
		}
		
		return sortArr;
	}
	
	public static int max(int[] arr) {
		int max = 0;
		for(int i = 0; i<arr.length; i++) {
			if(arr[i] > max)
				max = arr[i];
		}
		return max;
	}
	
}
