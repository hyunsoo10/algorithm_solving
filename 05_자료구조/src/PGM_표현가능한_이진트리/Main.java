package PGM_표현가능한_이진트리;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
	
		int[] ans = solution(new long[] {7, 42, 5});
		
		System.out.println(Arrays.toString(ans));
	}
	
    static char[] arr;
    static int ans;
    public static int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        
        int idx=0;
        for(long num : numbers){
        
            String str = Long.toBinaryString(num);    
            int k = 0;
            while(Math.pow(2, k)-1 < str.length()){
                k++;
            }
            while(str.length() != Math.pow(2, k)-1){
                str = "0" + str;
            }
            arr = new char[str.length()];
            for(int i=0; i<str.length(); i++){
                arr[i] = str.charAt(i);
            }
            ans = 1;
            dfs(0, str.length()-1, false);
            answer[idx++] = ans;
        }
    
        return answer;
    }
    public static void dfs(int left, int right, boolean isRootZero){
        if(ans == 0) return;
        
        int mid = (left+right)/2;
        //루트가 0인지 여부 체크
        if(arr[mid] == '0') isRootZero = true;
        //ans가 0인 경우 확인 후 return
        if(isRootZero && arr[mid]=='1'){
            ans = 0;
            return;
        }
        if(left!=right){
            //왼쪽 dfs
            dfs(left, mid-1, isRootZero);
            //오른쪽 dfs
            dfs(mid+1, right, isRootZero); 
        }

    }
}
