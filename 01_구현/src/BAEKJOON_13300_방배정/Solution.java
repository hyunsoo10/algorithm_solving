package BAEKJOON_13300_방배정;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 총 학생 수
		int K = sc.nextInt(); // 방 당 최대 인원 수

		Map<Integer, int[]> map = new HashMap<>();

		

		// 1학년 부터 6학년까지 일단 map value 정보 0으로 초기화
		for (int i = 1; i <= 6; i++) {
			int[] nums = new int[2];
			map.put(i, nums);
		}

		for (int i = 0; i < N; i++) {
			int gender = sc.nextInt();
			int grade = sc.nextInt();

			// 여자일 경우
			if (gender == 0) {
				map.get(grade)[0]++;
			}
			// 남자일 경우
			else {
				map.get(grade)[1]++;
			}

		}

		int answer = 0;
		for (int i = 1; i <= 6; i++) {
			for (int j = 0; j<2; j++) {
				//한 반의 한 성별의 총 인원이 제한 인원K보다 적을 경우는 방 1개만 필요
				if(map.get(i)[j] == 0) {
					continue;
				}
				else if(map.get(i)[j] <= K) {
					answer++;
				}
				//한 반의 한 성별의 총 인원이 제한 인원 보다 많을 경우
				else {
					//나누어떨어지는 경우 몫을 더해줌
					if(map.get(i)[j]%K == 0) {
						answer += map.get(i)[j]/K;
					}else {
						answer += map.get(i)[j]/K+1;
					}
				}
				
			}
			
		}
		
		System.out.println(answer);
		sc.close();

	}
}
