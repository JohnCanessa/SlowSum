import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;


/**
 * Slow Sums
 * https://www.facebookrecruiting.com/portal/coding_practice_question/?problem_id=836241573518034
 */
public class SlowSum {


    /**
     * Execution O(n log(n))
     */
    static int getTotalTime(int[] arr) {

        // **** sanity check(s) ****
        if (arr.length == 1)
            return 0;

        // **** sort array in descending order O(n log(n)) ****
        int[] rev = Arrays.stream(arr)
                        .boxed()
                        .sorted(Comparator.reverseOrder())
                        .mapToInt(Integer::intValue)
                        .toArray();

        // **** initialization ****
        int penalty     = rev[0] + rev[1];
        int penalties   = penalty;

        // **** loop counting penalties O(n) ****
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