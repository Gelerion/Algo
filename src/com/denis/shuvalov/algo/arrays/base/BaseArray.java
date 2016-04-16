package com.denis.shuvalov.algo.arrays.base;

import com.denis.shuvalov.algo.arrays.HighArray;

public abstract class BaseArray implements HighArray
{
	protected int[] array;
	protected int size;

	public BaseArray(int size)
	{
		this.array = new int[size];
		this.size = 0;
	}

	@Override
	public void display()
	{
		for (int j = 0; j < size; j++) // Перебор всех элементов
			System.out.print(array[j] + "[" + j + "] "); // Вывод текущего элемента
		System.out.println("");
	}

	@Override
	public int size()
	{
		return size;
	}

	public int length()
	{
		return array.length;
	}
}
