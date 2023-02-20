import java.util.Arrays;
import java.util.stream.IntStream;

public class Homeworks {
    // array of scores
    private int[] scores;

    /**
     * innitialises class, setting variables to an initial state
     * 
     * @param score should be between 1 and 100
     */
    public Homeworks(int score0, int score1, int score2, int score3, int score4) {
        // set the instance variable scores
        this.scores = new int[] { score0, score1, score2, score3, score4 };
        // if a perameter is an incorrect value (not a percentage)
        for (int score : scores) {
            if (score < 0 || score > 100) {
                throw new IllegalArgumentException("Score values should be between 0 and 100");
            }
        }
    }

    /**
     * uses scores to calculate an average percentage from the top 3
     * 
     * @return float as percentage
     */
    public float getPercentageOfTop3() {
        // sort by value order
        Arrays.sort(scores);
        // get 3 highest values by taking a sub array of last 3 elements of array
        int[] top3 = Arrays.copyOfRange(scores, scores.length - 3, scores.length);
        // calculate averrage by adding them together and devided by 3
        float percentage = IntStream.of(top3).sum() / 3;
        // return the Value
        return percentage;
    }
}
