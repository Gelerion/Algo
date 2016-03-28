package com.denis.shuvalov.little_api;

public interface ThrowingConsumer<T, E extends Exception>
{
	void accept(T t) throws E;
}
