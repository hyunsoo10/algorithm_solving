package BOJ_1655_가운데를말해요;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		//최대힙과 최소힙
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
		
		for(int t=0; t<T; t++) {
			int value = Integer.parseInt(br.readLine());
			
			//최대힙과 최소힙의 사이즈가 같을 경우엔 무조건 maxHeap에 넣을 것이다
			if(maxHeap.size() == minHeap.size()) {
				maxHeap.offer(value);
				
				//최소힙과 최대힙의 top값 비교후 sawp결정
				if(!minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
					//swap 해주기
					int tmp1 = maxHeap.poll();
					int tmp2 = minHeap.poll();
					minHeap.offer(tmp1);
					maxHeap.offer(tmp2);
				}
				if(!minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
					//swap 해주기
					int tmp1 = maxHeap.poll();
					int tmp2 = minHeap.poll();
					minHeap.offer(tmp1);
					maxHeap.offer(tmp2);
				}
				//최대힙에 있는 top value가 항상 중간 값임
				sb.append(maxHeap.peek()+"\n");
			}else {
				//최대힙과 최소힙의 사이즈가 다르다는 것은 최소힙의 원소가 1 더 적다
				//사이즈가 같을 경우엔 항상 최대힙에 넣었기 떄문
				minHeap.offer(value);
				//swap 여부 판단
				if(maxHeap.peek() > minHeap.peek()) {
					//swap 해주기
					int tmp1 = maxHeap.poll();
					int tmp2 = minHeap.poll();
					minHeap.offer(tmp1);
					maxHeap.offer(tmp2);
				}
				sb.append(maxHeap.peek()+"\n");
			}
			
		}
		System.out.println(sb.toString());
		
	}
}
