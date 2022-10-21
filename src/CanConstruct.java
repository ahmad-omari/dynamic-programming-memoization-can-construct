import java.util.HashMap;
import java.util.Map;

/**
 * @author : Ahmad Al-Omari
 * @mailto : alomari.ah98@gmail.com
 * @created : 10/21/2022, Friday
 * @project : dynamic-programming-memoization-can-construct
 **/
public class CanConstruct {

    public static boolean canConstruct(String target, String[] wordBank, Map<String, Boolean> memo){
        if (memo.containsKey(target)){
            return memo.get(target);
        }
        if (target.equals("")){
            return true;
        }
        for (String word: wordBank) {
            if (target.indexOf(word) == 0) {
                String suffix = target.substring(word.length());
                boolean resultConstruct = canConstruct(suffix, wordBank, memo);
                if (resultConstruct) {
                    memo.put(target, true);
                    return true;
                }
            }
        }
        memo.put(target, false);
        return false;
    }

    public static void main(String[] args) {
        System.out.println(canConstruct("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd"}, new HashMap<>()));
        System.out.println(canConstruct("skateboard", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"}, new HashMap<>()));
        System.out.println(canConstruct("enterapotentpot", new String[]{"a", "p", "ent", "enter", "ot", "o", "t"}, new HashMap<>()));
        System.out.println(canConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", new String[]{"e", "ee", "eee", "eeee", "eeeee", "eeeeee"}, new HashMap<>()));
    }
}
