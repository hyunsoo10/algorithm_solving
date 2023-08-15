package BAEKJOON_11399_ATM;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		//arr�� ������������ ����
		//insertion ������ �Ẹ��
		
		for(int i = 1; i<arr.length; i++) {
			//���� �񱳰��� �� ������ ������ ��� ���ؼ� ��ġ ����
			for(int j = i; j>0; j--) {
				//�ڽ� ���� ���� ���� �ִٸ� ��� ��ȯ
				if(arr[j-1] > arr[j]) {
					int tmp = arr[j-1];
					arr[j-1] = arr[j];
					arr[j] = tmp;
				}
			}
		}

		for(int i = 1; i<N; i++) {
			arr[i] += arr[i-1];
		}
		int sum = 0;
		for(int a : arr) {
			sum += a;
		}
		System.out.println(sum);
		sc.close();
	}
}
