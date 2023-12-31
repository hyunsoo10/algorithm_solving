package 순열과조합로직;

import java.util.Arrays;

public class Main {

	static int N, R;
	static int[] arr, permArr, comArr;
	static boolean[] visited;

	public static void main(String[] args) {

		N = 5;
		R = 3;

		arr = new int[] { 1, 2, 3, 4, 5 };// 뽑을 숫자들 모임
		visited = new boolean[N]; // 방문 여부 나타낼 배열
		permArr = new int[R]; // R만큼 뽑은 순열 담을 배열
		System.out.println("----순열-----");
		permutation(0, R);

		permArr = new int[R]; // R만큼 뽑은 중복순열 담을 배열
		System.out.println("----중복 순열-----");
		duplicatePerm(0, R);

		comArr = new int[R]; // R만큼 뽑은 조합 담을 배열
		System.out.println("----조합-----");
		combination(0, 0, R);
		
		comArr = new int[R]; // R만큼 뽑은 중복 조합 담을 배열
		System.out.println("----중복 조합-----");
		duplicateComb(0, 0, R);
		
		
		System.out.println("----부분 집합(재귀)-----");
		visited = new boolean[N];
		powerset(0);
		
		System.out.println("----부분 집합(비트 연산자)-----");
		arr = new int[] { 1, 2, 3, 4, 5 };
		powersetWithBit();
		
		
	}



	// 순열
	// cnt: 현재까지 뽑은 횟수, r: 총 뽑아야 하는 횟수
	static void permutation(int cnt, int r) {

		// 다 뽑 았으면
		if (cnt == r) {
			System.out.println(Arrays.toString(permArr));
			return;
		}
		// arr 배열에서 숫자 뽑기
		for (int i = 0; i < N; i++) {
			// arr의 i 인덱스에 방문을 하지 않았다면
			if (!visited[i]) {
				visited[i] = true;// 방문 처리하고
				permArr[cnt] = arr[i]; // 순열 첫번째 뽑은 숫자에 arr배열의 i 인덱스를 넣는다.
				permutation(cnt + 1, r);// 첫번 째 숫자를 뽑은 후에는 다음 숫자를 뽑아야 한다.
				visited[i] = false;// 위의 로직에서 마지막으로 방문 찍은 숫자를 false로 바꿔줘야 다음 숫자를 뽑을 수 있다.
			}
		}
	}

	// 중복순열
	// cnt: 현재까지 뽑은 횟수, r: 총 뽑아야 하는 횟수
	static void duplicatePerm(int cnt, int r) {
		if (cnt == r) {
			System.out.println(Arrays.toString(permArr));
			return;
		}
		// arr배열에서 숫자 뽑기
		// 순열에서 visited 로직만 없애면 됨
		for (int i = 0; i < N; i++) {
			permArr[cnt] = arr[i];
			duplicatePerm(cnt + 1, r);
		}
	}

	// 조합
	// cnt: 현재까지 뽑은 횟수, start: 뽑기 시작하는 인덱스 r: 총 뽑아야 하는 횟수
	static void combination(int cnt, int start, int r) {
		// 다 뽑았으면 출력
		if (cnt == r) {
			System.out.println(Arrays.toString(comArr));
			return;
		}

		//start = 0부터 오름차순으로 뽑으면 중복 체크 필요 없이 조합 구하기 가능
		for (int i = start; i < N; i++) {
			comArr[cnt] = arr[i];// comArr에 뽑은 숫자 담고
			combination(cnt + 1, i+1, r); //갯수 1개 추가해주고, 다음 숫자 뽑기
		}
	}
	
	//중복조합
	static void duplicateComb(int cnt, int start, int r) {
		if(cnt == r) {
			System.out.println(Arrays.toString(comArr));
			return;
		}
		
		for(int i=start; i<N; i++) {
			comArr[cnt] = arr[i];
			duplicateComb(cnt+1, i, r);
		}
	}
	
	//부분집합(재귀 활용)
	//idx : arr의 인덱스
	private static void powerset(int idx) {
		//모든 인덱스를 확인한 경우
		if(idx == N) {
			for(int i=0; i<N; i++) {
				if(visited[i])
					System.out.print(arr[i]+ " ");
			}
			System.out.println();
			return;
		}
		
		//현재 index를 뽑고 다음 인덱스로
		visited[idx] = true;
		powerset(idx+1);
		//현재 index를 뽑지 않고 다음 인덱스로
		visited[idx] = false;
		powerset(idx+1);
	}
	
	//부분집합(비트연산자)
	private static void powersetWithBit() {
		
		//1을 N번 왼쪽으로 밀고, 거기에 -1을 하면 N개의 비트가 1로 채워진다
		for(int i=1; i< (1<<N); i++) {
			//N개의 비트가 1인지 여부를 체크
			for(int j=0; j<N; j++) {
				//i에서 1이 채워진 비트를 출력(부분집합)
				if((i & (1<<j)) > 0) System.out.print(arr[j]+" ");
			}
			System.out.println();
		}
	}

}