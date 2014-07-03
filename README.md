霍夫曼编码 ---- 用于数据的无损压缩
=======
霍夫曼编码使用变长编码表对源符号进行编码，其中变长编码表是通过一种评估来源符号出现机率的方法得到的，出现机率高的字母使用较短的编码，反之出现机率低的则使用较长的编码，这便使编码之后的字符串的平均长度、期望值降低，从而达到无损压缩数据的目的
####霍夫曼树
在编码之前先根据符号的频率建立霍夫曼树，构建过程如下：

    1.  将每个符号依照出现频率由小排到大。
    2.  每个符号都代表一个叶节点，比较每个字母的出现频率，将最小的两个字母频率相加合成一个新的父节点。
    3.  重复2，知道值剩下一个待合成的节点，即树根。
  
  
####编码
    1.  给霍夫曼树的所有左链结'0'与右链结'1'。
    2.  从树根至树叶依序记录所有字母的编码。
    
####测试例子
    @Test
    public void testHuffmanEncoding() throws Exception {
        String source = "this is an example of a huffman tree";
        HuffmanTree<Byte, Integer> huffmanTree = createTree(source);
        huffmanTree.select((node) -> node.symbol != null).forEach(System.out::print);
    }

    [e : 000] [a : 001] [n : 0100] [m : 0101] [h : 0110] [i : 0111] [t : 1000] [s : 1001] [o : 10100] [l : 10101] 
    [u : 10110] [r : 10111] [p : 11000] [x : 11001] [f : 1101] [  : 111]

    
