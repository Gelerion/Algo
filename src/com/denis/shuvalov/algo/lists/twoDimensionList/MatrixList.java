package com.denis.shuvalov.algo.lists.twoDimensionList;

public class MatrixList<T> {
    private DimensionList<DimensionList<T>> columns;

    public MatrixList(int rows, int columns) {
        this.columns = new DimensionList<>(columns);
        for (int i = 0; i < columns; i++) {
            this.columns.insert(createRow(rows));
        }
    }

    private DimensionList<T> createRow(int rows) {
        DimensionList<T> row = new DimensionList<>(rows);
        for (int i = 0; i < rows; i++) {
            row.insert(null);
        }
        return row;
    }

    public void insert(int row, int column, T elem) {
        columns.get(column).update(row, elem);
    }

    public void display() {
        StringBuilder header = new StringBuilder(columns.getFirst().getSize());
        header.append("X").append(" | ");
        for (int i = 0; i < columns.getFirst().getSize(); i++) {
            header.append(i).append(" | ");
        }
        System.out.println(header);

        StringBuilder columnSb = new StringBuilder();
        for (int i = 0; i < columns.getSize(); i++) {
            columnSb.append(i).append(" | ");
            DimensionList<T> tDimensionList = columns.get(i);

            for (int j = 0; j < columns.getFirst().getSize(); j++) {
                T item = tDimensionList.get(j);
                if (item == null)
                    columnSb.append('X').append(" | ");
                else
                    columnSb.append(item).append(" | ");
            }

            columnSb.append("\n");
        }
        System.out.println(columnSb);
    }

}
