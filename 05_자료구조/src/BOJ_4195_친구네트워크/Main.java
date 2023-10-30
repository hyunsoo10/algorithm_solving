package BOJ_4195_친구네트워크;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static int[] p, count; // 대표를 저장할 배열
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int t=0; t<T; t++) {
			//친구 관계
			int F = Integer.parseInt(br.readLine());
			p = new int[200000];
			count = new int[2000000];
			for (int i = 0; i < 200000; i++) {
				p[i] = i;
				count[i] = 1;
			}
			//이름에 붙일 번호
			int no=0;
			Map<String, Integer> map = new HashMap<>();
			for(int i=0; i<F; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				String p1 = st.nextToken();
				String p2 = st.nextToken();
				
				if(!map.containsKey(p1)) map.put(p1, no++);
				if(!map.containsKey(p2)) map.put(p2, no++);
				
				//대표자 찾고
				int px = findset(map.get(p1));
				int py = findset(map.get(p2));
				//둘이 다른 집합이라면 유니온
				if(px != py) {
					union(px, py);
				}
				System.out.println(count[px]);
			}
		}
	}
	static void union(int x, int y) {
//		p[findset(y)] = findset(x); // x의 대표를 y의 대표로 넣겠다. rank고려x
		p[y] = x;
		count[x] += count[y];
	}

	static int findset(int x) {
		// 효율성 따지지 않은 순수 그잡채 기술
//		if(x == p[x]) return x;
//		return findset(p[x]);

		// 패쓰 컴푸레숀~~~
		if (x != p[x])
			p[x] = findset(p[x]);
		return p[x];
	}
}
