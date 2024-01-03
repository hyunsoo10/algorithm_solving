package BOJ_5568_카드놓기;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
	static int n, k;
	static int[]arr, sel;
	static boolean[] visited;
	static HashSet<Integer> set;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//n 장의 카드
		n = sc.nextInt();
		
		//k장을 선택
		k = sc.nextInt();
		
		arr = new int[n];

		//카드 입력
		for(int i=0; i<n; i++) arr[i] = sc.nextInt();
		
		set = new HashSet<Integer>();
		visited = new boolean[n];
		sel = new int[k];
		perm(0);

		System.out.println(set.size());
		
		sc.close();
	}
	//순열
	public static void perm(int cnt) {
		
		//k개 뽑았으면
		if(cnt==k) {
//			String str1 = "";
			String str2 = "";
//			for(int i=0; i<n; i++) {
//				if(visited[i]) {
//					str1 += String.valueOf(arr[i]);
//				}
//			}
			for(int s : sel) {
				str2 += String.valueOf(s);
			}
//			System.out.println("str1 : " + str1);
//			System.out.println("str2 : " + str2);
			set.add(Integer.parseInt(str2));
			return;
		}
		
		for(int i=0; i<n; i++) {
			if(!visited[i]) {
				visited[i] = true;
				sel[cnt] = arr[i];
				perm(cnt+1);
				visited[i] = false;
			}
		}//end for 
	}
}
