import java.util.*;

class Ts {
    public int leastInterval(char[] tasks, int n) {
        // Count the frequency of each task
        int[] freq = new int[26];
        for (char t : tasks) {
            freq[t - 'A']++;
        }

        Arrays.sort(freq); // sort frequencies ascending
        int maxFreq = freq[25]; // maximum frequency
        int maxCount = 1; // count of tasks that have max frequency

        // Count how many tasks have the same max frequency
        for (int i = 24; i >= 0; i--) {
            if (freq[i] != maxFreq) break;
            maxCount++;
        }

        // Calculate the minimum intervals
        int partCount = maxFreq - 1; // number of "gaps" between max freq tasks
        int partLength = n - (maxCount - 1); // length of each gap
        int emptySlots = partCount * partLength; // total idle slots needed
        int availableTasks = tasks.length - maxFreq * maxCount; // tasks to fill idle slots
        int idles = Math.max(0, emptySlots - availableTasks);

        return tasks.length + idles;
    }
}