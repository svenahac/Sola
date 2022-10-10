public class PovezanSeznam {
    Seznam prva;

    public void vstavi(int elt) {
        if (prva == null) {
            prva = new Seznam();
            prva.glava = elt;
        } else {
            prva.vstavi(elt);
        }
    }

    public boolean najdi(int elt) {
        if (prva == null) {
            return false;
        } else {
            return prva.najdi(elt);
        }
    }

    public boolean brisi(int elt) {
        if (prva.glava == elt) {
            prva = prva.rep;
            return true;
        } else {
            return prva.brisi(elt);
        }
    }

    public void izpisi() {
        if (prva != null) {
            prva.izpisi();
        }
        System.out.println();
    }
}
