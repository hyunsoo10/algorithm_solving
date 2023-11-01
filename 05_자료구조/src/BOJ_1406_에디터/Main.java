package BOJ_1406_에디터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static class Node{
		char data; //본인이 담고 있는 데이터
		Node next; //다음 노드

		public Node() {
		}
		
		public Node(char data) {
			this.data = data;
		}
		
	}
	//단순 연결 리스트 만들기
	static class SinglyLinkedList{
		Node head;
		Node tail;
//		Node[] nodeArr;
		int size;

		public SinglyLinkedList() {
			head = null;
//			nodeArr = new Node[600000];
		}
		
		//조회
		public Node get(int idx) {
			if(idx<0 || idx >= size)return null;
			Node curr = head;
			for(int i=0; i<idx; i++) {
				curr = curr.next;
			}
			return curr;
		}
		//첫번째 위치에 삽입
		public void addFirst(char data) {
			//노드 생성
			Node node = new Node(data);
			
			//head가 null이면
			if(head==null) {
				//head를 가리키고 head에 node대입
				node.next = head;
				head = node;
				tail = node;
			}else {
				node.next = head;
				head = node;
			}
			size++;//사이즈 증가
		}
		
		//마지막 위치에 삽입
		public void addLast(char data) {
			if(size == 0) {
				addFirst(data);
				return;
			}
			
			Node node = new Node(data);
			//tail의 next가 node를 가리키게하고. 그 node가 tail이 된다.
			tail.next = node;
			tail = node;
			size++;
		}
		
		public void insert(int idx, char data) {
			//idx가 0이면 addFirst연산
			if(idx == 0) {
				addFirst(data);
				return;
			} 
			//idx가 size이면 addLast연산
			if(idx == size) {
				addLast(data);
				return;
			}
			Node pre = get(idx-1);
			Node node = new Node(data);
			node.next = pre.next;
			pre.next = node;
			size++;
		}
		public void delete(int idx) {
			if(idx == 0) {
				if(head==null) return;
				head = head.next;
				size--;
				return;
			}
			if(idx == size-1) {
				tail = get(idx-1);
			}
			//삭제할 위치 이전의 노드 가져오기
			Node pre = get(idx-1);
			//삭제할 위치의 노드
			Node curr = get(idx);
			//삭제할 이전 위치의 노드가 삭제할 위치의 다음 노드를 가리키면 된다.
			pre.next = curr.next;
			size--;
			return;
		}
		public String printList() {
			StringBuilder sb = new StringBuilder();
			Node curr = head;
			while(curr != null) {
				sb.append(curr.data);
				curr = curr.next;
			}
			return sb.toString();
		}

		
	}
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		SinglyLinkedList list = new SinglyLinkedList();
		String input = br.readLine();
		
		for(int i=0; i < input.length(); i++) {
			list.addLast(input.charAt(i));
		}
		int idx = input.length();
		
		int M = Integer.parseInt(br.readLine());
		for(int i=0; i<M; i++) {
			StringTokenizer st  = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			if(command.equals("P")) {
				list.insert(idx, st.nextToken().charAt(0));
				idx++;
			}
			//왼쪽으로 커서 옮김(맨 앞이면 무시
			else if(command.equals("L")) {
				if(idx>0) idx--;
			}
			else if(command.equals("B")) {
				if(idx>0) {
					list.delete(idx-1);
					idx--;
				}
			}else {
				//오른쪽으로 커서 옮김
				if(idx<list.size) idx++;
			}
		}
		System.out.println(list.printList());
//		list.printList();
//		System.out.println(idx);
//		System.out.println(list.head.data);
//		System.out.println(list.tail.data);
	}
}
