package com.denis.shuvalov.other.jbreak.functional_style.refactoring.not_for_collection.functional;

import com.denis.shuvalov.other.jbreak.functional_style.refactoring.not_for_collection.BusinessObject;

import java.util.List;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class Functional implements BusinessObject {
    Function<String, BusinessObject> creatModel = this::createModel;
    UnaryOperator<BusinessObject> transform = this::transform;
    Function<BusinessObject, List<String>> validat = this::validate;

    static <K, V> Function<K, V> first(Function<K, V> f) {
        return f;
    }

    List<String> process(String param) {
        return first(this::createModel)
                .andThen(this::transform)
                .andThen(this::validate)
                .apply(param);
    }

    @Override
    public BusinessObject createModel(String object) {
        return null;
    }

    @Override
    public BusinessObject transform(BusinessObject object) {
        return null;
    }

    @Override
    public List<String> validate(BusinessObject object) {
        return null;
    }
}
