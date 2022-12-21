package psa.naloga1;

public class NodeBinarno {
	private static int counter;
	private int key;
	private NodeBinarno leftChild;
	private NodeBinarno rightChild;

	public int getKey() {
		return key;
	}

	public void setLeftChild(NodeBinarno leftChild) {
		this.leftChild = leftChild;
	}

	public NodeBinarno getLeftChild() {
		return leftChild;
	}

	public NodeBinarno getRightChild() {
		return rightChild;
	}

	public NodeBinarno(int key) {
		this.key = key;
	}

	public boolean insert(NodeBinarno node){
		if (compare(node) < 0 ) {
			if (this.leftChild == null) {
				this.leftChild = node;
				return true;
			} else if (compare(this.leftChild) == 0){
				return false;
			} else {
				return this.leftChild.insert(node);
			}
		} else if (compare(node) > 0) {

			if (this.rightChild == null) {
				this.rightChild = node;
				return true;
			} else if (compare(this.rightChild) == 0){
				return false;
			} else {
				return this.rightChild.insert(node);
			}
		} else {
			return false;
		}
	}

	public boolean search(NodeBinarno node){
		if (compare(node) < 0 ) {

			if (this.leftChild == null) {
				return false;
			} else if (compare(this.leftChild) == 0){
				return true;
			} else {
				return this.leftChild.search(node);
			}
		} else if (compare(node) > 0) {
			if (this.rightChild == null) {
				return false;
			} else if (compare(this.rightChild) == 0){
				return true;
			} else {
				return this.rightChild.search(node);
			}
		} else {
			return true;
		}
	}
	public boolean delete(int key, NodeBinarno node){
		if (key < this.key ) {
			if (leftChild != null) {
				return leftChild.delete(key, this);
			} else {
				return false;
			}
		} else if (key > this.key) {
			if (rightChild != null){
				return rightChild.delete(key, this);
			} else {
				return false;
			}
		} else {
			if (leftChild != null && rightChild != null) {
				this.key = rightChild.minValue();
				rightChild.delete(this.key, this);
			} else if (node.leftChild == this) {
				node.leftChild = (leftChild != null) ? leftChild : rightChild;
			} else if (node.rightChild == this) {
				node.rightChild = (leftChild != null) ? leftChild : rightChild;
			}
			return true;
		}
	}

	public int minValue() {
		if (leftChild == null) {
			return key;
		}
		else {
			return leftChild.minValue();
		}
	}

	public int compare(NodeBinarno node) {
		counter++;
		return node.key - this.key;
	}
	
	public int getCounter() {
		return counter;
	}
	
	public void resetCounter() {
		counter=0;
	}
}
