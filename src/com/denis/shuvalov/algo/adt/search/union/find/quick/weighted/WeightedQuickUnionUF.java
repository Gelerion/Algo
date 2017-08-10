package com.denis.shuvalov.algo.adt.search.union.find.quick.weighted;

import com.denis.shuvalov.algo.adt.search.union.find.UnionFind;

/**
 * Rather than arbitrarily connecting the second tree to the first for union() in
 * the quick-union algorithm, we keep track of the size of each tree and always
 * connect the smaller tree to the larger.
 */
public class WeightedQuickUnionUF implements UnionFind {
    private int[] parent; // parent[i] = parent of i
    private int[] size;   // size[i] = number of sites in subtree rooted at i
    private int nodes;    // number of component

    public WeightedQuickUnionUF(int nodes) {
        this.nodes = nodes;

        this.parent = new int[nodes];
        for (int i = 0; i < nodes; i++) parent[i] = i;

        this.size = new int[nodes];
        for (int i = 0; i < nodes; i++) size[i] = i;
    }

    @Override
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if(rootP == rootQ) return;

        //make smaller point to larger one
        if(size[rootP] < size[rootQ]) {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }
        else {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        }

        nodes--;
    }

    @Override
    public int find(int p) {
        while (p != parent[p]) p = parent[p]; //traverse by references to root
        return p;
    }

    @Override
    public int count() {
        return nodes;
    }
}
