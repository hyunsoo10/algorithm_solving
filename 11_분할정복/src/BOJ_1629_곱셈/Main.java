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
		
		long ans = pow(1, B);
		System.out.println(ans);
		System.out.println(ans%C);
	}
	static long pow(long sum, int x) {
		if(x == 1) return 1;
		//제곱을 짝수, 홀수에 따라 절반으로 나누기
		if(x%2==0) {
			x = x/2;
			long tmp = pow(A, x);
			ans = tmp * tmp;
			return ans;
		}else {
			int x1 = x/2;
			int x2 = (x/2)+1;
			ans = pow(A, x1) * pow(A, x2);
			return ans;
		}
		
	}
}
