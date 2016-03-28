package com.denis.shuvalov.algo.old.chapter_1.objectsArray;


public class ClassDataArray
{
	private Person[] array;
	private int size;

	public void insert(int value)
	{

	}

	public int find(String searchName)
	{
		int low = 0;
		int high = size;

		while (low <= high)
		{
			int mid = (low + high) / 2;
			Person midValue = array[mid];

			if(midValue.lastName.equals(searchName))
				return mid;
			if(midValue.compareTo(searchName) > 0)
				high = mid - 1;
			if(midValue.compareTo(searchName) < 0)
				low = mid + 1;
		}

		return -low;
	}

	public boolean delete(int value)
	{
		return false;
	}

	public void display()
	{

	}

	public int size()
	{
		return 0;
	}
}
