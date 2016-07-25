package com.denis.shuvalov.other.jbreak.generics.basics;

import java.util.List;
import java.util.concurrent.Callable;

import static java.util.Collections.emptyList;

//We could get Meta info about class in runtime
public class GenericsInRuntime<T extends Number> implements Callable<Double> {

    private final List<Integer> integers = emptyList();

    public List<T> numbers() { return emptyList(); }

    public List<String> strings() { return emptyList(); }

    @Override
    public Double call() throws Exception {
        return 0d;
    }
}
