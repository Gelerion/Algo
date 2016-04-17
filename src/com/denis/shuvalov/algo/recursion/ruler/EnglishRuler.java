package com.denis.shuvalov.algo.recursion.ruler;

/**
 * In the case of computing the factorial function, there is no compelling reason for
 * preferring recursion over a direct iteration with a loop. As a more complex example
 * of the use of recursion, consider how to draw the markings of a typical English
 * ruler. For each inch, we place a tick with a numeric label. We denote the length
 * of the tick designating a whole inch as the major tick length. Between the marks
 * for whole inches, the ruler contains a series of minor ticks, placed at intervals of
 * 1/2 inch, 1/4 inch, and so on. As the size of the interval decreases by half, the tick
 * length decreases by one.
 * <p>
 * ---- 0
 * -
 * --
 * -
 * ---
 * -
 * --
 * -
 * ---- 1
 * -
 * --
 * -
 * ---
 * -
 * --
 * -
 * ---- 2
 */
public class EnglishRuler {
    //drawRuler, drawInterval, drawLine
    public static void drawRuler(int inches, int majorLength) {
        drawLine(majorLength, 0);
        for (int i = 0; i < inches; i++) {
            drawInterval(majorLength - 1);
            drawLine(majorLength, i + 1);
        }

    }

    private static void drawLine(int length, int inch) {
        for (int i = 0; i < length; i++) {
            System.out.print("-");
        }

        if (inch >= 0) {
            System.out.print(" " + inch);
        }

        System.out.println();
    }

    private static void drawInterval(int centralLength) {
        if (centralLength >= 1) {
            drawInterval(centralLength - 1);
            drawLine(centralLength, -1);
            drawInterval(centralLength - 1);
        }
    }

    public static void main(String[] args) {
        EnglishRuler.drawRuler(2, 4);
    }
}

