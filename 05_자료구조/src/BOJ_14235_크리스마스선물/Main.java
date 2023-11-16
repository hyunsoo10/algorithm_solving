package BOJ_14235_크리스마스선물;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		//아이들과 거점지를 방문한 횟수
		int N = sc.nextInt();
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		
		for(int i=0; i<N; i++) {
			
			int x = sc.nextInt();
			
			if(x == 0) {
				if(pq.isEmpty()) sb.append(-1+"\n");
				else sb.append(pq.poll()+"\n");
			}else {
				for(int j=0; j<x; j++) {
					pq.add(sc.nextInt());
				}
			}
		}
		
		System.out.println(sb.toString());
	}
}
