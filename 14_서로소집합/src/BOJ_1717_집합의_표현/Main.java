package BOJ_1717_집합의_표현;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int[] p;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		p = new int[N+1];
		//make-set
		for(int i=0; i<N+1; i++) p[i]=i;
		
		for(int i=0; i<M; i++) {
			int command = sc.nextInt();
			int px = findSet(sc.nextInt());
			int py = findSet(sc.nextInt());
			
			if(command == 0) {
				//합치는 작업
				union(px, py);
				
			}else {
				//부모 찾는 작업
				//대표자가 같으면 YES
				if(px == py) System.out.println("YES");
				//대표자가 다르면 NO
				else System.out.println("NO");
			}
			
		}
	}
	
	//find
	static int findSet(int x) {
		if(p[x] != x) return p[x] = findSet(p[x]);
		return p[x];
	}
	//union
	static void union(int px, int py) {
		p[py] = px;
	}
}
