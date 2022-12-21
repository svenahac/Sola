package psa.naloga1;

public class Binarno {
	private NodeBinarno root;

	/*
	 * Metoda sprejme celo stevilo in ga vstavi v drevo. Ce element ze obstaja v drevesu, vrne false
	 * Metoda vrne true, ce je bil element uspesno vstavljen in false sicer.
	 */
	public boolean insert(int element) {
		if (root == null) {
			root = new NodeBinarno(element);
			return true;
		} else if (root.compare(new NodeBinarno(element))==0){
			return false;
		} else {
			return root.insert(new NodeBinarno(element));
		}
	}
	/*
	 * Metoda sprejme celo stevilo in izbrise element iz drevesa. 
	 * Metoda vrne true, ce je bil element uspesno izbrisan iz drevesa, in false sicer
	 */
	public boolean delete(int element) {
		if (root == null) {
			return false;
		} else {
			if (root.getKey() == element){
				NodeBinarno secondRoot = new NodeBinarno(0);
				secondRoot.setLeftChild(root);
				boolean res = root.delete(element, secondRoot);
				root = secondRoot.getLeftChild();
				return res;
			} else {
				return root.delete(element, root);
			}
		}
	}

	/*
	 * Metoda sprejme celo stevilo in poisce element v drevesu. 
	 * Metoda vrne true, ce je bil element uspesno najden v drevesu, in false sicer
	 */
	public boolean search(int element) {
		if (root == null) {
			return false;
		} else if (root.compare(new NodeBinarno(element))==0){
			return true;
		} else {
			return root.search(new NodeBinarno(element));
		}
	}

	public int getCounter() {
		return root != null?root.getCounter():null;
	}
	
	public void resetCounter() {
		if(root!= null)
			root.resetCounter();
	}
}

