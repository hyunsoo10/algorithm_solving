package BOJ_2805_나무자르기;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); //N: 나무의 수
		long M = sc.nextInt(); //M : 가져가야 하는 나무 길이
		
		Integer[] tree = new Integer[N];
		
		for(int i=0; i<N; i++) tree[i] = sc.nextInt();
		//내림차순 정렬
		Arrays.sort(tree, Collections.reverseOrder());
		
		//정답 담을 배열
		long ans = 0;
		long sum = 0;
		for(int i=0; i<N-1; i++) {
			//다음 나무의 최대 길이만큼 먼저 잘라보기
			sum = (tree[i]-tree[i+1]) * (i+1);
			if(sum >= M) {
				ans = (tree[i] - (long)Math.ceil((double)M/(i+1)));
				break;
			}else {
				M -= sum;
				if(i==N-2) {
					ans = (tree[i+1] -  (long)Math.ceil((double)M/(i+2)));
					break;					
				}
				
			}
		}
		
		System.out.println(ans);
	}
}
