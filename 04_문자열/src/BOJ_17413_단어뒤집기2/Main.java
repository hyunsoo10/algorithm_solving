package BOJ_17413_단어뒤집기2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Character> stack = new Stack<>();

        String line = br.readLine()+" ";
        int index = 0;
        StringBuilder inverseWord =new StringBuilder();
        while(index<line.length()){
            char alphabet = line.charAt(index);
            if(line.charAt(index)=='<'){
                if(stack.isEmpty()){
                    while(line.charAt(index)!='>'){
                        inverseWord.append(Character.toString(line.charAt(index++)));
                    }
                }
                else{
                    while(!stack.isEmpty()) {
                        inverseWord.append(Character.toString(stack.pop()));
                    }
                }
            }
            else if(line.charAt(index)=='>'){
                inverseWord.append(Character.toString(line.charAt(index++)));
            }
            else if(line.charAt(index)==' '){
                if(!stack.isEmpty()){
                    while(!stack.isEmpty()){
                        inverseWord.append(Character.toString(stack.pop()));
                    }
                    inverseWord.append(" ");
                }
                index++;
            }
            else{
                stack.push(line.charAt(index++));
            }
        }

        System.out.println(inverseWord);

    }
	
}
