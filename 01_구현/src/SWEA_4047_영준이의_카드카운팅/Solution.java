package SWEA_4047_영준이의_카드카운팅;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			String input = sc.next();

			Map<Character, List<Integer>> deck = new HashMap<>();
			//미리 카드 키 값 생성 후 빈 리스트 추가
			deck.put('S', new ArrayList<Integer>());
			deck.put('D', new ArrayList<Integer>());
			deck.put('H', new ArrayList<Integer>());
			deck.put('C', new ArrayList<Integer>());
			
			boolean flag = true;
			
			// card정보 읽는 인덱스
			int cardIdx = 0;
			while (cardIdx < input.length()) {
				char card = input.charAt(cardIdx);
				int cardNum = Integer.parseInt(input.substring(cardIdx + 1, cardIdx + 3));

				if (deck.get(card).contains(cardNum)) {
					// 중복 숫자 나오면 flag false로 바꾸고 반복문 탈출
					flag = false;
					break;
				}
				deck.get(card).add(cardNum);

				cardIdx += 3;
			}

			System.out.printf("#%d ", tc);
			if (flag) {
				System.out.print(13 - deck.get('S').size() + " ");
				System.out.print(13 - deck.get('D').size() + " ");
				System.out.print(13 - deck.get('H').size() + " ");
				System.out.print(13 - deck.get('C').size() + " ");
				System.out.println();
			} else {
				System.out.println("ERROR");
			}

		}

	}
}
