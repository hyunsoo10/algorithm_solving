import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BAEKJOON_3052 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < 10; i++) {
			int N = sc.nextInt();
			map.put(N % 42, 1);
		}
		System.out.println(map.keySet().size());
	}
}
