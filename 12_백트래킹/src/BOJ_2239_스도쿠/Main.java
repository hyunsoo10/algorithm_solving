package BOJ_2239_스도쿠;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static boolean[][] row = new boolean[9][10];
	static boolean[][] col = new boolean[9][10];
	static boolean[][] box = new boolean[9][10];
	static char[][] sudoku;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		sudoku = new char[9][9];
		
		for(int i=0; i<9; i++) sudoku[i] = sc.next().toCharArray();
		
		
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				if(sudoku[i][j] != '0') {
					row[i][sudoku[i][j]-'0'] = true;
					col[j][sudoku[i][j]-'0'] = true;
					box[3*(i/3) + j/3][sudoku[i][j]-'0'] = true;
				}
			}
		}
		play(0);
	}
	
	static void play(int idx) {
		//81까지 다 채웠으면 출력
		if(idx == 81) {
			for(int i=0; i<9; i++) {
				for(int j=0; j<9; j++) {
					System.out.print(sudoku[i][j]);
				}
				System.out.println();
			}
			System.exit(0);//맨 처음꺼 찾았으면 프로그램 종료
		}
		int r = idx/9;
		int c = idx%9;
		if(sudoku[r][c] != '0') play(idx+1);
		else {
			//1부터 10가지 대입해보기
			for(int x=1; x<10; x++) {
				if(!row[r][x] && !col[c][x] && !box[3*(r/3) + c/3][x]) {					
					//r행에 x숫자가 대입되었으므로 true
					row[r][x] = true;
					//c열에 x숫자가 대입되었으므로 true
					col[c][x] = true;
					//해당 박스에도 x숫자 true 찍어주기
					box[3*(r/3) + c/3][x] = true;
					sudoku[r][c] = (char) (x + '0');
					//다 찍었으면 다음 칸 play
					play(idx+1);
					//재귀 끝났으면 모든 정보 원상복귀
					row[r][x] = false;
					col[c][x] = false;
					box[3*(r/3) + c/3][x] = false;
					sudoku[r][c] = '0';
				}
			}
		}
	}
}
