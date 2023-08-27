package BAEKJOON_23290_마법사_상어와_복제;

import java.util.Scanner;

public class Main {
	static int M, S;
	static int[] dr = {0, 0, -1, -1, -1, 0, 1, 1, 1};
	static int[] dc = {0, -1, -1, 0, 1, 1, 1, 0, -1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		M = sc.nextInt(); // M: 물고기의 수
		S = sc.nextInt(); // S: 상어가 마법을 연습한 횟수
		
		//물고기의 정보 입력
		for(int i=0; i<M; i++) {
			int fx = sc.nextInt(); //물고기 x좌표
			int fy = sc.nextInt(); //물고기 y좌표
			int dir = sc.nextInt(); //방향
		}
		
		//step1. 복제 마법 시전
		// 아래 5번에서 물고기가 복제되어 칸에 나타난다
		
		//step2. 모든 물고기가 한칸 이동 (
		//상어가 있는칸 or 물고기의 냄새가 있는 칸 or 격자의 범위를 벗어나는 칸은 이동 불가
		//이동 가능한 칸을 찾을 때 까지 반시계 방향으로 45도 회전, 이동할 수 있는 칸이 없으면 이동 X
		
		//step3. 상어가 연속해서 3칸 이동
		//격자의 범위를 벗어나면 불가능한 이동 방법
		//이동하는 경로에 물고기가 있는 칸으로 이동하면 그 물고기는 모두 제외하고 물고기 냄새를 남긴다.
		//가능한 이동방법 중에서 제외되는 물고기의 수가 가장 많은 방법을 이동
		//그러한 방법이 여러가지인 경우 사전 순으로 가장 앞선 방법을 이용
		
		//step4. 두번 전 연습에서 생긴 물고기의 냄새가 사라진다.
		
		//step5. 1에서 사용한 복제 마법이 완료된다.
		//모든 복제된 물고기는 1에서의 위치와 방향을 그대로 갖는다.
		
		
		
		int sx = sc.nextInt();//상어 x 좌표
		int sy = sc.nextInt();//상어 y 좌표
		
	}
}
