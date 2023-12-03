package BOJ_22866_탑보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int N, L;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 1<=N<=100,000
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();

		// 빌딩의 높이 담을 배열
		int[] height = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			height[i] = Integer.parseInt(st.nextToken());
		}

		// 가장 먼저 볼 수 있는 빌딩 인덱스 담을 배열
		int[] first = new int[N + 1];

		// 카운트 배열
		int[] count = new int[N + 1];

		// 왼쪽으로 볼 수 있는 빌딩들 카운팅
		Stack<Integer> leftStack = new Stack<>();
		for (int i = 1; i <= N; i++) {
			// 스택에는 빌딩의 번호를 담는다.
			// 그 번호의 빌딩의 높이가 현재 타겟 빌딩(i)의 높이보다 같거나 낮으면 볼 수 없으므로 stack에서 뺀다
			while (!leftStack.isEmpty() && height[leftStack.peek()] <= height[i]) {
				leftStack.pop();
			}

			// pop하고 남은 스택의 크기가 곧 볼 수 있는 개수
			count[i] = leftStack.size();
			// 왼쪽에서 볼 수 있는 빌딩들이 있는 경우라면, leftStack에서 가장 마지막에 쌓인 인덱스
			// 즉 peek() 값이 왼쪽 기준 가장 가까운 빌딩 번호 이다
			if (count[i] > 0)
				first[i] = leftStack.peek();

			// stack에는 계속 적으로 인덱스를 쌓아줘야한다.
			leftStack.push(i);
		}//end leftStack
		
		//오른쪽으로 볼 수 있는 빌딩들 카운팅은 반대로 진행하면 된다.
		Stack<Integer> rightStack = new Stack<>();
		for (int i = N; i > 0; i--) {
			while (!rightStack.isEmpty() && height[rightStack.peek()] <= height[i]) {
				rightStack.pop();
			}

			// pop하고 남은 스택의 크기가 곧 볼 수 있는 개수
			count[i] += rightStack.size();

			if (rightStack.size() > 0) {
				if(first[i] == 0) first[i] = rightStack.peek();
				if(i-first[i] > rightStack.peek()-i) first[i] = rightStack.peek();		
				
			}
			// stack에는 계속 적으로 인덱스를 쌓아줘야한다.
			rightStack.push(i);
		}//end rightStack

		//정답 출력
		for(int i=1; i<=N; i++) {
			sb.append(count[i]);
			if(count[i] > 0) sb.append(" "+first[i]);
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}// end main
}
