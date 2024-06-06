package Strategies;

import java.util.List;
import java.util.Set;

public interface Strategy {
    void solve(String[][] s, int i, Set<String> visited, List<String> current, List<List<String>> ans);
}
