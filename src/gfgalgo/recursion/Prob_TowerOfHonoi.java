package gfgalgo.recursion;

public class Prob_TowerOfHonoi {
    public static void moveDisks(int diskCount, char A, char B, char C){
        // base case
        if(diskCount==1) {
            System.out.println("Move 1 from "+ A + " to " + C);
            return;
        }

        //recursive cases
        moveDisks(diskCount-1, A, C, B);
        System.out.println("Move "+ diskCount +  " from " + A + " to " + C);
        moveDisks(diskCount-1, B, A, C);
    }

    public static void main(String[] args) {
        moveDisks(3, 'A', 'B', 'C');
    }
}
