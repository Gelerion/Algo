package com.denis.shuvalov.algo.trees.tree_234.book;

class DataItem {
    public long dData;

    // Один объект данных
    public DataItem(long dd) { dData = dd; }

    // Вывод элемента в формате "/27"
    public void displayItem() { System.out.print("/" + dData); }

    @Override
    public String toString() {
        return String.valueOf(dData);
    }
}
