package BOJ_15900_나무탈출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int count;
	static List<Integer>[] adjArr;
	static int[] isLeaf;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		//트리의 정점 개수 N(2 ≤ N ≤ 500,000)
		int N = Integer.parseInt(br.readLine());
		
		//배열에 담긴 정점의 값이 1이면 리프노드이다.
		isLeaf = new int[5000001];
		
		//인접리스트
		adjArr = new ArrayList[500001];
		
		//N-1개의 간선 정보
		for(int i=0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(adjArr[a] == null) adjArr[a] = new ArrayList<>();
			if(adjArr[b] == null) adjArr[b] = new ArrayList<>();
			//인접 체크
			adjArr[a].add(b);
			adjArr[b].add(a);
			
			//등장 횟수 cnt 증가 => 2이상이면 연결관계가 2개 이상 나왔으므로 리프노드가 아니다
			isLeaf[a]++;
			isLeaf[b]++;
		}
		
		count = 0;
		dfs(1, 0, 0);
		//count가 홀수면 Yes, 짝수면 No
		String ans = ((count | 1 ) == count )? "Yes" : "No";
		System.out.println(ans);
	}

	private static void dfs(int cur, int prev, int depth) {
		for(int i=0; i<adjArr[cur].size(); i++) {
			
			//리프노드라면 count에 depth 추가
			if(isLeaf[cur] == 1) count += depth;
			//부모 노드면 continue
			if(adjArr[cur].get(i).equals(prev)) continue;
			
			//부모 노드가 아니라면 dfs 호출
			dfs(adjArr[cur].get(i), cur, depth+1);
		}
	}
}
