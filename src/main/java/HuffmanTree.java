import sun.security.util.BitArray;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

public class HuffmanTree<K, V> {
    private final Node<K, V> root;

    public HuffmanTree(Node<K, V> root) {
        this.root = root;
    }

    public void each(Consumer<Node<K, V>> consumer) {
        encode();
        if (this.root != null) {
            iterate(this.root, consumer);
        }
    }

    public Stream<Node<K, V>> select(Function<Node<K, V>, Boolean> function) {
        List<Node<K, V>> list = new ArrayList<>();
        each((node) -> {
            if (function.apply(node)) {
                list.add(node);
            }
        });

        return list.stream();
    }

    private void iterate(Node<K, V> node, Consumer<Node<K, V>> consumer) {
        consumer.accept(node);
        if (node.left != null) {
            iterate(node.left, consumer);
        }
        if (node.right != null) {
            iterate(node.right, consumer);
        }
    }

    private void setCode(Node<K, V> node, BitArray code) {
        node.code = code;
        if (node.left != null) {
            BitArray leftCode = newBitArray(node.code, false);
            setCode(node.left, leftCode);
        }
        if (node.right != null) {
            BitArray rightCode = newBitArray(node.code, true);
            setCode(node.right, rightCode);
        }
    }

    private BitArray newBitArray(BitArray bitArray, boolean b) {
        BitArray newBitArray = new BitArray(bitArray.length() + 1);
        for (int i = 0; i < bitArray.length(); i++) {
            newBitArray.set(i, bitArray.get(i));
        }

        newBitArray.set(bitArray.length(), b);
        return newBitArray;
    }

    public void encode() {
        setCode(this.root, new BitArray(0));
    }

}
