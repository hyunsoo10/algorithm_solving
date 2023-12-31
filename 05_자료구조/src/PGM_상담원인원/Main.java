package PGM_상담원인원;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
//		int[][] reqs = {{10, 60, 1}, {15, 100, 3}, {20, 30, 1}, {30, 50, 3}, {50, 40, 1}
//		,{60, 30, 2}, {65, 30, 1}, {70, 100, 2}};
		int[][] reqs = {{5, 55, 2}, {10, 90, 2}, {20, 40, 2}, {50, 45, 2}, {100, 50, 2}};
		int ans = solution(2, 3, reqs);
		
		System.out.println(ans);
	}
	
    public static int solution(int k, int n, int[][] reqs) {
        int answer = 0;
        
        List<int[]>[] arr = new ArrayList[k+1];
        Queue<Integer>[] result = new LinkedList[k+1];
        
        for(int i=0; i<reqs.length; i++){
            int type = reqs[i][2];
            
            if(arr[type] == null) arr[type] = new ArrayList<int[]>();
            arr[type].add(new int[] {reqs[i][0], reqs[i][1]});
        }
        int m = n-k;
        // System.out.println(Arrays.toString(arr[2].get(0)));
        
        //상담 유형에 멘토 배정 작업
        for(int i=1; i<=k; i++){
            //i유형의 신청자가 없으면 continue
            if(arr[i] == null) continue;
            
            List<int[]> list = arr[i];

            result[i] = new LinkedList<Integer>();
            
            
            Stack<Integer> stack = new Stack<>();
            for(int j=1; j<=m+1; j++){
                
                //다음 차례에 들어갈 사람 가리키는 idx
                int idx = 0;
                //i유형의 멘토가 j명일 때 걸리는 시간
                int time = 0;
                //상담 진행중인 참가자 담을 우선순위큐
                PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
                    public int compare(int[]o1, int[]o2){
                        return o1[1] - o2[1];
                    }
                });
                
                //j명 만큼 pq에 넣고 시작
                for(int x=0; x<j; x++){
                    if(x>=list.size()) break;
                    pq.add(new int[]{list.get(x)[0], list.get(x)[0]+list.get(x)[1]});
                    idx++;
                }
                
               
                
                while(idx<list.size()){
                    //다음 사람
                    int[] start = list.get(idx);
                    //끝난 사람
                    int[] end = pq.poll();
                    
                    if(end[1] > start[0]){
                        time += end[1]-start[0];
                        pq.add(new int[]{end[1], end[1]+start[1]});
                    } else {
                        pq.add(new int[]{start[0], start[0]+start[1]});
                    }
                    idx++;
                }// end while
                if(stack.isEmpty())
                    result[i].add(time);
                else{
                    result[i].add(stack.peek() - time);
                }
                stack.push(time);
                // System.out.println("i: "+i+" / j : "+j +", time:" + time);
             
            }// end for j
  
        }//end for i

        //첫 소요 시간들 다 넣어주기
        for(int i=1; i<=k; i++){
            if(result[i]==null) continue;
            answer += result[i].poll();
        }
        
        while(m > 0){
            
            int number = 0;
            int amount = 0; 
            
            for(int i=1; i<=k; i++){
                if(result[i]==null) continue;
                if(result[i].peek() > amount){
                    number = i;
                    amount = result[i].peek();
                }
            }
            result[number].poll();
            answer -= amount;
            m--;
 
        }
        
        return answer;
    }
}
