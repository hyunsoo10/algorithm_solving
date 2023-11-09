package BOJ_11812_K진트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static long N;
	static int K, Q;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		//필요한 변수 입력
		N = Long.parseLong(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());


		for(int i=0; i<Q; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			//거리 구해야할 두 노드  x, y 입력 받기
			long x = Long.parseLong(st.nextToken());
			long y = Long.parseLong(st.nextToken());

			
			//K가1일 때 예외 처리
			if(K==1) {
				System.out.println(Math.abs(x-y));
			}else {
				//나머지가 0이면 몫 이 부모 노드임
				List<Long> listX = new ArrayList<>();
				while(true) {
					if(x-1 == 0) break;
					long modX = (x-1) % K;
					x = (x-1) / K;
					if(modX != 0) x = x+1;
					listX.add(x);
				}
				List<Long> listY = new ArrayList<>();
				while(true) {
					if(y-1 == 0) break;
					long modY = (y-1) % K;
					y = (y-1) / K;
					if(modY != 0) y = y+1;
					listY.add(y);
				}
				int idx1 = listX.size()-1;
				int idx2 = listY.size()-1;
				int depth = -1;
				long p = 0;
				
				while(idx1>=0 && idx2>=0 && listX.get(idx1).equals(listY.get(idx2))) {
					depth++;
					idx1--;
					idx2--;
				}
				//공통조상의 깊이
				if(depth == -1) depth = 0;
				System.out.println((listX.size()+listY.size())-(depth*2));
			}

		}
		
	}
}
