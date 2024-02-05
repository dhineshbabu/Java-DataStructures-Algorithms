package gfgalgo.module18greedyalgo;

import java.util.Arrays;

class Item implements Comparable<Item> {
    int wt, val;

    public Item(int w, int v) {
        wt = w;
        val = v;
    }

    public int compareTo(Item i) {
        return wt * i.val - val * i.wt;
    }
}

public class Prob_02FractionalKnapSack {
    static double fracKnapSack(Item[] arr, int totalWeight) {
        // sort the array
        Arrays.sort(arr);

        double res = 0.0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].wt <= totalWeight) {
                res += arr[i].val;

                // subtract from total weight
                totalWeight = totalWeight - arr[i].wt;
            } else {
                // else this is the final item can be consumed
                res += arr[i].val * ((double) totalWeight) / (double) arr[i].wt;
                break;
            }
            System.out.println(res);

        }
        return res;
    }

    public static void main(String[] args) {
        Item[] arr = {
                new Item(10, 60),
                new Item(40, 40),
                new Item(20, 100),
                new Item(30, 120),
        };

        int w = 50;
        System.out.println(fracKnapSack(arr, w));
    }
}
