/*
Fractional Knapsack

Given the weights and values of N items, put these items in a knapsack of capacity W to 
get the maximum total value in the knapsack.

value = [60, 100, 120]
weight = [10, 20, 30]
capacity = = 50
ans = 240

*/

package GreedyAlgo;

import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {
    public static int fractionalKnapsack(int[] value, int[] weights, int capacity) {
        double[][] ratio = new double[value.length][2];
        int profit = 0;

        for (int i = 0; i < value.length; i++) {
            ratio[i][0] = i;
            ratio[i][1] = value[i] / (double) weights[i];
        }

        Arrays.sort(ratio, Comparator.comparingDouble(r -> r[1]));

        for (int i = (ratio.length - 1); i >= 0; i--) {
            int index = (int) ratio[i][0];
            if (capacity >= weights[index]) {
                capacity -= weights[index];
                profit += value[index];
            } else {
                profit += capacity * (int) ratio[i][1];
                break;
            }
        }

        return profit;
    }

    public static void main(String[] args) {
        int[] value = {60, 100, 120};
		int[] weights = {10, 20, 30};
		int capacity = 50;
		System.out.println(fractionalKnapsack(value, weights, capacity));
    }
}
