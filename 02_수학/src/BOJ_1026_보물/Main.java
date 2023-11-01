package BOJ_1026_보물;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] arr1 = new int[N];
		int[] arr2 = new int[N];
		
		for(int i=0; i<N; i++) arr1[i] = sc.nextInt();
		for(int i=0; i<N; i++) arr2[i] = sc.nextInt();
		
		PriorityQueue<Integer> minQ = new PriorityQueue<Integer>();
		PriorityQueue<Integer> maxQ = new PriorityQueue<Integer>(Collections.reverseOrder());
		for(int i=0; i<N; i++) minQ.add(arr1[i]);
		for(int i=0; i<N; i++) maxQ.add(arr2[i]);
		
		int sum = 0;
		for(int i=0; i<N; i++) {
			sum += minQ.poll() * maxQ.poll();
		}
		System.out.println(sum);
		
		
	}
}
