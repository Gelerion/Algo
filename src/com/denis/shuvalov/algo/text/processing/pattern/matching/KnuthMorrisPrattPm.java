package com.denis.shuvalov.algo.text.processing.pattern.matching;

/**
 * In examining the worst-case performances of the brute-force and Boyer-Moore
 * pattern-matching algorithms on specific instances of the problem, we should notice
 * a major inefficiency (at least in the worst case).
 * For a certain alignment of the pattern, if we find several matching characters but
 * then detect a mismatch, we ignore all the information gained by the successful
 * comparisons after restarting with the next incremental placement of the pattern.
 * The Knuth-Morris-Pratt (or “KMP”) algorithm avoids this waste of information and,
 * in so doing, it achieves a running time of O(n+m), which is asymptotically optimal.
 * That is, in the worst case any pattern-matching
 * algorithm will have to examine all the characters of the text and all the characters
 * of the pattern at least once. The main idea of the KMP algorithm is to pre compute
 * self-overlaps between portions of the pattern so that when a mismatch occurs
 * at one location, we immediately know the maximum amount to shift the pattern
 * before continuing the search.
 */
public class KnuthMorrisPrattPm {

    public static void main(String[] args) {
        int kmp = KnuthMorrisPrattPm.findKmp("denis".toCharArray(), "ni".toCharArray());
        System.out.println("kmp = " + kmp);
    }

/*  If a mismatch occurs at the indicated location, the pattern could be
    shifted to the second alignment, without explicit need to recheck
    the partial match*/

    static int findKmp(char[] text, char[] pattern) {
        int n = text.length;
        int m = pattern.length;
        if(m == 0) return 0;
        int[] fail = computeFailKMP(pattern);

        int j = 0;
        int k = 0;

        while (j < n) {
            if (text[j] == pattern[k]) {
                if(k == m - 1) return j - m + 1;
                j++; k++;
            } else if (k > 0) {
                k = fail[k - 1];
            } else j++;
        }

        return -1;
    }

    /**
     * a failure function, f , that
     * indicates the proper shift of the pattern upon a failed comparison. Specifically, the
     * failure function f (k) is defined as the length of the longest prefix of the pattern that
     * is a suffix of the substring pattern[1..k] (note that we did not include pattern[0]
     * here, since we will shift at least one unit). Intuitively, if we find a mismatch upon
     * character pattern[k+1], the function f (k) tells us how many of the immediately
     * preceding characters can be reused to restart the pattern.
     * <p>
     * k     0 1 2 3 4 5 6 7 8 9 10 11
     * P[k]  a m a l g a m a t i o n
     * f (k) 0 0 1 0 0 1 2 3 0 0 0 0
     *
     * The values in the prefix table are:
     * the length of the longest proper prefix that matches a proper suffix
     * in the same subpattern
     * !!! https://www.youtube.com/watch?v=5i7oKodCRJo
     */
    static int[] computeFailKMP(char[] pattern) {
        int m = pattern.length;
        int[] fail = new int[m]; //by default all overlaps are zeros

        int j = 1;
        int k = 0;

        while (j < m) {
            if (pattern[j] == pattern[k]) {
                fail[j] = k + 1;
                j++;
                k++;
            } else if (k > 0) k = fail[k - 1];
            else j++;
        }

        return fail;

    }
}
