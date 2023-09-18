package BOJ_15829_Hashing;

import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		long sum = 0;
		char[] arr = sc.next().toCharArray();
		int x = 1234567891;
		long pow = 1;
		for(int i=0; i<N; i++) {
			sum += (arr[i] - 96)*pow;
			pow = (pow*31)%x;
		}
		System.out.println(sum%x);

	}
}
