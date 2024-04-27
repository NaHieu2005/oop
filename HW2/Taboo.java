import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Taboo<T> {
    public List<T> rule;

    public Taboo(List<T> rule) {
        this.rule = rule;
    }

    public Set<T> noFollow(T elem){
        Set<T> set = new HashSet<T>();

        T prev = null;
        for (T t : rule) {
            if (prev != null && prev.equals(elem)) {
                set.add(t);
            }
            prev = t;
        }

        return set;
    }

    public void reduce(List<T> list){
        int k = 0;
        int i = 0;
        while (i < list.size() - 1) {
            boolean check = false;
            for (i = k; i < list.size()-1; i++) {
                T next = list.get(i+1);
                T current = list.get(i);
                if (noFollow(current).contains(next)) {
                    k = i;
                    check = true;
                    break;
                }
            }

            if (check) list.remove(k+1);
        }
    }
}
