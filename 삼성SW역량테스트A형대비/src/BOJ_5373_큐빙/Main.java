package BOJ_5373_큐빙;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	//0: U   1: D   2: R   3: L   4: F   5: B	
	static int[][] relataion= {
			{0, 0, 1, 1, 1, 1}, //윗면 회전에 영향을 받는면
			{0, 0, 1, 1, 1, 1}, //아랫면 회전에 영향을 받는면
			{1, 1, 0, 0, 1, 1}, //오른쪽면
			{1, 1, 0, 0, 1, 0}, //왼쪽면
			{1, 1, 1, 1, 0, 0}, //앞면
			{1, 1, 1, 1, 0, 0}  //뒷면
	};
	//초기 큐브
	//윗면: w 아랫면 : y
	//왼쪽 면 : g 오른쪽 면 : b
	//앞면 : r 뒷면 : o
	static String[][] cube;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();		
		
		//테스트 케이스
		int T = Integer.parseInt(br.readLine());


		for(int tc=1; tc<=T; tc++) {
			cube = new String[][]
				{
					{"www", "www", "www"},
					{"yyy", "yyy", "yyy"},
					{"bbb", "bbb", "bbb"},
					{"ggg", "ggg", "ggg"},
					{"rrr", "rrr", "rrr"},
					{"ooo", "ooo", "ooo"}
					
				};
			//큐브를 돌린 횟수
			int n = Integer.parseInt(br.readLine());
			
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int i=0; i<n; i++) {
				String str = st.nextToken();
				char side = str.charAt(0);
				char direction = str.charAt(1);
				
				int num = 0;
				int dir = 0;
				
				//회전하려고 하는 면의 정보 숫자로 바꾸기
				if(side=='U') num = 0;
				else if(side=='D') num=1;
				else if(side=='R') num=2;
				else if(side=='L') num=3;
				else if(side=='F') num=4;
				else num = 5;
				
				//회전하려는 방향 숫자로 바꾸기
				if(direction =='+') dir=1;
				else dir =-1;
				
				//회전 하는 면 색상 정보 업데이트하는 메서드
				rotateSelf(num, dir);
				
				//해당 면이 회전함으로써 영향을 받는 면 색상 정보 업데이트 하는 메서드
				rotateOthers(num, dir);
				
			}
			
			for(String line : cube[0]) {
				System.out.println(line);
			}
		}
		
	}
	//해당 면이 회전함으로써 영향 받는 면 색상 정보 변화
	private static void rotateOthers(int num, int dir) {
		
		//윗면 or 아랫면 회전
		if(num==0 || num==1) {
			//오른, 앞, 왼, 뒤  영향
			int row = 0;
			if(num == 1) row = 2;
			String tmp1 = cube[2][row]; //오른쪽 0행
			String tmp2 = cube[4][row];//앞쪽
			String tmp3 = cube[3][row]; //왼쪽
			String tmp4 = cube[5][row]; //뒤쪽
			//시계방향
			if((num==0 && dir==1) || (num==1 && dir==-1)) {
				cube[4][row] = tmp1; //오른쪽 -> 앞쪽
				cube[3][row] = tmp2; //앞쪽 -> 왼쪽
				cube[5][row] = tmp3; //왼쪽 -> 뒤쪽 
				cube[2][row] = tmp4; //뒤쪽 -> 오른쪽
			}else {
				cube[2][row] = tmp2; //오른쪽 <- 앞쪽
				cube[4][row] = tmp3; //앞쪽 <- 왼쪽
				cube[3][row] = tmp4; //왼쪽 <- 뒤쪽 
				cube[5][row] = tmp1; //뒤쪽 <- 오른쪽
				
			}
		}
		//오른쪽 or 왼쪽 회전
		else if(num==2 || num==3) {
			//위, 뒤, 아래, 앞 영향
			int col1 = 0;
			int col2 = 2;
			if(num == 3) {
				col1 = 2;			
				col2 = 0;
			} 
			String tmp1 = String.valueOf(cube[0][0].charAt(col2))+String.valueOf(cube[0][1].charAt(col2))+String.valueOf(cube[0][2].charAt(col2)); 
			String tmp2 = String.valueOf(cube[5][0].charAt(col1))+String.valueOf(cube[5][1].charAt(col1))+String.valueOf(cube[5][2].charAt(col1)); 
			String tmp3 = String.valueOf(cube[1][0].charAt(col2))+String.valueOf(cube[1][1].charAt(col2))+String.valueOf(cube[1][2].charAt(col2)); 
			String tmp4 = String.valueOf(cube[4][0].charAt(col2))+String.valueOf(cube[4][1].charAt(col2))+String.valueOf(cube[4][2].charAt(col2)); 

			StringBuilder sb1 = new StringBuilder(tmp1);
			StringBuilder sb2 = new StringBuilder(tmp2);
			StringBuilder sb3 = new StringBuilder(tmp3);
			StringBuilder sb4 = new StringBuilder(tmp4);
			//거꾸로 뽑은 문자열
			String tmp1R = sb1.reverse().toString();
			String tmp2R = sb2.reverse().toString();
			String tmp3R = sb3.reverse().toString();
			String tmp4R = sb4.reverse().toString();
			
			//시계방향
			if((num==2&&dir==1) || (num==3 && dir==-1)) {
				sideRotate(0, tmp4, num); //앞쪽 -> 위쪽
				sideRotate(4, tmp3, num); //아래쪽 -> 앞쪽
				sideRotate(1, tmp2R, num); //뒤쪽 -> 아래쪽
				sideRotate(5, tmp1R, num); //위쪽 -> 뒤쪽
			}else {
				//반시계 방향
				sideRotate(4, tmp1, num); //앞쪽 <- 위쪽
				sideRotate(1, tmp4, num); //아래쪽 <- 앞쪽
				sideRotate(5, tmp3R, num); //뒤쪽 <- 아래쪽
				sideRotate(0, tmp2R, num); //위쪽 <- 뒤쪽
			}
		}
		//앞쪽 or 뒤쪽 회전
		else {
			int row1 = 2;
			int row2 = 0;
			int colR = 0;
			int colL = 2;
			
			if(num == 5) {
				row1 = 0;
				row2 = 2;
				colR = 2;
				colL = 0;
				
			}
			//위, 오른쪽, 아래, 왼쪽
			String tmp1 = cube[0][row1]; 
			String tmp2 = String.valueOf(cube[2][0].charAt(colR))+String.valueOf(cube[2][1].charAt(colR))+String.valueOf(cube[2][2].charAt(colR)); 
			String tmp3 = cube[1][row2];
			String tmp4 = String.valueOf(cube[3][0].charAt(colL))+String.valueOf(cube[3][1].charAt(colL))+String.valueOf(cube[3][2].charAt(colL)); 
			
			StringBuilder sb1 = new StringBuilder(tmp1);
			StringBuilder sb2 = new StringBuilder(tmp2);
			StringBuilder sb3 = new StringBuilder(tmp3);
			StringBuilder sb4 = new StringBuilder(tmp4);
			//거꾸로 뽑은 문자열
			String tmp1R = sb1.reverse().toString();
			String tmp2R = sb2.reverse().toString(); 
			String tmp3R = sb3.reverse().toString();
			String tmp4R = sb4.reverse().toString();
			
			//시계방향
			if((num==4 && dir==1) || (num==5 && dir==-1)) {
				frontBackRotate(0, tmp4R, num); //왼쪽 -> 위쪽
				frontBackRotate(2, tmp1, num); //위쪽 -> 오른쪽
				frontBackRotate(1, tmp2R, num); //오른쪽 -> 아래쪽
				frontBackRotate(3, tmp3, num); //아래쪽 -> 왼쪽
			}else {
				//반시계 방향
				frontBackRotate(3, tmp1R, num); //왼쪽 <-위쪽
				frontBackRotate(2, tmp3R, num); //오른쪽 <- 아래쪽
				frontBackRotate(0, tmp2, num); //위쪽 <- 오른쪽
				frontBackRotate(1, tmp4, num); //아래쪽  <- 왼쪽
			}
		}
	}
	//앞 뒷면 회전 시킬 때 각 면 업데이트 메서드
	private static void frontBackRotate(int num, String str, int side) {
	
		//윗면
		int idx1 = 2;
		if(side == 5) idx1 = 0;
		if(num == 0) {
			cube[num][idx1] = str;
		}
		//아랫면
		int idx2 = 0;
		if(side == 5) idx2 = 2;
		if(num == 1) {
			cube[num][idx2] = str;
		}
		//오른면
		if(num == 2) {
			for(int i=0; i<3; i++) {
				char[] tmp = new char[3];
				//바꾸려는 면의 i번째 char array로 받아와서 str를 활용해 업데이트
				tmp = cube[num][i].toCharArray();
				tmp[idx2] = str.charAt(i);
				String newStr = "";
				for(int s=0; s<3; s++) newStr += tmp[s];
				cube[num][i] = newStr;
			} 
		}
		//왼쪽면
		if(num == 3) {
			for(int i=0; i<3; i++) {
				char[] tmp = new char[3];
				//바꾸려는 면의 i번째 char array로 받아와서 str를 활용해 업데이트
				tmp = cube[num][i].toCharArray();
				tmp[idx1] = str.charAt(i);
				String newStr = "";
				for(int s=0; s<3; s++) newStr += tmp[s];
				cube[num][i] = newStr;
			} 
		}
		
	}
	//사이드 회전 시킬 때 각 면 업데이트 메서드
	private static void sideRotate(int num, String str, int side) {
		for(int i=0; i<3; i++) {
			char[] tmp = new char[3];
			//바꾸려는 면의 i번째 char array로 받아와서 str를 활용해 업데이트
			tmp = cube[num][i].toCharArray();
			//오른쪽을 회전시키는 경우
			if(side == 2) {
				if(num == 5) tmp[0] = str.charAt(i);
				else tmp[2] = str.charAt(i);
			}
			//왼쪽을 회전시키는 경우
			else {
				if(num == 5) tmp[2] = str.charAt(i);
				else tmp[0] = str.charAt(i);
			}
			String newStr = "";
			for(int s=0; s<3; s++) newStr += tmp[s];
			cube[num][i] = newStr;
		}
	}
	
	//회전시키는 면 색상 정보 변화
	private static void rotateSelf(int num, int dir) {
		String[] curr = new String[3];
		//회전하려는 면의 색상 정보 깊은 복사
		for(int i=0; i<3; i++) {
			curr[i] = cube[num][i];
			
		}
		
		//시계방향 회전 일 때
		if(dir==1) {
			//행역 열 우선순위로 읽어서 행 우선순위로 정보 업데이트
			for(int j=0; j<=2; j++) {
				String tmp="";
				for(int i=2; i>=0; i--) {
					tmp += curr[i].charAt(j);
				}
				cube[num][j] = tmp;
			}
		}//시계 방향 끝
		//반 시계 방향 시작
		else {
			//행 열역 우선순위로 읽어서 행 우선순위로 정보 업데이트
			for(int j=2, idx=0; j>=0; j--) {
				String tmp="";
				for(int i=0; i<=2; i++) {
					tmp += curr[i].charAt(j);
				}
				cube[num][idx++] = tmp;
			}
		}//반 시계 방향 끝
	}
}
