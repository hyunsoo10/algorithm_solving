package BOJ_1701_Cubeditor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {
	static int ans = 0;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String text = br.readLine();
		
		for(int i=1; i<text.length(); i++) {
			String pattern = text.substring(0, text.length()-i);
			if (kmp(text, pattern, 0)) break;
		}

		System.out.println(ans);
	}

	// 실패함수 getPi()
	public static int[] getPi(String pt) {
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
		}

		return pi;
	}
	
	public static boolean kmp(String text, String pt, int cnt) {
		int[] pi = getPi(pt); //점프테이블 		
		int j = 0; //패턴 내에서 움직이는 인덱스
		int idx = 0;
		while(idx<text.length()) {
			//i:본문의 인덱스
			for(int i = idx ; i<text.length(); i++) {
				//실패하면 pi에서 구한 값만큼 점프
				while(j > 0 && text.charAt(i) != pt.charAt(j))
					j = pi[j-1];
				
				//내가 보고 있는 패턴위치와 텍스트의 값이 동일 하다면
				if(text.charAt(i) == pt.charAt(j)) {
					if(j == pt.length()-1) {
						cnt++;
						j=0;
						idx++;
						continue;
					}else {
						//다 찾은게 아니라면 계속 진행시켜
						j++;
					}
				}
			}
			j=0;
			idx++;
		}
		if(cnt >=2) {
			ans = pt.length();
			return true;
		}
		return false;
	}
}
