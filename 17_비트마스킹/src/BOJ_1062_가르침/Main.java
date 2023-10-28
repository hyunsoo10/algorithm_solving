package BOJ_1062_가르침;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int [] arr = {1, 3, 4, 5, 6, 7, 9, 10, 11, 12, 14, 15, 16, 17, 18, 20, 21, 22, 23, 24, 25};
	static int [] sel, letter;
	static int pick, max, fixed;
	public static void main(String[] args) throws IOException {

		
		//남극 언어의 모든 단어는 anta, tica로 끝난다
		//a, c, i, n, t는 기본적으로 무조건 가르쳐야 한다
		//ASCII 코드로 숫자 변환하면 0, 2, 8, 13, 19에 해당
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		//고정 문자의 위치의 비트에 1을 마스킹해서 채워둔
		fixed = (1<<0) + (1<<2) + (1<<8) + (1<<13) + (1<<19);
		
		//arr 배열에서 K-5개를 뽑아서 가르쳐야 한다.
		pick = K-5;
		if(pick < 0) {
			//pick이 0보다 작으면 아무것도 못 읽으니까 0
			System.out.println(0);
		}
		else {
			letter  = new int[N]; //다 읽었을 때의 비트 마스킹한 숫자를 각각 담는다.
			
			
			for(int i=0; i<N; i++) {
				String str = br.readLine();
				int tmp = fixed;
				//첫 4글자와 끝 4글자는 고정이기 때문에 가운데 글자만 체크해도 무방하다.
				for(int j=4; j<str.length()-4; j++) {
					tmp = tmp | (1<<str.charAt(j)-97);
				}
				letter[i] = tmp;
			}
			
			//pick이 0이면 해당 비트가 fixed비트와 같은 것들은 읽을 수 있다
			if(pick == 0) {
				int cnt = 0;
				for(int a : letter) {
					if(a == fixed) cnt++;
				}
				System.out.println(cnt);
				
			}else {
				//pick이 1이상일 경우는 조합으로 구해서 계산한다.
				//조합으로 몇개를 읽을 수 있는지 구하고 최대값 갱신
				max = Integer.MIN_VALUE;
				sel = new int[pick];
				combi(0, 0);
				System.out.println(max);
			}
		}
	}
	static void combi(int idx, int sidx) {
		//다 뽑았으면
		if(sidx == pick) {
			int tmpFixed = fixed;
			for(int s : sel) {
				tmpFixed = tmpFixed | (1<<s);
			}
			int cnt = 0;
			for(int i=0; i<letter.length; i++) {
				if((letter[i] & tmpFixed) == letter[i]) cnt++;
			}
			max = Math.max(cnt, max);
			return;
		}
		for(int i=idx; i<21; i++) {
			sel[sidx] = arr[i];
			combi(i+1, sidx+1);
		}
	}
}
