package make_diamond;

class Diamond {

    public static StringBuffer make_space(int n, StringBuffer sb) {
        for (int i = 0; i < n; i++) {
            sb.append(" ");
        }
        return sb;
    }

    public static StringBuffer make_star(int n, StringBuffer sb) {
        for (int i = 0; i < n; i++) {
            sb.append("*");
        }
        sb.append("\n");
        return sb;
    }
    public static String print(int n) {
        // TODO your code here
        if (n <= 0 || n % 2 == 0) {
            return null;
        }

        int layer = n - (n / 2);
        StringBuffer sb = new StringBuffer();

        int j = 1;
        for (int i = layer - 1; i >= 0; i--) {
            make_star(j, make_space(i, sb));
            j = j+2;
        }
        j = j-2;
        for (int i = 0; i < layer; i++) {
            make_star(j = j-2, make_space(i, sb.append(' ')));
        }
        System.out.println(sb);
        return sb.toString();
    }

    public static void main(String[] args) {
        new Diamond().print(5);
    }
}
