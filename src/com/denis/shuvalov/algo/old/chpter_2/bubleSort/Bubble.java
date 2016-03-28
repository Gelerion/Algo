package com.denis.shuvalov.algo.old.chpter_2.bubleSort;

import java.util.Arrays;

/**
 * 1. Сравнить двух игроков.
 * 2. Если левый игрок выше, поменять их местами.
 * 3. Перейти на одну позицию вправо.
 */
public class Bubble
{
	static void sort(int[] arr)
	{
		int outer = arr.length - 1;

		for (int i = 0; i < arr.length - 1; i++)
		{
			for (int k = 0; k < outer; k++)
			{
				int left = arr[k];
				int right = arr[k + 1];

				if (left > right)
				{
					int tmp = arr[k];
					arr[k] = arr[k + 1];
					arr[k + 1] = tmp;
				}
			}

			outer--;
		}
	}

	public static void main(String[] args)
	{
		int[] a = new int[] { 1, 8, 5, 6, 7, 12, 0 };
		a = new int[] {77, 99, 44, 55, 22, 88, 11, 0, 66, 33 };

		sort(a);
		System.out.println("length: " + a.length);
		System.out.println("a = " + Arrays.toString(a));
	}
}
