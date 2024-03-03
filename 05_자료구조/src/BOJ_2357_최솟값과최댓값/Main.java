package BOJ_2357_최솟값과최댓값;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] arr, maxTree, minTree;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N+1];
		maxTree =  new int[4*N];
		minTree = new int[4*N];
		
		//배열 입력 받기
		for(int i=1; i<=N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		init(1, 1, N);
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			sb.append(queryMin(1, 1, N, a, b) + " ");
			sb.append(queryMax(1, 1, N, a, b) + "\n");
		}
		System.out.println(sb.toString());
		br.close();
	}
	
	// 세그먼트 트리 초기화 메서드
	static void init(int node, int left, int right) {
		//리프 노드에 도달하면
		if(left == right) {
			maxTree[node] = arr[left];
			minTree[node] = arr[left];
			return;
		}
		
		int mid = (left + right) / 2;
		
		//자식 노드 재귀 호출
		init(node*2, left, mid);
		init(node*2 + 1, mid+1, right);
		//세그먼트 트리의 노드에 각각 최대, 최소 값 저장
		maxTree[node] = Math.max(maxTree[node*2], maxTree[node*2+1]);
		minTree[node] = Math.min(minTree[node*2], minTree[node*2+1]);
	}
	
	// 구간 최대값 찾는 메서드
	static int queryMax(int node, int left, int right, int queryLeft, int queryRight) {
		
		//겹치는 구간이 없을 때
		if(left > queryRight || right < queryLeft) return 0;
		//찾고하 하는 구간(query)이 완전 포함될 때
		if(left >= queryLeft && right <= queryRight) return maxTree[node];
		
		//그 외의 경우
		int mid = (left + right)/2;
		int leftMax = queryMax(node*2, left, mid, queryLeft, queryRight);
		int rightMax = queryMax(node*2 + 1, mid+1, right, queryLeft, queryRight);
		
		return Math.max(leftMax, rightMax);
	}
	
	// 구간 최소값 찾는 메서드
	static int queryMin(int node, int left, int right, int queryLeft, int queryRight) {
		if(left > queryRight || right < queryLeft) return Integer.MAX_VALUE;
		if(left >= queryLeft && right <= queryRight) return minTree[node];
		
		int mid = (left + right)/2;
		int leftMin = queryMin(node*2, left, mid, queryLeft, queryRight);
		int rightMin = queryMin(node*2+1, mid+1, right, queryLeft, queryRight);

		return Math.min(leftMin, rightMin);
		
	}
}
