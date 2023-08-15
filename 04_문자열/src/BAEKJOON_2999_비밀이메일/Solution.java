package BAEKJOON_2999_비밀이메일;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String message = sc.next();
	
		//메시지 총 길이
		int N = message.length();
		//약수를 담을 리스트
		List<Integer> num = new ArrayList<>();

		//약수 추가
		for (int i = 1; i <= N; i++) {
			if (N % i == 0) {
				num.add(i);
			}
		}

		int R;
		int C;

		//약수가 2개일 경우는 첫번쨰 요소가 R, 두번째 요소가 C
		if (num.size() == 2) {
			R = num.get(0);
			C = num.get(1);
			
		}
		//num의 약수의 개수가 홀수일 경우는 제곱근임, R, C는 중간 값으로 동일
		else if (num.size()%2 == 1) {
			R = num.get(num.size()/2);
			C = num.get(num.size()/2);
		} 
		//그 외의 경우는 중간값에 있는 두 수가 작은 순서대로 각각 R과 C
		else {
			R = num.get(num.size() / 2 - 1);
			C = num.get(num.size() / 2);
		}
		
		char[][] arr = new char[R][C];
		int temp=0;
		for (int i = 0; i < C; i++) {
			for (int j = 0; j < R; j++) {
				arr[j][i] = message.charAt(temp);
				temp++;
			}
		}
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(arr[i][j]);
			}
		}

	}
}
