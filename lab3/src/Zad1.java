import Strategies.Strategy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Zad1 {
    public static List<List<String>> findListOfNotDuplicatedComponents(String[][] s, Strategy strategy){
        List<List<String>> ans = new ArrayList<>();
        strategy.solve(s, 0, new HashSet<>(), new ArrayList<>(), ans);
        return ans;
    }
}
