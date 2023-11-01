package BOJ_1406_에디터;

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
		Node[] nodeArr;
		int size;

		public SinglyLinkedList() {
			head = null;
			nodeArr = new Node[600000];
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
			//head를 가리키고 head에 node대입
			node.next = head;
			head = node;
			size++;//사이즈 증가
		}
		
		//마지막 위치에 삽입
		public void addLast(char data) {
			if(size == 0) {
				addFirst(data);
				return;
			}
			
			Node node = new Node(data);
			//마지막 노드 찾아가서  뒤에 삽입
			Node curr = head;
			while(curr.next != null) {
				curr = curr.next;
			}
			curr.next = node;
			size++;
			
		}

		
	}
	public static void main(String[] args) {
		
	}
}
