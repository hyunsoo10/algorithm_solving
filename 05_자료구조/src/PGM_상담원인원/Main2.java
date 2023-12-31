package PGM_상담원인원;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

//시간초과 풀이
public class Main2 {
	public static void main(String[] args) {
		int[][] reqs = {{10, 60, 1}, {15, 100, 3}, {20, 30, 1}, {30, 50, 3}, {50, 40, 1}
		,{60, 30, 2}, {65, 30, 1}, {70, 100, 2}};
//		int[][] reqs = {{5, 55, 2}, {10, 90, 2}, {20, 40, 2}, {50, 45, 2}, {100, 50, 2}};
		int ans = solution(3, 5, reqs);
		
		System.out.println(ans);
	}
	
    static int m, min;
    static int[] sel, arr, consultant;
    static Map<Integer, List<int[]>> map;
    public static int solution(int k, int n, int[][] reqs) {
        int answer = 0;
        //상담 유형: k(1 ≤ k ≤ 5)
        //멘토의 수: n (k ≤ n ≤ 20)
        // reqs = [a, b, c] / a분에 b분동안 c유형의 상담
        
        map = new HashMap<>();
        for(int i=1; i<=k; i++){
            //상담 유형에 따라 큐에 집어넣기
            List<int[]> list = new ArrayList<>();
            map.put(i, list);
        }
        
        for(int i=0; i<reqs.length; i++){
            int type = reqs[i][2];
            map.get(type).add(reqs[i]);
        } 
        
        //n명을 k그룹에 분배
        //각 그룹에 최소 1명 --> n-k명을 k그룹으로 분배
        //즉, k개 중에 중복으로 n-k를 뽑으면 된다
        m = n-k;
        //전체 상담 유형 배열
        arr = new int[k];
        for(int i=0; i<k; i++) arr[i] = i+1;
        //분배해서 담을 배열
        sel = new int[m];
        
        min = Integer.MAX_VALUE;
   
        combination(0, 0);
        
        answer = min;
        return answer;
    }
    //idx : arr의인덱스, sidx: sel의 인덱스
    public static void combination(int idx, int sidx){
        if(sidx == m){
            //상담원 현황
            int k = arr.length;
            consultant = new int[k+1];
            for(int i=1; i<=k; i++) consultant[i]=1;
            for(int i=0; i<sel.length; i++){
                consultant[sel[i]]++;
            }
            // System.out.println(Arrays.toString(consultant));
            work(consultant, k);
            return;
        }
        for(int i=idx; i<arr.length; i++){
            sel[sidx] = arr[i];
            combination(idx, sidx+1);
        }
    }
    public static void work(int[] consultant, int k){
        // System.out.println(Arrays.toString(consultant)+ ", " + k);
        //i번째 유형 상담에서 기다리는 시간
        int time = 0; 
        for(int i=1; i<=k; i++){
            if(map.get(i).size()==0) continue;
            //대기 명단
            List<int[]> waiting = map.get(i);
            //상담중인 사람 정보담을 우선순위큐 
            PriorityQueue<int[]> ongoing = new PriorityQueue<>(new Comparator<int[]>(){
                
                //o1[1]기준 오름차순
                public int compare(int[] o1, int[] o2){
                    return o1[1] - o2[1];
                }
            });
            
            int curr = 0;
            int total = waiting.size();
            
            //초기 상담 가능 인원만큼 다 일단 집어 넣고 시작
            for(int j=0; j<consultant[i]; j++){
                if(j >= waiting.size()) break;
                int[] info = waiting.get(j);
                ongoing.add(new int[]{info[0], info[0]+info[1]});
                curr++;
            }
            while(!ongoing.isEmpty()){
                if(curr == total) break; 
                //끝난 사람
                int[] end = ongoing.poll();
                //시작할 사람
                int[] start = waiting.get(curr);
                if(end[1] > start[0]) {
                	time += (end[1] - start[0]);
                	ongoing.add(new int[]{end[1], end[1]+start[1]});
                }else ongoing.add(new int[]{start[0], start[0]+start[1]});
                
                curr++;
            }
          
        }// end for i
        min = Math.min(time, min);
    }
}
