package BOJ_10830_행렬제곱;

import java.util.Scanner;

public class Main {
	static int N;
	static long B;
	static long[][] result, original;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		B = sc.nextLong();

		original = new long[N][N];
		result = new long[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				original[i][j] = sc.nextLong()%1000;
			}
		}
		result = pow(original, B);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}

	}

	static long[][] pow(long[][] matrix, long x) {
		if (x == 1L) {
			return matrix;
		}
		long[][] tmp = pow(matrix, x / 2);
		tmp = matrixPow(tmp, tmp);

		if (x % 2 == 1L) {
			tmp = matrixPow(tmp, original);
		}
		return tmp;

	}

	static long[][] matrixPow(long[][] matrix1, long[][] matrix2) {
		long tmp[][] = new long[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					tmp[i][j] += matrix1[i][k] * matrix2[k][j];
					tmp[i][j] %= 1000;
				}
			}
		}
		return tmp;
	}
}
