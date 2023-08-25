package SWEA_18630_스켜끄;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); //스위치 갯수
		
		int[] arr = new int[N+1]; //0번 인덱스 사용X
		//1번 스위치 정보 부터 입력받기
		for(int i=1; i<=N; i++)
			arr[i] = sc.nextInt();
		
		int M = sc.nextInt(); //학생 수
		
		//스위치 조작 시작
		for(int i=0; i<M; i++) {
			
			//성별 구분
			int gender = sc.nextInt();
			
			//남학생일 때
			if(gender==1) {
				int num = sc.nextInt();//받은 수
				
				//받은 수의 배수 스위치 바꾸기
				for(int j=1; j <= N; j++) {
					if(j%num==0)
						//상태 바꾸기
						arr[j] = swap(arr[j]);
				}
			}
			//여학생 일 때
			else {
				int num = sc.nextInt();//받은 수
				//step1. 일단 본인이 받은 수 스위치 바꾸기
				arr[num] = swap(arr[num]);
				
				//대칭 검사
				int idx=1;
				//범위 안에 있을 때
				while(num-idx>=1 && num+idx <=N) {
					//좌우 상태가 다르면 break
					if(arr[num-idx] != arr[num+idx])
						break;
					//같으면 스위치 상태 바꿔주기
					arr[num-idx] = swap(arr[num-idx]);
					arr[num+idx] = swap(arr[num+idx]);
					idx++;
		
				}
				
				
			}
			
		}
		for(int i=1; i<=N; i++) {
			System.out.print(arr[i]+ " ");
		}
 	}
	
	//1과 0 상태를 바꿔주는 메소드
	public static int swap(int a) {
		if(a==1)
			return 0;
		else
			return 1;
	}
}
