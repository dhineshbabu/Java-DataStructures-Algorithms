package gfgalgo.recursion;

public class Prob_07JosephusProblem {
    /*
     the Josephus Problem, a theoretical problem related to a certain counting-out game. In this context,
     it computes the position of the survivor in a circle of n people, where every k-th person is eliminated.
     */
    public static int survivor(int n, int k) {
        // Base case: If there is only one person (n == 1), that person survives at position 0.
        if(n ==1) return 0;
            // Recursive case:
            // Calculate the survivor's position in a circle of n people where every k-th person is eliminated.
            // The survivor's position is determined by recursively calculating the survivor position for n-1 people.
            // The "+ k" accounts for the k-th person being eliminated in the current round.
            // The "% n" ensures that the position remains within the circle (wraps around).
        else {
            System.out.println(n);
            return (survivor(n - 1, k) + k) % n;
        }
    }

    public static void main(String[] args) {
        System.out.println(survivor(5,3));
    }
}
