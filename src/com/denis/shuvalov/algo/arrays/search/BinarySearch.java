package com.denis.shuvalov.algo.arrays.search;

import com.denis.shuvalov.algo.arrays.base.BaseArray;
import com.denis.shuvalov.algo.arrays.base.Helper;
import com.denis.shuvalov.algo.arrays.base.Log;

public class BinarySearch extends BaseArray
{
	public BinarySearch(int quantity)
	{
		super(quantity);
	}

	public void insert(int value)
	{
		array[size++] = value;
	}

	@Override
	public int find(int value)
	{
		int first = 0;
		int last = size - 1;
		int mid = (first + last) / 2;
		System.out.println(mid);
		int result = 0;

		while (value != array[mid]) {
			if(value > array[mid]) {
				System.out.println("bigger");
				int tmp = mid;
				first = ++tmp;
				mid = (first + last) / 2;
				System.out.println("mid = " + mid);
			}
			else if (value < array[mid]) {
				System.out.println("lower");
				int tmp = mid;
				last = --tmp;
				mid = (first + last) / 2;
				System.out.println("mid = " + mid);
			}
			else {
				System.out.println("found");
				result = mid;
				break;
			}
		}

		if(value == array[mid])
		{
			Log.find.found(value, mid);
			return mid;
		}

		Log.find.notFound(value);
		return -1;
	}

	@Override
	public boolean delete(int value)
	{
		return false;
	}

	public static void main(String[] args)
	{
		BinarySearch array = new BinarySearch(10);
		Helper.fillOrderedValues(array);
		array.find(8);

	}
}
