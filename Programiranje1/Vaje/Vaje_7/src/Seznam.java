public class Seznam {
    int glava;
    Seznam rep;

    public void vstavi(int elt) {
        if (rep == null) {
            rep = new Seznam();
            rep.glava = elt;
        } else {
            rep.vstavi(elt);
        }
    }

    public boolean najdi(int elt) {
        if (glava == elt) {
            return true;
        } else if (rep == null) {
            return false;
        } else {
            return rep.najdi(elt);
        }
    }

    public boolean brisi(int elt) {
        if (rep == null) {
            return false;
        } else if (rep.glava == elt) {
            rep = rep.rep;
            return true;
        } else {
            return rep.brisi(elt);
        }
    }

    public void izpisi() {
        System.out.print(glava + " ");
        if (rep != null) {
            rep.izpisi();
        }
    }

}
