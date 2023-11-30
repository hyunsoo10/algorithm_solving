package BOJ_14890_경사로;

import java.util.Scanner;

public class Main {
	static int N, L, cnt;
	static int[][] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//N*N 맵, L : 경사로의 길이
		N = sc.nextInt();
		L = sc.nextInt();
		
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) map[i][j] = sc.nextInt();
		}
		
		//행 우선 탐색 경사로 체크
		for(int i=0; i<N; i++) {
			if(check(map[i]))cnt++;
		}
		for(int j=0; j<N; j++) {
			//열 우선 탐색해서 임시로 담을 배열
			int[] tmp = new int[N];
			for(int i=0; i<N; i++)tmp[i] = map[i][j];
			
			if(check(tmp)) cnt++;
		}
		System.out.println(cnt);
	}
	//해당 길에 경사로가 설치 가능한지 체크하는 메서드
	private static boolean check(int[] arr) {
		
		//경사로 설치 공사한 위치 표시
		int idx = 0;
		int i = 0;
		while(i<N-1) {
			//높이가 같으면 경사로 놓을 필요 없음
			if(arr[i] == arr[i+1]) i++;
			//높이 차이가 1이라면 경사로를 설치 시도
			//올라가는 경사로
			else if(arr[i] == arr[i+1]-1) {
				//경사로를 놓을 공간이 확보가 된다면
				if(i - idx+1 >= L) {
					//경사로 설치 좌표 업데이트
					idx = i+1;
					i++;
				}else return false; //경사로를 설치 못하면 false 반환
			}
			//내려가는 경사로
			else if(arr[i] == arr[i+1]+1) {
				//인덱스 범위 체크 && 경사로 공간 체크
				if(i+L< N) {
					for(int j=0; j<L; j++) {
						//경사로를 놓을 공간에 높이가 다르다면
						if(arr[i+1] != arr[i+1+j]) return false;
					}
					idx = i+L+1;//idx업데이트
					i = i+L;
				} else return false; // 경사로 설치할 공간 자체가 없으므로 false
			}else return false;//높이 차이가 2 이상 나면 바로 false
		}
		//위에 for문에서 false 반환이 안된 경우라면 경사로 설치 가능한 것이므로 true반환
		return true;
	}
}
