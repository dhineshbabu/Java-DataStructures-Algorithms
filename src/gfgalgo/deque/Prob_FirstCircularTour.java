package gfgalgo.deque;

public class Prob_FirstCircularTour {
    /*
    using a deque
     */

    static int firstPetrolTour(int[] petrol, int[] distance){
        int n = petrol.length;
        int start = 0;
        int curr_petrol = 0;
        int prev_petrol = 0;

        // start the loop
        for(int i=0; i<n; i++){
            curr_petrol = curr_petrol + (petrol[i] - distance[i]);
            if(curr_petrol < 0) {
                prev_petrol = curr_petrol;
                // reset the start
                start = i+1;
                curr_petrol = 0;

            }
        }

        return ((curr_petrol + prev_petrol) >=0) ? (start + 1) : -1;
    }

    public static void main(String[] args) {
        int[] petrol = {50, 10, 60, 100};
        int[] distance = {30, 20, 100, 10};

        System.out.println(firstPetrolTour(petrol, distance));
    }
}
