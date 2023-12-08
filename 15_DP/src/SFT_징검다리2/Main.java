package SFT_징검다리2;
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

      //증가하는 LIS
      int[] LIS = new int[N+1];
      int[] dp1 = new int[N];
      int idx1 = 0;
      //i: arr배열의 인덱스, idx: dp배열의 인덱스
      for(int i=0; i<N; i++){
        //LIS
        //다음 돌을 밟을 수 있는 경우엔 dp배열의 다음 idx에 해당 정보 바로 추가
        if(arr[i] > LIS[idx1]) LIS[++idx1] = arr[i];  
        else {
        	int left = 1;
        	int right = idx1;
        	while(left < right){
        		int mid = (left+right)/2;
        		if(LIS[mid] < arr[i]) {
        			left = mid+1;
        		}
        		else{
        			right = mid;
        		}
        	}// 이분탐색 종료
        	LIS[right] = arr[i];
        }// end else

        dp1[i] = idx1;
      }// end for
      //감소하는 LDS
      int[] LDS = new int[N+1];
      int[] dp2 = new int[N];
      int idx2 = N;
      int cnt = 0;
      for(int i=N-1; i>=0; i--) {
          //LDS
          if(arr[i] > LDS[idx2]) {
        	  LDS[--idx2] = arr[i];  
        	  cnt++;
          }
          else {
          	int left = idx2;
          	int right = N-1;
          	while(left < right){
          		int mid = (left+right)/2+1;
          		if(LDS[mid] > arr[i]) {
                    left = mid;
          		}
          		else{
                    right = mid-1;
          		}
          	}// 이분탐색 종료
          	LDS[right] = arr[i];
          }// end else
          dp2[i] = cnt;
      }// end for
      int ans = 0;
      for(int i=0; i<N; i++){
        ans = Math.max(ans, dp1[i] + dp2[i] - 1);
      }

      System.out.println(ans);
    } //end main
}