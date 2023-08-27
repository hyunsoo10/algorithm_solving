package BAEKJOON_17471_게리맨더링;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main3 {
	static int N, min;
	static int[] population, arr, arr2;
	static boolean[] visited;
	static int[][] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt(); //구역의 개수 N
		population =  new int[N+1];
		for(int i=1; i<=N; i++) {
			population[i] = sc.nextInt();
		}//구역 인구수 입력 끝
		
		map = new int [N+1][];
		for(int i=1; i<=N; i++) {
			int num = sc.nextInt();
			map[i] = new int[num];
			for(int j=0; j<num; j++) {
				map[i][j] = sc.nextInt();
			}
		}//구역 연결관계 입력 끝
		
		//선거구 나누기
		//부분집합  + 조합 활용
		
		//총 구역이 N개일 때 1 ~ r개까지 뽑는 조합의 부분집합을 구해야 한다.
		int r = N/2;
		//총 구역 번호 담은 배열
		arr = new int[N];
		for(int i=1, idx=0; i<=N; i++, idx++) {
			arr[idx] = i;
		}
		min = Integer.MAX_VALUE;
		//1~r까지 뽑는 조합
		for(int i=1; i<=r; i++) {
			arr2 = new int[i];//구역 나눌 때 한 구역을 임시로 담을 배열
			combination(0, 0, i);
		}
		
		int answer = 0;
		if(min == Integer.MAX_VALUE)
			answer = -1;
		else
			answer = min;
//		System.out.println(Arrays.deepToString(map));
		System.out.println(answer);
		
	}
	//cnt가 현재 뽑은 횟수 카운팅 : 항상 0 부터 시작
	//start는 뽑기 시작할 인덱스
	//r은 총 뽑아야 하는 수
	static void combination(int cnt, int start, int r) {
		//cnt == r 면 다 뽑은 것임
		if(cnt == r) {
//			System.out.println(Arrays.toString(arr2));
			
			//이렇게 구역이 형성 되었을 때 가능한지 아닌지 검사
			//만약 구역이 형성되는 경우라면 구역1과 구역2의 인구수 차이 계산
			int tmp = check(arr2);
			
			//구역의 인구수를 나눌 수 있는 경우라면 그 인구수의 차이 최소값 갱신
			if(tmp != -1) {
				min = Math.min(min, tmp);
			}
			return;
		}
		
		//start 인덱스부터 뽑기 시작
		for(int i=start; i<N; i++) {
			arr2[cnt] = arr[i];
			combination(cnt+1, i+1, r);
		}
	}
	
	static int check(int[] arr2) {
		
		List<Integer> area1 = new ArrayList<>();//임시 1구역
		List<Integer> area2 = new ArrayList<>();//임시 2구역
		boolean flag = true;//가능으로 초기화
		//임시 1구역과 2구역 나누기
		for(int a : arr2)
			area1.add(a);
		for(int a: arr)
			if(!area1.contains(a))
				area2.add(a);
		
		//구역의 크기가 1보다 클때
		if(area1.size()>1) {
			//구역에 있는 요소들 검사
			for(int a : area1) {
				//그 구역과 연결되어 있는 구역 검사
				int tmp=0;
				for(int num : map[a]) {
					if(area1.contains(num))
						tmp++;
				}
				//해당 구역이 다른 마을과 연결되 있지 않다면 false 하고 break
				if(tmp==0) {
					flag=false;
					break;
				}
			}
		}
		//구역의 크기가 1보다 클때
		if(area2.size()>1) {
			//구역에 있는 요소들 검사
			for(int a : area2) {
				//그 구역과 연결되어 있는 구역 검사
				int tmp=0;
				for(int num : map[a]) {
					if(area2.contains(num))
						tmp++;
				}
				//해당 구역이 다른 마을과 연결되 있지 않다면 false 하고 break
				if(tmp==0) {
					flag=false;
					break;
				}
			}
		}
//		System.out.println(area1.toString());
//		System.out.println(area2.toString());
//		System.out.println(flag);
		//구역을 나눌 수 있는 경우라면 그 인구수의 차이 리턴
		if(flag) {
			int sum1 = 0;
			int sum2 = 0;
			for(int a : area1) {
				sum1 += population[a];
			}
			for(int a : area2) {
				sum2 += population[a];
			}
			
			//두 구역 인구수의 총합의 차이 리턴
			return Math.abs(sum1-sum2);
			
		}
		//만약 구역을 나눌 수 없다면 -1 리턴
		return -1;
	}
	

}
