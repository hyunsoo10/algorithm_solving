package SWEA_4014_활주로건설;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T =  sc.nextInt();
        for(int tc = 1; tc<=T; tc++) {
             
            int N = sc.nextInt(); //N*N맵
            int X = sc.nextInt(); //경사로 길이
             
            int[][] map = new int[N][N];
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    map[i][j] = sc.nextInt();
                }
            }//활주로 맵 정보 입력 끝
             
            int cnt = 0;
             
            //가로 탐색
            for(int i=0; i<N; i++) {
                boolean flag = true;//건설 가능 여부 체크 변수
                //첫번째 시작 높이 초기화
                int height = map[i][0];
                int idx=0;//스타트시점 인덱스 
                for(int j=1; j<N; j++) {
                     
                     
                    //높이 차이가 1보다 크면 건설 불가능
                    if(Math.abs(map[i][j]-height) > 1) {
                        flag = false;
                        break;
                    }
                     
                    //높이가 더 높아지는 경우
                    if(map[i][j] > height) {
                        //경사로 길이가 더 긴 경우 건설 불가능
                        if(j-idx < X) {
                            flag = false;
                            break;
                        }
                        //건설 성공시 높이랑 스타트시점 인덱스 최신화
                        height = map[i][j];
                        idx = j;
                    }
                    //높이가 더 낮아지는 경우
                    else if(map[i][j] < height) {
                        //낮아진 순간 그 높이와 같은 높이가 결사로의 길이 이상으로 유지되면 건설 가능
                        height = map[i][j];
                        int k = 1; //조회할 인덱스
                        int len=1;//길이는 1부터 시작
                        while(j+k < N && map[i][j+k]==height) {
                            len++;
                            k++;
                        }
                        //경사로의 길이보다 작으면 건설 불가능
                        if(len < X) {
                            flag = false;
                            break;
                        }
                        idx=j+X;
                        j=j+k-1;
                    }
                    //높이가 같으면 그냥 계속 가면 됌
                    else
                        continue;
                     
                }//한 행 탐색 끝
                if(flag)
                    cnt++;
            }
             
            //세로 탐색
            for(int j=0; j<N; j++) {
                boolean flag = true;//건설 가능 여부 체크 변수
                //첫번째 시작 높이 초기화
                int height = map[0][j];
                int idx=0;//스타트시점 인덱스 
                for(int i=1; i<N; i++) {
                     
                     
                    //높이 차이가 1보다 크면 건설 불가능
                    if(Math.abs(map[i][j]-height) > 1) {
                        flag = false;
                        break;
                    }
                     
                    //높이가 더 높아지는 경우
                    if(map[i][j] > height) {
                        //경사로 길이가 더 긴 경우 건설 불가능
                        if(i-idx < X) {
                            flag = false;
                            break;
                        }
                        //건설 성공시 높이랑 스타트시점 인덱스 최신화
                        height = map[i][j];
                        idx = i;
                    }
                    //높이가 더 낮아지는 경우
                    else if(map[i][j] < height) {
                        //낮아진 순간 그 높이와 같은 높이가 결사로의 길이 이상으로 유지되면 건설 가능
                        height = map[i][j];
                        int k = 1; //조회할 인덱스
                        int len=1;//길이는 1부터 시작
                        while(i+k < N && map[i+k][j]==height) {
                            len++;
                            k++;
                        }
                        //경사로의 길이보다 작으면 건설 불가능
                        if(len < X) {
                            flag = false;
                            break;
                        }
                        idx=i+X;
                        i=i+k-1;
                    }
                    //높이가 같으면 그냥 계속 가면 됌
                    else
                        continue;
                     
                }//한 행 탐색 끝
                if(flag)
                    cnt++;
            }
             
            System.out.printf("#%d %d\n",tc, cnt);
        }
    }
}