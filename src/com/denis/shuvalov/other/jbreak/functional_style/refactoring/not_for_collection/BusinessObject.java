package com.denis.shuvalov.other.jbreak.functional_style.refactoring.not_for_collection;

import java.util.List;

public interface BusinessObject {

    BusinessObject createModel(String object);

    BusinessObject transform(BusinessObject object);

    List<String> validate(BusinessObject object);
}
