package SWEA_5432_쇠막대기_자르기;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			String bar = sc.next();
			
			//막대기 쌓을 리스트
			List<Character> list = new ArrayList<>();
			
			//총 막대기 갯수
			int ans = 0;
			int top=-1;//리스트 마지막 인덱스 가리킴
			for(int i=0; i<bar.length(); i++) {
				//열린 괄호인 경우
				if(bar.charAt(i)=='(') {
					//바로 닫힌 괄호가 나올 경우 레이저 이므로 지금까지 쌓인 막대기 갯수 카운팅
					if(bar.charAt(i+1) == ')') {
						ans += list.size();
						i=i+1;//레이저 건너뛰기
					}
					
					//아닐 경우 list에 막대기 쌓기
					else {
						list.add('(');
						top++;
					}
				}
				//닫힌 괄호일 경우(레이저인 경우는 이미 건너뛰므로, 막대기의 끝을 의미)
				else {
					ans+=1; //막대기 1개 추가
					list.remove(top--);//그 막대기를 리스트에서 빼줘야함
				}
			}
			
			System.out.printf("#%d %d\n",tc,ans);
		}
	}
}
