import java.util.HashSet;
import java.util.Set;

public class StringCode {
    String blowup(String str){
        String res = "";

        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9'){
                int temp = str.charAt(i) - '0';
                for (int j = 1; j <= temp; j++) res += str.charAt(i + 1);
            }
            else res += str.charAt(i);
        }

        return res;
    }

    int maxRun(String str){
        int res = 1;

        for (int i = 0; i < str.length() - 1; i++){
            int j = i;
            while (str.charAt(j) == str.charAt(i)) j++;
            res = Math.max(res, j - i);
        }

        return res;
    }

    boolean stringIntersect(String a, String b, int len){
        Set<String> set1 = substring(a, len);
        Set<String> set2 = substring(b, len);

        for (String s : set1){
            for (String s2 : set2){
                if (s.equals(s2)) return true;
            }
        }

        return false;
    }

    private Set<String> substring(String str, int len){
        Set<String> set = new HashSet<>();

        for (int i = 0; i < str.length() - len + 1; i++){
            set.add(str.substring(i, i + len));
        }

        return set;
    }

}

