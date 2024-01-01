package PGM_연속된부분수열의합;

import java.util.Arrays;

//시간초과 풀이
public class Main {
	public static void main(String[] args) {
		
		int[] sequence = {1, 2, 3, 4, 5};
		int k = 7;
		int[] ans = solution(sequence, k);
		System.out.println(Arrays.toString(ans));
	}
    public static int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        answer[0] = -1;
        int n = sequence.length;
        long[] sum = new long[n+1];
        
    
        //누적합 구하기
        sum[0] = sequence[0];
        for(int i=1; i<n; i++){
            sum[i] = sum[i-1] + sequence[i];
        }
        
        int left = 0; 
        int right = 0; 
        
        while(left<n && right<n && left <= right){

            long leftSum = 0;
            if(left != 0) leftSum = sum[left-1];
            long rightSum = sum[right];
            
            
       
            long midSum = rightSum - leftSum;
            
            // 1. k보다 큰 경우
            if(midSum > k) left++;
            //2. k보다 작은 경우
            else if(midSum < k ) right++;
            //3. k와같은 경우 
            else{
                if(answer[0]==-1){
                    answer[0] = left;
                    answer[1] = right; 
                }else{
                    if(answer[1] - answer[0] > right-left){
                        answer[0] = left;
                        answer[1] = right;
                    }
                }
                left++;
                right++;
            }
        }
        return answer;
    }
}
