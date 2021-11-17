import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;


/**
 * Slow Sums
 * https://www.facebookrecruiting.com/portal/coding_practice_question/?problem_id=836241573518034
 */
public class SlowSum {


    /**
     * Using a stream.
     * 
     * Execution O(n log(n)) - Space: O(n)
     */
    static int getTotalTime0(int[] arr) {

        // **** sanity check(s) ****
        if (arr.length == 1) return 0;

        // ???? ????
        System.out.println("<<< arr:: " + Arrays.toString(arr));

        // **** sort array in descending order - O(n log(n)) ****
        int[] rev = Arrays.stream(arr)
                        .boxed()
                        .sorted(Comparator.reverseOrder())
                        .mapToInt(Integer::intValue)
                        .toArray();

        // ???? ????
        System.out.println("<<< rev:: " + Arrays.toString(rev));

        // **** initialization ****
        int penalty     = rev[0] + rev[1];
        int penalties   = penalty;

        // **** loop counting penalties - O(n) ****
        for (int i = 2; i < rev.length; i++) {

            // **** generate penalty ****
            penalty += rev[i];

            // **** add penalty ****
            penalties += penalty;
        }

        // **** return penalties ****
        return penalties;
    }


    /**
     * Using a priority queue instead of a stream.
     * 
     * Execution: O(n) - Space: O(n)
     */
    static int getTotalTime(int[] arr) {

        // **** sanity check(s) ****
        if (arr.length == 1) return 0;

        // **** initialization - O(n * log(n)) ****
        PriorityQueue<Integer> rev = new PriorityQueue<>(arr.length, (a,b) -> b - a);
        for (int i : arr) rev.add(i);

        int penalty     = rev.poll() + rev.poll();
        int penalties   = penalty;

        // **** loop counting penalties - O(n) ****
        while (!rev.isEmpty()) {

            // **** generate penalty ****
            penalty += rev.poll();

            // **** add penalty ****
            penalties += penalty;
        }

        // **** return penalties ****
        return penalties;
    }


    /**
     * Test scaffolding
     * 
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        
        // **** open buffered reader ****
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // **** read input line and split values ****
        String[] strs = br.readLine().trim().split(",");

        // **** close buffered reader ****
        br.close();
        
        // **** create and populate array of integers ****
        int[] arr = Arrays.stream(strs).mapToInt(Integer::parseInt).toArray();

        // ???? ????
        System.out.println("main <<< arr: " + Arrays.toString(arr));

        // **** call function and display resuly ****
        System.out.println("main <<< output: " + getTotalTime(arr));
    }
}