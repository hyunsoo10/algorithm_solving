package BOJ_14891_톱니바퀴;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static char[][] gear;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		gear = new char[5][8];
		
		for(int i=1; i<=4; i++) {
			gear[i] = sc.next().toCharArray();
		}
		//톱니바퀴 회전 수
		int K = sc.nextInt();
		for(int i=0; i<K; i++) {
			//회전 시킬 톱니바퀴 번호
			int num = sc.nextInt();
			//회전 시킬 방향
			int direction = sc.nextInt();
			//회전 시킬 톱니바퀴 번호 담을 배열
			int [][] check = new int[5][2];
			//0번 인덱스 -> 0: 회전x, 1: 회전o
			//1번 인덱스 -> 회전 시킬 방향
			//타겟 톱니바퀴 번호는 일단 회전 여부 체크
			check[num][0] = 1;
			check[num][1] = direction;
			
			//서로 맞물림 체크할 배열
			int[][] adjArr = new int[4][5];
			for(int x=1; x<4; x++) {
				if(gear[x][2] != gear[x+1][6]) {
					adjArr[x][x+1]=1;
				}
			}
			
			//1번 톱니바퀴를 회전 시킬 경우
			if(num == 1) {
				//2번 톱니바퀴 회전 체크 조건
				if(adjArr[1][2]==1) {
					check[2][0] = 1; //회전 여부 체크
					check[2][1] = -(direction);//방향 반대방향으로 저장
				}
				//3번 톱니바퀴 회전 체크 조건
				if(check[2][0]==1 && adjArr[2][3]==1) {
					check[3][0] = 1;
					check[3][1] = direction;
				}
				//4번 톱니바퀴
				if(check[3][0]==1 && adjArr[3][4]==1) {
					check[4][0] = 1;
					check[4][1] = -(direction);
					
				}
			}
			//4번 톱니바퀴를 회전 시킬 경우
			if(num == 4) {
				//3번 톱니바퀴 회전 체크 조건
				if(adjArr[3][4]==1) {
					check[3][0] = 1; //회전 여부 체크
					check[3][1] = -(direction);//방향 반대방향으로 저장
				}
				//2번 톱니바퀴 회전 체크 조건
				if(check[3][0]==1 && adjArr[2][3]==1) {
					check[2][0] = 1;
					check[2][1] = direction;
				}
				//1번 톱니바퀴
				if(check[2][0]==1 && adjArr[1][2]==1) {
					check[1][0] = 1;
					check[1][1] = -(direction);
					
				}
			}
			//2번 톱니바퀴를 회전 시킬 경우
			if(num == 2) {
				//1번 톱니바퀴 회전 체크 조건
				if(adjArr[1][2]==1) {
					check[1][0] = 1; //회전 여부 체크
					check[1][1] = -(direction);//방향 반대방향으로 저장
				}
				//3번 톱니바퀴 회전 체크 조건
				if(adjArr[2][3]==1) {
					check[3][0] = 1;
					check[3][1] = -(direction);
				}
				//4번 톱니바퀴
				if(check[3][0]==1 && adjArr[3][4]==1) {
					check[4][0] = 1;
					check[4][1] = direction;
					
				}
			}
			//3번 톱니바퀴를 회전 시킬 경우
			if(num == 3) {
				//2번 톱니바퀴 회전 체크 조건
				if(adjArr[2][3]==1) {
					check[2][0] = 1; //회전 여부 체크
					check[2][1] = -(direction);//방향 반대방향으로 저장
				}
				//4번 톱니바퀴 회전 체크 조건
				if(adjArr[3][4]==1) {
					check[4][0] = 1;
					check[4][1] = -(direction);
				}
				//1번 톱니바퀴
				if(check[2][0]==1 && adjArr[1][2]==1) {
					check[1][0] = 1;
					check[1][1] = direction;
					
				}
			}
			//체크 여부 확인 끝났으면 move 메서드 호출
			move(check);
		}
//		for(char[] g : gear) System.out.println(Arrays.toString(g));
		//스코어 계산
		int ans = 0;
		for(int i = 1; i<=4; i++) {
			if(gear[i][0] == '1') ans += Math.pow(2, i-1);
		}
		System.out.println(ans);
	}
	//톱니바퀴 전체 회전 결과 도출할 메서드
	static void move(int[][] check) {
		for(int i=1; i<=4; i++) {
			//회전해야되면 회전한다
			if(check[i][0]==1) {
				String tmp = rotate(gear[i], check[i][1]);
				gear[i] = tmp.toCharArray(); 
			}
		}
	}

	//개별 톱니바퀴 방향에 따라 회전한 결과
	static String rotate(char[] arr, int dir) {
		String text = "";
		//시계방향 회전
		if(dir == 1) {
			text += arr[7];
			for(int i=0; i<7; i++) text += arr[i];
		}else {
			//반시계 방향
			for(int i=1; i<8; i++)text += arr[i];
			text += arr[0];
		}
		return text;
	}
}
