import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author huanghaoxing
 */
public class wordBreak139 {

    // 139. 单词拆分
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> words = new HashSet<>(wordDict);
        return dfs(s, 0, words, new HashSet<>());
    }

    public boolean dfs(String s, int start, Set<String> words, Set<Integer> indexs) {
        if (start == s.length()) {
            return true;
        }

        for (int i = start + 1; i <= s.length(); i++) {
            if (indexs.contains(i)) {
                continue;
            }
            if (!words.contains(s.substring(start, i))) {
                continue;
            }
            if (dfs(s, i, words, indexs)) {
                return true;
            }
            indexs.add(i);
        }
        return false;
    }
}
