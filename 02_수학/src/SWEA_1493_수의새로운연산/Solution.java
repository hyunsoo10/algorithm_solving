package SWEA_1493_수의새로운연산;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int p = sc.nextInt();
			int q = sc.nextInt();
			
			int x1 = getX(p);
			int y1 = 1;
			int num1 = getNum(x1);
			while(p != num1 ) {
				x1--; //x좌표 줄이고
				y1++; //y좌표 늘리고
				num1--; //num 줄이고	
			}
			int x2 = getX(q);
			int y2 = 1;
			int num2 = getNum(x2);
			while(q != num2 ) {
				x2--; //x좌표 줄이고
				y2++; //y좌표 늘리고
				num2--; //num 줄이고	
			}
			//1차 연산 후 새롭게 얻은 x,y 좌표
			int newX = x1+x2;
			int newY = y1+y2;
			
			//두 좌표를 더한 후 1을 빼면 해당 숫자와 동일선상에 있는 값들의 최대 X좌표의 시작 숫자를 구할 수 있다.
			int startNum = getNum(newX+newY-1);
			int startX = newX+newY-1;
			int startY = 1;
			
			while(startX != newX || startY != newY) {
				startX--;
				startY++;
				startNum--;
			}
			System.out.printf("#%d %d\n",tc,startNum);
		}

	}
	//최대 x좌표를 리턴
	public static int getX(int num) {
		int x = 1; //최대 x좌표
		int n = 1; //최대 x좌표에 있는 숫자 값
		while(n <= num) {
			if(n == num)
				return x;
			n = n+x+1;
			x++;
		}
		return x;
	}
	//최대 숫자 리턴
	public static int getNum(int targetX) {
		int x = 1; //최대 x좌표
		int n = 1; //최대 x좌표에 있는 숫자 값
		while(x <= targetX ) {
			if(x == targetX)
				return n;
			n = n+x+1;
			x++;
		}
		return n;
	}
}
