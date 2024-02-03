package gfgalgo.module13deque;

import java.util.Deque;
import java.util.LinkedList;

public class Prob_02DSWithMinMaxOperations {
    /*

    insertMin(x)
    insertMax(x)
    getMin()
    getMax()
    extractMin()
    extractMax()

    idea is to create a deque
    use first position for minimum
    use last position for maximum
     */

    Deque<Integer> dq = new LinkedList<>();

    void insertMin(int x) {
        dq.offerFirst(x);
    }

    void insertMax(int x) {
        dq.offerLast(x);
    }

    int getMin() {
        return dq.peekFirst();
    }

    int getMax() {
        return dq.peekLast();
    }

    int extractMin() {
        return dq.pollFirst();
    }

    int extractMax() {
        return dq.pollLast();
    }
}
