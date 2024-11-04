import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Comparator;
import java.util.PriorityQueue;

class S {
    private final int id;
    private final String n;
    private final double g;

    public S(int id, String n, double g) {
        this.id = id;
        this.n = n;
        this.g = g;
    }

    public int getId() {
        return id;
    }

    public String getN() {
        return n;
    }

    public double getG() {
        return g;
    }
}

class P {
    
    private final PriorityQueue<S> q = new PriorityQueue<>(
            Comparator.comparing(S::getG).reversed()
                    .thenComparing(S::getN)
                    .thenComparing(S::getId));

    public List<S> getS(List<String> ev) {
        ev.forEach((e) -> {
            if (e.equals("SERVED")) {
                q.poll();
            } else {
                String[] d = e.split(" ");
                q.add(new S(Integer.parseInt(d[3]), d[1], Double.parseDouble(d[2])));
            }
        });

        List<S> r = new ArrayList<>();
        while (!q.isEmpty()) {
            r.add(q.poll());
        }

        return r;
    }
}

public class Solution {
    
    private final static Scanner sc = new Scanner(System.in);
    private final static P p = new P();

    public static void main(String[] args) {
        int t = Integer.parseInt(sc.nextLine());
        List<String> ev = new ArrayList<>();

        while (t-- != 0) {
            String e = sc.nextLine();
            ev.add(e);
        }

        List<S> r = p.getS(ev);

        if (r.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (S s : r) {
                System.out.println(s.getN());
            }
        }
    }
}
