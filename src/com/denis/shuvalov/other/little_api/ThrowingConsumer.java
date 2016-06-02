package com.denis.shuvalov.other.little_api;

public interface ThrowingConsumer<T, E extends Exception>
{
	void accept(T t) throws E;
}
