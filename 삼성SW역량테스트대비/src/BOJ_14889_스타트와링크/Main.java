package BOJ_14889_스타트와링크;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static int N;
	static int[][] map;
	static List<Integer> nums;
	static int[] sel;
	static int min;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//N(4 ≤ N ≤ 20, N은 짝수)
		N = sc.nextInt();
		
		//1 <= S <=100 (능력치 값)
		//다 합쳐도 int 자료형 범위내에 있음
		map = new int[N][N];
		
		//map 정보 입력
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) map[i][j] = sc.nextInt();
		}
		
		//N명 중에서 N/2를 뽑는 조합
		//전체 번호(편의상 그냥 0번 부터 활용하겠음)
		nums = new ArrayList<>();
		//조합으로 뽑을 번호를 담을 배열
		sel = new int[N/2];
		
		for(int i=0; i<N; i++) nums.add(i);
		
		min = Integer.MAX_VALUE;
		
		combination(0, 0);
		
		System.out.println(min);
	
	}
	static void combination(int idx, int sidx) {
		//한 조합을 뽑으면 나머지 조합은 자동으로 완성되기 때문에 중복해서 뽑지 않기 위한 조건
		if(sel[0]!=nums.get(0)) return;
		//기저 조건: 다 뽑았음면 뽑은 숫자 담고 리턴
		if(sidx == N/2) {
			List<Integer> temp = new ArrayList<>();
			for(int a : sel) temp.add(a);
			check(temp);
			return;
		}
		//idx 다 확인 했으면 리턴
		if(idx == N )return;
		
		//재귀 파트
		//1.현재 숫자 뽑고 다음 숫자로
		sel[sidx] = nums.get(idx);
		combination(idx+1, sidx+1);
		//2.현재 숫자 안뽑고 다음 숫자로
		combination(idx+1, sidx);
	}
	static void check(List<Integer> temp) {
		//team1
		List<Integer> team1 = temp;
		//team2
		List<Integer> team2 = new ArrayList<>();
		for(int a: nums) {
			if(!team1.contains(a)) team2.add(a);
		}
//		System.out.print("team1: "+team1.toString());
//		System.out.println("team2: "+team2.toString());
		
		int sum1 = 0;
		//완전탐색으로 해당 팀의 시너지 구하기
		for(int i=0; i<N/2; i++) {
			for(int j=i+1; j<N/2; j++) {
				 sum1 += map[team1.get(i)][team1.get(j)];
				 sum1 += map[team1.get(j)][team1.get(i)];
			}
		}
		int sum2 = 0;
		//완전탐색으로 해당 팀의 시너지 구하기
		for(int i=0; i<N/2; i++) {
			for(int j=i+1; j<N/2; j++) {
				sum2 += map[team2.get(i)][team2.get(j)];
				sum2 += map[team2.get(j)][team2.get(i)];
			}
		}
		min = Math.min(Math.abs(sum2-sum1), min);
		
		
	}
}
