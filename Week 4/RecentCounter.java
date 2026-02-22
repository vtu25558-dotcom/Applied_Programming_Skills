import java.util.*;

class RecentCounter {
    private Queue<Integer> queue;

    /** Initialize the counter with zero recent requests. */
    public RecentCounter() {
        queue = new LinkedList<>();
    }

    /** 
     * Add a new request at time t and return the number of requests in the past 3000 ms. 
     */
    public int ping(int t) {
        queue.offer(t);

        // Remove requests older than t - 3000
        while (!queue.isEmpty() && queue.peek() < t - 3000) {
            queue.poll();
        }

        return queue.size();
    }
}