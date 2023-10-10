package BOJ_1697_숨바꼭질;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N, K, min;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt(); //수빈이의 현재 점
		K = sc.nextInt(); //동생의 현재 점
		
		//걷는다면 X+1, X-1로 이동
		//순간이동하면 2*X의 위치로 이동
		min = Integer.MAX_VALUE;
		int[] visited = new int[100001];
		Queue<int[]> queue = new LinkedList<>();
		//수빈이의 위치와 depth 넣어주기
		queue.add(new int[] {N, 0});
		visited[N] = 1;
		
		while(!queue.isEmpty()) {
			int[] curr = queue.poll();
			int pos = curr[0];
			int depth = curr[1];
			
			//동생을 찾았으면 끝
			if(pos == K) {
				min = Math.min(min, depth);
			}
			if(depth < min) {
				if(pos-1 >=0 && pos-1<=100000&&visited[pos-1]==0) {
					queue.add(new int[]{pos-1, depth+1});
					visited[pos-1] = 1;
				}
				if(pos+1 >=0 && pos+1<=100000&&visited[pos+1]==0) {
					queue.add(new int[]{pos+1, depth+1});
					visited[pos+1] = 1;
				}
				if(pos*2 >=0 && pos*2<=100000&&visited[pos*2]==0) {
					queue.add(new int[]{pos*2, depth+1});
					visited[pos*2] = 1;
				}
			}
			
		}
		System.out.println(min);
		
	}

}
