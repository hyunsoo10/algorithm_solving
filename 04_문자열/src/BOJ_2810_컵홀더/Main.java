package BAEKJOON_2810_컵홀더;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		
		// 자리 배치도 입력 받기
		String input = sc.next();

		// S와 LL의 갯수 구하기
		int cntOfS = 0;
		int cntOfLL = 0;

		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == 'S')
				cntOfS++;
			if (input.charAt(i) == 'L')
				cntOfLL++;
		}
		//L은 항상 짝으로 나오므로 LL의 갯수는 L이 나온 횟수에서 나누기2를 해준다
		cntOfLL /= 2;

		//LL이 없을 경우는 그냥 S가 나온 횟수가 최대값
		if(cntOfLL == 0)
			System.out.println(cntOfS);
		
		//S가 나온 경우가 없을 경우 LL이 나온 횟수에 +1해준 값이 최대값(커플이기 때문에 S의 경우보다 1명 더 컵홀더 이용가능)
		if(cntOfS == 0)
			System.out.println(cntOfLL + 1);
		//S와 LL이 섞여있을 경우는 S나온 횟수 + LL나온 횟수 + 1
		if(cntOfS != 0 && cntOfLL != 0)
			System.out.println(cntOfLL + cntOfS + 1);

		sc.close();
	}
}
