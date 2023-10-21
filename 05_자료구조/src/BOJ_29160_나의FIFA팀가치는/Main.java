package BOJ_29160_나의FIFA팀가치는;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		//선수의 수
		int N = Integer.parseInt(st.nextToken());
		//K년
		int K = Integer.parseInt(st.nextToken());
		
		Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
		
//		map.computeIfAbsent(1, key -> new PriorityQueue<Integer>(Collections.reverseOrder()));
//		map.get(1).add(6);
//		map.get(1).add(5);
//		System.out.println(map.toString());
		
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			//포지션
			int position = Integer.parseInt(st.nextToken());
			//가치
			int value = Integer.parseInt(st.nextToken());
			
			//key : 포지션   value : 선수 값어치
			map.computeIfAbsent(position, key -> new PriorityQueue<Integer>(Collections.reverseOrder()));
			map.get(position).add(value);
		}
		
		int sum = 0;
		for(int i=0; i<K; i++) {
			
			//선발선수 가치-1
			for(int key : map.keySet()) {
				List<Integer> list = new ArrayList<>();
				//해당 포지션의 가장 가치가 높은 선수의 가치를-1해서 다시 팀에 넣어준다
				int target = map.get(key).poll();
				if(target-1 <= 0 ) map.get(key).add(0);
				else map.get(key).add(target-1);
			}
			
			//선발선수 가치 합 구하기
			sum = 0;
			for(int key : map.keySet()) {
				sum += map.get(key).peek();
			}
		}
		System.out.println(sum);
	}
}
