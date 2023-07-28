import java.util.Scanner;

public class BAEKJOON_2527 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String [] result = new String[4];
		for(int i = 0; i < 4; i++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int p1 = sc.nextInt();
			int q1 = sc.nextInt();

			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			int p2 = sc.nextInt();
			int q2 = sc.nextInt();
			
			result[i] = verify(x1, y1, p1, q1, x2, y2, p2, q2);
		}

	
		for(String s : result) {
			System.out.println(s);
		}

		sc.close();
	}
	
	public static String verify(int x1, int y1, int p1, int q1, int x2, int y2, int p2, int q2) {
		// (x1, y1) (p1, q1) / (x2, y2) (p2,q2)
		if (((x1 == p2) && (y1 == q2)) || ((x1 == p2) && (q1 == y2)) || ((p1 == x2) && (y1 == q2))
				|| ((p1 == x2) && (q1 == y2))) {
			return "c";
		} else if (((y1 == q2) || (q1 == y2)) && ((x2 < p1) && (p2 > x1))) {
			return "b";
		} else if (((p1 == x2) || (x1 == p2)) && ((y2 < q1) && (q2 > y1))) {
			return "b";
		} else if (((p1 < x2) || (x1 > p2)) || ((y1 > q2) || (y2 > q1))) {
			return "d";
		} else {
			return "a";
		}
	}
	
}
