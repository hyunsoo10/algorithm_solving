package BOJ_2606_바이러스;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//컴퓨터의 수
		int N = sc.nextInt();
		
		//컴퓨터 연결관계 수
		int M = sc.nextInt();
		
		Map<Integer, List<Integer>> map = new HashMap<>();
		
		//map에 네트워크 연결관계 저장
		for(int i=0; i<M; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			if(!map.containsKey(x)) {
				map.put(x, new ArrayList<>());
			}
			if(!map.containsKey(y)) {
				map.put(y, new ArrayList<>());
			}
			map.get(x).add(y);
			map.get(y).add(x);
		}
		
		 Queue<Integer> queue = new LinkedList<>();
		 List<Integer> list = new ArrayList<>();
		 //1부터 시작
		 queue.add(1);
		 list.add(1);
		 if(!map.containsKey(1)) System.out.println(0);
		 else {
			 while(!queue.isEmpty()) {
				 int curr = queue.poll();
				 for(int x : map.get(curr)) {
					 if(!list.contains(x)) {
						 queue.add(x);
						 list.add(x);
					 }
				 }
			 }
			 System.out.println(list.size()-1);
		 }
	}
}
