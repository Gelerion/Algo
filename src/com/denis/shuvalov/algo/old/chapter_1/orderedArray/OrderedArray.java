package com.denis.shuvalov.algo.old.chapter_1.orderedArray;

import com.denis.shuvalov.algo.HighArray;

import java.util.Arrays;

public class OrderedArray implements HighArray
{
	private int[] array;
	private int size;

	public OrderedArray(int size)
	{
		this.array = new int[size];
		this.size = 0;
	}

	@Override
	public void insert(int value)
	{
		if (size == 0)
		{
			array[0] = value;
			size++;
			return;
		}

		int index = find(value);
		if (index > 0)
			return; //already exist

		int insertIndex = Math.abs(index);

		if (insertIndex >= array.length)
		{
			System.out.println("[WARN] Could not insertFirst, create bigger array");
			return;
		}

		//moving all values
		for (int k = size; k > insertIndex; k--)
		{
			array[k] = array[k - 1];
		}

		array[insertIndex] = value;
		size++;
	}

	@Override
	public int find(int value)
	{
		if (size == 0)
			return 0;

		int low = 0;
		int high = size - 1;

		while (low <= high)
		{
			int mid = (low + high) / 2;
			int midValue = array[mid];

			if (midValue == value)
				return mid;
			else if (value > midValue)
				low = mid + 1;
			else if (value < midValue)
				high = mid - 1;
		}

		return -low;
	}

	@Override
	public boolean delete(int value)
	{
		int index = find(value);
		//not found
		if (index < 0)
			return false;

		for (int i = index + 1; i < size; i++)
		{
			array[i - 1] = array[i];
		}
		size--;
		return true;
	}

	@Override
	public void display()
	{
		for (int j = 0; j < size; j++) // Перебор всех элементов
			System.out.print(array[j] + " "); // Вывод текущего элемента
		System.out.println("");
	}

	@Override
	public int size()
	{
		return size;
	}

	public int getMax()
	{
		if (size == 0)
			return -1;

		int currentMax = array[0];
		for (int i = 1; i < size; i++)
		{
			if (array[i] > currentMax)
				currentMax = array[i];
		}
		return array[size - 1];
	}

	/*	объединяющий два упорядоченных исходных массива в один упорядочен-
		ный приемный массив. Включите в main() фрагмент кода, который заполняет два
		исходных массива случайными числами, вызывает merge() и выводит содержимое
		полученного массива. Исходные массивы могут содержать разное количество эле-
		ментов. Ваш алгоритм должен сравнивать ключи исходных массивов и копировать
		меньший в приемный массив. Также необходимо предусмотреть ситуацию, когда
		элементы в одном исходном массиве заканчиваются раньше, чем в другом.*/
	public void merge(OrderedArray anotherArray, int anotherSize)
	{
		int[] result = new int[size + anotherSize];
		int[] first = array;
		int[] second = anotherArray.array;

		int firstSize = size;
		int secondSize = anotherSize;

		for (int resultIndex = 0, firstIndex = 0, secondIndex = 0; resultIndex < result.length; resultIndex++)
		{
			if (firstIndex == firstSize)
			{
				result[resultIndex] = second[secondIndex];
				secondIndex++;
				continue;
			}

			if (secondIndex == secondSize)
			{
				result[resultIndex] = first[firstIndex];
				firstIndex++;
				continue;
			}

			if(first[firstIndex] > second[secondIndex])
			{
				result[resultIndex] = second[secondIndex];
				secondIndex++;
			}
			else if(first[firstIndex] == second[secondIndex])
			{
				System.out.println("Duplicates not allowed");
				result[resultIndex] = first[firstIndex];
				firstIndex++; secondIndex++;
			}
			else
			{
				result[resultIndex] = first[firstIndex];
				firstIndex++;
			}
		}

		System.out.println("result = " + Arrays.toString(result));
	}

	private void merge0(int[] a, int[] b)
	{
		int[] answer = new int[a.length + b.length];
		int i = a.length - 1, j = b.length - 1, k = answer.length;

		while (k > 0)
			answer[--k] = (j < 0 || (i >= 0 && a[i] >= b[j])) ? a[i--] : b[j--];
	}

	private void noDups(int[] a)
	{
	}
}
