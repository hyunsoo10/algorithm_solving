package BOJ_5639_이진검색트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	static class Node {
		int root; 
		Node left, right;

		public Node(int root) {
			this.root = root;
		}

		public Node(int root, Node left, Node right) {
			this.root = root;
			this.left = left;
			this.right = right;
		}
		
		void insert(int child) {
			if(this.root > child) {
				if(this.left == null) {
					this.left = new Node(child);
				}else this.left.insert(child);
			}else {
				if(this.right == null) {
					this.right = new Node(child);
				}else this.right.insert(child);
			}
		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Node root = new Node(Integer.parseInt(br.readLine()));
		String input;
		while (true) {
			input = br.readLine();
			if (input == null || input.equals(""))
				break;
			root.insert(Integer.parseInt(input));
		}
		
		postOrder(root);
	}

	private static void postOrder(Node node) {
		if(node == null) return;
		postOrder(node.left);
		postOrder(node.right);
		System.out.println(node.root);
	}

}
