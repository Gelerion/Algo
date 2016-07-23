package com.denis.shuvalov.other.jbreak.generics.basics;

public class Person implements Comparable<Person> {
    private String name;

    @Override
    public int compareTo(Person o) {
        return name.compareTo(o.name);
    }

    //!! Error
    //Both methods have same erasure
/*    public int compareTo(Object o) {
        return toString().compareTo(o.toString());
    }*/

    //Type erasure
    // - Процедура стирания информации о дженериках на уровне компиляции
    // - Вставка кастованич
    // - Генерация методов мостов
}
