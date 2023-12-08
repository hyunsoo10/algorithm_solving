package SFT_징검다리;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int N = Integer.parseInt(br.readLine());
      int[] arr = new int[N];
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      
      for(int i=0; i<N; i++){
        arr[i] = Integer.parseInt(st.nextToken());
      }

      int[] dp = new int[N+1];
      //dp[0] = 1부터 시작
      //idx=1부터 시작
      int idx=0;
      //i: arr배열의 인덱스, idx: dp배열의 인덱스
      for(int i=0; i<N; i++){
        //다음 돌을 밟을 수 있는 경우엔 dp배열의 다음 idx에 해당 정보 바로 추가
        if(arr[i] > dp[idx]) dp[++idx] = arr[i];  
        else {
        	int left = 1;
        	int right = idx;
        	while(left < right){
        		int mid = (left+right)/2;
        		if(dp[mid] < arr[i]) {
        			left = mid+1;
        		}
        		else{
        			right = mid;
        		}
        	}// 이분탐색 종료
        	dp[right] = arr[i];
        }// end else
      }// end for

      System.out.println(idx);
    } //end main
}