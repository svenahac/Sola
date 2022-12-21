package psa.naloga3;

/*
 * Razred mora imeplementirati podatkovno strukturo Razprsilne tabele.
 * Za funkcijo uporabite: h(x) = x * 53 mod 100
 * V primeru kolizij uporabite LINEARNO NASLAVLJANJE.
 */
public class HashTable2 {

	int[] data;

	public HashTable2() {
		data = new int[100];
	}

	public int hash(int x) {
		return (x * 53) % 100;
	}

	/*
	 * Metoda sprejme število in ga vstavi v tabelo. Metoda vrne true, ce je
	 * bilo ustavljanje uspešno in false sicer
	 */
	public boolean insert(int key) {
		int index = hash(key);
		for (int i = 0; i < 100; i++) {
			if (data[index] == 0) {
				data[index] = key;
				return true;
			}
		}
		return false;
	}

	/*
	 * Metoda sprejme število in ga poišče v tabeli. Metoda vrne true, ce je
	 * bilo ustavljanje uspešno in false sicer
	 */
	public boolean search(int key) {
		int index = hash(key);
		for (int i = 0; i < 100; i++) {
			if (data[index] == key) {
				return true;
			}
		}
		return false;
	}

	/*
	 * Metoda sprejme število in ga izbriše iz tabele. Metoda vrne true, ce je
	 * bilo ustavljanje uspešno in false sicer
	 */
	public boolean delete(int key) {
		int index = hash(key);
		for (int i = 0; i < 100; i++) {
			if (data[index] == key) {
				data[index] = 0;
				return true;
			}
		}
		return false;
	}
}
