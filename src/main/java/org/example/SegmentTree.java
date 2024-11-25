package org.example;

public class SegmentTree {
    int[] t;
    int n;

    public SegmentTree(int n) {
        this.t = new int[4 * n];
        for (int i = 0; i < n; ++i) {
            this.t[i] = -1;
        }
        this.n = n;
    }

    public void update(int l, int r, int color) {
        update(1, 0, n - 1, l, r, color);
    }

    public int get(int pos) {
        return get(1, 0, n - 1, pos);
    }

    private void update(int v, int tl, int tr, int l, int r, int color) {
        if (l > r) {
            return;
        }
        if (l == tl && tr == r) {
            t[v] = color;
        } else {
            push(v);
            int tm = (tl + tr) / 2;
            update(v * 2, tl, tm, l, Math.min(r, tm), color);
            update(v * 2 + 1, tm + 1, tr, Math.max(l, tm + 1), r, color);
        }
    }

    private void push(int v) {
        if (t[v] != -1) {
            t[v * 2] = t[v * 2 + 1] = t[v];
            t[v] = -1;
        }
    }

    private int get(int v, int tl, int tr, int pos) {
        if (tl == tr)
            return t[v];
        push(v);
        int tm = (tl + tr) / 2;
        if (pos <= tm)
            return get(v * 2, tl, tm, pos);
        else
            return get(v * 2 + 1, tm + 1, tr, pos);
    }
}