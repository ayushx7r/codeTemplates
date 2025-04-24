class Node {
    Node children[];
    boolean isEnd;

    Node() {
        this.children = new Node[26];
        this.isEnd = false;
    }

    boolean contains(char ch) {
        return children[ch-'a'] != null;
    }

    void add(char ch) {
        children[ch-'a'] = new Node();
    }

    Node next(char ch) {
        return children[ch - 'a'];
    }

    void setEnd() {
        isEnd = true;
    }
}

class Trie {
    Node root;
    public Trie() {
        this.root = new Node();
    }

    public void insert(String word) {
        int n = word.length();
        Node curr = root;
        for(int i = 0; i < n; i++) {
            char ch = word.charAt(i);
            if(!curr.contains(ch)) curr.add(ch);
            curr = curr.next(ch);
        }
        curr.setEnd();
    }
    
    public boolean search(String word) {
        int n = word.length();
        Node curr = root;
        for(int i = 0; i < n; i++) {
            char ch = word.charAt(i);
            if(!curr.contains(ch)) return false;
            curr = curr.next(ch);
        }   
        return curr.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        int n = prefix.length();
        Node curr = root;
        for(int i = 0; i < n; i++) {
            char ch = prefix.charAt(i);
            if(!curr.contains(ch)) return false;
            curr = curr.next(ch);
        }
        return true;
    }
}
