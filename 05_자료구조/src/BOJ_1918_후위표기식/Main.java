package BAEKJOON_1918_후위표기식;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static Map<Character, Integer> operator = new HashMap<>();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// operator에 연산 우선순위 넣기
		operator.put('*', 2);
		operator.put('/', 2);
		operator.put('+', 1);
		operator.put('-', 1);
		operator.put('(', 0);
		operator.put(')', 0);

		String input = sc.next();
		input = postExpression(input);
		System.out.println(input);

	}

	public static String postExpression(String input) {
		String changed = "";
		// 연산자 쌓을 스택
		List<Character> myStack = new ArrayList<>();
		int top = -1; // top포인터
		for (int i = 0; i < input.length(); i++) {
			// 연산자일 경우
			if (operator.containsKey(input.charAt(i))) {
				// 여는 괄호는 우선순위가 제일 높으므로 스택에 그냥 넣는다.
				if (input.charAt(i) == '(') {
					myStack.add(input.charAt(i));
					top++;
				}
				// 닫는 괄호가 나올 경우 (가 나올 때 까지 pop한다.
				else if (input.charAt(i) == ')') {
					while (myStack.get(top) != '(') {
						// 연산자 pop
						changed += myStack.get(top);
						myStack.remove(top--);
					}
					// 마지막에는 (괄호도 빼줘야함
					myStack.remove(top--);
				}
				// 괄호가 아닌 경우 우선순위에 따라 연산자 pop작업 진행
				else {
					// 스택이 비어있으면
					if (myStack.size() == 0) {
						myStack.add(input.charAt(i));
						top++;
					} else {
						// 스택 크기가 0이 아니면서 top 연산자의 우선순위가 크거나 같을 경우 pop
						while (myStack.size() != 0 && operator.get(myStack.get(top)) >= operator.get(input.charAt(i))) {
							changed += myStack.get(top);
							myStack.remove(top--);
						}
						// pop작업이 끝났으면 현재 토큰 쌓기
						myStack.add(input.charAt(i));
						top++;
					}
				}
			}
			// 피연산자일 경우
			else {

				// 그냥 문자열에 더해준다.
				changed += input.charAt(i);
			}

		}
		while (top >= 0) {
			changed += myStack.get(top);
			myStack.remove(top--);
		}

		return changed;
	}

}