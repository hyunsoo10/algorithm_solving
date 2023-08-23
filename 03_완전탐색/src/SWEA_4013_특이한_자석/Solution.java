package SWEA_4013_특이한_자석;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int K = sc.nextInt();// 자석을 회전시키는 횟수

			// 자석 정보 담을 리스트
			List<List<Integer>> list = new ArrayList<>();

			// 자석 4개 정보 받기
			for (int i = 0; i < 4; i++) {

				List<Integer> innerList = new ArrayList<>();
				for (int j = 0; j < 8; j++) {
					innerList.add(sc.nextInt());
				}
				list.add(innerList);
			} // 자석 4개 정보 받기 끝

			// 자석 회전 실행
			for (int i = 0; i < K; i++) {
				int magnet = sc.nextInt(); // 회전하려는 자석 번호
				int direction = sc.nextInt();// 시계방향: 1, 반시계방향: -1

				// 1번 자석 회전 시킬 때
				if (magnet == 1) {
			
					// 2, 3, 4번 자석 회전 여부
					boolean flag2 = false;
					boolean flag3 = false;
					boolean flag4 = false;

					// 접점이 다르면 바꿔야됌;
					if (list.get(0).get(2) != list.get(1).get(6))
						flag2 = true;// 회전 해야 함
					if (list.get(1).get(2) != list.get(2).get(6))
						flag3 = true;
					if (list.get(2).get(2) != list.get(3).get(6))
						flag4 = true;
					
					list.set(0, rotate(list.get(0), direction));//1번회전
					//2, 3, 4 회전
					if (flag2)
						list.set(1, rotate(list.get(1), -(direction)));
					if (flag2 && flag3)
						list.set(2, rotate(list.get(2), direction));
					if (flag2 && flag3 && flag4)
						list.set(3, rotate(list.get(3), -(direction)));

				} else if (magnet == 2) {
	
					// 2, 3, 4번 자석 탐색
					boolean flag1 = false;
					boolean flag3 = false;
					boolean flag4 = false;

					// 접점 다르면 회전
					if (list.get(1).get(6) != list.get(0).get(2))
						flag1 = true;// 회전 해야 함
					if (list.get(1).get(2)!= list.get(2).get(6))
						flag3 = true;
					if (list.get(2).get(2) != list.get(3).get(6))
						flag4 = true;

					list.set(1, rotate(list.get(1), direction));
					if (flag1)
						list.set(0, rotate(list.get(0), -(direction)));
					if (flag3)
						list.set(2, rotate(list.get(2), -(direction)));
					if (flag3 && flag4)
						list.set(3, rotate(list.get(3), direction));

				} else if (magnet == 3) {
		
					boolean flag1 = false;
					boolean flag2 = false;
					boolean flag4 = false;

					if (list.get(2).get(2) != list.get(3).get(6))
						flag4 = true;
					if (list.get(2).get(6) != list.get(1).get(2))
						flag2 = true;
					if (list.get(1).get(6) != list.get(0).get(2))
						flag1 = true;

					list.set(2, rotate(list.get(2), direction));
					if (flag2)
						list.set(1, rotate(list.get(1), -(direction)));
					if (flag2&&flag1)
						list.set(0, rotate(list.get(0), direction));
					if (flag4)
						list.set(3, rotate(list.get(3), -(direction)));

				} else {
					boolean flag1 = false;
					boolean flag2 = false;
					boolean flag3 = false;

					if (list.get(3).get(6)!= list.get(2).get(2))
						flag3 = true;// 회전 해야 함
					if (list.get(2).get(6) != list.get(1).get(2))
						flag2 = true;
					if (list.get(1).get(6) != list.get(0).get(2))
						flag1 = true;

					list.set(3, rotate(list.get(3), direction));
					if (flag3)
						list.set(2, rotate(list.get(2), -(direction)));
					if (flag3 && flag2)
						list.set(1, rotate(list.get(1), direction));
					if (flag3 && flag2 && flag1)
						list.set(0, rotate(list.get(0), -(direction)));
				}

			}
			
			int answer = 0;

			if (list.get(0).get(0) == 1)
				answer += 1;
			if (list.get(1).get(0) == 1)
				answer += 2;
			if (list.get(2).get(0) == 1)
				answer += 4;
			if (list.get(3).get(0) == 1)
				answer += 8;

			System.out.printf("#%d %d\n", tc, answer);
		}

	}

	public static List<Integer> rotate(List<Integer> list, int direction) {
		List<Integer> newList = new ArrayList<>();
		// 시계방향
		if (direction == 1) {
			// 마지막 인덱스 부터 삽입
			newList.add(list.get(list.size() - 1));
			for (int i = 0; i < list.size() - 1; i++) {
				newList.add(list.get(i));
			}
			return newList;
		}
		// 반시계방향 회전
		else {
			for (int i = 1; i < list.size(); i++) {
				newList.add(list.get(i));
			}
			newList.add(list.get(0));
			return newList;
		}
	}
}
