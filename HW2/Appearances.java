import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Appearances {
    static <T> int sameCount(Collection<T> a, Collection<T> b) {
        int cnt = 0;
        Map<T, Integer> map1 = new HashMap<>();
        Map<T, Integer> map2 = new HashMap<>();

        for (T t : a) {
            if (map1.containsKey(t)) {
                map1.put(t, map1.get(t) + 1);
            }
            else {
                map1.put(t, 1);
            }
        }

        for (T t : b) {
            if (map2.containsKey(t)) {
                map2.put(t, map2.get(t) + 1);
            }
            else {
                map2.put(t, 1);
            }
        }

        for (T t : map1.keySet()) {
            if (map2.containsKey(t)) {
                if (map1.get(t) == map2.get(t)) {
                    cnt++;
                }
            }
        }

        return cnt;
    }
}
