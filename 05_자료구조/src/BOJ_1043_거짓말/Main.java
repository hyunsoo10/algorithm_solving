package BOJ_1043_거짓말;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); //N: 사람의 수
		int M = sc.nextInt(); //M: 파티의 수
		
		int K = sc.nextInt(); //K: 진실을 아는 사람의 수
		List<Integer> truth = new ArrayList<>();
		for(int i=0; i<K; i++) truth.add(sc.nextInt());
		
		int ans = 0; //정답
		//진실을 아는 사람이 없으면 정답은 곧 M
		if(K==0) {
			ans = M;
		}else {
			//진실을 아는 사람이 없는 파티 개수 모두 구하기
			int cnt = 0;
			for(int i=0; i<M; i++) {
				
			}
			
		}
	}
}
