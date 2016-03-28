package com.denis.shuvalov.algo.old.chpter_2.insertionSort;

import java.util.Arrays;

public class InsertionSort
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
		for (int outer = 1; outer < arr.length; outer++)
		{
			int temp = arr[outer];
			int inner = outer - 1;

			while (inner >= 0 && arr[inner] >= temp)
			{
				arr[inner + 1] = arr[inner];
				inner--;
			}
			arr[inner + 1] = temp;
		}
	}
}
