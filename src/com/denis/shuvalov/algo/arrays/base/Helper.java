package com.denis.shuvalov.algo.arrays.base;

import java.util.Random;

public class Helper
{
	private static Random random = new Random();

	public static void fillWithRandom(BaseArray array)
	{
		for (int i = 0; i < array.length(); i++)
		{
			array.insert(random.nextInt(100));
		}

		System.out.println("== Filled with random ==");
		array.display();
		System.out.println("=========================");
	}

	public static void fillValues(BaseArray array)
	{
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

		System.out.println("== Filled with values ==");
		array.display();
		System.out.println("=========================");
	}


	public static void fillOrderedValues(BaseArray array)
	{
		for (int i = 0; i < array.length(); i++)
		{
			array.insert(i * 2);
		}

		System.out.println("== Filled with values ==");
		array.display();
		System.out.println("=========================");
	}

	public static void fillWithRandom(BaseArray array, int amount)
	{
		for (int i = 0; i < amount; i++)
		{
			array.insert(random.nextInt(100));
		}
	}
}
