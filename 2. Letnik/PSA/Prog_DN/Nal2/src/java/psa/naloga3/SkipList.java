package psa.naloga3;

public class SkipList {

	private NodeSkipList head; 

	/*
	 * Tvoritelj sprejme kot parameter stevilo elementov, ki jih je sposoben obdelati
	 */
	public SkipList(long maxNodes) {
		head = new NodeSkipList(Integer.MAX_VALUE, (int) Math.floor(Math.log(maxNodes)/Math.log(2)));
	}

	private int getLevel() {
		int level = 1;
		while (Math.random() >= 0.5 && level < head.getLevel()) {
			level++;
		}
		return level;
	}

	/*
	 * Metoda sprejme stevilo in ga vstavi v preskocni seznam. Ce element ze
	 * obstaja v podatkovni strukturi, vrne false. Metoda vrne true, ce je bil
	 * element uspesno vstavljen in false sicer.
	 */
	public boolean insert(int searchKey) {
		NodeSkipList[] next = new NodeSkipList[head.getLevel()];
		NodeSkipList node = head;
		for (int i = head.getLevel() - 1; i >= 0; i--) {
			while (node.getNext(i) != null && node.getNext(i).getKey() < searchKey) {
				node = node.getNext(i);
			}
			next[i] = node;
		}
		node = node.getNext(0);
		if (node == null || node.getKey() != searchKey) {
			int level = getLevel();
			if (level > head.getLevel()) {
				for (int i = head.getLevel(); i < level; i++) {
					next[i] = head;
				}
				head = new NodeSkipList(Integer.MAX_VALUE, level);
			}
			node = new NodeSkipList(searchKey, level);
			for (int i = 0; i < level; i++) {
				node.setNext(i, next[i].getNext(i));
				next[i].setNext(i, node);
			}
			return true;
		}
		return false;

	}

	/*
	 * Metoda sprejme stevilo in poisce element v preskocnem seznamu. Metoda
	 * vrne true, ce je bil element uspesno najden v podatkovni strukturi, in
	 * false sicer
	 */

	public boolean search(int searchKey) {
		NodeSkipList node = head;
		for (int i = node.getLevel() - 1; i >= 0; i--) {
			while (node.getNext(i) != null && node.getNext(i).getKey() < searchKey) {
				node = node.getNext(i);
			}
		}
		node = node.getNext(0);
		if (node == null) {
			return false;
		} else return node.getKey() == searchKey;

	}

	/*
	 * Metoda sprejme stevilo in izbrise element iz preskocnega seznama. Metoda
	 * vrne true, ce je bil element uspesno izbrisan iz podatkovne strukture, in
	 * false sicer
	 */
	public boolean delete(int key) {
		NodeSkipList[] next = new NodeSkipList[head.getLevel()];
		NodeSkipList node = head;
		for (int i = head.getLevel() - 1; i >= 0; i--) {
			while (node.getNext(i) != null && node.getNext(i).getKey() < key) {
				node = node.getNext(i);
			}
			next[i] = node;
		}
		node = node.getNext(0);
		if (node != null && node.getKey() == key) {
			for (int i = 0; i < node.getLevel(); i++) {
				next[i].setNext(i, node.getNext(i));
			}
			return true;
		}
		return false;
	}



}
