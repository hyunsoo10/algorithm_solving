package SWEA_5658_보물상자_비밀번호;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution2 {
	static List<String> result;
	static int N, M;
	static Deque<String>[] box;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt(); //테스트 케이스 
		for(int tc=1; tc<=T; tc++) {
			N = sc.nextInt(); //N: 비밀번호 개수
			M = N/4;
			int K = sc.nextInt(); //K번째 큰수
	
			//모든 비밀번호 조합 담을 리스트
			result = new ArrayList<>();
			
			//4방면의 번호를 deque에 담아서 관리한다.
			box = new Deque[4];
			String[] str = sc.next().split("");
			int idx=0;
			for(int i=0; i<4; i++) {
				//Deque 초기화
				box[i] = new LinkedList<String>();

				for(int j=0; j<M; j++) {
					box[i].add(str[idx++]);
				} 
			}
			
			for(int i=0; i<M; i++) {
				//보물상자 비밀 번호 담기
				for(int j=0; j<4; j++) {
					Deque<String>copy = copyDeque(box[j]);
					check(copy);
				}		
				change();
			}
			//16진수 기준으로 내림차순 정렬
			Collections.sort(result, (a, b) -> Integer.parseInt(b, 16) - Integer.parseInt(a,16));
			//K번째 큰수 10진수로 변환해서 정답에 대입
			int ans = Integer.parseInt(result.get(K-1), 16);
			System.out.printf("#%d %d\n", tc, ans);
			
		}
	}
	
	//비밀번호 숫자 넣기
	static void check(Deque<String> deque) {
		String tmp = "";
		while(!deque.isEmpty()) tmp += deque.poll();
		if(!result.contains(tmp)) result.add(tmp);
	}
	//비밀번호 돌리기
	static void change() {
		//맨 마지막 요소를 pop해서 맨 처음에 넣기
		box[0].addFirst(box[3].pollLast());
		for(int i=1; i<4; i++) {
			//이전 deque pop해서 다음 deque에 add하기
			box[i].addFirst(box[i-1].pollLast());
		}
	}
	//덱 깊은 복사
	static Deque<String> copyDeque(Deque<String> original){
		Deque<String> d =new LinkedList<String>();
		for(String a: original) {
			d.add(a);
		}
		return d;
	}
}
