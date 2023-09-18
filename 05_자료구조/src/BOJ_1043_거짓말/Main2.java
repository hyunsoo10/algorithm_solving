package BOJ_1043_거짓말;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main2 {
	static Map<Integer, List<Integer>> party;
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(input);
		
		int N = sc.nextInt(); //N: 사람의 수
		int M = sc.nextInt(); //M: 파티의 수
		
		int K = sc.nextInt(); //K: 진실을 아는 사람의 수
		//진실을 아는 사람과, 진실을 아는 사람과 같이 파티에 오는 사람을 나타낼 배열
		boolean[] truth = new boolean[N+1];
		for(int i=0; i<K; i++) {
			truth[sc.nextInt()] = true;
		}
		party  = new HashMap<>();
		
		int ans = 0; //정답
		
		//진실을 아는 사람이 없으면 정답은 곧 M
		if(K==0) {
			ans = M;
		}else {
			//진실을 아는 사람이 없는 파티 개수 모두 구하기
			int cnt = 0;
			for(int i=0; i<M; i++) {
				//각 파티에 오는 사람
				int tmp = sc.nextInt();
				List<Integer> tmpPeople = new ArrayList<>();
				//파티에 오는 사람 번호
				for(int j=0; j<tmp; j++) tmpPeople.add(sc.nextInt());
				//진실 아는 사람 있는 지 여부
				//없다는 것으로 초기화
				boolean flag = false;
				for(int a : tmpPeople) {
					if(truth[a] == true) flag =  true;
				}
				if(flag) {
					for(int a : tmpPeople) {
						truth[a] = true;
					}	
				}
				party.put(i, tmpPeople);
			}

			
			//역 순회 해서 또 true 찍어주기
			for(int i=M-1; i>=0; i--) {
				boolean flag1 = false;
				for(int x : party.get(i)) {
					if(truth[x] == true) flag1 = true;
				}
				if(flag1) {
					for(int x : party.get(i)) truth[x] = true;
				}
			}
			//truth 배열에서 true로 찍혀 있는 사람이 한명도 없는 경우에만 ans++
			for(int i=0; i<M; i++) {
				boolean flag2 = true;
				for(int x : party.get(i)) {
					if(truth[x] == true) flag2 = false;
				}
				if(flag2) ans++;
			}
		}
//		System.out.println(Arrays.toString(truth));
		System.out.println(ans);
	}
	static void bfs(Map<Integer, List<Integer>> map ) {
		
	}
	
	static String input = "5 4\r\n" + 
			"1 5\r\n" + 
			"2 1 2\r\n" + 
			"2 2 3\r\n" + 
			"2 3 4\r\n" + 
			"2 4 5";
}
