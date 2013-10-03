import sun.security.util.BitArray;

public class Node<K, V> {
    public final K symbol;
    public final V weight;
    public final Node<K, V> left;
    public final Node<K, V> right;
    public BitArray code;

    public Node(K k, V v) {
        symbol = k;
        weight = v;
        this.left = null;
        this.right = null;
    }

    public Node(K k, V v, Node<K, V> left, Node<K, V> right) {
        this.symbol = k;
        this.weight = v;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return String.format("%c:%s:%s,", symbol, weight, bitSetToString(this.code));
    }

    private String bitSetToString(BitArray b) {
        if (b == null) {
            return "";
        }
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < b.length(); i++) {
            s.append(b.get(i) ? "1" : "0");
        }
        return s.toString();
    }

}
