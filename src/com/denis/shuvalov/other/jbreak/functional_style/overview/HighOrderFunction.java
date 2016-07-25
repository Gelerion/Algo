package com.denis.shuvalov.other.jbreak.functional_style.overview;

/**
 * Функции высшего порядка
 * - Принимает в качестве аргумента другие функции
 * - Возвращяет другую функцию в качестве результата
 */
public class HighOrderFunction {

    public static void main(String[] args) {
        HighOrderFunction f = new HighOrderFunction();

        Runnable method = () -> {
            try {
                System.out.println("Zzzz");
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Runnable decorated = f.decorate(method);
        decorated.run();
    }

    Runnable decorate(Runnable runnable) {
        return () -> {
            long time = System.currentTimeMillis();
            try {
                runnable.run();
            } finally {
                System.out.println("Exec time: " + (System.currentTimeMillis() - time));
            }
        };
    }
}
