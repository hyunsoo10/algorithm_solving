package 트라이;

import java.util.HashMap;
import java.util.Map;

//트라이 노드
class TrieNode{
	//key : 문자열, value : 자식 노드들을 담고 있는 TrieNode
	Map<Character, TrieNode> childNodes = new HashMap<>();
	
	//본인이 마지막 문자열인지 여부를 나타내는 변수
	boolean isLast;
}

//트라이 자료구조
class Trie {
	//Trie자료구조를 생성할 떄 rootNode를 기본적으로 생성
	TrieNode rootNode  = new TrieNode();
	
	//트라이 자료구조에 문자열 삽입
	void insert(String word) {
		//트라이 자료구조는 항상 rootNode부터 시작한다.
		TrieNode node = this.rootNode;
		
		//문자열을 삽입할 때마다 자식 노드 중에 있는지 체크한다
		//만약에 없으면 자식노드를 새로 생성한다.
		for(int i=0; i<word.length(); i++) {
			node = node.childNodes.computeIfAbsent(word.charAt(i), key -> new TrieNode());
		}
		//저장할 문자열의 마지막 단어에 단어의 끝임을 표시
		node.isLast = true;
	}
	//해당 word가 트라이 자료구조에 존재 여부를 반환해주는 메서드
	boolean search(String word) {
		//트라이 자료구조는 항상 루트노드부터 시작한다.
		TrieNode node = this.rootNode;
		
		//문자열의 각 단어마다 노드가 존재하는지 체크한다.
		for(int i=0; i<word.length(); i++) {
			//문자열의 각 단어에 매핑되는 노드가 존재하면 가져오고 아니면 null
			node = node.childNodes.getOrDefault(word.charAt(i), null);
			if(node == null) {
				//노드가 null이라는 것은 현재 탐색중인 trie 자료구조 내부에 해당하는 문자열이 없음을 의미한다.
				return false; //그러므로 false를 리턴
			}
		}
		
		//문자열의 마지막 단어까지 매핑된 노드가 존재한다고해서 무조건 그 문자열이 존재하는 것은 아니다.
		//예를 들면 busy Trie자료구조에 저장되어 있다고 헀을 때, bus의 마지막 단어 s에 매핑된 노드는 존재하지만
		//Trie 자료구조에 저장된 것은 bus가 아니라 busy이다. 따라서 현재 노드가 단어의 끝이라면 true, 아니라면 false
		return node.isLast;
	}
}

public class Main {
	
	public static void main(String[] args) {
		Trie trie = new Trie();
		
		trie.insert("kakao");
		trie.insert("busy");
		trie.insert("card");
		trie.insert("cap");
		
		System.out.println(trie.search("kakao")); //true
		System.out.println(trie.search("bus")); //false
	}
}
