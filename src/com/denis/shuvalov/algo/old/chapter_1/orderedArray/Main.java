package com.denis.shuvalov.algo.old.chapter_1.orderedArray;

public class Main
{
	public static void main(String[] args)
	{
		int maxSize = 100;
		OrderedArray array = new OrderedArray(maxSize);
		array.insert(77); // Вставка 10 элементов
		array.insert(99);
		array.insert(44);
		array.insert(55);
		array.insert(22);
		array.insert(88);
		array.insert(11);
		array.insert(00);
		array.insert(66);
		array.insert(33);
		int searchKey = 55; // Поиск элемента
		if( array.find(searchKey) != array.size() )
			System.out.println("Found " + searchKey);
		else
			System.out.println("Can't find " + searchKey);
		array.display(); // Вывод содержимого
		array.delete(00); // Удаление трех элементов
		array.delete(55);
		array.delete(99);
		array.display(); // Повторный вывод

		int max = array.getMax();
		System.out.println("max = " + max);
	}
}
