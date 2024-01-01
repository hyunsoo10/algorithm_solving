package PGM_연속된부분수열의합;

import java.util.Arrays;

//시간초과 풀이
public class Main2 {
	public static void main(String[] args) {
		
		int[] sequence = {1, 2, 3, 4, 5};
		int k = 7;
		int[] ans = solution(sequence, k);
		System.out.println(Arrays.toString(ans));
	}
    public static int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        
        long[] sum = new long[sequence.length+1];
        
        boolean find = false;
        
        for(int i=0; i<sequence.length; i++){
            sum[i+1] = sum[i] + sequence[i];
            if(sequence[i] == k){
                answer[0] = i;
                answer[1] = i;
                find = true;
                break;
            }
        }
        
        int tmp = 2; 
        while(!find){
            for(int i=tmp; i<sum.length; i++){
                if(sum[i] - sum[i-tmp] == k){
                    answer[0] = i-tmp;
                    answer[1] = i-1;
                    find=true;
                    break;
                }
            }  
            tmp++;
        }
   
        return answer;
    }
}
