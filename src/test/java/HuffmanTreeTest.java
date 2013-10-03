import org.junit.Test;

import java.util.*;

public class HuffmanTreeTest {
    @Test
    public void testEncode() throws Exception {
        String source = "this is an example of a huffman tree";
        HuffmanTree<Byte, Integer> huffmanTree = createTree(source);

        huffmanTree.select((node) -> node.symbol != null).forEach(System.out::print);
    }

    private HuffmanTree<Byte, Integer> createTree(String source) {
        byte[] sourceBytes = source.getBytes();
        List<Node<Byte, Integer>> nodes1 = frequencyNodes(sourceBytes);

        Collections.sort(nodes1, (first, second) -> first.weight - second.weight);

        while (nodes1.size() > 1) {
            Node<Byte, Integer> first = nodes1.get(0);
            Node<Byte, Integer> second = nodes1.get(1);
            nodes1.add(new Node<>(null, first.weight + second.weight, first, second));
            nodes1.remove(0);
            nodes1.remove(0);
            Collections.sort(nodes1, (left, right) -> left.weight - right.weight);
        }
        List<Node<Byte, Integer>> nodes = nodes1;

        return new HuffmanTree<>(nodes.get(0));
    }

    private List<Node<Byte, Integer>> frequencyNodes(byte[] sourceBytes) {
        HashMap<Byte, Node<Byte, Integer>> hashMap = new HashMap<>();
        for (byte b : sourceBytes) {
            if (hashMap.containsKey(b)) {
                hashMap.put(b, new Node<>(b, hashMap.get(b).weight + 1));
            } else {
                hashMap.put(b, new Node<>(b, 1));
            }
        }

        return new ArrayList<>(hashMap.values());
    }


}


