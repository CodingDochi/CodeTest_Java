package algorithmLesson.executionTime.P_24265;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    /*
    아래 알고리즘의 수행 횟수는 n*(n-1)/2 회이며 반복문이 중첩되어 있으므로 차수가 2이다.

    MenOfPassion(A[], n) {
        sum <- 0;
        for i <- 1 to n - 1
            for j <- i + 1 to n
                sum <- sum + A[i] × A[j]; # 코드1
        return sum;
    }
     */

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /*
        int로 변수를 받으면 오버플로우가 발생한다.
        int의 범위는 -2,147,483,648~ 2,147,483,647 인데, 주어진 입력 n 이 46341 이상이면
         n * n이 int의 표현범위를 초과하게 되므로 long을 사용한다.
         */

        long n = Long.parseLong(br.readLine());
        System.out.println(n*(n-1)/2);
        System.out.println(2);
    }
}
