package sum_of_digits;

public class DRoot {
    public static int digital_root(int n) {
        String new_int = String.valueOf(n);
        int sum = 0;
        for (int i = 0; i < new_int.length(); i++) {
            sum = sum + Integer.parseInt(new_int.substring(i, i + 1));
        }
        if (sum / 10 == 0) {
            return sum;
        } else {
            return digital_root(sum);
        }
    }
}