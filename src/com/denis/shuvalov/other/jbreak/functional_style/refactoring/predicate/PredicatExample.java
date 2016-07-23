package com.denis.shuvalov.other.jbreak.functional_style.refactoring.predicate;

import com.denis.shuvalov.other.jbreak.functional_style.utils.Child;
import com.denis.shuvalov.other.jbreak.functional_style.utils.Parent;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toList;

public class PredicatExample {

    //PECS
    List<Child> collectChildren(List<Parent> parents, Predicate<? super Child> condition) {
        return parents.stream()
                      .map(Parent::getChild)
                      .filter(condition)
                      .distinct()
                      .collect(toList());
    }

    void fluentCondition() {
        List<Parent> parents = new ArrayList<>();

        collectChildren(parents, olderThan(14).and(withName("Anton")));
        collectChildren(parents, withName("Jack").or(olderThan(18)));

    }

    //Without unnecessary methods
    void functionsFluent() {
        List<Parent> parents = new ArrayList<>();

        Function<String, Predicate<Child>> withName  = name -> child -> child.getName().equals(name);
        IntFunction<Predicate<Child>>      olderThan = years -> child -> child.getAge() >= years;

        collectChildren(parents, withName.apply("Elena").and(olderThan.apply(15)));
    }

    private Predicate<Child> olderThan(int age) {
        return child -> child.getAge() >= age;
    }

    private Predicate<Child> withName(String name) {
        return child -> child.getName().equals(name);
    }
}
