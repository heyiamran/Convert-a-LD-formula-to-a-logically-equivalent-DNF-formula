// Zhuoran Bi 20217231
public enum Operators {
    //use enum give different operators different priority.
    AND('&', 1), OR('|', 1), SINGLE('-', 1), NOT('~', 2), LEFT_BRACKET('[', 3), RIGHT_BRACKET(']', 3);

    private char value;
    private int priority;

    Operators(char value, int priority) {
        this.value = value;
        this.priority = priority;
    }

    // compare the priority.
    public static int cmp(char c1, char c2) {
        int p1 = 0;
        int p2 = 0;
        for (Operators o : Operators.values()) {
            if (o.value == c1) {
                p1 = o.priority;
            }
            if (o.value == c2) {
                p2 = o.priority;
            }
        }
        return p1 - p2;
    }

    // below are something are needed in my program to judge if it is a suitable character。
    public static boolean isOperator(char c) {
        if (c == '~' || c == '&' || c == '|' || c == '[' || c == ']' || c == '-')

            return true;

        else

            return false;
    }


    public static boolean isABCDE(char c) {
        if (c == 'A' || c == 'B' || c == 'C' || c == 'D' || c == 'E' || c == 'G' || c == 'H' || c == 'J' || c == 'K' || c == 'L')

            return true;

        else

            return false;
    }


    public static boolean isOperatorOutput(String c) {
        if ("~".equals(c) || "&".equals(c) || "|".equals(c))

            return true;

        else

            return false;
    }

    public static boolean isOperatorString(String s) {

        if ("[".equals(s) || "]".equals(s) || "|".equals(s) || "&".equals(s)
                || "~".equals(s) || "-".equals(s))

            return true;

        else

            return false;
    }
}
