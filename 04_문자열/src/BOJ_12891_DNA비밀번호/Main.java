package BOJ_12891_DNA비밀번호;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();// N: 문자열의 길이
		int P = sc.nextInt();// P: 부분 문자열의 길이

		
		String str = sc.next();

		
		int[] arr = new int[4];// A,C,G,T 순서
		for (int i = 0; i < 4; i++) {
			arr[i] = sc.nextInt();
		}

		int cnt = 0;
		int[] count = new int[4];
		//초기 부분집합 
		for (int i = 0; i < P; i++) {
			if (str.charAt(i) == 'A') count[0]++;
			else if (str.charAt(i) == 'C') count[1]++;
			else if (str.charAt(i) == 'G') count[2]++;
			else count[3]++;

		}
		boolean flag1 = true;
		for(int k=0; k<4; k++) {
			if(count[k] < arr[k]) {
				flag1 = false;
				break;
			}
		}
		if(flag1) cnt++;
		
		for (int i = P; i < N; i++) {
			char addChar = str.charAt(i);//추가할 문자열
			char removeChar = str.charAt(i-P); //삭제할 문자열
			if (addChar == 'A') {
				count[0]++;
				if(removeChar == 'A') count[0]--;
				else if(removeChar == 'C') count[1]--;
				else if(removeChar == 'G') count[2]--;
				else count[3]--;
			}
			else if (addChar == 'C') {
				count[1]++;
				if(removeChar == 'A') count[0]--;
				else if(removeChar == 'C') count[1]--;
				else if(removeChar == 'G') count[2]--;
				else count[3]--;
			}
			else if (addChar == 'G') {
				count[2]++;
				if(removeChar== 'A') count[0]--;
				else if(removeChar == 'C') count[1]--;
				else if(removeChar == 'G') count[2]--;
				else count[3]--;
			}
			else{
				count[3]++;
				if(removeChar == 'A') count[0]--;
				else if(removeChar == 'C') count[1]--;
				else if(removeChar == 'G') count[2]--;
				else count[3]--;
			}
			boolean flag2 = true;
			for(int k=0; k<4; k++) {
				if(count[k] < arr[k]) {
					flag2 = false;
					break;
				}
			}
			if(flag2) cnt++;
		}
		System.out.println(cnt); 
	}
}
