package BOJ_10814_나이순정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//온라인 저지 회원의 수 N이 주어진다. (1 ≤ N ≤ 100,000)
		int N = Integer.parseInt(br.readLine());
		int idx = 0;
		String[] names = new String[N];
		//우선순위 큐 생성
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b)->{
			//나이가 같으면 가입 순서로
			if(a[0] == b[0])
				return a[1] - b[1];
			else
				return a[0] - b[0];
		});
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			
			names[i] = name;
			pq.offer(new int[] {age, i});
		}
		
		StringBuilder sb = new StringBuilder();
		while(!pq.isEmpty()) {
			int[] temp = pq.poll();
			
			sb.append(temp[0] + " " + names[temp[1]] + "\n");
		}
		
		System.out.println(sb);
		
		
		br.close();
	}
}
