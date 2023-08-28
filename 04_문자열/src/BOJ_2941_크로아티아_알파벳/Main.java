package BOJ_2941_크로아티아_알파벳;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] croatiaAlphabet = new String[]{"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
		
		String input = sc.next();
		
		int answer = 0; // 정답 담을 변수
		
		int cnt = 0;
		for(int i = 0; i < croatiaAlphabet.length; i++) {
			//input이 크로아티아 알파벳에 해당하는 요소 가 있을경우
			if(input.contains(croatiaAlphabet[i])) {
				//크로아티아 알파벳을 "a"로 교환
				input = input.replace(croatiaAlphabet[i], "a");
			
			}
		}
		answer = input.length(); //정답은 남은 문자의 길이
		System.out.println(answer);
		sc.close();
	}
}
