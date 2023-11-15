package BOJ_1417_국회의원선거;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//후보의 수
		int N = sc.nextInt();
		
		if(N==1) System.out.println(0);
		else {
			PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
			int myVote = sc.nextInt();
			
			//최대힙에 집어 넣기
			for(int i=0; i<N-1; i++) {
				pq.add(sc.nextInt());
			}
			
			int cnt = 0;
			//최다 득표자 뽑기
			int max = Integer.MAX_VALUE;
			while(myVote <= max) {
				max = pq.poll();
				if(max < myVote) break;
				cnt++;
				myVote++;
				pq.add(max-1);
			}
			
			System.out.println(cnt);
		}
		
	}
}
