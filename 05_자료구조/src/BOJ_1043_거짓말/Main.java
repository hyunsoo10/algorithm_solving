package BOJ_1043_거짓말;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static Map<Integer, List<Integer>> party, group;
	static int  N, M;
	static boolean[] truth;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt(); //N: 사람의 수
		M = sc.nextInt(); //M: 파티의 수
		
		int K = sc.nextInt(); //K: 진실을 아는 사람의 수
		
		//진실을 알고 있는 사람
		//해당 인덱스가 true면 진실을 알고 있는 사람
		truth = new boolean[N+1];
		for(int i=0; i<K; i++) {
			truth[sc.nextInt()] = true;
		}
		party = new HashMap<>();
		group = new HashMap<>();
		for(int g=1; g<=N; g++) group.put(g, new ArrayList<>());
		
		int ans = 0; //정답
		
		//진실을 아는 사람이 없으면 정답은 곧 M
		if(K==0) {
			ans = M;
		}else {
			//진실을 아는 사람이 없는 파티 개수 모두 구하기
			for(int i=0; i<M; i++) {
				//각 파티에 오는 사람
				int tmp = sc.nextInt();
				List<Integer> tmpPeople = new ArrayList<>();
				//파티에 오는 사람 번호
				for(int j=0; j<tmp; j++) tmpPeople.add(sc.nextInt());
				
				party.put(i, tmpPeople);
				
				for(int j=0; j<tmpPeople.size(); j++) {
					for(int k=0; k<tmpPeople.size(); k++)
						if(!group.get(tmpPeople.get(j)).contains(tmpPeople.get(k)))
							group.get(tmpPeople.get(j)).add(tmpPeople.get(k));
				}
			}
			for(int key : group.keySet()) {
				boolean flag = true;
				if(group.get(key).isEmpty()) continue;
				else {
					for(int value : group.get(key)) {
						//진실을 아는 사람이 한명이라도 포함되어 있는 파티라면 false;
						if(truth[value] == true) flag = false;
					}
					if(!flag) {
						for(int value : group.get(key)) {
							truth[value] = true;
						}
					}
				}
				
			}
			for(int k = 0; k <M; k++) {
				boolean flag = true;
				for(int a : party.get(k)) {
					//진실을 아는 사람이 존재하면 false
					flag = bfs(a);
				}
				if(flag) ans++;
			}
		
			
		}
//		System.out.println(Arrays.toString(truth));
//		System.out.println(party.toString());
//		System.out.println(group.toString());
		System.out.println(ans);
	}
	
	static boolean bfs(int root) {
		Queue<Integer> queue = new LinkedList<>();//방문한 요소 queue에 담기
		List<Integer> result = new ArrayList<>();
		boolean[] v = new boolean[N+1];
		
		queue.offer(root);//초기값 넣기
		v[root] = true; //방문 처리
		
		//queue가 빌 때 까지
		while(!queue.isEmpty()) {
			int start = queue.poll();
			result.add(start);
			for(int value : group.get(start)) {
				//방문 기록이 없고 구역에 속한 번호라면
				if(!v[value]) {
					v[value] = true;
					queue.offer(value);
				}
			}
		}
		for(int r : result) {
			if(truth[r] == true) return false;
		}
		return true;
	}

}
