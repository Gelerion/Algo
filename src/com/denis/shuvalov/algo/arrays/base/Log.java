package com.denis.shuvalov.algo.arrays.base;

public class Log
{
	public static class find {
		public static void found(int value, int index)
		{
			System.out.println("find(): found value [" + value + "], at index [" + index + "]");
		}

		public static void notFound(int value)
		{
			System.out.println("find(): value [" + value + "], not found [-1]");
		}

	}
}
