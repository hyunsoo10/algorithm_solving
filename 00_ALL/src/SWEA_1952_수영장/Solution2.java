package SWEA_1952_수영장;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Solution2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = 1;
		
		for(int tc=1; tc<=T; tc++) {
			int day = sc.nextInt(); //1일 이용 요금
			int month = sc.nextInt(); //1개월 이용 요금
			int threeMonth = sc.nextInt();//3개월 이용 요금
			int year = sc.nextInt(); //1년 이용 요금
			
			//0번 인덱스 제외한 월 이용 요금 담을 배열
			int[] plan = new int[13];
			//이용할 월만 담은 리스트
			List<Integer> list = new ArrayList<>();
			for(int i=1; i<=12; i++) {
				plan[i] = sc.nextInt();
				if(plan[i]!=0)
					list.add(i);
			}
			
			int answer = 0;

			Map<Integer, Integer> cost = new HashMap<>();
			
			//step1. day요금 담기
			for(int i=0; i<list.size(); i++) {
				cost.put(list.get(i), plan[list.get(i)] * day);
			}
			//step2. month요금이 더 적으면 month요금 담기
			for(int i=0; i<list.size(); i++) {
				if(cost.get(list.get(i)) > month)
					cost.put(list.get(i), month);
			}
			//step1과 step2를 끝냈으면, 해당 월을 따로 계산 했을 때의 최저 금액을 일단 구했다.
			
			List<Integer> tmpList = new ArrayList<>();
			//step3. 3개월 요금을 고려하자
			for(int i=0; i<list.size(); i++) {
				int tmp=0;
				for(int j=0; j<list.size(); j++) {
					//만약 연속된 숫자가 아니라면 그 월의 최저요금을 더해주자.
					if(list.get(j)!=list.get(i)&&list.get(j)!=list.get(i)+1 && list.get(j)!=list.get(i)+2)
						tmp += cost.get(list.get(j));
				}
				tmp += threeMonth;
				tmpList.add(tmp);
			}
			
			System.out.println(Arrays.toString(plan));
			System.out.println(list.toString());
			System.out.println(cost.toString());
			System.out.println(tmpList.toString());
		}
	}
}

