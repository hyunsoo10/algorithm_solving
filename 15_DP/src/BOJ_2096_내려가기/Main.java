package BOJ_2096_내려가기;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//N줄의 계단  (1 ≤ N ≤ 100,000)
		int N = sc.nextInt();
		
		//각 줄에 담겨있는 점수 정보 담을 배열
		int[][] line = new int[N+1][3]; 
		
		for(int i=1; i<=N; i++) {
			for(int j=0; j<3; j++) line[i][j] = sc.nextInt();
		}//line 정보 입력 끝
		
		//각 칸의 dp 배열을 누적 시켜갈 것임
		//행의 의미하는 것은 N번 째 줄, 열이 의미하는 것은 각각 0번인덱스에 최대값, 1번 인덱스에 최소값 저장
		int dp0[][] = new int[N+1][2];
		int dp1[][] = new int[N+1][2];
		int dp2[][] = new int[N+1][2];

		//초기값 초기화
		dp0[1][0] = dp0[1][1] = line[1][0];
		dp1[1][0] = dp1[1][1] = line[1][1];
		dp2[1][0] = dp2[1][1] = line[1][2];
		
		//0번 인덱스에는 최대값 저장
		//1번 인덱스에는 최소값 저장
		for(int i=2; i<=N; i++) {
			//i번째 줄의 0번 위치의 최대, 최소 업데이트
			dp0[i][0] = Math.max(dp0[i-1][0], dp1[i-1][0]) + line[i][0];
			dp0[i][1] = Math.min(dp0[i-1][1], dp1[i-1][1]) + line[i][0];
			
			//i번째 줄의 1번위치의 최대, 최소 업데이트
			//1번 위치는 0,1,2번 위치 모두 확인 해야 함
			
			//배열에 값을 담아서 정렬후 인덱스를 활용해 각각 최소 최대 값을 찾아낸다
			int[] tmpMin = new int[3];
			int[] tmpMax = new int[3];
			
			tmpMax[0] = dp0[i-1][0];
			tmpMax[1] = dp1[i-1][0];
			tmpMax[2] = dp2[i-1][0];
			
			tmpMin[0] = dp0[i-1][1];
			tmpMin[1] = dp1[i-1][1];
			tmpMin[2] = dp2[i-1][1];
			
			//정렬
			Arrays.sort(tmpMin); 
			Arrays.sort(tmpMax); 
			
			//max배열의 2번인덱스가 최댁값
			//min배열의 0번 인덱스가 최소값
			dp1[i][0] = tmpMax[2] + line[i][1];
			dp1[i][1] = tmpMin[0] + line[i][1];
			
			//i번째 줄의 2번위치의 최대, 최소 업데이트
			dp2[i][0] = Math.max(dp1[i-1][0], dp2[i-1][0]) + line[i][2];
			dp2[i][1] = Math.min(dp1[i-1][1], dp2[i-1][1]) + line[i][2];
		}
		
		//최대값 찾기
		int max = Math.max(dp0[N][0], dp1[N][0]);
		max = Math.max(max, dp2[N][0]);
	
		
		//최소값 찾기
		int min = Math.min(dp0[N][1], dp1[N][1]);
		min = Math.min(min, dp2[N][1]);
		
		System.out.printf("%d %d", max, min);
		
	}
}
