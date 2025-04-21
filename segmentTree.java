class ST {
    int tree[];

    ST(int n) {
        this.tree = new int[4*n];
    }

    void buildTreeUtil(int i, int st, int en, int arr[]) {
        if(st == en) {
            tree[i] = arr[st];
            return;
        }

        int mid = (st + en) >> 1;
        buildTreeUtil(2*i+1, st, mid, arr);
        buildTreeUtil(2*i+2, mid+1, en, arr);

        tree[i] = Math.min(tree[2*i+1], tree[2*i+2]);
    }

    void buildTree(int arr[]) {
        int n = arr.length;

        buildTreeUtil(0, 0, n-1, arr);
    }

    int getMinUtil(int i, int st, int en, int qi, int qj) {
        if(en < qi || st > qj) return Integer.MAX_VALUE;
        if(st >= qi && en <= qj) return tree[i];

        int mid = (st + en) >> 1;

        int left = getMinUtil(2*i+1, st, mid, qi, qj);
        int right = getMinUtil(2*i+2, mid+1, en, qi, qj);

        return Math.min(left, right);
    }

    int getMin(int arr[], int i, int j) {
        int n = arr.length;

        return getMinUtil(0, 0, n-1, i, j);
    }

    void updateUtil(int i, int st, int en, int idx, int val) {
        if(idx < st || idx > en) return;

        if(st == en) {
            tree[i] = val;
            return;
        }

        int mid = (st + en) >> 1;
        updateUtil(2*i+1, st, mid, idx, val);
        updateUtil(2*i+2, mid+1, en, idx, val);

        tree[i] = Math.min(tree[2*i+1], tree[2*i+2]);
    }

    void update(int arr[], int i, int val) {
        int n = arr.length;
        arr[i] = val;

        updateUtil(0, 0, n-1, i, val);
    }
}
