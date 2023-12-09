package square_number;


import java.util.Objects;

public class Square {
    public static boolean isSquare(int n) {
       if (n < 0 ) {
           return false;
       }
       if (n == 0) {
           return true;
       }
       double sqrt = Math.sqrt(n);
       String[] splited = String.valueOf(sqrt).split("\\.");

       if (splited.length==2 && !Objects.equals(splited[1], "0")) {
           return false;
       } else {
           return true;
       }
    }

}