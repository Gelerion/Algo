package com.denis.shuvalov.algo.adt.search.union.find.quick.find;

import com.denis.shuvalov.algo.adt.search.union.find.UnionFind;

//maintains the invariant that p and q are connected if and only if id[p]
//is equal to id[q].
//In other words, all sites in a component must have the same value in id[].
// (N+3)(N-1) ~ N^2 complexity
public class QuickFindUF implements UnionFind {
    private int nodes;
    private int[] id;

    public QuickFindUF(int nodes) {
        this.nodes = nodes;
        this.id = new int[nodes];
        for (int i = 0; i < nodes; i++) id[i] = i;
    }

    @Override
    public int count() {
        return nodes;
    }

    @Override
    public void union(int p, int q) {
        int pId = find(p);
        int qId = find(q);

        if(pId == qId) return; //already related to same component

        for (int i = 0; i < id.length; i++) {
            if (id[i] == pId) id[i] = qId;
            nodes--;
        }
    }

    @Override
    public int find(int p) {
        return id[p];
    }
}
