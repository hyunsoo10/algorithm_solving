package BOJ_14888_연산자끼워넣기;

import java.util.Scanner;

public class Main {
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	static int N;
	static int[] nums, op;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//수의 개수 N(2 ≤ N ≤ 11)
		N = sc.nextInt();
		//숫자 입력받기
		nums = new int[N];
		for(int i=0; i<N; i++) nums[i] = sc.nextInt();
		
		//연산식 각각의 개수 입력 받기
		op = new int[4];
		for(int i=0; i<4; i++) op[i] = sc.nextInt();
		
		//첫번째 숫자와 1번단계부터 시작
		dfs(nums[0], 1);
		
		System.out.println(max);
		System.out.println(min);
	}
	
	//value: 현재까지 계산된 값, step: 현재 단계
	static void dfs(int value, int step) {
		
		//기저조건 : step이 N이 되면 모든 숫자의 연산을 했으므로 value값을 최대 최소와 비교후 업데이트하고 리턴
		if(step == N) {
			max = Math.max(max, value);
			min = Math.min(min, value);
			return;
		}
		
		//재귀파트
		//덧셈, 뺄셈, 나눗셈, 곱셈 순으로 dfs 재귀 호출(순서는 상관 없긴 함)
		if(op[0] > 0) {
			op[0]--; //연산자 사용했으므로 감소
			dfs(value + nums[step], step+1);
			op[0]++; //다시 복귀 작업
		}
		if(op[1]>0) {
			op[1]--; //연산자 사용했으므로 감소
			dfs(value - nums[step], step+1);
			op[1]++; //다시 복귀 작업
		}
		if(op[2]>0) {
			op[2]--; //연산자 사용했으므로 감소
			dfs(value * nums[step], step+1);
			op[2]++; //다시 복귀 작업
		}
		if(op[3]>0){
			op[3]--; //연산자 사용했으므로 감소
			dfs(value / nums[step], step+1);
			op[3]++; //다시 복귀 작업
			
		}
	}

}
