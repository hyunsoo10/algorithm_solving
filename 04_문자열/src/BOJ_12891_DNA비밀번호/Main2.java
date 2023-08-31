package BOJ_12891_DNA비밀번호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		
		String str = br.readLine();
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		int[] arr = new int[4];//A,C,G,T 순서
		for(int i=0; i<4; i++) {
			arr[i] = Integer.parseInt(st2.nextToken());
		}
		
		int cnt=0;
		
		for(int i=0; i<=str.length()-P; i++) {
			int[] count = new int[5];
			for(int j=i; j<i+P; j++) {
				if(str.charAt(j) == 'A')count[0]++;
				else if(str.charAt(j) == 'C')count[1]++;
				else if(str.charAt(j) == 'G')count[2]++;
				else if(str.charAt(j) == 'T')count[3]++;
				else count[4]++;
			}
			//다른 문자열이 포함 되어 있지 않을 때만 DNA 문자열 검사 
			if(count[4]==0) {
				boolean flag = true;
				for(int k=0; k<4; k++) {
					if(count[k] < arr[k]) {
						flag = false;
						break;
					}
				}
				if(flag) cnt ++;
			}
			
		}
		System.out.println(cnt);
	}
}
