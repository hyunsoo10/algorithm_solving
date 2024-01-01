package PGM_광물캐기;

public class Main {
	public static void main(String[] args) {
		
		int[] picks = {1, 3, 2};
		String[] minerals = {"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"};
		
		int ans = solution(picks, minerals);
		System.out.println(ans);
	}
	
    static int min = Integer.MAX_VALUE;
    static String[] mineralsArray;
    public static int solution(int[] picks, String[] minerals) {
        int answer = 0;
        
        //picks[dia, iron, stone] : 곡괭이 수 (0 ≤ dia, iron, stone ≤ 5)
        //minerals[...] : 광물 순서 배열 (5 ≤ minerals의 길이 ≤ 50)
        
        int totalWork = (picks[0] + picks[1] + picks[2]) * 5;
        int len = minerals.length;
        
        //총 뽑아야 하는 곡괭이 수
        int total = 0;
        
        if(totalWork <= len) total = totalWork/5;
        else total = total = (int) Math.ceil((double)len/5);
        
        int[] picked = new int[total];
        mineralsArray = minerals;
        dfs(0, picks, picked);
        
        answer = min;
        return answer;
    }
    // idx: 뽑은 횟수, picks : 곡괭이 배열,  picked: 뽑은 곡괭이 배열
    public static void dfs(int idx, int[] picks, int[] picked){
        if(idx == picked.length){
            // System.out.println(Arrays.toString(picked));
            // System.out.println(work(picked));
            min = Math.min(min, work(picked));
            return;
        }
        for(int i=0; i<picks.length; i++){
            //뽑을 곡괭이가 있으면
            if(picks[i] > 0){
                picks[i]--;
                picked[idx] = i;
                dfs(idx+1, picks, picked);
                picks[i]++; 
            }
        }
    }
    //주어진 곡괭이 배열로 피로도 계산
    public static int work(int[] picked){
        int idx = 0;
        int sum = 0; 
        for(int i=0; i<picked.length; i++){
            if(idx >= mineralsArray.length) break;
            int type = picked[i];
            int end = mineralsArray.length - idx;
            if(end >=5) end = 5;
            //다이아몬드 곡괭이 일 경우
            if(type == 0){
                for(int j=idx; j<idx+end; j++){
                    sum++;
                }
                idx+=5; 
            }
            else{
                for(int j=idx; j<idx+end; j++){
                    // 철 일 경우
                    if(type == 1){
                        if(mineralsArray[j].equals("diamond")) sum+=5;
                        else sum ++;
                    }
                    // 스톤일 경우
                    else{
                        if(mineralsArray[j].equals("diamond")) sum+=25;
                        else if(mineralsArray[j].equals("iron")) sum+=5;
                        else sum++;
                    }
                }
                idx+=5;
            }
        }
        return sum;
    }
}
