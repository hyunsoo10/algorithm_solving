package PGM_아날로그시계;

public class Main {

	public static void main(String[] args) {
		
		int ans = solution(0, 5, 30, 0, 7, 0);
		System.out.println("expected = 2, ans = " +ans);
	}
    public static int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        
        int t1 = hmsToSec(h1, m1, s1); //00:00:00 ~ 시작 시간까지를 초로 변환
        int t2 = hmsToSec(h2, m2, s2); //00:00:00 ~ 종료 시간까지를 초로 변환
        
        //00:00:00 ~ 종료시간 까지 울린 알람 수
        int cnt2 = countAlarm(t2);
        //00:00:00 ~ 시작시간 까지 울린 알람 수
        int cnt1 = countAlarm(t1);
        //시작시간이 알람시간인경우에는 +1 해주기
        return countAlarm(t2) - countAlarm(t1) + (alarmNow(t1) ? 1 : 0);
    }

    private static int hmsToSec(int h, int m, int s) {
        m += h * 60;
        s += m * 60;
        return s;
    }

    private static int countAlarm(int time) {

        // 시침은 12시간(60*60*12 = 43200초)에 한바퀴를 돌며, 같은시간에 초침은 (60*12) 720바퀴를 돈다
        // 시침이 1바퀴 도는 동안 초침은 720바퀴를 돈다
        // 43200초 동안 시-초 알람은 719번 울린다(1바퀴 도는 그 정확한 지점에서는 다시 시작하는 것이므로 719번 울리는 것으로 간주)
        // -> 다시 말하면 시-초 알람은 43200/719 초마다 1회 울린다
        int hourAlarm = time * 719 / 43200;
        // 분침은 1시간(60*60 = 3600초)에 한바퀴, 같은시간에 초침은 60바퀴를 돈다
        // -> 분-초 알람은 3600초 동안 59번 울리며, 3600/59 초마다 1회 울린다
        int minAlarm = time * 59 / 3600;
        // 00시 및 12시 정각에는 시-초 / 분-초 알람이 동시에 울리기 때문에 중복을 제거
        // 12시간 이내라면 1회 중복, 12시간 이상이라면 2회 중복
        int penalty = 43200 <= time ? 2 : 1;

        return hourAlarm + minAlarm - penalty;
    }

    //시작 시간이 알람시간일 경우 true 리턴
    private static boolean alarmNow(int time) {
        return time * 719 % 43200 == 0 || time * 59 % 3600 == 0;
    }
    
    
    //하드 코딩 실패..
    public static int solution2(int h1, int m1, int s1, int h2, int m2, int s2) {
        int answer = -1;
        
        //전체 흘러야 하는시간을 초로 변환
        int totalSec = (h2-h1)*3600 + (m2-m1)*60 + s2-s1;
        
        //분침의 move per second
        double minMove = (double)1 / (double) 60;
        //시침의 move per second
        double hourMove = minMove * minMove;
        
        double hour1ToSec = 0;
        double min1ToSec = (double)m1 + minMove * s1;
      
        //시침은 0~24까지
        if(h1 > 12) h1 -= 12;
        if(h1 == 12) h1 = 0;
        hour1ToSec = h1*5;
        hour1ToSec += hourMove * (m1*60 + s1)*5;
    
        int cnt = 0;
        for(int s=0; s<totalSec; s++){
            
            //60이 되면 다시 0으로
            if(s1 == 60) s1 = 0;
            if(hour1ToSec == 60) hour1ToSec = 0;
            if(min1ToSec == 60) min1ToSec = 0;
            
     
            //s1이 59초일 경우
            if(s1 == 59) {
                // System.out.println(cnt);
                System.out.println(hour1ToSec);
                System.out.println(min1ToSec);
                if(hour1ToSec > 59 && min1ToSec > 59) cnt++;
                else{
                    //만약 시침이랑 분침이 59 ~ 0에 있으면 겹친다
                    if(hour1ToSec >= 59) cnt ++;
                    if(min1ToSec >= 59) cnt ++; 
                }
          
            }
            //그 외의 경우
            else{
                // if(s1 == 0 && hour1ToSec == 0 && min1ToSec == 0) cnt++;
                if(s1 == hour1ToSec && s1 == min1ToSec) cnt++;
                else{
                     if(hour1ToSec >= s1 && (hour1ToSec+hourMove) <= s1+1 ) cnt++;
                     if(min1ToSec >= s1 && (min1ToSec+minMove) <= s1+1 ) cnt++;  
                }
        
            }
            
            //1초뒤에 움직임  
            s1++;
            hour1ToSec += (double) hourMove;
            min1ToSec += (double) minMove;
            
        }
        
        answer = cnt;

        return answer;
    }
	
}
