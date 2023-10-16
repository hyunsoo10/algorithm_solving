package BOJ_1701_Cubeditor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[] pi;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String text = br.readLine();
		
		int max = 0;
		for(int i=0; i<text.length(); i++) {
			pi = new int[5001];
			String pattern = text.substring(i, text.length());
			max = getPi(pattern, max);
		}
		System.out.println(max);
	}

	// 실패함수 getPi()
	public static int getPi(String pt, int max) {
		// 접두사와 접미사가 일치하는 최대길이를 담은 배열
		int[] pi = new int[pt.length()];

		int j = 0; // 현재 여기까지는 같다.
		// i, j가 가리키는 값이 같다면 둘다 증가
		// i는 무조건 증가
		for (int i = 1; i < pt.length(); i++) {
			// 두포인트가 다르다면
			while (j > 0 && pt.charAt(i) != pt.charAt(j)) {
				j = pi[j - 1];
			}

			// 두포인트가 같다면
			if (pt.charAt(i) == pt.charAt(j))
				pi[i] = ++j; // i번째의 최대길이는 ++j값을 저장하겠다.
			
			if(max < pi[i]) max = pi[i];
		}

		return max;
	}
	
}
