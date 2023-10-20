package BOJ_14725_개미굴;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

//트라이 자료구조
class Trie{
	Map<String, Trie> childNodes = new TreeMap<>();
	//루트 노드 생성
	
	public Trie() {
		
	}
	
	//단어들 삽입
	void insert(String[] wordList) {
		//루트 노드 지정
		Trie node = this;
		
		for(int i=0; i < wordList.length; i++) {
			node = node.childNodes.computeIfAbsent(wordList[i], key -> new Trie());
		}
	}
	
	public void print(Trie curr, int depth) {
		//현재 노드
		Trie node = curr;
		
		//현재 보고 있는 노드의 자식노드가 null이 아니라면
		if(node.childNodes != null) {
			List<String> list = new ArrayList<>(node.childNodes.keySet());
			for(String str : list) {
				//깊이만큼 -- 출력
				for(int i=0; i<depth; i++) {
					System.out.print("--");
				}
				System.out.println(str);
				print(node.childNodes.get(str), depth+1);
			}
		}
	}
}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		//먹이의 정보 개수 N (1 ≤ N ≤ 1000)
		int N = Integer.parseInt(br.readLine());
		//개미굴 정보를 담을 트라이 자료구조
		Trie trie = new Trie();
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			//개미 한마리가 보내준 먹이 정보 개수 K (1 ≤ K ≤ 15)
			int K = Integer.parseInt(st.nextToken());
			String[] words = new String[K];
			
			for(int j=0; j<K; j++) {
				words[j] = st.nextToken();
			}
			
			//트라이 자료구조에 넣어주기
			trie.insert(words);
			
		}

		trie.print(trie, 0);
		
	}
}
