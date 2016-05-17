package com.denis.shuvalov.algo.recursion.exercises;

public class TowersOfHanoi {
    public static void main(String[] args) {
        solve(4, 'A', 'B', 'C');
    }

    //num of towers   towerA     towerB      towerC
    static void solve(int current, char from, char inter, char to) {
        //is on top
        if (current == 1) {
            System.out.println("Disk " + current + " moving from " + from + " to " + to);
            return;
        }

        //go up
        solve(current - 1, from, to, inter);
        System.out.println("Disk " + current + " moving from " + from + " to " + to);
        //previous on current
        solve(current - 1, inter, from, to);
    }
}
