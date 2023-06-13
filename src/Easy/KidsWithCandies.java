package Easy;

import java.util.ArrayList;
import java.util.List;

public class KidsWithCandies {

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        ArrayList<Boolean> result = new ArrayList<>(candies.length);
        int maxCandies = candies[0];
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] > maxCandies) {
                maxCandies = candies[i];
            }
            candies[i] += extraCandies;
        }
        for (int kid: candies) {
            result.add(kid >= maxCandies);
        }
        return result;
    }
}
