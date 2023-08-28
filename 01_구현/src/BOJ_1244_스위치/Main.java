package BAEKJOON_1244_스위치;

import java.io.*;
import java.util.*;

public class Main {

//	public static int changeNum(int a) {
//		if (a == 1) {
//			return 0;
//		} else {
//			return 1;
//		}
//	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 스위치 개수
		int[] switchArr = new int[N + 1]; // 스위치 초기 상태를 담을 배열

		for (int i = 1; i <= N; i++) {
			switchArr[i] = sc.nextInt(2);
		}

		int num = sc.nextInt();

		for (int i = 0; i < num; i++) {
			int gender = sc.nextInt(); // gender
			int target_number = sc.nextInt(); // number

			// 남자일 경우
			if (gender == 1) {
				for (int j = 1; j <= N; j++) {
					// target_number의 배수일 경우 값을 변환
					if (j % target_number == 0) {
						// 기존 값이 1일 경우 0으로, 0일 경우 1로 변환
						// switchArr[j] = changeNum(switchArr[j]);
						if (switchArr[j] == 1)
							switchArr[j] = 0;
						else
							switchArr[j] = 1;
					}
				}
			}

			 //여자일 경우
			else {
				int index = 1;
				// 일단 target_number는 값이 바뀜
				if (switchArr[target_number] == 1)
					switchArr[target_number] = 0;
				else
					switchArr[target_number] = 1;

				// switchArr[target_number] = changeNum(switchArr[target_number]);

				while (true) {
					if (target_number - index > 0 && target_number + index < switchArr.length) {
						
						if (switchArr[target_number - index] == switchArr[target_number + index]) {

							if (switchArr[target_number + index] == 1) {
								switchArr[target_number - index] = 0;
								switchArr[target_number + index] = 0;
							} else {
								switchArr[target_number - index] = 1;
								switchArr[target_number + index] = 1;
							}

							index++;
						}
						// 같지 않을 경우 반복문 탈출
						else {
							break;
						}
					} else {
						break;
					}
				}

			}
		}

		for (int i = 1; i < switchArr.length; i++) {
			System.out.print(switchArr[i] + " ");
			if (i % 20 == 0) {
				System.out.println();
			}
			
		}
		sc.close();
	}
}
