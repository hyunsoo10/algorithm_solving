package BOJ_2042_구간합_구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static long[] arr, sumTree;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N  = Integer.parseInt(st.nextToken());
		int M  = Integer.parseInt(st.nextToken());
		int K  = Integer.parseInt(st.nextToken());
		
		//세그먼트 tree 배열 선언
		arr = new long[N+1];
		sumTree = new long[N*4];
		//배열 요소 입력 받기
		for(int i=1; i<N+1; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}
		//세그먼트 트리 초기화
		init(1, 1, N);
		
		//쿼리 질문
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<M+K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int command = Integer.parseInt(st.nextToken());
		
			//update
			if(command == 1) {
				int index = Integer.parseInt(st.nextToken());
				long value = Long.parseLong(st.nextToken());
				update(1, 1, N, index, value);
			}
			else {
				int queryLeft = Integer.parseInt(st.nextToken());
				int queryRight = Integer.parseInt(st.nextToken());
				sb.append(querySum(1, 1, N,  queryLeft, queryRight) + "\n");
			}
		}
		System.out.println(sb.toString());
	}

	static void init(int node, int left, int right) {
		//리프 노드 도달
		if(left == right) {
			sumTree[node] = arr[left];
			return;
		}
		int mid = (left + right)/2;
		
		init(node*2, left, mid);
		init(node*2+1, mid+1, right);
		//세그 먼트 트리 노드에 구간합 더해주기
		sumTree[node] = sumTree[node*2] + sumTree[node*2+1];
	}
	static long querySum(int node, int left, int right, int queryLeft, int queryRight) {
		
		//겹치는 구간이 없을 때
		if(right < queryLeft || left > queryRight) return 0;
		//찾고자 하는 구간이 포함 될 때
		if(left >= queryLeft && right <= queryRight) return sumTree[node];
		
		//그 외의 경우
		int mid = (left + right)/2;
		long sumLeft = querySum(node*2, left, mid, queryLeft, queryRight);
		long sumRight = querySum(node*2+1, mid+1, right, queryLeft, queryRight);
		return sumLeft + sumRight;
	}
	
	// node : 현재 노드 번호
    // left, right : 현재 노드가 관리하는 영역
    // queryIndex : update 하고 싶은 배열의 index
    // value : update 하고 싶은 값
	static void update(int node, int left, int right, int queryIndex, long value) {
	
		
		// 범위를 벗어나면
		if(left > queryIndex || right < queryIndex) return;
		// 도달하면
		if(left == right) {
			sumTree[node] = value;
			return;
		}
		int mid = (left+right)/2;
		update(node*2, left, mid, queryIndex, value);
		update(node*2+1, mid+1, right, queryIndex, value);
		sumTree[node] = sumTree[node*2] + sumTree[node*2+1];
	}
}
