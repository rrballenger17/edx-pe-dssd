
import java.lang.Math;

public class BinarySearchTree<E extends Comparable<E>> {
	class Node {
		E value;
		Node leftChild = null;
		Node rightChild = null;
		Node(E value) {
			this.value = value;
		}
		@Override
		public boolean equals(Object obj) {
			if ((obj instanceof BinarySearchTree.Node) == false)
				return false;
			@SuppressWarnings("unchecked")
			Node other = (BinarySearchTree<E>.Node)obj;
			return other.value.compareTo(value) == 0 &&
					other.leftChild == leftChild && other.rightChild == rightChild;
		}
	}
	
	protected Node root = null;
	
	protected void visit(Node n) {
		System.out.println(n.value);
	}
	
	public boolean contains(E val) {
		return contains(root, val);
	}
	
	protected boolean contains(Node n, E val) {
		if (n == null) return false;
		
		if (n.value.equals(val)) {
			return true;
		} else if (n.value.compareTo(val) > 0) {
			return contains(n.leftChild, val);
		} else {
			return contains(n.rightChild, val);
		}
	}
	
	public boolean add(E val) {
		if (root == null) {
			root = new Node(val);
			return true;
		}
		return add(root, val);
	}
	
	protected boolean add(Node n, E val) {
		if (n == null) {
			return false;
		}
		int cmp = val.compareTo(n.value);
		if (cmp == 0) {
			return false; // this ensures that the same value does not appear more than once
		} else if (cmp < 0) {
			if (n.leftChild == null) {
				n.leftChild = new Node(val);
				return true;
			} else {
				return add(n.leftChild, val);
			} 	
		} else {
			if (n.rightChild == null) {
				n.rightChild = new Node(val);
				return true;
			} else {
				return add(n.rightChild, val);
			} 	
		}
	}	
	
	public boolean remove(E val) {
		return remove(root, null, val);
	}
	
	protected boolean remove(Node n, Node parent, E val) {
		if (n == null) return false;

		if (val.compareTo(n.value) == -1) {
				return remove(n.leftChild, n, val);
		} else if (val.compareTo(n.value) == 1) {
				return remove(n.rightChild, n, val);
		} else {
			if (n.leftChild != null && n.rightChild != null){
				n.value = maxValue(n.leftChild);
				remove(n.leftChild, n, n.value);
			} else if (parent == null) {
				root = n.leftChild != null ? n.leftChild : n.rightChild;
			} else if (parent.leftChild == n){
				parent.leftChild = n.leftChild != null ? n.leftChild : n.rightChild;
			} else {
				parent.rightChild = n.leftChild != null ? n.leftChild : n.rightChild;
			}
			return true;
		}
	}

	protected E maxValue(Node n) {
		if (n.rightChild == null) {
			return n.value;
	    } else {
	       return maxValue(n.rightChild);
	    }
	}

	
	/*********************************************
	 * 
	 * IMPLEMENT THE METHODS BELOW!
	 *
	 *********************************************/
	
	private int depth = 0;
	
	// Method #1.
	public Node findNode(E val) {

		depth = 0;

		if(val == null){
			return null; 
		}

		Node current = root;

		while(current != null){

			E value = current.value;

			if(value.equals(val)){
				return current;
			}

			if(val.compareTo(value) > 0){
				current = current.rightChild;
			}else{
				current = current.leftChild;
			}

			depth++;

		}

		/* IMPLEMENT THIS METHOD! */
		
		return null; // this line is here only so this code will compile if you don't modify it

	}
	
	// Method #2.
	protected int depth(E val) {

		if(findNode(val) == null){
			return -1;
		}

		/* IMPLEMENT THIS METHOD! */
		
		return depth; // this line is here only so this code will compile if you don't modify it

	}
	
	// Method #3.
	protected int height(E val) {

		if(val == null){
			return -1;
		}

		Node target = findNode(val);

		if(target == null){
			return -1;
		}


		int rightHeight = 0;
		Node rightNode = target.rightChild;
		if(rightNode != null){
			rightHeight = height(target.rightChild.value) + 1;
		}
		

		int leftHeight = 0;
		Node leftNode = target.leftChild;
		if(leftNode != null){
			leftHeight = height(target.leftChild.value) + 1;
		}


		/* IMPLEMENT THIS METHOD! */
		
		return rightHeight > leftHeight ? rightHeight : leftHeight; // this line is here only so this code will compile if you don't modify it

	}


	// Method #4.
	protected boolean isBalanced(Node n) {

		if(n == null){
			return false;
		}

		if(findNode(n.value) == null){
			return false;
		}

		Node rightNode = n.rightChild;
		Node leftNode = n.leftChild;

		int rightHeight = -1;
		if(rightNode != null){
			rightHeight = height(rightNode.value);
		}


		int leftHeight = -1;
		if(leftNode != null){
			leftHeight = height(leftNode.value);
		}

		/* IMPLEMENT THIS METHOD! */
		
		boolean result = Math.abs(rightHeight - leftHeight) < 2;

		if(rightNode != null && result == true){
			result = isBalanced(rightNode);
		}

		if(leftNode != null && result == true){
			result = isBalanced(leftNode);
		}

		return result; // this line is here only so this code will compile if you don't modify it

	}
	
	// Method #5. .
	public boolean isBalanced() {

		/* IMPLEMENT THIS METHOD! */
		boolean result = isBalanced(root);

		return result; // this line is here only so this code will compile if you don't modify it

	}

}
