package PGM_두원사이의_정수쌍;

public class Main {
	public static void main(String[] args) {
		
		long ans = solution(2, 3);
		System.out.println("expected: 20, ans: " + ans);
	}
	
    public static long solution(int r1, int r2) {
        long answer = 0;
        
        // 시간 초과
        // //공간에 있는 점의 개수  구하기
        // long cnt1 = 0;
        // for(int x=1; x<=r2; x++){
        //     for(int y=1; y<=r2; y++){
        //         double distance = Math.sqrt((x*x) + (y*y));
        //         if( distance >= r1 && distance <= r2 ){
        //             cnt1++;
        //         }
        //     }
        // }                        
        // cnt1 *= 4;
        // //라인에 있는 점의 개수 구하기
        // long cnt2 = ((r2-r1)+1)*4;
        // answer = cnt1+cnt2;
        
        //y축에 있는 점의 개수
        long cnt1 = (long)(r2 - r1 + 1) * 4L;
        answer += cnt1;
        //원의 방정식 : x제곱 + y제곱 = r제곱
        //=> y제곱 = r제곱 - x제곱을 이용하면 된다
        long y1 = 0;
        long y2 = 0;
        for(int x = 1; x < r2; x++){
            //올림
            y1 = (long) Math.ceil(Math.sqrt((long)r1*r1 - (long)x*x));
            //버림
            y2 = (long) Math.floor(Math.sqrt((long)r2*r2 - (long)x*x));
            
            long tmp = y2-y1+1;
            //x축에 있는 점들은 빼주기
            if(y1==0 || y2 ==0) tmp--;
            //4사분면 곱해주기
            answer += tmp*4;
        }
        
        return answer;
    }
}
