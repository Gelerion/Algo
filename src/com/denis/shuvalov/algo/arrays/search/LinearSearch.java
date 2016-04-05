package com.denis.shuvalov.algo.arrays.search;

import com.denis.shuvalov.algo.arrays.base.BaseArray;
import com.denis.shuvalov.algo.arrays.base.Helper;
import com.denis.shuvalov.algo.arrays.base.Log;

public class LinearSearch extends BaseArray
{
	public LinearSearch(int size)
	{
		super(size);
	}

    public static void main(String[] args) {
        LinearSearch array = new LinearSearch(10);
        Helper.fillValues(array);
        array.find(88);

    }

	public void insert(int value)
	{
		array[size++] = value;
	}

	@Override
	public int find(int value)
	{
		for (int i = 0; i < size; i++)
		{
			if (value == array[i])
			{
                Log.Array.find.found(value, i);
                return i;
			}
		}

        Log.Array.find.notFound(value);
        return -1;
	}

	@Override
	public boolean delete(int value)
	{
		return false;
	}
}
