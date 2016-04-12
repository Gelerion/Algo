package com.denis.shuvalov.complex.levinshtein_distance;

import static java.lang.Math.min;

public class LevinshteinCalculator {
    public static int calculate(String firstWord, String secondWord) {
        int distanceMatrix[][] = new int[firstWord.length() + 1][secondWord.length() + 1];

        for (int i = 1; i < distanceMatrix[0].length; i++) {
            distanceMatrix[0][i] = i;
        }

        for (int i = 1; i < distanceMatrix.length; i++) {
            distanceMatrix[i][0] = i;
        }

        System.out.println("Initial matrix: ");
        displayMatrix(distanceMatrix, firstWord, secondWord);

        for (int rowIndex = 0; rowIndex < firstWord.length(); rowIndex++) {
            for (int columnIndex = 0; columnIndex < secondWord.length(); columnIndex++) {
                int edit = 1;
                if (firstWord.charAt(rowIndex) == secondWord.charAt(columnIndex))
                    edit = 0;

                distanceMatrix[rowIndex + 1][columnIndex + 1] =
                        min(distanceMatrix[rowIndex][columnIndex + 1] + 1,
                                min(distanceMatrix[rowIndex + 1][columnIndex] + 1, distanceMatrix[rowIndex][columnIndex] + edit));
            }

            System.out.printf("After %d iteration:\n", rowIndex + 1);
            displayMatrix(distanceMatrix, firstWord, secondWord);
        }

        return distanceMatrix[firstWord.length()][secondWord.length()];
    }

    private static void displayMatrix(int[][] distanceMatrix, String first, String second) {
        StringBuilder sb = new StringBuilder();

        int outer = 0;
        int inner = 0;
        for (int i = 0; i < distanceMatrix.length; i++) {

            if (outer == 0) {
                sb.append(" ").append(" | ");
            }

            if (i == 0) {
                for (int j = 0; j < distanceMatrix[i].length; j++) {
                    if (j == 0) sb.append("-").append(" | ");
                    else sb.append(second.charAt(j - 1)).append(" | ");

                }
                sb.append("\n");

                for (int j = 0; j < distanceMatrix[i].length * 5; j++) {
                    sb.append("-");
                }
                sb.append("\n");
            }

            for (int j = 0; j < distanceMatrix[i].length; j++) {
                if (inner == 0) {
                    sb.append("-").append(" | ");
                }

                if (j == 0 && inner > 1) {
                    sb.append(first.charAt(i - 1)).append(" | ");
                }

                sb.append(distanceMatrix[i][j]).append(" | ");
                inner++;
            }

            sb.append("\n");
            outer++;
        }
        System.out.println(sb);
    }

    public static void main(String[] args) {
        System.out.println("Distance is: " + calculate("denisa", "denis"));
    }
}
