import java.util.*;

class Solution {
    
    private static boolean isB(String exp) {
        if ((exp.length() & 1) == 1)
            return false;

        char[] b = exp.toCharArray();
        Stack<Character> s = new Stack<>();
        for (char c : b)
            switch (c) {
                case '{':
                    s.push('}');
                    break;
                case '(':
                    s.push(')');
                    break;
                case '[':
                    s.push(']');
                    break;
                default:
                    if (s.empty() || c != s.peek())
                        return false;
                    s.pop();
            }
        return s.empty();
    }

    public static void main(String[] a) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String exp = sc.next();
            System.out.println(isB(exp) ? "true" : "false");
        }
        sc.close();
    }
}
