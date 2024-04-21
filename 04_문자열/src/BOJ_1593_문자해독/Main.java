package BOJ_1593_문자해독;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int g = sc.nextInt();
		int s = sc.nextInt();
		int answer = 0;
		
		String str1 = sc.next();
		String str2 = sc.next();
		
		int[] arr1 = new int[52];
		int[] arr2 = new int[52];
	
		//str1배열 char 배열로 채우기
		for(char c : str1.toCharArray()){
			putChar(c, arr1, 1);
		}
		
		int start = 0;
		int len = 0;
		for(int i=0; i<str2.length(); i++) {
			//부분 문자열 시작부터 넣기
			char current = str2.charAt(i);
			putChar(current, arr2, 1);
			len++;
			
			//str1만큼 길이가 되면
			if(len == str1.length()) {
				//arr1 == arr2 면 answer ++
				if(Arrays.equals(arr1, arr2)) answer++;
				
				//오른쪽으로 한칸 슬라이딩
				//1. str2의 start char 빼주기
				putChar(str2.charAt(start), arr2, -1);
				//2. start 인덱스 1 증가
				start++;
				//3. len 1 감소
				len --;
			}
		}
		System.out.println(answer);
		sc.close();
	}
	
	static void putChar(char word, int[] arr, int num) {
		//소문자인 경우
		if('a' <= word && word <= 'z') {
			arr[word - 'a'+26]+=num;
		}
		else {
			arr[word - 'A']+=num;
		}
	}
}
