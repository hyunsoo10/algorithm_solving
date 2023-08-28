package BOJ_2018_수들의합5;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
	
		int count = 1;//자기 자신은 항상 나타낼 수 있으므로 1부터 시작
		int start = 1;
		int end = 1;
		int sum = 1;
		//end 포인터가 갈 수 있는 최대 값은 (N/2)+1
		while(end <= (N/2) + 1 && start!=(N/2)+1) {
			//구간합이 N이면 count증가
			if(sum == N) {
				count++;				
				end++;
				sum+=end;
			}
			//구간합이 N보다 클 경우에는
			//구간합에서 start포인터 값을 빼준 후에 start 포인터를 증가
			else if(sum > N) {
				sum -= start;
				start++;
			}
			//구간합이 N보다 작을 경우
			//end포인터를 증가시킨 후에 구간합에 end를 추가
			else {
				end++;
				sum+=end;
			}
		}
		System.out.println(count);
	}
}
