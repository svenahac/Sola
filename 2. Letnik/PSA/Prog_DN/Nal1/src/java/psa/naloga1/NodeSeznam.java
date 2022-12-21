package psa.naloga1;

public class NodeSeznam {
	private static int counter;
	private int key;

	private NodeSeznam tail;

	public NodeSeznam getTail() {
		return tail;
	}

	public NodeSeznam(int key) {
		this.key = key;
	}

	public int compare(NodeSeznam node) {
		counter++;
		return node.key - this.key;
	}

	public boolean insert(NodeSeznam node) {
		if (tail == null) {
			tail = node;
			return true;
		} else if (tail.compare(node) == 0) {
			return false;
		} else {
			return tail.insert(node);
		}
	}

	public boolean delete(NodeSeznam node) {
		if (tail == null) {
			return false;
		} else if (tail.compare(node) == 0) {
			tail = tail.tail;
			return true;
		} else {
			return tail.delete(node);
		}
	}

	public boolean search(NodeSeznam node) {
		if (tail == null) {
			return false;
		} else if (tail.compare(node) == 0) {
			return true;
		} else {
			return tail.search(node);
		}
	}
	
	public int getCounter() {
		return counter;
	}
	
	public void resetCounter() {
		counter=0;
	}
}
