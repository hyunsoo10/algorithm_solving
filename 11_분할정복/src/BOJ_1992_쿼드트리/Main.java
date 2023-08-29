package BOJ_1992_쿼드트리;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static String ans="";
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		char[][] map = new char[N][N];
		
		for(int i=0; i<N; i++)
			map[i] = sc.next().toCharArray();
		
		divide(map, N);
	
		System.out.println(ans);
	}
	
	//분할메소드
	static void divide (char[][] map, int N){
		List<Character> list0 = new ArrayList<>();
		List<Character> list1 = new ArrayList<>();
		//전체 탐색
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j]=='0')
					list0.add(map[i][j]);
				else
					list1.add(map[i][j]);
			}
		}
		//한 가지 수로만 이루어져 있으면 정복 메소드
		if(list0.size() == N*N) {
			ans += conquor('0');
			return;
		}
		else if(list1.size() == N*N) {
			ans += conquor('1');
			return;
		}
		else {
			int M = N/2;//N 절반 으로 나누기
			char[][] sub1 = new char[M][M];
			char[][] sub2 = new char[M][M];
			char[][] sub3 = new char[M][M];
			char[][] sub4 = new char[M][M];
			
			//sub map 채우기
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					//좌상단 채우기
					if(i<M && j<M)
						sub1[i][j] = map[i][j];
					//우상단 채우기
					if(i<M && j>=M)
						sub2[i][j-M] = map[i][j];
					//좌하단 채우기
					if(i>=M && j<M)
						sub3[i-M][j] = map[i][j];
					//우하단 채우기
					if(i>=M && j>=M)
						sub4[i-M][j-M] = map[i][j];
				}
			}//sub map나누기 끝

			//분할한 map 다시 분할 시도
			ans+="(";
			divide(sub1, M);
			divide(sub2, M);
			divide(sub3, M);
			divide(sub4, M);
			ans+=")";
		}
	
	}
	static String conquor(char ch) {
		if(ch == '0')
			return "0";
		else
			return "1";
	}
}
