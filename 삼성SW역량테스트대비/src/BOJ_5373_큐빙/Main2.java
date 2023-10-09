//package BOJ_5373_큐빙;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.StringTokenizer;
//
//public class Main2 {
//	//0: U   1: D   2: R   3: L   4: F   5: B	
//	static int[][] relataion= {
//			{0, 0, 1, 1, 1, 1}, //윗면 회전에 영향을 받는면
//			{0, 0, 1, 1, 1, 1}, //아랫면 회전에 영향을 받는면
//			{1, 1, 0, 0, 1, 1}, //오른쪽면
//			{1, 1, 0, 0, 1, 0}, //왼쪽면
//			{1, 1, 1, 1, 0, 0}, //앞면
//			{1, 1, 1, 1, 0, 0}  //뒷면
//	};
//	//초기 큐브
//	//윗면: w 아랫면 : y
//	//왼쪽 면 : g 오른쪽 면 : b
//	//앞면 : r 뒷면 : o
//	static char[][][] cube= {
//			{
//				{'w', 'w', 'w'},
//				{'w', 'w', 'w'},
//				{'w', 'w', 'w'}
//			},
//			{
//				{'y', 'y', 'y'},
//				{'y', 'y', 'y'},
//				{'y', 'y', 'y'}				
//			},
//			{
//				{'b', 'b', 'b'},
//				{'b', 'b', 'b'},
//				{'b', 'b', 'b'}
//			},
//			{
//				{'g', 'g', 'g'},
//				{'g', 'g', 'g'},
//				{'g', 'g', 'g'}
//			},
//			{
//				{'r', 'r', 'r'},
//				{'r', 'r', 'r'},
//				{'r', 'r', 'r'}
//			},
//			{
//				{'o', 'o', 'o'},
//				{'o', 'o', 'o'},
//				{'o', 'o', 'o'}
//			}
//	};
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();		
//		
//		//테스트 케이스
//		int TC = Integer.parseInt(br.readLine());
//		
//		
//		//큐브를 돌린 횟수
//		int n = Integer.parseInt(br.readLine());
//
//		
//		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//		for(int i=0; i<n; i++) {
//			String str = st.nextToken();
//			char side = str.charAt(0);
//			char direction = str.charAt(1);
//			
//			int num = 0;
//			int dir = 0;
//			
//			//회전하려고 하는 면의 정보 숫자로 바꾸기
//			if(side=='U') num = 0;
//			else if(side=='D') num=1;
//			else if(side=='R') num=2;
//			else if(side=='L') num=3;
//			else if(side=='F') num=4;
//			else num = 5;
//			
//			//회전하려는 방향 숫자로 바꾸기
//			if(direction =='+') dir=1;
//			else dir =-1;
//			
//			//회전 하는 면 색상 정보 업데이트하는 메서드
//			rotateSelf(num, dir);
//			//해당 면이 회전함으로써 영향을 받는 면 색상 정보 업데이트 하는 메서드
//			rotateOthers(num, dir);
//			
//		}
//		
//	}
//	//해당 면이 회전함으로써 영향 받는 면 색상 정보 변화
//	private static void rotateOthers(int num, int dir) {
//		
//		//윗면 회전
//		if(num==1) {
//			String tmp1; //오른쪽
//			String tmp2; //앞쪽
//			String tmp3; //왼쪽
//			String tmp4; //뒤쪽
//			
//			cube[2][0]
//		}
//	}
//	
//	//회전시키는 면 색상 정보 변화
//	private static void rotateSelf(int num, int dir) {
//		char[][] curr = new char[3][3];
//		//회전하려는 면의 색상 정보 깊은 복사
//		for(int i=0; i<3; i++) {
//			for(int j=0; j<3; j++) {
//				curr[i][j] = cube[num][i][j];
//			}
//		}
//		
//		//시계방향 회전 일 때
//		if(dir==1) {
//			//행역 열 우선순위로 읽어서 행 우선순위로 정보 업데이트
//			for(int j=0; j<=2; j++) {
//				String tmp="";
//				for(int i=2; i>=0; i--) {
//					tmp += curr[i][j];
//				}
//				cube[num][j] = tmp.toCharArray();
//			}
//		}//시계 방향 끝
//		//반 시계 방향 시작
//		else {
//			//행 열역 우선순위로 읽어서 행 우선순위로 정보 업데이트
//			for(int j=2, idx=0; j>=0; j--) {
//				String tmp="";
//				for(int i=0; i<=2; i++) {
//					tmp += curr[i][j];
//				}
//				cube[num][idx++] = tmp.toCharArray();
//			}
//		}//반 시계 방향 끝
//	}
//}
