package com.denis.shuvalov.algo.old.chpter_2.selectSort;

import java.util.Arrays;

public class SelectSort
{
	public static void main(String[] args)
	{
		int[] a = new int[] {77, 99, 44, 55, 22, 88, 11, 0, 66, 33 };

		sort(a);
		System.out.println("length: " + a.length);
		System.out.println("a = " + Arrays.toString(a));
	}

	static void sort(int[] arr)
	{
		for (int startIndex = 0; startIndex < arr.length; startIndex++)
		{
			int minValueIndex = startIndex;

			for (int i = startIndex + 1; i < arr.length; i++)
			{
				if (arr[minValueIndex] > arr[i]) {
					minValueIndex = i;
				}
			}

			int tmp = arr[startIndex];
			arr[startIndex] = arr[minValueIndex];
			arr[minValueIndex] = tmp;
		}
	}
}
