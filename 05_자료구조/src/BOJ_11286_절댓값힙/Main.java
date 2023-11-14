package BOJ_11286_절댓값힙;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
			public int compare(int[] o1, int[] o2) {
				if( o1[0] - o2[0] > 0) return 1;
				else if( o1[0] - o2[0] < 0) return -1;
				return (o1[1] - o2[1] > 0) ? 1 : -1;
			}; 
		});
		
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			int x = Integer.parseInt(br.readLine());
			//꺼내는 작업
			if(x==0) {
				//비었으면 0
				if(pq.isEmpty()) sb.append("0\n");
				else {
					int[] tmp = pq.poll();
					if(tmp[1] == 1) sb.append(tmp[0]+"\n");
					else sb.append(-(tmp[0])+"\n");
				}
					
			}
			//pq에 넣는 작업
			else {
				if(x > 0) {
					//양수
					pq.add(new int[]{x, 1});
				}else {
					//음수
					pq.add(new int[]{-(x), 0});
					
				}
			}
		}
		System.out.println(sb.toString());
	}
}