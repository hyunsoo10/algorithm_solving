package BOJ_22866_탑보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//완탐 시간초과
public class Main2 {
	static int N, L;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//1<=N<=100,000
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		int[] buildings = new int[N+1];
		for(int i=1; i<=N; i++) {
			buildings[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=1; i<=N; i++) {
			//좌, 우 탐색할 포인터 인덱스
			int right = i+1;
			int left = i-1;
			//볼 수 있는 가장 가까운 건물 인덱스 
			int first = 0;
			
			//타겟 빌딩 높이
			int targetForLeft = buildings[i];
			int targetForRight = buildings[i];
			//카운팅
			int count = 0;

			while(left>0 || right<=N) {
				if(left > 0 && buildings[left] > targetForLeft) {
					if(first == 0) first = left;
					targetForLeft = buildings[left];
					count++;
				}
				if(right <= N && buildings[right] > targetForRight) {
					if(first == 0) first = right;
					targetForRight = buildings[right];
					count++;
				}
				left--;
				right++;
			
			}//end while
			//볼 수 있는 건물의 개수 더해주고
			sb.append(count);
			if(count > 0) sb.append(" "+first);
			sb.append("\n");
		}//end for
		System.out.println(sb.toString());
	}//end main
}
