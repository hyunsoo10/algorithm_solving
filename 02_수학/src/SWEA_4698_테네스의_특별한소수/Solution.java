package SWEA_4698_테네스의_특별한소수;

import java.util.Scanner;

public class Solution {

	public static int maxNum = 1000001;
	public static int[] prime = new int[maxNum];
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

	
		//소수판별 배열 채우기
		//에라토스테네스의 체 알고리즘 활용
		prime[1]=1;//1은 소수가 아니므로 1찍어주기
		for(int i=2; i<maxNum; i++) {
			
			//소수가 아님이 이미 판별이 된 요소는 건너뛰기
			if(prime[i]==1)
				continue;
			//소수의 배수에 모두 소수가 아님을 나타내는 1 찍기
			for(int j=i*2; j<maxNum; j+=i) {
				prime[j] = 1;
			}
		}
	
		for (int tc = 1; tc <= T; tc++) {
			String D = sc.next();//특별한 숫자 D String으로 받기
			
			//A~B 사이의 특별한 소수 탐색
			int A = sc.nextInt();
			int B = sc.nextInt();

			
			int cnt = 0; //특별한 소수 갯수
			
			for(int i=A; i<=B; i++) {
				if(prime[i]==0 && String.valueOf(i).contains(D))
					cnt++;
	
			}
			
			
			System.out.printf("#%d %d\n", tc, cnt);
		}


	}
}
