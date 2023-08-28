package BOJ_1158_요세푸스;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		List<Integer> list = new ArrayList<>();
		// 정답 순열 담을 리스트
		List<Integer> result = new ArrayList<>();

		int N = sc.nextInt(); // 총 사람 수 N명
		int K = sc.nextInt(); // 제거 되는 순서

		// 인원수대로 일단 리스트 생성
		for (int i = 1; i <= N; i++) {
			list.add(i);
		}
		int idx = 0;
		while (list.size() != 0) {
			if (list.size() >= K) {
				idx = K-1;
				result.add(list.get(idx));
				list.remove(idx);
				Collections.rotate(list, list.size() - idx);
			}
			// 제거해야 되는 K번째 보다 총 남아 있는 인원수가 적으면서 남아 있는 인원수가 2명 이상이면
			else if (list.size() > 1) {
				//나머지가 0일 때는 마지막 인덱스가 해당
				if (K % list.size() == 0) {
					idx = list.size()-1;
					result.add(list.get(idx));
					list.remove(idx);
					Collections.rotate(list, list.size() - idx);
				}
				//나머지가 0이 아닐 떄는 나머지에서 -1 해준 값이 인덱스
				else {
					idx = (K % list.size()) - 1;
					result.add(list.get(idx));
					list.remove(idx);
					Collections.rotate(list, list.size() - idx);
				}
			}
			// 한명 남았으면 그 값 result에 추가하고 list에서 빼면 끝
			else {
				result.add(list.get(0));
				list.remove(0);
			}
		}
		System.out.print("<");
		for (int i = 0; i < result.size()-1; i++) {
			System.out.printf("%d, ", result.get(i));
		}
		System.out.printf("%d>", result.get(result.size()-1));
	}
}
