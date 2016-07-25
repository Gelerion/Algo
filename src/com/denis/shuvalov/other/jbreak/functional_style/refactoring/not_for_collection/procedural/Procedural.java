package com.denis.shuvalov.other.jbreak.functional_style.refactoring.not_for_collection.procedural;

import com.denis.shuvalov.other.jbreak.functional_style.refactoring.not_for_collection.BusinessObject;

import java.util.List;

public class Procedural implements BusinessObject {

    List<String> process(String param) {
        BusinessObject model       = createModel(param);
        BusinessObject transformed = transform(model);
        return validate(transformed); //validate(transform(createModel(param)))
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
