/*
 * Class: CMSC204 
 * Instructor: Dr. Kuijt
 * Description: Node class for each letter node of the entire alphabet. Nodes in morse code tree use this class.
 * Due: 4/9/23
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Kevin Ferry
*/

public class TreeNode<T> {
	private T nodeData;
	private TreeNode<T> leftChild, rightChild;
	
	public TreeNode(T dataNode) {
		nodeData = dataNode;
		leftChild = null;
		rightChild = null;
	}
	
	public TreeNode(TreeNode<T> node) {
		nodeData = node.getData();
		//ToDo: finish this and figure out how to do deep copy or get the child nodes
	}
	
	public T getData() {
		return nodeData;
	}
	
	public TreeNode<T> getLeftChild() {
		return leftChild;
	}
	
	public TreeNode<T> getRightChild() {
		return rightChild;
	}
	
	public void setLeftChild(TreeNode<T> x) {
		leftChild = x;
	}
	
	public void setRightChild(TreeNode<T> x) {
		rightChild = x;
	}
}
