/*
 * Class: CMSC204 
 * Instructor: Dr. Kuijt
 * Description: Class consists of methods that build and utilize the morse code tree.
 * Due: 4/9/23
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Kevin Ferry
*/

import java.util.ArrayList;

public class MorseCodeTree implements LinkedConverterTreeInterface<java.lang.String> {
	private TreeNode<java.lang.String> treeRoot;
	
	public MorseCodeTree() {
		buildTree();
	}
	
	public TreeNode<java.lang.String> getRoot() {
		return treeRoot;
	}
	
	public void setRoot(TreeNode<java.lang.String> newNode) {
		treeRoot = newNode;
	}
	
	public void insert(java.lang.String code, java.lang.String letter) {
		addNode(treeRoot, code, letter);
	}
	
	public void addNode(TreeNode<java.lang.String> root, java.lang.String code, java.lang.String letter) {
		if (code.length() == 1) {
			if (code.contentEquals(".")) {
				root.setLeftChild(new TreeNode<String>(letter));
				return;
			}
			if (code.contentEquals("-")) {
				root.setRightChild(new TreeNode<String>(letter));
				return;
			}
		}
	
		if (code.charAt(0) == '.') {
			addNode(root.getLeftChild(), code.substring(1), letter);
		}
		
		if (code.charAt(0) == '-') {
			addNode(root.getRightChild(), code.substring(1), letter);
		}
	}
	
	public java.lang.String fetch(java.lang.String code) {
		return fetchNode(treeRoot, code);
	}
	
	public java.lang.String fetchNode(TreeNode<java.lang.String> root, java.lang.String code) {
		if (code.length() == 1) {
			if (code.contentEquals(".")) {
				return root.getLeftChild().getData();
			}
			if (code.contentEquals("-")) {
				return root.getRightChild().getData();
			}
		}
		
		if (code.charAt(0) == '.') {
			return fetchNode(root.getLeftChild(), code.substring(1));
		}
		
		return fetchNode(root.getRightChild(), code.substring(1));
	}
	
	public MorseCodeTree delete(java.lang.String data) throws java.lang.UnsupportedOperationException {
		throw new java.lang.UnsupportedOperationException();
	}
	
	public MorseCodeTree update() throws java.lang.UnsupportedOperationException {
		throw new java.lang.UnsupportedOperationException();
	}
	
	public void buildTree() {
		treeRoot = new TreeNode<String>("");
		insert(".", "e");
		insert("-", "t");
		insert("..", "i");
		insert(".-", "a");
		insert("-.", "n");
		insert("--", "m");
		insert("...", "s");
		insert("..-", "u");
		insert(".-.", "r");
		insert(".--", "w");
		insert("-..", "d");
		insert("-.-", "k");
		insert("--.", "g");
		insert("---", "o");
		insert("....", "h");
		insert("...-", "v");
		insert("..-.", "f");
		insert(".-..", "l");
		insert(".--.", "p");
		insert(".---", "j");
		insert("-...", "b");
		insert("-..-", "x");
		insert("-.-.", "c");
		insert("-.--", "y");
		insert("--..", "z");
		insert("--.-", "q");
	}
	
	public java.util.ArrayList<java.lang.String> toArrayList() {
		ArrayList<String> arrayList = new ArrayList<String>();
		LNRoutputTraversal(treeRoot, arrayList);
		return arrayList;
	}
	
	public void LNRoutputTraversal(TreeNode<java.lang.String> root, java.util.ArrayList<java.lang.String> list) {
		if (root == null) {
			return;
		}
		
		LNRoutputTraversal(root.getLeftChild(), list);
		list.add(root.getData());
		LNRoutputTraversal(root.getRightChild(), list);
	}
}
