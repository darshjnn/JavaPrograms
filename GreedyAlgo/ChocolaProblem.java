/*
Chocola Problem

Given a bar of chocolate composed of m x n square pieces. One should break the chocolate
into single squares. Each break of a part of the chocolate is charged a cost expressed by a
positive integer. This cost does not depend on the size of the part that is being broken but
only depends on the line the break goes along. Let us denote the costs of breaking along 
consecutive vertical lines with x1, x2, ... , xm-1 and along horizontal lines with 
y1, y2, ... , yn-1.

Compute the minimal cost of breaking the whole chocolate into single squares.

*/

package GreedyAlgo;

import java.util.Arrays;
import java.util.Collections;

public class ChocolaProblem {
    public static int minCost(Integer[] verCost, Integer[] horCost) {
        int cost = 0;

        // Sort vertical & horizontal cut costs in decreasing order.
        Arrays.sort(verCost, Collections.reverseOrder());
        Arrays.sort(horCost, Collections.reverseOrder());

        int h = 0, v = 0; // Horizontal & Vertical Pointer for Cost arrays.
        int horPieces = 1, verPieces = 1; // Number of Horizontal & Vertical Pieces.

        while (h < horCost.length && v < verCost.length) {
            if (horCost[h] <= verCost[v]) {
                // Vertical Cut
                cost += (horPieces * verCost[v]);
                ++verPieces;
                ++v;
            } else {
                // Horizontal Cut
                cost += (verPieces * horCost[h]);
                ++horPieces;
                ++h;
            }
        }

        // Applying Remaining Horizontal Cuts
        while (h < horCost.length) {
            cost += (verPieces * horCost[h]);
            ++horPieces;
            ++h;
        }

        // Applying Remaining Vertical Cuts
        while (v < verCost.length) {
            cost += (verPieces * verCost[v]);
            ++verPieces;
            ++v;
        }

        return cost;
    }

    public static void main(String[] args) {
        Integer[] verCost = { 2, 1, 3, 1, 4 };
        Integer[] horCost = { 4, 1, 2 };
        System.out.println(minCost(verCost, horCost));
    }
}
