霍夫曼编码 ---- 用于数据的无损压缩
=======
霍夫曼编码使用变长编码表对源符号进行编码，其中变长编码表是通过一种评估来源符号出现机率的方法得到的，出现机率高的字母使用较短的编码，反之出现机率低的则使用较长的编码，这便使编码之后的字符串的平均长度、期望值降低，从而达到无损压缩数据的目的
#### 测试例子
`@Test
    public void testHuffmanEncode() throws Exception {
        String source = "this is an example of a huffman tree";
        HuffmanTree<Byte, Integer> huffmanTree = createTree(source);
        huffmanTree.select((node) -> node.symbol != null).forEach(System.out::println);
    }`

`output: [e : 000]
        [a : 001]
        [n : 0100]
        [m : 0101]
        [h : 0110]
        [i : 0111]
        [t : 1000]
        [s : 1001]
        [o : 10100]
        [l : 10101]
        [u : 10110]
        [r : 10111]
        [p : 11000]
        [x : 11001]
        [f : 1101]
        [  : 111]`

    
