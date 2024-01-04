package PGM_뒤에있는큰수찾기;

import java.util.Arrays;

//시간초과 풀이
public class Main2 {
	public static void main(String[] args) {
		int[] ans = solution(new int[]{9, 1, 5, 3, 6, 2});
		System.out.println(Arrays.toString(ans));
	}
    public static int[] solution(int[] numbers) {
        int n = numbers.length;
        int[] answer = new int[n];
        //멘 뒤는 무조건 -1
        answer[n-1] = -1;
        
        //가장 가까운값 저장할 변수
        int next = numbers[n-1];
        //지금 까지의 최대값 저장할 변수
        int max = numbers[n-1];
        int idx = n-1;
        for(int i=n-2; i>=0; i--){
            //가장 가까운 최대값 부터 비교
            if(numbers[i] < next)answer[i] = next;
            //최대값이 존재하는 경우
            else if(numbers[i] < max){
                for(int j=i+1; j<=idx; j++){
                    if(numbers[i] < numbers[j]){
                        answer[i] = numbers[j];
                        break;
                    }
                        
                }
            }
                
            //최대값 존재 안하는 경우
            else answer[i] = -1;

            if(numbers[i] >= max){
                max = numbers[i];
                idx = i;
            }
            
            next = numbers[i];
        }
        return answer;
    }
}
