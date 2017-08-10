package com.denis.shuvalov.algo.adt.search.union.find.quick.union;

import com.denis.shuvalov.algo.adt.search.union.find.UnionFind;

/**
 * based on the same data structure—the site-indexed id[] array—but it uses a
 * different interpretation of the values that leads to more complicated structures.
 * Specifically, the id[] entry for each site will be the name of another site in the
 * same component (possibly itself). To implement find() we start at the given site,
 * follow its link to another site, follow that sites link to yet another site, and
 * so forth, following links until reaching a root, a site that has a link to itself.
 * Two sites are in the same component if and only if this process leads them to the
 * same root. To validate this process, we need union() to maintain this invariant,
 * which is easily arranged: we follow links to find the roots associated with each
 * of the given sites, then rename one of the components by linking one of these
 * roots to the other.
 */
public class QuickUnionUF implements UnionFind {
    private int nodes;
    private int[] id;

    public QuickUnionUF(int nodes) {
        this.nodes = nodes;
        this.id = new int[nodes];
        for (int i = 0; i < nodes; i++) id[i] = i;
    }

    @Override //linear time
    public void union(int p, int q) {
        int pRootId = find(p);
        int qRootId = find(q);

        if(pRootId == qRootId) return;

        id[pRootId] = qRootId;
        nodes--;
    }

    //find the root
    @Override
    public int find(int p) {
        while (p != id[p]) p = id[p];
        return p;
    }

    @Override
    public int count() {
        return nodes;
    }
}
