package PGM_과제진행하기;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		
		String[][] plans = {{"korean", "11:40", "30"}, {"english", "12:10", "20"}, {"math", "12:30", "40"}};
		String[] ans = solution(plans);
		System.out.println(Arrays.toString(ans));
	}
	
    public static String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        
        //시작 시간 기준 오름차순으로 담을 우선순위 큐
        PriorityQueue<String[]> pq = new PriorityQueue<>(new Comparator<String[]>(){
            public int compare(String[] o1, String[] o2){
                return Integer.parseInt(o1[1]) - Integer.parseInt(o2[1]);
            }
        });
        
        //시작 시간 기준으로 우선순위 큐에 plans 배열 정보 담기 
        for(int i=0; i<plans.length; i++){
            plans[i][1] = changeToMinute(plans[i][1]);
            pq.add(plans[i]);
        }
        
        //중단 작업 저장해둘 스택
        Stack<String[]> stack = new Stack<>();
        
        // 시작 시간 빠른 순으로 작업 시작
        String[] curr = pq.poll();
       
        String[] next = null;
        int idx = 0;
        while(!pq.isEmpty()){
            //다음 작업
            next = pq.poll();
            // System.out.println("curr: " + Arrays.toString(curr));
            // System.out.println("next: " +Arrays.toString(next));
            
            //1. 다음 작업 이전에 현재 진행 중인 작업이 끝난다면
            if(Integer.parseInt(curr[1]) + Integer.parseInt(curr[2]) < Integer.parseInt(next[1])){
                //진행 중인 작업 바로 끝낼 수 있음
                answer[idx++] = curr[0];
                //잠시 멈추었던 작업이 있다면
                if(!stack.isEmpty()){
                    //가장 최근에 멈춘 작업 꺼내서 이어 하기
                    String[] leftover = stack.pop();
                    
                    String startTime = String.valueOf(Integer.parseInt(curr[1]) + Integer.parseInt(curr[2]));
                
                    curr = new String[]{leftover[0], startTime, leftover[1]};
                    //다음 작업을 작업 큐에 다시 넣어두기
                    pq.add(next);
                }
                //멈추었던 작업이 없다면 바로 다음 작업 시작
                else curr = next;
            }
                        
            //2. 현재 작업이 끝나는 시간과 다음 작업 시간이 겹칠 경우
            else if(Integer.parseInt(curr[1]) + Integer.parseInt(curr[2]) == Integer.parseInt(next[1])){
                //진행 중인 작업 바로 끝낸다.
                answer[idx++] = curr[0];
                //다음 작업 시작
                curr = next;
            }
            //3. 현재 작업을 끝내지 못하고 다음 작업을 시작해야 하는 경우
            else{
                
                //해당 작업 + 잔여시간을 배열로 만들어서 stack에 저장
                stack.push(new String[]{curr[0], String.valueOf(Integer.parseInt(curr[1])+Integer.parseInt(curr[2]) - Integer.parseInt(next[1]))});
                // System.out.println("waiting : " + Arrays.toString(stack.peek()));
                curr = next;
            }
        }
        answer[idx++] = next[0];
        while(!stack.isEmpty()){
            answer[idx++] = stack.pop()[0];
        }
        return answer;
    }
    
    //시간을 분으로 변환
    public static String changeToMinute(String str){
        String[] arr = str.split(":");
        int tmp1 = Integer.parseInt(arr[0]) * 60;
        int tmp2 = Integer.parseInt(arr[1]);
        int result = tmp1+tmp2;
        return String.valueOf(result);
    }
}
