package BOJ_1253_좋다;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();// N개의 수
		
		int[] num = new int[N];
		for(int i=0; i<N; i++)
			num[i] = sc.nextInt();
		
		Arrays.sort(num);
		
		//좋은 수 횟수
		int cnt = 0;
		
		//전채 요소 싸이클
		for(int x=0; x<N; x++) {
			long target = num[x];
			
			int first = 0; //첫번째 포인터
			int second = N-1; //두번째 포인터
		
			while(first < second) {
				//두 포인터 위치의 합이 target일 때
				if(num[first]+num[second] == target) {
					//둘다 target 위치가 아니면 cnt 증가
					if(first != x && second !=x) {
						cnt++;
						break;						
					}
					else if(first == x)
						first++;
					else if(second == x)
						second--;
				
				}
				//투포인터 위치의 값이 target보다 작으면 fisrt 포인터를 증가
				else if(num[first] + num[second] < target) {
					first++;
				}
				//투 포인터 위치의 값이 target보다 크면 second 포인터 감소
				else {
					second--;
				}
				
			}
		}
		System.out.println(cnt);
	}
}
