package BOJ_1068_트리;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static int N;
	static int[] parent, leaf;
	static boolean[] deleted;
	static List<Integer>[] adjArr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//노드의 개수 (1<=N<=50)
		N = sc.nextInt();
		parent = new int[N];
		
		//리프노드 인지 체크할배열
		leaf = new int[N];
		//삭제한 노드 체크 배열
		deleted = new boolean[N];
	
		//인접리스트 초기화
		adjArr = new ArrayList[N];
		for(int i=0; i<N; i++) adjArr[i] = new ArrayList<>();
		
		//0번 노드부터 N-1번 노드까지 부모 정보
		for(int i=0; i<N; i++) {
			int tmp = sc.nextInt();
			parent[i] = tmp;
			if(tmp==-1) continue;
			leaf[tmp]++; //자식 개수 leaf에 저장
			//연결관계 표시
			adjArr[i].add(tmp);
			adjArr[tmp].add(i);
		}
		
		//지울 노드
		int target = sc.nextInt();
		//dfs로 지우기
		dfs(target, parent[target]);
		
		int cnt = 0;
		for(int i=0; i<N; i++) {
			if(leaf[i]==0 && !deleted[i])cnt++;
		}
		System.out.println(cnt);
		
	}
	//dfs로 내려가면서 모두 지우기
	private static void dfs(int curr, int prev) {
		deleted[curr] = true; //본인 노드 삭제 처리
		if(parent[curr]!=-1)
			leaf[parent[curr]]--;//해당 노드의 부모 배열에서 자식 개수 감소
		for(int i=0; i<adjArr[curr].size(); i++) {
			if(adjArr[curr].get(i) == prev) continue;
			dfs(adjArr[curr].get(i), curr);
		}
		
	}
}
