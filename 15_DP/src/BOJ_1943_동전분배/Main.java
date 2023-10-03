package BOJ_1943_동전분배;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int tc=1; tc<=3; tc++) {
			//정답 0으로 초기화
			int ans = 0;
			//동전의 종류
			int N = sc.nextInt();
			//동전으로 만들 수 있는 총 금액을 담을 변수
			int total = 0;
			//주어진 동전으로 만들 수 있는 금액 표시할 배열
			//half값만 만들면 되기 때문에 50000원 까지만 체크해도 무방
			boolean[] money = new boolean[500001];
			int[][] coins = new int[N][2];
			
			for(int i=0; i<N; i++) {
				int value = sc.nextInt();
				int count = sc.nextInt();
				total += value*count;
				coins[i][0] = value;
				coins[i][1] = count;	
			}
			//리스트에 첫 동전으로 만들 수 있는 경우다 넣어주기
			List<Integer> list = new ArrayList<>();
			for(int c=1; c<=coins[0][1]; c++) {
				int tmp = coins[0][0]*c;
//				System.out.println(tmp);
				list.add(tmp);
				money[tmp] = true;
			}		
			//두 번째 동전 값을 넣을 때, 이미 리스트에 있는 값들로 만들 수 있는 값 조합해가면서 넣기
out:		for(int i=1; i<N; i++) {
				for(int c=1; c<=coins[i][1]; c++) {
					int size = list.size();
					for(int x=0; x<size; x++) {
						//조합해서 넣어주기
						list.add(list.get(x) + coins[i][0]*c);
						money[list.get(x) + coins[i][0]*c] = true;
						if(money[total/2]) {
							ans = 1;
							break out;							
						}
					}
					list.add(coins[i][0]*c);
					money[coins[i][0]*c] = true;
					if(money[total/2]) {
						ans = 1;
						break out;							
					}
				}
			}
			
			//주어진 정보만으로 정답 도출 가능할 경우 먼저 체크
			//애초에 절반으로 나눌 수 없는 경우는 정답 그대로0임
//			if(total%2==1) continue;
//			//절반금액이 이미 true로 체크되어 있으면 정답1로 도출 가능
//			else if(money[total/2]) ans = 1;
//			else {
//				//그 외의 경우는 만들 수 있는 코인 다 체크
//				for(int i=0; i<N; i++) {
//					for(int x=0; x<list.size(); x++) {
//						for(int j=1; j<=coins[i][1]; j++) {
//							int tmp = list.get(x) - coins[i][0]*j;
//							if(tmp>0) {
//								if(!money[tmp]) {
//									list.add(tmp);
//									money[tmp] = true;									
//								}
//							}
//					
//						}						
//					}
//				}//전체 코인
//				System.out.println(list.toString());
//				if(money[total/2]) ans = 1;
//			}

//			System.out.println(list.toString());
			if(money[total/2]) ans = 1;
//			for(int[]c : coins) System.out.println(Arrays.toString(c));
			System.out.println(ans);
			
		}//end testCase
	}
}
