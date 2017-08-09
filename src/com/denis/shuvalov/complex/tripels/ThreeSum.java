package com.denis.shuvalov.complex.tripels;

import java.util.Arrays;

import com.denis.shuvalov.algo.recursion.book.samples.binary_search.RecursiveBinarySearch;

//calculate triples in array with sum equals to zero
public class ThreeSum {

	// with pair its simple in N * LogN time
	// for each i in a
	// binarySearch(a, -i) > i (if gotten index is bigger than current)

	// now for triples triple with sum exists only when -(a[i] + a[j]) exist in
	// array
	static int count(int[] a) {
		Arrays.sort(a); // N^2 in worst case

		int n = a.length;
		int cnt = 0;

		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (RecursiveBinarySearch.rank(-a[i] - a[j], a) > j) {
					cnt++;
				}
			}
		}

		return cnt;
	}
}
