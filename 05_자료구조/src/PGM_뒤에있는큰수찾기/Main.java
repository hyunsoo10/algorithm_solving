package PGM_뒤에있는큰수찾기;

import java.util.Arrays;
import java.util.PriorityQueue;

//시간초과 풀이
public class Main {
	public static void main(String[] args) {
		int[] ans = solution(new int[]{9, 1, 5, 3, 6, 2});
		System.out.println(Arrays.toString(ans));
	}
	  public static int[] solution(int[] numbers) {
	        int n = numbers.length;
	        int[] answer = new int[n];
	        //1번 인덱스 기준으로 오름차순
	        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);

	        for(int i=0; i<n; i++){

	            int currValue = numbers[i];

	            //currValue를 가장 가까운 최대값으로 갖는 인덱스들에 currValue 넣어주기
	            while(!pq.isEmpty() && pq.peek()[1] < currValue){
	                answer[pq.poll()[0]] = currValue;
	            }
	            //pq에 넣어주기
	            pq.add(new int[]{i, numbers[i]});
	        }

	        while(!pq.isEmpty()) answer[pq.poll()[0]]=-1;


	        return answer;
	    }
}
