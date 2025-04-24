class Trie {
    Node root;

    Trie() {
        root = new Node();
    }

    void insert(int num) {
        Node curr = root;
        for(int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if(!curr.contains(bit)) {
                curr.add(bit, new Node());
            }
            curr = curr.get(bit);
        }
    }

    int max(int x) {
        Node curr = root;
        int maxValue = 0;
        for(int i = 31; i >= 0; i--) {
            int bit = (x >> i) & 1;
            int reqBit = 1 - bit;
            if(curr.contains(reqBit)) {
                maxValue = (1 << i) | maxValue;
                curr = curr.get(reqBit);
            }
            else {
                curr = curr.get(bit);
            }
        }
        return maxValue;
    }
}

class Node {
    Node children[];

    Node() {
        this.children = new Node[2];
    }

    boolean contains(int bit) {
        return children[bit] != null;
    }

    void add(int bit, Node node) {
        children[bit] = node;
    }

    Node get(int bit) {
        return children[bit];
    }
}
