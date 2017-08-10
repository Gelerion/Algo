package com.denis.shuvalov.algo.adt.search.union.find;

import com.denis.shuvalov.algo.adt.search.union.find.quick.find.QuickFindUF;
import com.denis.shuvalov.algo.adt.search.union.find.quick.union.QuickUnionUF;
import com.denis.shuvalov.algo.adt.search.union.find.quick.weighted.WeightedQuickUnionUF;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class UnionFindTest {

    public static void main(String[] args) throws URISyntaxException, IOException {
        URI tiny = UnionFindTest.class.getResource(
                "/com/denis/shuvalov/algo/adt/search/union/find/input/tinyUF.txt").toURI();

        try (BufferedReader in = Files.newBufferedReader(Paths.get(tiny))) {

//            UnionFind uf = new QuickFindUF(Integer.parseInt(in.readLine()));
//            UnionFind uf = new QuickUnionUF(Integer.parseInt(in.readLine()));
            UnionFind uf = new WeightedQuickUnionUF(Integer.parseInt(in.readLine()));

            String line;
            while ((line = in.readLine()) != null) {
                String[] connection = line.split("\\s");
                int p = Integer.parseInt(connection[0]);
                int q = Integer.parseInt(connection[1]);

                if(uf.connected(p,q)) continue; //already connected
                uf.union(p,q); //connect components
                System.out.println(p + " " + q);
            }
        }
    }
}

/*      4 3
        3 8
        6 5
        9 4
        2 1
        5 0
        7 2
        6 1*/

