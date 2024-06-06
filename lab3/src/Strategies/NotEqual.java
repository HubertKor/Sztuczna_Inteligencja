package Strategies;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class NotEqual implements Strategy{
    @Override
    public void solve(String[][] s, int i, Set<String> visited, List<String> current, List<List<String>> ans) {
        if(i == s.length){
            ans.add(new ArrayList<>(current));
            return;
        }
        for(String str : s[i]){
            if(!visited.contains(str)){
                visited.add(str);
                current.add(str);
                solve(s, i + 1, visited, current, ans);
                current.remove(current.size() - 1);
                visited.remove(str);
            }
        }
    }
}
