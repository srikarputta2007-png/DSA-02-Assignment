public class SegmentTreeCaseStudy {

    int[] tree;
    int n;

    SegmentTreeCaseStudy(int arr[]) {
        n = arr.length;
        tree = new int[4 * n];
        build(arr, 1, 0, n - 1);
    }

    void build(int arr[], int node, int start, int end) {
        if (start == end)
            tree[node] = arr[start];
        else {
            int mid = (start + end) / 2;

            build(arr, 2 * node, start, mid);
            build(arr, 2 * node + 1, mid + 1, end);

            tree[node] = tree[2 * node] + tree[2 * node + 1];
        }
    }

    int query(int node, int start, int end, int l, int r) {

        if (r < start || end < l)
            return 0;

        if (l <= start && end <= r)
            return tree[node];

        int mid = (start + end) / 2;

        return query(2 * node, start, mid, l, r)
                + query(2 * node + 1, mid + 1, end, l, r);
    }

    void update(int node, int start, int end, int idx, int val) {

        if (start == end)
            tree[node] = val;
        else {

            int mid = (start + end) / 2;

            if (idx <= mid)
                update(2 * node, start, mid, idx, val);
            else
                update(2 * node + 1, mid + 1, end, idx, val);

            tree[node] = tree[2 * node] + tree[2 * node + 1];
        }
    }

    public static void main(String[] args) {

        int revenue[] = {1200, 1500, 1800, 1100, 2000, 1700, 1300, 1600};

        SegmentTreeCaseStudy st = new SegmentTreeCaseStudy(revenue);

        System.out.println("Revenue [0-7] = "
                + st.query(1, 0, 7, 0, 7));

        System.out.println("Revenue [2-6] = "
                + st.query(1, 0, 7, 2, 6));

        System.out.println("Revenue [1-4] = "
                + st.query(1, 0, 7, 1, 4));

        System.out.println("Revenue [3-5] = "
                + st.query(1, 0, 7, 3, 5));

        st.update(1, 0, 7, 4, 2500);

        System.out.println("Updated Revenue [0-7] = "
                + st.query(1, 0, 7, 0, 7));
    }
}
