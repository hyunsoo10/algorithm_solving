package BOJ_3548_가장가까운공통조상;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int parent[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int t=0; t<T; t++) {
			//노드의 수
			int N = Integer.parseInt(br.readLine());
			//부모를 담을 배열
			parent = new int[N+1];
			for(int i=0; i<N-1; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				//b의 부모가 a임
				parent[b] = a;
			}
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			//x의 부모 담을 리스트
			List<Integer> listX = new ArrayList<>();
			listX.add(x);
			int sx = x;
			while(parent[sx] != 0) {
				int tmp1 = parent[sx];
				listX.add(tmp1);
				sx = tmp1;
			}
			
			//y의 부모 담으 리스트
			List<Integer> listY = new ArrayList<>();
			listY.add(y);
			int sy = y;
			while(parent[sy] != 0) {
				int tmp1 = parent[sy];
				listY.add(tmp1);
				sy = tmp1;
			}
			int idx1=listX.size()-1;
			int idx2=listY.size()-1;
			while(idx1>=0 && idx2>=0 && (int)listX.get(idx1) == (int)listY.get(idx2)) {
				idx1--;
				idx2--;
			}
			System.out.println(listX.get(idx1+1));
		}
	}
}
