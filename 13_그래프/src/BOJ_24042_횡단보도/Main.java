package BOJ_24042_횡단보도;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node>{
	int end;
	long t;

	public Node(int end, long t) {
		this.end = end;
		this.t = t;
	}

	@Override
	public int compareTo(Node o) {
		return Long.compare(this.t, o.t);
	}

}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		// 지역의 수 2<= N <= 100,000
		int N = Integer.parseInt(st.nextToken());

		// 횡단보도의 주기 1<= M <= 700,000
		int M = Integer.parseInt(st.nextToken());

		ArrayList<Node>[] adjArr = new ArrayList[N + 1];

		// 초기화 작업
		for (int i = 0; i < N + 1; i++)
			adjArr[i] = new ArrayList<Node>();

		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			adjArr[A].add(new Node(B, m));
			adjArr[B].add(new Node(A, m));
		}

		PriorityQueue<Node> pq = new PriorityQueue(new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return Long.compare(o1.t, o2.t);
			}
		});
		
//		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		//초기 값 넣어주기
		pq.offer(new Node(1, 0));

		//dist 배열 세팅
		long [] dist = new long[N + 1];
		Arrays.fill(dist, Long.MAX_VALUE);
		dist[1] = 0;

		while (!pq.isEmpty()) {

			Node curr = pq.poll();
			
			
			//dist 배열의 값이 더 작은 경우 pass
			if (dist[curr.end] < curr.t) continue;
			
			for(Node next : adjArr[curr.end]){
				//바로 건널 수 있는 경우는 바로 건너기
				if(curr.t <= next.t) next.t++;
				else {
//					next.t = ((long) Math.ceil(((double)curr.t-next.t)/M)) * M + next.t + 1;
					long tmp = curr.t - next.t;
					long mod = tmp / M;
					if(tmp % M == 0) next.t = tmp + next.t + 1;
					else next.t = next.t + (mod+1)*M + 1;

				}
				if(next.t < dist[next.end]) {
					dist[next.end] = next.t;
					pq.offer(new Node(next.end, next.t));
				}
			}
		
		} // end while
		System.out.println(dist[N]);
	}
}
