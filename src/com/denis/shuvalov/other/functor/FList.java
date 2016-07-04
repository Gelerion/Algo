package com.denis.shuvalov.other.functor;

import com.denis.shuvalov.other.functor.example.MyFunction;

import java.util.ArrayList;
import java.util.List;

public class FList<T> implements Functor<T, FList<?>> {

    //immutable list
    private final List<T> list;

    FList(List<T> list) {
        //ImmutableList.copyOf();
        this.list = new ArrayList<>(list);
    }

    @Override
    public <R> FList<?> map(MyFunction<T, R> function) {
        ArrayList<R> result = new ArrayList<>(list.size());
        for (T t : list) {
            result.add(function.apply(t));
        }
        return new FList<>(result);
    }
}
