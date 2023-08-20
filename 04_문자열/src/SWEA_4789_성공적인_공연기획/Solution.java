package SWEA_4789_성공적인_공연기획;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			
			String input = sc.next();
			//현재 일어난 사람 수
			int currentStand = input.charAt(0) - '0';
			int ans = 0;//고용인
			
			//i : 필요한 일어난 사람의 수
			//currentStand : 현재 일어나 있는 사람의 수
			for(int i = 1; i<input.length(); i++) {
				//1이상을 찾을경우
				if(input.charAt(i)!='0') {
					
					//필요한 사람의 수보다 현재 일어나 있는 사람의 수가 작을때만 고용인 추가
					if(currentStand < i) {						
						//고용인 추가
						ans += i - currentStand;
						//그때 필요했던 고용인 숫자 더해주고
						currentStand += i - currentStand;
						
					}
					//조건이 충족되면 일어나는 사람의 수 더해준다.
					currentStand += input.charAt(i) - '0'; 
				}

			}
			System.out.printf("#%d %d\n",tc, ans);
		}
	}
}
