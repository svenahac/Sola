package psa.naloga3;

public class NodeSkipList {

    private int key;
    private NodeSkipList[] next;

    public NodeSkipList(int key, int level) {
        this.key = key;
        this.next = new NodeSkipList[level];
    }

    public int getKey() {
        return key;
    }

    public NodeSkipList getNext(int level) {
        return next[level];
    }

    public void setNext(int level, NodeSkipList node) {
        next[level] = node;
    }

    public int getLevel() {
        return next.length;
    }


}
