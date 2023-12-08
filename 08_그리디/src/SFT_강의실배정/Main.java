package SFT_강의실배정;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int N = Integer.parseInt(br.readLine());

      StringTokenizer st;
     
      PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
        public int compare(int[] o1, int[] o2){
          return o1[1] - o2[1];
        }
      });
      for(int i=0; i<N; i++){
        st = new StringTokenizer(br.readLine(), " ");
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        pq.offer(new int[] {start, end});
      }

      int end = 1;
      int cnt = 0;
      while(!pq.isEmpty()){
        int[] lecture = pq.poll();
        if(end <= lecture[0]){
          cnt++;
          end = lecture[1];
        }
      }
      System.out.println(cnt);
    }// end main
}
