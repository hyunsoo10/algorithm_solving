package BOJ_1629_곱셈;

import java.util.Scanner;

public class Main {
	static int A,B,C;
	static long ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		A = sc.nextInt();
		B = sc.nextInt();
		C = sc.nextInt();
		
		long ans = pow(A, B);
		System.out.println(ans);
	}
	static long pow(long A, int x) {
		if(x == 1) return A%C;
		long tmp = pow(A, x/2);
		//제곱을 짝수, 홀수에 따라 절반으로 나누기
		//모듈러 연산으로 분할 정복 계산시에 미리 나머지 연산 해줘야 연산 범위를 안 벗어난다.
		if(x%2==0) {
			return (tmp * tmp)%C;
		}else {
			return (tmp * tmp )%C *A%C;
		}
		
	}
}
