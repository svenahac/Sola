package psa.naloga1;

public class Seznam {
	private NodeSeznam head;


	/*
	 * Metoda sprejme celo stevilo in ga vstavi v seznam. Ce element ze obstaja v seznamu, vrne false
	 * Metoda vrne true, ce je bil element uspesno vstavljen in false sicer.
	 */
	public boolean insert(int element) {
		if (head == null) {
			head = new NodeSeznam(element);
			return true;
		} else if (head.compare(new NodeSeznam(element)) == 0) {
			return false;
		} else {
			return head.insert(new NodeSeznam(element));
		}
	}

	/*
	 * Metoda sprejme celo stevilo in izbrise element iz seznama. 
	 * Metoda vrne true, ce je bil element uspesno izbrisan iz seznama, in false sicer
	 */
	public boolean delete(int element) {
		if (head == null) {
			return false;
		} else if (head.compare(new NodeSeznam(element)) == 0) {
			head = head.getTail() ;
			return true;
		} else {
			return head.delete(new NodeSeznam(element));
		}
	}

	/*
	 * Metoda sprejme celo stevilo in poisce element v seznamu. 
	 * Metoda vrne true, ce je bil element uspesno najden v seznamu, in false sicer
	 */
	public boolean search(int element) {
		if (head == null) {
			return false;
		} else if (head.compare(new NodeSeznam(element)) == 0) {
			return true;
		} else {
			return head.search(new NodeSeznam(element));
		}
	}
	
	public int getCounter() {
		return head != null?head.getCounter():null;
	}
	
	public void resetCounter() {
		if(head!= null)
			head.resetCounter();
	}
}
