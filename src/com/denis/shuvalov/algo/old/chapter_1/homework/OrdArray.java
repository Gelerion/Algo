package com.denis.shuvalov.algo.old.chapter_1.homework;

import com.denis.shuvalov.algo.old.chapter_1.orderedArray.OrderedArray;

public class OrdArray
{
	private long[] a; // Ссылка на массив a
	private int nElems; // Количество элементов данных

	//-----------------------------------------------------------
	public OrdArray(int max) // Конструктор
	{
		a = new long[max]; // Создание массива
		nElems = 0;
	}

	//-----------------------------------------------------------
	public int size()
	{
		return nElems;
	}

	//-----------------------------------------------------------
	public int find(long searchKey)
	{
		int lowerBound = 0;
		int upperBound = nElems - 1;
		int curIn;
		while (true)
		{
			curIn = (lowerBound + upperBound) / 2;
			if (a[curIn] == searchKey)
				return curIn; // Элемент найден
			else if (lowerBound > upperBound)
				return nElems; // Элемент не найден
			else // Деление диапазона
			{
				if (a[curIn] < searchKey)
					lowerBound = curIn + 1; // В верхней половине
				else
					upperBound = curIn - 1; // В нижней половине
			}
		}
	}

	//-----------------------------------------------------------
	public void insert(long value) // Вставка элемента в массив
	{
		int j;
		for (j = 0; j < nElems; j++) // Определение позиции вставки
			if (a[j] > value) // (линейный поиск)
				break;
		for (int k = nElems; k > j; k--) // Перемещение последующих элементов
			a[k] = a[k - 1];
		a[j] = value; // Вставка
		nElems++; // Увеличение размера
	}

	//-----------------------------------------------------------
	public boolean delete(long value)
	{
		int j = find(value);
		if (j == nElems) // Найти не удалось
			return false;
		else // Элемент найден
		{
			for (int k = j; k < nElems; k++) // Перемещение последующих элементов
				a[k] = a[k + 1];
			nElems--; // Уменьшение размера
			return true;
		}
	}

	//-----------------------------------------------------------
	public void display() // Вывод содержимого массива
	{
		for (int j = 0; j < nElems; j++) // Перебор всех элементов
			System.out.print(a[j] + " "); // Вывод текущего элемента
		System.out.println("");
	}
	//-----------------------------------------------------------
}

////////////////////////////////////////////////////////////////
class OrderedApp
{
	public static void main(String[] args)
	{
		//chapter_1();
		int maxSize = 15;
		OrderedArray arr = new OrderedArray(maxSize);
		arr.insert(11);
		arr.insert(22);
		arr.insert(33);
		arr.insert(44);
		arr.insert(55);
		arr.insert(66);
		arr.insert(77);

		OrderedArray arr2 = new OrderedArray(maxSize);
		arr2.insert(14);
		arr2.insert(15);
		arr2.insert(16);
		arr2.insert(17);
		arr2.insert(18);
		arr2.insert(19);
		arr2.insert(20);
		arr2.insert(21);
		arr2.insert(22);
		arr2.insert(23);
		arr2.insert(24);

		arr.merge(arr2, arr2.size());
	}

	private static void chapter_1()
	{
		int maxSize = 100; // Размер массива
		OrdArray arr; // Ссылка на массив
		arr = new OrdArray(maxSize); // Создание массива
		arr.insert(77); // Вставка 10 элементов
		arr.insert(99);
		arr.insert(44);
		arr.insert(55);
		arr.insert(22);
		arr.insert(88);
		arr.insert(11);
		arr.insert(00);
		arr.insert(66);
		arr.insert(33);
		int searchKey = 55; // Поиск элемента
		if (arr.find(searchKey) != arr.size())
			System.out.println("Found " + searchKey);
		else
			System.out.println("Can't find " + searchKey);
		arr.display(); // Вывод содержимого
		arr.delete(00); // Удаление трех элементов
		arr.delete(55);
		arr.delete(99);
		arr.display(); // Повторный вывод
	}
}
